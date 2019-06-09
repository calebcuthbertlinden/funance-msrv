package funance.controllers;

import funance.data.Budget;
import funance.data.FinancialProfile;
import funance.data.Gameboard;
import funance.data.PortfolioRepository;
import funance.mappers.ProfileMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.discovery.portal.api.ProfileApi;
import za.co.discovery.portal.model.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class ProfileController implements ProfileApi {

    private PortfolioRepository portfolioRepository;

    @Autowired
    ProfileController(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    @CrossOrigin
    public ResponseEntity<ProfileResponse> profileGet() {
        ProfileResponse response = new ProfileResponse();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    @CrossOrigin
    public ResponseEntity<Void> profilePost() {
        ProfileResponse response = new ProfileResponse();
        return new ResponseEntity(response, HttpStatus.OK);
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
                    body.getCategory().toString(), body.getDate(), body.getOnceoff(), BudgetItem.StateEnum.OPEN.toString(), body.getDescription());
            return new ResponseEntity(profileBudgetItemGet(id).getBody(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception, HttpStatus.OK);
        }
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
