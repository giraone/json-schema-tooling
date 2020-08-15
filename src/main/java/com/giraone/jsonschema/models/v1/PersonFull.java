package com.giraone.jsonschema.models.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.giraone.jsonschema.models.v1.GenderEnum;
import com.giraone.jsonschema.models.v1.GeoLocation;
import com.giraone.jsonschema.models.v1.PersonBase;
import com.giraone.jsonschema.models.v1.PersonFullAllOf;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.LocalDateTime;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PersonFull
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-15T10:15:19.103680200+02:00[Europe/Berlin]")
public class PersonFull   {
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

  @JsonProperty("age")
  private Integer age;

  @JsonProperty("creation_date_time")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime creationDateTime;

  public PersonFull id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * The person's ID.
   * @return id
  */
  @ApiModelProperty(required = true, value = "The person's ID.")
  @NotNull

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public PersonFull firstName(String firstName) {
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

  public PersonFull lastName(String lastName) {
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

  public PersonFull dateOfBirth(LocalDate dateOfBirth) {
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

  public PersonFull gender(GenderEnum gender) {
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

  public PersonFull deceased(Boolean deceased) {
    this.deceased = deceased;
    return this;
  }

  /**
   * Flag, if person is deceased.
   * @return deceased
  */
  @ApiModelProperty(required = true, value = "Flag, if person is deceased.")
  @NotNull


  public Boolean getDeceased() {
    return deceased;
  }

  public void setDeceased(Boolean deceased) {
    this.deceased = deceased;
  }

  public PersonFull comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * A comment.
   * @return comment
  */
  @ApiModelProperty(required = true, value = "A comment.")
  @NotNull

@Size(max=1000) 
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public PersonFull location(GeoLocation location) {
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

  public PersonFull age(Integer age) {
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

  public PersonFull creationDateTime(LocalDateTime creationDateTime) {
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
    PersonFull personFull = (PersonFull) o;
    return Objects.equals(this.id, personFull.id) &&
        Objects.equals(this.firstName, personFull.firstName) &&
        Objects.equals(this.lastName, personFull.lastName) &&
        Objects.equals(this.dateOfBirth, personFull.dateOfBirth) &&
        Objects.equals(this.gender, personFull.gender) &&
        Objects.equals(this.deceased, personFull.deceased) &&
        Objects.equals(this.comment, personFull.comment) &&
        Objects.equals(this.location, personFull.location) &&
        Objects.equals(this.age, personFull.age) &&
        Objects.equals(this.creationDateTime, personFull.creationDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, dateOfBirth, gender, deceased, comment, location, age, creationDateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonFull {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    deceased: ").append(toIndentedString(deceased)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
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

