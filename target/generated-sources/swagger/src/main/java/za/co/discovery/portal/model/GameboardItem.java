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
 * GameboardItem
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-08T21:15:48.012+02:00")

public class GameboardItem   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("itemType")
  private GameItemType itemType = null;

  public GameboardItem name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GameboardItem itemType(GameItemType itemType) {
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
    GameboardItem gameboardItem = (GameboardItem) o;
    return Objects.equals(this.name, gameboardItem.name) &&
        Objects.equals(this.itemType, gameboardItem.itemType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, itemType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameboardItem {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

