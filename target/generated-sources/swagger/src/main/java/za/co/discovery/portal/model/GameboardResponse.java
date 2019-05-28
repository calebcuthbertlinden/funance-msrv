package za.co.discovery.portal.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import za.co.discovery.portal.model.GameboardItem;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GameboardResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-28T12:07:44.845+02:00")

public class GameboardResponse   {
  @JsonProperty("coin")
  private Integer coin = null;

  @JsonProperty("items")
  private List<GameboardItem> items = null;

  /**
   * Gets or Sets environment
   */
  public enum EnvironmentEnum {
    SMALL("SMALL"),
    
    MEDIUM("MEDIUM"),
    
    LARGE("LARGE");

    private String value;

    EnvironmentEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EnvironmentEnum fromValue(String text) {
      for (EnvironmentEnum b : EnvironmentEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("environment")
  private EnvironmentEnum environment = null;

  public GameboardResponse coin(Integer coin) {
    this.coin = coin;
    return this;
  }

   /**
   * Get coin
   * @return coin
  **/
  @ApiModelProperty(value = "")


  public Integer getCoin() {
    return coin;
  }

  public void setCoin(Integer coin) {
    this.coin = coin;
  }

  public GameboardResponse items(List<GameboardItem> items) {
    this.items = items;
    return this;
  }

  public GameboardResponse addItemsItem(GameboardItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<GameboardItem>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * Get items
   * @return items
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<GameboardItem> getItems() {
    return items;
  }

  public void setItems(List<GameboardItem> items) {
    this.items = items;
  }

  public GameboardResponse environment(EnvironmentEnum environment) {
    this.environment = environment;
    return this;
  }

   /**
   * Get environment
   * @return environment
  **/
  @ApiModelProperty(value = "")


  public EnvironmentEnum getEnvironment() {
    return environment;
  }

  public void setEnvironment(EnvironmentEnum environment) {
    this.environment = environment;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameboardResponse gameboardResponse = (GameboardResponse) o;
    return Objects.equals(this.coin, gameboardResponse.coin) &&
        Objects.equals(this.items, gameboardResponse.items) &&
        Objects.equals(this.environment, gameboardResponse.environment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coin, items, environment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameboardResponse {\n");
    
    sb.append("    coin: ").append(toIndentedString(coin)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    environment: ").append(toIndentedString(environment)).append("\n");
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

