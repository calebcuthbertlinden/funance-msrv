package za.co.discovery.portal.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GameboardSummary
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-28T19:32:38.748+02:00")

public class GameboardSummary   {
  @JsonProperty("returnCode")
  private Integer returnCode = null;

  public GameboardSummary returnCode(Integer returnCode) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameboardSummary gameboardSummary = (GameboardSummary) o;
    return Objects.equals(this.returnCode, gameboardSummary.returnCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(returnCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameboardSummary {\n");
    
    sb.append("    returnCode: ").append(toIndentedString(returnCode)).append("\n");
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

