package za.co.discovery.portal.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.co.discovery.portal.model.GameItemType;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BuyGameItemRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-28T12:07:44.845+02:00")

public class BuyGameItemRequest   {
  @JsonProperty("itemType")
  private GameItemType itemType = null;

  public BuyGameItemRequest itemType(GameItemType itemType) {
    this.itemType = itemType;
    return this;
  }

   /**
   * Get itemType
   * @return itemType
  **/
  @ApiModelProperty(value = "")

  @Valid

  public GameItemType getItemType() {
    return itemType;
  }

  public void setItemType(GameItemType itemType) {
    this.itemType = itemType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BuyGameItemRequest buyGameItemRequest = (BuyGameItemRequest) o;
    return Objects.equals(this.itemType, buyGameItemRequest.itemType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BuyGameItemRequest {\n");
    
    sb.append("    itemType: ").append(toIndentedString(itemType)).append("\n");
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

