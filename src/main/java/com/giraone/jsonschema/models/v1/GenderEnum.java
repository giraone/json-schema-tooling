package com.giraone.jsonschema.models.v1;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gender of a person. * `U`: undefined or unknown * `M`: male * `F`: female * `D`: divers 
 */
public enum GenderEnum {
  
  UNDEFINED("U"),
  
  MALE("M"),
  
  FEMALE("F"),
  
  DIVERS("D");

  private String value;

  GenderEnum(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static GenderEnum fromValue(String value) {
    for (GenderEnum b : GenderEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

