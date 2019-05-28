package za.co.discovery.portal.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets GameItemType
 */
public enum GameItemType {
  
  SMALL_PLANT("SMALL_PLANT"),
  
  MEDIUM_PLANT("MEDIUM_PLANT"),
  
  BIG_PLANT("BIG_PLANT");

  private String value;

  GameItemType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static GameItemType fromValue(String text) {
    for (GameItemType b : GameItemType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

