package funance.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import funance.data.PortfolioRepository;
import funance.mappers.ProfileMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.discovery.portal.model.BudgetItem;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TwilioController {

    private PortfolioRepository portfolioRepository;
    private ProfileController profileController;

    private Logger logger = LoggerFactory.getLogger(ProfileController.class);
    private static final String TWILIO_HEADER_KEY = "Memory";
    private static final String ACCOUNT_SID = "ACc36728ec8967249a8f4de31a97239edb";
    private static final String AUTH_TOKEN = "aea85cf59bd1692c37f23ac058644975";

    @Autowired
    TwilioController(PortfolioRepository portfolioRepository, ProfileController profileController) {
        this.portfolioRepository = portfolioRepository;
        this.profileController = profileController;
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
                    getTodaysDate(), true, BudgetItem.StateEnum.PAYED.toString(), "");
            sendTwilioMessage(userNumber,
                    "You have successfully added a new paid item to your budget: " + title  + " for R" + amount);
            return profileController.profileBudgetItemGet(id);
        } catch (Exception exception) {
            return new ResponseEntity(exception, HttpStatus.OK);
        }
    }

    private String getUserNumber(String twilioRequest) {
        return twilioRequest.substring(79, 91);
    }

    private String getUsernameFromNumber(String number) {
        // TODO userRepository get username from their number
        return "cuthbertlinden";
    }

    private String getTodaysDate() {
        return "12/12/2019";
    }

    private void sendTwilioMessage(String userNumber, String messageBody) {
        Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:" + userNumber),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                messageBody)
            .create();
    }

}
