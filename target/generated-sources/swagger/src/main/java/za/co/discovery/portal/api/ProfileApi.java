/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package za.co.discovery.portal.api;

import za.co.discovery.portal.model.BudgetItem;
import za.co.discovery.portal.model.BudgetResponse;
import za.co.discovery.portal.model.BuyGameItemRequest;
import za.co.discovery.portal.model.CaptureBudgetItemRequest;
import za.co.discovery.portal.model.CreateBudgetItemRequest;
import za.co.discovery.portal.model.DashboardResponse;
import za.co.discovery.portal.model.GameboardResponse;
import za.co.discovery.portal.model.ProfileResponse;
import za.co.discovery.portal.model.SavingsResponse;
import za.co.discovery.portal.model.SavingsThresholdRequest;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-28T12:07:44.845+02:00")

@Api(value = "profile", description = "the profile API")
public interface ProfileApi {

    @ApiOperation(value = "Retrieves users full budget", notes = "", response = BudgetResponse.class, tags={ "budget", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Budget of the logged in user", response = BudgetResponse.class) })
    
    @RequestMapping(value = "profile/budget",
        method = RequestMethod.GET)
    ResponseEntity<BudgetResponse> profileBudgetGet( @NotNull@ApiParam(value = "username", required = true) @RequestParam(value = "username", required = true) String username);


    @ApiOperation(value = "Captures a sub item on a budget item", notes = "", response = Void.class, tags={ "budget", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "The budget item that was created", response = Void.class) })
    
    @RequestMapping(value = "profile/budget/item/capture",
        method = RequestMethod.POST)
    ResponseEntity<Void> profileBudgetItemCapturePost(@ApiParam(value = "Details for the sub item to create" ,required=true )  @Valid @RequestBody CaptureBudgetItemRequest body);


    @ApiOperation(value = "Marks items as complete", notes = "", response = Void.class, tags={ "budget", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "The budget items state was updated", response = Void.class) })
    
    @RequestMapping(value = "profile/budget/item/capture",
        method = RequestMethod.PUT)
    ResponseEntity<Void> profileBudgetItemCapturePut( @NotNull@ApiParam(value = "Id of the item", required = true) @RequestParam(value = "itemId", required = true) Long itemId, @NotNull@ApiParam(value = "State of the item", required = true) @RequestParam(value = "state", required = true) String state);


    @ApiOperation(value = "Retrieves a specific budget item", notes = "", response = BudgetItem.class, tags={ "budget", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Budget item chosen by the user", response = BudgetItem.class) })
    
    @RequestMapping(value = "profile/budget/item",
        method = RequestMethod.GET)
    ResponseEntity<BudgetItem> profileBudgetItemGet( @NotNull@ApiParam(value = "itemId", required = true) @RequestParam(value = "itemId", required = true) Long itemId);


    @ApiOperation(value = "Creates a new budget item", notes = "", response = BudgetItem.class, tags={ "budget", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The budget item that was created", response = BudgetItem.class) })
    
    @RequestMapping(value = "profile/budget/item",
        method = RequestMethod.POST)
    ResponseEntity<BudgetItem> profileBudgetItemPost(@ApiParam(value = "Details for the item to create" ,required=true )  @Valid @RequestBody CreateBudgetItemRequest body);


    @ApiOperation(value = "Retrieves users full dashboard and summarised items", notes = "", response = DashboardResponse.class, tags={ "profile", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Retrieves users full dashboard and summarised items", response = DashboardResponse.class) })
    
    @RequestMapping(value = "profile/dashboard",
        method = RequestMethod.GET)
    ResponseEntity<DashboardResponse> profileDashboardGet();


    @ApiOperation(value = "Retrieve the full game state of the", notes = "", response = GameboardResponse.class, tags={ "gameboard", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The game state of the user", response = GameboardResponse.class) })
    
    @RequestMapping(value = "profile/gameboard",
        method = RequestMethod.GET)
    ResponseEntity<GameboardResponse> profileGameboardGet();


    @ApiOperation(value = "Buy a gameboard item", notes = "", response = GameboardResponse.class, tags={ "gameboard", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The updated game state of the user", response = GameboardResponse.class) })
    
    @RequestMapping(value = "profile/gameboard/item",
        method = RequestMethod.POST)
    ResponseEntity<GameboardResponse> profileGameboardItemPost(@ApiParam(value = "Details for item bought" ,required=true )  @Valid @RequestBody BuyGameItemRequest body);


    @ApiOperation(value = "Retrieves profile of the requested user", notes = "", response = ProfileResponse.class, tags={ "profile", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Profile of the logged in user", response = ProfileResponse.class) })
    
    @RequestMapping(value = "profile",
        method = RequestMethod.GET)
    ResponseEntity<ProfileResponse> profileGet();


    @ApiOperation(value = "Creates a new profile for a user", notes = "", response = Void.class, tags={ "profile", })
    @ApiResponses(value = {  })
    
    @RequestMapping(value = "profile",
        method = RequestMethod.POST)
    ResponseEntity<Void> profilePost();


    @ApiOperation(value = "Retrieve the full savings information", notes = "", response = SavingsResponse.class, tags={ "savings", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The savings of the user", response = SavingsResponse.class) })
    
    @RequestMapping(value = "profile/savings",
        method = RequestMethod.GET)
    ResponseEntity<SavingsResponse> profileSavingsGet();


    @ApiOperation(value = "Retrieve the full savings information", notes = "", response = Void.class, tags={ "savings", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Confirmation that savings goal was saved", response = Void.class) })
    
    @RequestMapping(value = "profile/savings/goal",
        method = RequestMethod.POST)
    ResponseEntity<Void> profileSavingsGoalPost(@ApiParam(value = "Goal type to be captured",required=true ) @PathVariable("goalType") String goalType);


    @ApiOperation(value = "Capture your savings threshold", notes = "", response = Void.class, tags={ "savings", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Confirmation is was saved correctly", response = Void.class) })
    
    @RequestMapping(value = "profile/savings/threshold",
        method = RequestMethod.POST)
    ResponseEntity<Void> profileSavingsThresholdPost(@ApiParam(value = "Threshold amount" ,required=true )  @Valid @RequestBody SavingsThresholdRequest body);

}
