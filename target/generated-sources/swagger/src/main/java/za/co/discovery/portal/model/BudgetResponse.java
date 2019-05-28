package za.co.discovery.portal.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import za.co.discovery.portal.model.CategoryList;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BudgetResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-28T12:07:44.845+02:00")

public class BudgetResponse   {
  @JsonProperty("categories")
  private List<CategoryList> categories = null;

  @JsonProperty("progress")
  private Integer progress = null;

  @JsonProperty("amountComplete")
  private Integer amountComplete = null;

  @JsonProperty("amountTotal")
  private Integer amountTotal = null;

  @JsonProperty("daysLeftThisMonth")
  private String daysLeftThisMonth = null;

  public BudgetResponse categories(List<CategoryList> categories) {
    this.categories = categories;
    return this;
  }

  public BudgetResponse addCategoriesItem(CategoryList categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<CategoryList>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

   /**
   * Get categories
   * @return categories
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CategoryList> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryList> categories) {
    this.categories = categories;
  }

  public BudgetResponse progress(Integer progress) {
    this.progress = progress;
    return this;
  }

   /**
   * Get progress
   * @return progress
  **/
  @ApiModelProperty(value = "")


  public Integer getProgress() {
    return progress;
  }

  public void setProgress(Integer progress) {
    this.progress = progress;
  }

  public BudgetResponse amountComplete(Integer amountComplete) {
    this.amountComplete = amountComplete;
    return this;
  }

   /**
   * Get amountComplete
   * @return amountComplete
  **/
  @ApiModelProperty(value = "")


  public Integer getAmountComplete() {
    return amountComplete;
  }

  public void setAmountComplete(Integer amountComplete) {
    this.amountComplete = amountComplete;
  }

  public BudgetResponse amountTotal(Integer amountTotal) {
    this.amountTotal = amountTotal;
    return this;
  }

   /**
   * Get amountTotal
   * @return amountTotal
  **/
  @ApiModelProperty(value = "")


  public Integer getAmountTotal() {
    return amountTotal;
  }

  public void setAmountTotal(Integer amountTotal) {
    this.amountTotal = amountTotal;
  }

  public BudgetResponse daysLeftThisMonth(String daysLeftThisMonth) {
    this.daysLeftThisMonth = daysLeftThisMonth;
    return this;
  }

   /**
   * Get daysLeftThisMonth
   * @return daysLeftThisMonth
  **/
  @ApiModelProperty(value = "")


  public String getDaysLeftThisMonth() {
    return daysLeftThisMonth;
  }

  public void setDaysLeftThisMonth(String daysLeftThisMonth) {
    this.daysLeftThisMonth = daysLeftThisMonth;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BudgetResponse budgetResponse = (BudgetResponse) o;
    return Objects.equals(this.categories, budgetResponse.categories) &&
        Objects.equals(this.progress, budgetResponse.progress) &&
        Objects.equals(this.amountComplete, budgetResponse.amountComplete) &&
        Objects.equals(this.amountTotal, budgetResponse.amountTotal) &&
        Objects.equals(this.daysLeftThisMonth, budgetResponse.daysLeftThisMonth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categories, progress, amountComplete, amountTotal, daysLeftThisMonth);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BudgetResponse {\n");
    
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
    sb.append("    amountComplete: ").append(toIndentedString(amountComplete)).append("\n");
    sb.append("    amountTotal: ").append(toIndentedString(amountTotal)).append("\n");
    sb.append("    daysLeftThisMonth: ").append(toIndentedString(daysLeftThisMonth)).append("\n");
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

