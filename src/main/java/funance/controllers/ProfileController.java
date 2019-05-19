package funance.controllers;

import funance.data.Budget;
import funance.data.PortfolioRepository;
import funance.mappers.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ProfileResponse> profileGet() {
        ProfileResponse response = new ProfileResponse();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> profilePost() {
        ProfileResponse response = new ProfileResponse();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BudgetResponse> profileBudgetGet(@NotNull Long userId) {
        if (userId == 0) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        try {
            List<Budget> budget = portfolioRepository.findByUserId(userId);
            return new ResponseEntity(ProfileMapper.mapBudgetResponse(budget), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<BudgetItem> profileBudgetItemGet(@NotNull Long itemId) {
        try {
            Budget budgetItem = portfolioRepository.findItemById(itemId);
            return new ResponseEntity(ProfileMapper.mapBudgetItem(budgetItem), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<BudgetItem> profileBudgetItemPost(@Valid CreateBudgetItemRequest body) {
        long id = ProfileMapper.getRandomIntegerBetweenRange();
        try {
            portfolioRepository.createBudgetItem(id, body.getUserId(), body.getTitle(), body.getAmount(),
                    body.getCategory().toString(), body.getDate(), body.getOnceoff(), "OPEN");
            return new ResponseEntity(profileBudgetItemGet(id).getBody(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<DashboardResponse> profileDashboardGet() {
        DashboardResponse response = new DashboardResponse();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> profileBudgetItemCapturePost(@Valid CaptureBudgetItemRequest body) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SavingsResponse> profileSavingsGet() {
        SavingsResponse savingsResponse = new SavingsResponse();
        return new ResponseEntity(savingsResponse, HttpStatus.OK);
    }

    @Override
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
