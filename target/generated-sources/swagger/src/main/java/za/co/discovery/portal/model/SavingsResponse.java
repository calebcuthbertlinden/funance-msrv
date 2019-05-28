package za.co.discovery.portal.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import za.co.discovery.portal.model.SavingsProjection;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SavingsResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-28T19:32:38.748+02:00")

public class SavingsResponse   {
  @JsonProperty("value")
  private BigDecimal value = null;

  @JsonProperty("projections")
  private List<SavingsProjection> projections = null;

  public SavingsResponse value(BigDecimal value) {
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

  public SavingsResponse projections(List<SavingsProjection> projections) {
    this.projections = projections;
    return this;
  }

  public SavingsResponse addProjectionsItem(SavingsProjection projectionsItem) {
    if (this.projections == null) {
      this.projections = new ArrayList<SavingsProjection>();
    }
    this.projections.add(projectionsItem);
    return this;
  }

   /**
   * Get projections
   * @return projections
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<SavingsProjection> getProjections() {
    return projections;
  }

  public void setProjections(List<SavingsProjection> projections) {
    this.projections = projections;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SavingsResponse savingsResponse = (SavingsResponse) o;
    return Objects.equals(this.value, savingsResponse.value) &&
        Objects.equals(this.projections, savingsResponse.projections);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, projections);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SavingsResponse {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    projections: ").append(toIndentedString(projections)).append("\n");
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

