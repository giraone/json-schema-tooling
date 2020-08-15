package com.giraone.jsonschema.models.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.time.LocalDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PersonFullAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-15T10:15:19.103680200+02:00[Europe/Berlin]")
public class PersonFullAllOf   {
  @JsonProperty("age")
  private Integer age;

  @JsonProperty("creation_date_time")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime creationDateTime;

  public PersonFullAllOf age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * Age in years which must be equal to or greater than zero.
   * minimum: 0
   * @return age
  */
  @ApiModelProperty(required = true, value = "Age in years which must be equal to or greater than zero.")
  @NotNull

@Min(0)
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public PersonFullAllOf creationDateTime(LocalDateTime creationDateTime) {
    this.creationDateTime = creationDateTime;
    return this;
  }

  /**
   * Timestamp, when the entry was added.
   * @return creationDateTime
  */
  @ApiModelProperty(value = "Timestamp, when the entry was added.")

  @Valid

  public LocalDateTime getCreationDateTime() {
    return creationDateTime;
  }

  public void setCreationDateTime(LocalDateTime creationDateTime) {
    this.creationDateTime = creationDateTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonFullAllOf personFullAllOf = (PersonFullAllOf) o;
    return Objects.equals(this.age, personFullAllOf.age) &&
        Objects.equals(this.creationDateTime, personFullAllOf.creationDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(age, creationDateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonFullAllOf {\n");
    
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    creationDateTime: ").append(toIndentedString(creationDateTime)).append("\n");
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

