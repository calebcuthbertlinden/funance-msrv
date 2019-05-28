package za.co.discovery.portal.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SavingsGoalRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-28T19:32:38.748+02:00")

public class SavingsGoalRequest   {
  @JsonProperty("value")
  private BigDecimal value = null;

  /**
   * Gets or Sets goalType
   */
  public enum GoalTypeEnum {
    SHORT_TERM("SHORT_TERM"),
    
    LONG_TERM("LONG_TERM");

    private String value;

    GoalTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GoalTypeEnum fromValue(String text) {
      for (GoalTypeEnum b : GoalTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("goalType")
  private GoalTypeEnum goalType = null;

  public SavingsGoalRequest value(BigDecimal value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public SavingsGoalRequest goalType(GoalTypeEnum goalType) {
    this.goalType = goalType;
    return this;
  }

   /**
   * Get goalType
   * @return goalType
  **/
  @ApiModelProperty(value = "")


  public GoalTypeEnum getGoalType() {
    return goalType;
  }

  public void setGoalType(GoalTypeEnum goalType) {
    this.goalType = goalType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SavingsGoalRequest savingsGoalRequest = (SavingsGoalRequest) o;
    return Objects.equals(this.value, savingsGoalRequest.value) &&
        Objects.equals(this.goalType, savingsGoalRequest.goalType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, goalType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SavingsGoalRequest {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    goalType: ").append(toIndentedString(goalType)).append("\n");
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

