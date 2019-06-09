package funance.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import funance.data.repositories.PortfolioRepository;
import funance.data.repositories.UserRepository;
import funance.mappers.ProfileMapper;
import funance.models.TwilioRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.discovery.portal.model.BudgetItem;
import za.co.discovery.portal.model.BudgetResponse;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TwilioController {

    private PortfolioRepository portfolioRepository;
    private UserRepository userRepository;
    private ProfileController profileController;

    private Logger logger = LoggerFactory.getLogger(ProfileController.class);
    private static final String TWILIO_HEADER_KEY = "Memory";
    private static final String TWILIO_BUDGET_ITEM_DESCRIPTION = "Added by your Funancial advisor";
    private static final int WHATSAPP_NUMBER_START_INDEX = 79;
    private static final int WHATSAPP_NUMBER_END_INDEX = 91;
    private static final String ACCOUNT_SID = "ACc36728ec8967249a8f4de31a97239edb";
    private static final String AUTH_TOKEN = "aea85cf59bd1692c37f23ac058644975";

    @Autowired
    TwilioController(PortfolioRepository portfolioRepository, ProfileController profileController, UserRepository userRepository) {
        this.portfolioRepository = portfolioRepository;
        this.profileController = profileController;
        this.userRepository = userRepository;
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    @CrossOrigin
    @PostMapping("/profile/budget/item/twilio")
    public ResponseEntity<BudgetItem> profileBudgetItemTwilioPost(HttpServletRequest request) {
        long id = ProfileMapper.getRandomIntegerBetweenRange();

        Gson gson = new GsonBuilder().create();
        TwilioRequest item = gson.fromJson(request.getParameterMap().get(TWILIO_HEADER_KEY)[0], TwilioRequest.class);

        String userNumber = getUserNumber(request.getParameterMap().get(TWILIO_HEADER_KEY)[0]);
        String username = getUsernameFromNumber(userNumber);

        String title = item.getTwilio().getCollected_data().getCollect_comments().getAnswers().getTitle().getAnswer();
        String category = item.getTwilio().getCollected_data().getCollect_comments().getAnswers().getCategory().getAnswer();
        String amount = item.getTwilio().getCollected_data().getCollect_comments().getAnswers().getValue().getAnswer();

        try {
            portfolioRepository.createBudgetItem(id, username, title, Float.valueOf(amount), category,
                    getTodaysDate(), true, BudgetItem.StateEnum.OPEN.toString(), TWILIO_BUDGET_ITEM_DESCRIPTION);
            sendTwilioMessage(userNumber,
                    "You have successfully added a new item to your budget: \n" + title  + " for R" + amount);
            return profileController.profileBudgetItemGet(id);
        } catch (Exception exception) {
            return new ResponseEntity(exception, HttpStatus.OK);
        }
    }

    @CrossOrigin
    @PostMapping("/profile/budget/twilio")
    public ResponseEntity<Void> profileTwilioPost(HttpServletRequest request) {
        String userNumber = getUserNumber(request.getParameterMap().get(TWILIO_HEADER_KEY)[0]);

        // TODO Make reactive with observable pattern
        sendTwilioMessage(userNumber, "Fetching your budget summary. Give me one sec'");

        String username = getUsernameFromNumber(userNumber);
        try {
            BudgetResponse budgetResponse = profileController.profileBudgetGet(username).getBody();
            if (budgetResponse != null) {
                sendTwilioMessage(userNumber,
                        "Here's a summary of your budget: \n"
                                + "You have R" + budgetResponse.getOutstandingPaymentAmount().toString() + " in outstanding payments \n"
                                + "You have " + (budgetResponse.getAmountTotal() - budgetResponse.getAmountComplete()) + " items left to pay\n");
            } else {
                sendTwilioMessage(userNumber,
                        "Something went wrong fetching your budget");
            }
        } catch (Exception exception) {
            logger.error("Something went wrong");
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    private String getUserNumber(String twilioRequest) {
        return twilioRequest.substring(WHATSAPP_NUMBER_START_INDEX, WHATSAPP_NUMBER_END_INDEX);
    }

    private String getUsernameFromNumber(String number) {
        return userRepository.findByContact(number).getUsername();
    }

    private String getTodaysDate() {
        return "12/12/2019";
    }

    private void sendTwilioMessage(String userNumber, String messageBody) {
        Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:".concat(userNumber)),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                messageBody)
            .create();
    }

}
