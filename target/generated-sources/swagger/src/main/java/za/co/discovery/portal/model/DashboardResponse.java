package za.co.discovery.portal.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.co.discovery.portal.model.BudgetSummary;
import za.co.discovery.portal.model.FinanceSummary;
import za.co.discovery.portal.model.GameboardSummary;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DashboardResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-08T21:15:48.012+02:00")

public class DashboardResponse   {
  @JsonProperty("gameboard")
  private GameboardSummary gameboard = null;

  @JsonProperty("budget")
  private BudgetSummary budget = null;

  @JsonProperty("finance")
  private FinanceSummary finance = null;

  public DashboardResponse gameboard(GameboardSummary gameboard) {
    this.gameboard = gameboard;
    return this;
  }

   /**
   * Get gameboard
   * @return gameboard
  **/
  @ApiModelProperty(value = "")

  @Valid

  public GameboardSummary getGameboard() {
    return gameboard;
  }

  public void setGameboard(GameboardSummary gameboard) {
    this.gameboard = gameboard;
  }

  public DashboardResponse budget(BudgetSummary budget) {
    this.budget = budget;
    return this;
  }

   /**
   * Get budget
   * @return budget
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BudgetSummary getBudget() {
    return budget;
  }

  public void setBudget(BudgetSummary budget) {
    this.budget = budget;
  }

  public DashboardResponse finance(FinanceSummary finance) {
    this.finance = finance;
    return this;
  }

   /**
   * Get finance
   * @return finance
  **/
  @ApiModelProperty(value = "")

  @Valid

  public FinanceSummary getFinance() {
    return finance;
  }

  public void setFinance(FinanceSummary finance) {
    this.finance = finance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardResponse dashboardResponse = (DashboardResponse) o;
    return Objects.equals(this.gameboard, dashboardResponse.gameboard) &&
        Objects.equals(this.budget, dashboardResponse.budget) &&
        Objects.equals(this.finance, dashboardResponse.finance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gameboard, budget, finance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardResponse {\n");
    
    sb.append("    gameboard: ").append(toIndentedString(gameboard)).append("\n");
    sb.append("    budget: ").append(toIndentedString(budget)).append("\n");
    sb.append("    finance: ").append(toIndentedString(finance)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

