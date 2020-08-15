
package com.giraone.jsonschema.models.v2;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Base definition of a Person.
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "first_name",
    "last_name",
    "date_of_birth",
    "gender",
    "deceased",
    "comment",
    "location"
})
public class PersonBase {

    /**
     * The person's UUID.
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("The person's UUID.")
    private UUID id;
    /**
     * 
     * Corresponds to the "first_name" property.The person's first name.
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    @JsonPropertyDescription("The person's first name.")
    private String firstName;
    /**
     * 
     * Corresponds to the "last_name" property.The person's last name.
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    @JsonPropertyDescription("The person's last name.")
    private String lastName;
    /**
     * 
     * Corresponds to the "date_of_birth" property.Person's data of birth.
     * (Required)
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @JsonProperty("date_of_birth")
    @JsonPropertyDescription("Person's data of birth.")
    private Date dateOfBirth;
    /**
     * Gender of a person. * `U`: undefined or unknown * `M`: male * `F`: female * `D`: divers
     * (Required)
     * 
     */
    @JsonProperty("gender")
    @JsonPropertyDescription("Gender of a person. * `U`: undefined or unknown * `M`: male * `F`: female * `D`: divers")
    private PersonBase.GenderEnum gender = PersonBase.GenderEnum.fromValue("U");
    /**
     * Flag, if person is deceased.
     * 
     */
    @JsonProperty("deceased")
    @JsonPropertyDescription("Flag, if person is deceased.")
    private boolean deceased = false;
    /**
     * A comment.
     * 
     */
    @JsonProperty("comment")
    @JsonPropertyDescription("A comment.")
    private String comment;
    /**
     * Longitude and Latitude Values
     * <p>
     * A geographical coordinate.
     * 
     */
    @JsonProperty("location")
    @JsonPropertyDescription("A geographical coordinate.")
    private GeoLocation location;

    /**
     * The person's UUID.
     * 
     */
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    /**
     * The person's UUID.
     * 
     */
    @JsonProperty("id")
    public void setId(UUID id) {
        this.id = id;
    }

    public PersonBase withId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * Corresponds to the "first_name" property.The person's first name.
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * Corresponds to the "first_name" property.The person's first name.
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public PersonBase withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * 
     * Corresponds to the "last_name" property.The person's last name.
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * Corresponds to the "last_name" property.The person's last name.
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonBase withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * 
     * Corresponds to the "date_of_birth" property.Person's data of birth.
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * 
     * Corresponds to the "date_of_birth" property.Person's data of birth.
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PersonBase withDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    /**
     * Gender of a person. * `U`: undefined or unknown * `M`: male * `F`: female * `D`: divers
     * (Required)
     * 
     */
    @JsonProperty("gender")
    public PersonBase.GenderEnum getGender() {
        return gender;
    }

    /**
     * Gender of a person. * `U`: undefined or unknown * `M`: male * `F`: female * `D`: divers
     * (Required)
     * 
     */
    @JsonProperty("gender")
    public void setGender(PersonBase.GenderEnum gender) {
        this.gender = gender;
    }

    public PersonBase withGender(PersonBase.GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Flag, if person is deceased.
     * 
     */
    @JsonProperty("deceased")
    public boolean isDeceased() {
        return deceased;
    }

    /**
     * Flag, if person is deceased.
     * 
     */
    @JsonProperty("deceased")
    public void setDeceased(boolean deceased) {
        this.deceased = deceased;
    }

    public PersonBase withDeceased(boolean deceased) {
        this.deceased = deceased;
        return this;
    }

    /**
     * A comment.
     * 
     */
    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    /**
     * A comment.
     * 
     */
    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    public PersonBase withComment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * Longitude and Latitude Values
     * <p>
     * A geographical coordinate.
     * 
     */
    @JsonProperty("location")
    public GeoLocation getLocation() {
        return location;
    }

    /**
     * Longitude and Latitude Values
     * <p>
     * A geographical coordinate.
     * 
     */
    @JsonProperty("location")
    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    public PersonBase withLocation(GeoLocation location) {
        this.location = location;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PersonBase.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("dateOfBirth");
        sb.append('=');
        sb.append(((this.dateOfBirth == null)?"<null>":this.dateOfBirth));
        sb.append(',');
        sb.append("gender");
        sb.append('=');
        sb.append(((this.gender == null)?"<null>":this.gender));
        sb.append(',');
        sb.append("deceased");
        sb.append('=');
        sb.append(this.deceased);
        sb.append(',');
        sb.append("comment");
        sb.append('=');
        sb.append(((this.comment == null)?"<null>":this.comment));
        sb.append(',');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null)?"<null>":this.location));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.firstName == null)? 0 :this.firstName.hashCode()));
        result = ((result* 31)+((this.lastName == null)? 0 :this.lastName.hashCode()));
        result = ((result* 31)+(this.deceased? 1 : 0));
        result = ((result* 31)+((this.gender == null)? 0 :this.gender.hashCode()));
        result = ((result* 31)+((this.dateOfBirth == null)? 0 :this.dateOfBirth.hashCode()));
        result = ((result* 31)+((this.comment == null)? 0 :this.comment.hashCode()));
        result = ((result* 31)+((this.location == null)? 0 :this.location.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PersonBase) == false) {
            return false;
        }
        PersonBase rhs = ((PersonBase) other);
        return (((((((((this.firstName == rhs.firstName)||((this.firstName!= null)&&this.firstName.equals(rhs.firstName)))&&((this.lastName == rhs.lastName)||((this.lastName!= null)&&this.lastName.equals(rhs.lastName))))&&(this.deceased == rhs.deceased))&&((this.gender == rhs.gender)||((this.gender!= null)&&this.gender.equals(rhs.gender))))&&((this.dateOfBirth == rhs.dateOfBirth)||((this.dateOfBirth!= null)&&this.dateOfBirth.equals(rhs.dateOfBirth))))&&((this.comment == rhs.comment)||((this.comment!= null)&&this.comment.equals(rhs.comment))))&&((this.location == rhs.location)||((this.location!= null)&&this.location.equals(rhs.location))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))));
    }


    /**
     * Gender of a person. * `U`: undefined or unknown * `M`: male * `F`: female * `D`: divers
     * 
     */
    public enum GenderEnum {

        U("U"),
        M("M"),
        F("F"),
        D("D");
        private final String value;
        private final static Map<String, PersonBase.GenderEnum> CONSTANTS = new HashMap<String, PersonBase.GenderEnum>();

        static {
            for (PersonBase.GenderEnum c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private GenderEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static PersonBase.GenderEnum fromValue(String value) {
            PersonBase.GenderEnum constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
