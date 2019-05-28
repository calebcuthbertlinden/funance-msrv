package za.co.discovery.portal.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FinanceSummary
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-28T12:07:44.845+02:00")

public class FinanceSummary   {
  @JsonProperty("returnCode")
  private Integer returnCode = null;

  @JsonProperty("savings")
  private BigDecimal savings = null;

  @JsonProperty("budget")
  private Integer budget = null;

  @JsonProperty("debt")
  private Integer debt = null;

  public FinanceSummary returnCode(Integer returnCode) {
    this.returnCode = returnCode;
    return this;
  }

   /**
   * Get returnCode
   * @return returnCode
  **/
  @ApiModelProperty(value = "")


  public Integer getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(Integer returnCode) {
    this.returnCode = returnCode;
  }

  public FinanceSummary savings(BigDecimal savings) {
    this.savings = savings;
    return this;
  }

   /**
   * Get savings
   * @return savings
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getSavings() {
    return savings;
  }

  public void setSavings(BigDecimal savings) {
    this.savings = savings;
  }

  public FinanceSummary budget(Integer budget) {
    this.budget = budget;
    return this;
  }

   /**
   * Get budget
   * @return budget
  **/
  @ApiModelProperty(value = "")


  public Integer getBudget() {
    return budget;
  }

  public void setBudget(Integer budget) {
    this.budget = budget;
  }

  public FinanceSummary debt(Integer debt) {
    this.debt = debt;
    return this;
  }

   /**
   * Get debt
   * @return debt
  **/
  @ApiModelProperty(value = "")


  public Integer getDebt() {
    return debt;
  }

  public void setDebt(Integer debt) {
    this.debt = debt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FinanceSummary financeSummary = (FinanceSummary) o;
    return Objects.equals(this.returnCode, financeSummary.returnCode) &&
        Objects.equals(this.savings, financeSummary.savings) &&
        Objects.equals(this.budget, financeSummary.budget) &&
        Objects.equals(this.debt, financeSummary.debt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(returnCode, savings, budget, debt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FinanceSummary {\n");
    
    sb.append("    returnCode: ").append(toIndentedString(returnCode)).append("\n");
    sb.append("    savings: ").append(toIndentedString(savings)).append("\n");
    sb.append("    budget: ").append(toIndentedString(budget)).append("\n");
    sb.append("    debt: ").append(toIndentedString(debt)).append("\n");
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

