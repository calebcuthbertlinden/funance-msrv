package funance.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import za.co.discovery.portal.api.ProfileApi;
import za.co.discovery.portal.model.*;

import javax.validation.Valid;

@RestController
public class ProfileController implements ProfileApi {

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
    public ResponseEntity<BudgetResponse> profileBudgetGet() {
        BudgetResponse response = new BudgetResponse();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BudgetItemResponse> profileBudgetItemGet() {
        BudgetItemResponse response = new BudgetItemResponse();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BudgetItemResponse> profileBudgetItemPost(@Valid CreateBudgetItemRequest body) {
        BudgetItemResponse response = new BudgetItemResponse();
        return new ResponseEntity(response, HttpStatus.OK);
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
