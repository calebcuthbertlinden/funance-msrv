package za.co.discovery.portal.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateBudgetItemRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-08T21:15:48.012+02:00")

public class CreateBudgetItemRequest   {
  @JsonProperty("username")
  private String username = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("onceoff")
  private Boolean onceoff = null;

  /**
   * Gets or Sets category
   */
  public enum CategoryEnum {
    DEBIT_ORDER("DEBIT_ORDER"),
    
    FOOD("FOOD"),
    
    MISC("MISC"),
    
    CUSTOM("CUSTOM");

    private String value;

    CategoryEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CategoryEnum fromValue(String text) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("category")
  private CategoryEnum category = null;

  @JsonProperty("categoryCustom")
  private String categoryCustom = null;

  @JsonProperty("amount")
  private Float amount = null;

  @JsonProperty("date")
  private String date = null;

  public CreateBudgetItemRequest username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @ApiModelProperty(value = "")


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public CreateBudgetItemRequest title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(value = "")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public CreateBudgetItemRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CreateBudgetItemRequest onceoff(Boolean onceoff) {
    this.onceoff = onceoff;
    return this;
  }

   /**
   * Get onceoff
   * @return onceoff
  **/
  @ApiModelProperty(value = "")


  public Boolean getOnceoff() {
    return onceoff;
  }

  public void setOnceoff(Boolean onceoff) {
    this.onceoff = onceoff;
  }

  public CreateBudgetItemRequest category(CategoryEnum category) {
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")


  public CategoryEnum getCategory() {
    return category;
  }

  public void setCategory(CategoryEnum category) {
    this.category = category;
  }

  public CreateBudgetItemRequest categoryCustom(String categoryCustom) {
    this.categoryCustom = categoryCustom;
    return this;
  }

   /**
   * Get categoryCustom
   * @return categoryCustom
  **/
  @ApiModelProperty(value = "")


  public String getCategoryCustom() {
    return categoryCustom;
  }

  public void setCategoryCustom(String categoryCustom) {
    this.categoryCustom = categoryCustom;
  }

  public CreateBudgetItemRequest amount(Float amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")


  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public CreateBudgetItemRequest date(String date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateBudgetItemRequest createBudgetItemRequest = (CreateBudgetItemRequest) o;
    return Objects.equals(this.username, createBudgetItemRequest.username) &&
        Objects.equals(this.title, createBudgetItemRequest.title) &&
        Objects.equals(this.description, createBudgetItemRequest.description) &&
        Objects.equals(this.onceoff, createBudgetItemRequest.onceoff) &&
        Objects.equals(this.category, createBudgetItemRequest.category) &&
        Objects.equals(this.categoryCustom, createBudgetItemRequest.categoryCustom) &&
        Objects.equals(this.amount, createBudgetItemRequest.amount) &&
        Objects.equals(this.date, createBudgetItemRequest.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, title, description, onceoff, category, categoryCustom, amount, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateBudgetItemRequest {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    onceoff: ").append(toIndentedString(onceoff)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    categoryCustom: ").append(toIndentedString(categoryCustom)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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

