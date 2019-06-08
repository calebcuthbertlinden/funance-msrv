package funance.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.autopilot.v1.assistant.task.TaskActions;
import funance.data.*;
import funance.mappers.ProfileMapper;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.discovery.portal.api.ProfileApi;
import za.co.discovery.portal.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class ProfileController implements ProfileApi {

    private PortfolioRepository portfolioRepository;

    Logger logger = LoggerFactory.getLogger(ProfileController.class);

    public static final String ACCOUNT_SID = "ACc36728ec8967249a8f4de31a97239edb";
    public static final String AUTH_TOKEN = "aea85cf59bd1692c37f23ac058644975";

    @Autowired
    ProfileController(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    @Override
    @CrossOrigin
    public ResponseEntity<ProfileResponse> profileGet() {
        ProfileResponse response = new ProfileResponse();
        sendTwilioMessage();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    @CrossOrigin
    public ResponseEntity<Void> profilePost() {
        ProfileResponse response = new ProfileResponse();
        sendTwilioMessage();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    private void sendTwilioMessage() {
        logger.error("HELLO YOU HIT THE ENDPOINT");
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+27647520016"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                "You have successfully added a new item to your budget")
                .create();
    }

    @Override
    @CrossOrigin
    public ResponseEntity<BudgetResponse> profileBudgetGet(@NotNull @RequestParam String username) {
        if (username == null || username.isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        try {
            List<Budget> budget = portfolioRepository.findByUserId(username);
            FinancialProfile profile = portfolioRepository.findFinancialProfileByUser(username);
            return new ResponseEntity(ProfileMapper.mapBudgetResponse(budget, profile), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @CrossOrigin
    public ResponseEntity<BudgetItem> profileBudgetItemGet(@NotNull @RequestParam Long itemId) {
        try {
            Budget budgetItem = portfolioRepository.findItemById(itemId);
            return new ResponseEntity(ProfileMapper.mapBudgetItem(budgetItem), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @CrossOrigin
    public ResponseEntity<BudgetItem> profileBudgetItemPost(@NotNull @RequestBody CreateBudgetItemRequest body) {
        long id = ProfileMapper.getRandomIntegerBetweenRange();

        try {
            portfolioRepository.createBudgetItem(id, body.getUsername(), body.getTitle(), body.getAmount(),
                    body.getCategory().toString(), body.getDate(), body.getOnceoff(), "OPEN", body.getDescription());
            sendTwilioMessage();
            return new ResponseEntity(profileBudgetItemGet(id).getBody(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception, HttpStatus.OK);
        }
    }

    @CrossOrigin
    @RequestMapping("/profile/budget/item/twilio")
    public ResponseEntity<BudgetItem> profileBudgetItemTwilioPost(HttpServletRequest request, HttpServletResponse response) {
        long id = ProfileMapper.getRandomIntegerBetweenRange();

        Gson gson = new GsonBuilder().create();
        TwilioRequest item = gson.fromJson(request.getParameterMap().get("Memory")[0], TwilioRequest.class);

        String username = getUsernameFromNumber(request.getParameterMap().get("Memory")[0]);

        try {
            portfolioRepository.createBudgetItem(id, username,
                    item.getTwilio().getCollected_data().getCollect_comments().getAnswers().getTitle().getAnswer(),
                    Float.valueOf(item.getTwilio().getCollected_data().getCollect_comments().getAnswers().getValue().getAnswer()),
                    item.getTwilio().getCollected_data().getCollect_comments().getAnswers().getCategory().getAnswer(),
                    "12/12/2019", true, "OPEN", "sdasdasdsads");
            sendTwilioMessage();
            return new ResponseEntity(profileBudgetItemGet(id).getBody(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception, HttpStatus.OK);
        }
    }

    private String getUsernameFromNumber(String response) {
        // TODO extract number from MASSSSSSIIIVVVEEEE string
        return "cuthbertlinden";
    }

    @Override
    @CrossOrigin
    public ResponseEntity<Void> profileBudgetPost(@Valid CaptureBudgetRequest body) {
        try {
            portfolioRepository.createFinancialProfile(body.getUsername(), body.getIncome().floatValue(), body.getSavings().floatValue(),
                    body.getInvestments().floatValue());
            portfolioRepository.createGameboard(body.getUsername(), 100);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception, HttpStatus.OK);
        }
    }

    @Override
    @CrossOrigin
    public ResponseEntity<DashboardResponse> profileDashboardGet() {
        DashboardResponse response = new DashboardResponse();
        response.setBudget(ProfileMapper.mapBudgetSummary());
        response.setFinance(ProfileMapper.mapFinanceSummary());
        response.setGameboard(ProfileMapper.mapGameboardSummary());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    @CrossOrigin
    public ResponseEntity<Void> profileBudgetItemCapturePost(@Valid CaptureBudgetItemRequest body) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @CrossOrigin
    public ResponseEntity<Void> profileBudgetItemCapturePut(@NotNull Long itemId, @NotNull String state) {
        portfolioRepository.updateBudgetItem(itemId, "PAYED");
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @CrossOrigin
    public ResponseEntity<SavingsResponse> profileSavingsGet() {
        SavingsResponse savingsResponse = new SavingsResponse();
        return new ResponseEntity(savingsResponse, HttpStatus.OK);
    }

    @Override
    @CrossOrigin
    public ResponseEntity<Void> profileSavingsGoalPost(String goalType) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> profileSavingsThresholdPost(@Valid SavingsThresholdRequest body) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @CrossOrigin
    public ResponseEntity<GameboardResponse> profileGameboardGet(@NotNull String username) {
        Gameboard gameboard = portfolioRepository.findGameboardFromUser(username);
        return new ResponseEntity(ProfileMapper.mapGameboard(gameboard), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GameboardResponse> profileGameboardItemPost(@Valid BuyGameItemRequest body) {
        GameboardResponse gameboardResponse = new GameboardResponse();
        return new ResponseEntity(gameboardResponse, HttpStatus.OK);
    }
}
