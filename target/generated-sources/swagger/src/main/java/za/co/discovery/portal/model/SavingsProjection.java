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
 * SavingsProjection
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-08T21:15:48.012+02:00")

public class SavingsProjection   {
  @JsonProperty("value")
  private BigDecimal value = null;

  /**
   * Gets or Sets projectionPeriod
   */
  public enum ProjectionPeriodEnum {
    SIX_MONTHS("SIX_MONTHS"),
    
    ONE_YEAR("ONE_YEAR"),
    
    TWO_YEARS("TWO_YEARS");

    private String value;

    ProjectionPeriodEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ProjectionPeriodEnum fromValue(String text) {
      for (ProjectionPeriodEnum b : ProjectionPeriodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("projectionPeriod")
  private ProjectionPeriodEnum projectionPeriod = null;

  public SavingsProjection value(BigDecimal value) {
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

  public SavingsProjection projectionPeriod(ProjectionPeriodEnum projectionPeriod) {
    this.projectionPeriod = projectionPeriod;
    return this;
  }

   /**
   * Get projectionPeriod
   * @return projectionPeriod
  **/
  @ApiModelProperty(value = "")


  public ProjectionPeriodEnum getProjectionPeriod() {
    return projectionPeriod;
  }

  public void setProjectionPeriod(ProjectionPeriodEnum projectionPeriod) {
    this.projectionPeriod = projectionPeriod;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SavingsProjection savingsProjection = (SavingsProjection) o;
    return Objects.equals(this.value, savingsProjection.value) &&
        Objects.equals(this.projectionPeriod, savingsProjection.projectionPeriod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, projectionPeriod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SavingsProjection {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    projectionPeriod: ").append(toIndentedString(projectionPeriod)).append("\n");
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

