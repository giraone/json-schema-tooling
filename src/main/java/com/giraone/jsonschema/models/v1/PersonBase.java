package com.giraone.jsonschema.models.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.giraone.jsonschema.models.v1.GenderEnum;
import com.giraone.jsonschema.models.v1.GeoLocation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PersonBase
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-15T10:15:19.103680200+02:00[Europe/Berlin]")
public class PersonBase   {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("first_name")
  private String firstName;

  @JsonProperty("last_name")
  private String lastName;

  @JsonProperty("date_of_birth")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate dateOfBirth;

  @JsonProperty("gender")
  private GenderEnum gender = GenderEnum.UNDEFINED;

  @JsonProperty("deceased")
  private Boolean deceased = false;

  @JsonProperty("comment")
  private String comment;

  @JsonProperty("location")
  private GeoLocation location;

  public PersonBase id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * The person's ID.
   * @return id
  */
  @ApiModelProperty(value = "The person's ID.")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public PersonBase firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * The person's first name.
   * @return firstName
  */
  @ApiModelProperty(required = true, value = "The person's first name.")
  @NotNull

@Pattern(regexp="^[0-9a-zA-Z]{1,100}$") 
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public PersonBase lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * The person's last name.
   * @return lastName
  */
  @ApiModelProperty(required = true, value = "The person's last name.")
  @NotNull

@Pattern(regexp="^[0-9a-zA-Z]{1,100}$") 
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public PersonBase dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Person's data of birth.
   * @return dateOfBirth
  */
  @ApiModelProperty(required = true, value = "Person's data of birth.")
  @NotNull

  @Valid

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public PersonBase gender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public PersonBase deceased(Boolean deceased) {
    this.deceased = deceased;
    return this;
  }

  /**
   * Flag, if person is deceased.
   * @return deceased
  */
  @ApiModelProperty(value = "Flag, if person is deceased.")


  public Boolean getDeceased() {
    return deceased;
  }

  public void setDeceased(Boolean deceased) {
    this.deceased = deceased;
  }

  public PersonBase comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * A comment.
   * @return comment
  */
  @ApiModelProperty(value = "A comment.")

@Size(max=1000) 
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public PersonBase location(GeoLocation location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  */
  @ApiModelProperty(value = "")

  @Valid

  public GeoLocation getLocation() {
    return location;
  }

  public void setLocation(GeoLocation location) {
    this.location = location;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonBase personBase = (PersonBase) o;
    return Objects.equals(this.id, personBase.id) &&
        Objects.equals(this.firstName, personBase.firstName) &&
        Objects.equals(this.lastName, personBase.lastName) &&
        Objects.equals(this.dateOfBirth, personBase.dateOfBirth) &&
        Objects.equals(this.gender, personBase.gender) &&
        Objects.equals(this.deceased, personBase.deceased) &&
        Objects.equals(this.comment, personBase.comment) &&
        Objects.equals(this.location, personBase.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, dateOfBirth, gender, deceased, comment, location);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonBase {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    deceased: ").append(toIndentedString(deceased)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
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

