package funance.controllers;

import funance.data.Budget;
import funance.data.FinancialProfile;
import funance.data.PortfolioRepository;
import funance.data.UserRepository;
import funance.mappers.ProfileMapper;
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
    private UserRepository userRepository;

    @Autowired
    ProfileController(PortfolioRepository portfolioRepository, UserRepository userRepository) {
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
    }

    @Override
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ProfileResponse> profileGet() {
        ProfileResponse response = new ProfileResponse();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> profilePost() {
        ProfileResponse response = new ProfileResponse();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    @CrossOrigin(origins = "http://localhost:3000")
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
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<BudgetItem> profileBudgetItemGet(@NotNull @RequestParam Long itemId) {
        try {
            Budget budgetItem = portfolioRepository.findItemById(itemId);
            return new ResponseEntity(ProfileMapper.mapBudgetItem(budgetItem), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<BudgetItem> profileBudgetItemPost(@NotNull @RequestBody CreateBudgetItemRequest body) {
        long id = ProfileMapper.getRandomIntegerBetweenRange();
        try {
            portfolioRepository.createBudgetItem(id, body.getUsername(), body.getTitle(), body.getAmount(),
                    body.getCategory().toString(), body.getDate(), body.getOnceoff(), "OPEN", body.getDescription());
            return new ResponseEntity(profileBudgetItemGet(id).getBody(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception, HttpStatus.OK);
        }
    }

    @Override
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> profileBudgetPost(@Valid CaptureBudgetRequest body) {
        try {
            portfolioRepository.createFinancialProfile(body.getUsername(), body.getIncome().floatValue(), body.getSavings().floatValue(),
                    body.getInvestments().floatValue());
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception, HttpStatus.OK);
        }
    }

    @Override
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<DashboardResponse> profileDashboardGet() {
        DashboardResponse response = new DashboardResponse();
        response.setBudget(ProfileMapper.mapBudgetSummary());
        response.setFinance(ProfileMapper.mapFinanceSummary());
        response.setGameboard(ProfileMapper.mapGameboardSummary());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> profileBudgetItemCapturePost(@Valid CaptureBudgetItemRequest body) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> profileBudgetItemCapturePut(@NotNull Long itemId, @NotNull String state) {
        portfolioRepository.updateBudgetItem(itemId, "PAYED");
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<SavingsResponse> profileSavingsGet() {
        SavingsResponse savingsResponse = new SavingsResponse();
        return new ResponseEntity(savingsResponse, HttpStatus.OK);
    }

    @Override
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> profileSavingsGoalPost(String goalType) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> profileSavingsThresholdPost(@Valid SavingsThresholdRequest body) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GameboardResponse> profileGameboardGet() {
        GameboardResponse gameboardResponse = new GameboardResponse();
        return new ResponseEntity(gameboardResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GameboardResponse> profileGameboardItemPost(@Valid BuyGameItemRequest body) {
        GameboardResponse gameboardResponse = new GameboardResponse();
        return new ResponseEntity(gameboardResponse, HttpStatus.OK);
    }
}
