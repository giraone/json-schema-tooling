
package com.giraone.jsonschema.models;

import java.util.Date;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Definition of a Person object, that is returned by the Person API.
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "age",
    "creation_date_time"
})
public class PersonFull
    extends PersonBase
{

    /**
     * Age in years which must be equal to or greater than zero.
     * (Required)
     * 
     */
    @JsonProperty("age")
    @JsonPropertyDescription("Age in years which must be equal to or greater than zero.")
    private int age;
    /**
     * 
     * Corresponds to the "creation_date_time" property.Timestamp, when the entry was added.
     * (Required)
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
    @JsonProperty("creation_date_time")
    @JsonPropertyDescription("Timestamp, when the entry was added.")
    private Date creationDateTime;

    /**
     * Age in years which must be equal to or greater than zero.
     * (Required)
     * 
     */
    @JsonProperty("age")
    public int getAge() {
        return age;
    }

    /**
     * Age in years which must be equal to or greater than zero.
     * (Required)
     * 
     */
    @JsonProperty("age")
    public void setAge(int age) {
        this.age = age;
    }

    public PersonFull withAge(int age) {
        this.age = age;
        return this;
    }

    /**
     * 
     * Corresponds to the "creation_date_time" property.Timestamp, when the entry was added.
     * (Required)
     * 
     */
    @JsonProperty("creation_date_time")
    public Date getCreationDateTime() {
        return creationDateTime;
    }

    /**
     * 
     * Corresponds to the "creation_date_time" property.Timestamp, when the entry was added.
     * (Required)
     * 
     */
    @JsonProperty("creation_date_time")
    public void setCreationDateTime(Date creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public PersonFull withCreationDateTime(Date creationDateTime) {
        this.creationDateTime = creationDateTime;
        return this;
    }

    @Override
    public PersonFull withId(UUID id) {
        super.withId(id);
        return this;
    }

    @Override
    public PersonFull withFirstName(String firstName) {
        super.withFirstName(firstName);
        return this;
    }

    @Override
    public PersonFull withLastName(String lastName) {
        super.withLastName(lastName);
        return this;
    }

    @Override
    public PersonFull withDateOfBirth(Date dateOfBirth) {
        super.withDateOfBirth(dateOfBirth);
        return this;
    }

    @Override
    public PersonFull withGender(PersonBase.GenderEnum gender) {
        super.withGender(gender);
        return this;
    }

    @Override
    public PersonFull withDeceased(boolean deceased) {
        super.withDeceased(deceased);
        return this;
    }

    @Override
    public PersonFull withComment(String comment) {
        super.withComment(comment);
        return this;
    }

    @Override
    public PersonFull withLocation(GeoLocation location) {
        super.withLocation(location);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PersonFull.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        int baseLength = sb.length();
        String superString = super.toString();
        if (superString!= null) {
            int contentStart = superString.indexOf('[');
            int contentEnd = superString.lastIndexOf(']');
            if ((contentStart >= 0)&&(contentEnd >contentStart)) {
                sb.append(superString, (contentStart + 1), contentEnd);
            } else {
                sb.append(superString);
            }
        }
        if (sb.length()>baseLength) {
            sb.append(',');
        }
        sb.append("age");
        sb.append('=');
        sb.append(this.age);
        sb.append(',');
        sb.append("creationDateTime");
        sb.append('=');
        sb.append(((this.creationDateTime == null)?"<null>":this.creationDateTime));
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
        result = ((result* 31)+ this.age);
        result = ((result* 31)+((this.creationDateTime == null)? 0 :this.creationDateTime.hashCode()));
        result = ((result* 31)+ super.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PersonFull) == false) {
            return false;
        }
        PersonFull rhs = ((PersonFull) other);
        return ((super.equals(rhs)&&(this.age == rhs.age))&&((this.creationDateTime == rhs.creationDateTime)||((this.creationDateTime!= null)&&this.creationDateTime.equals(rhs.creationDateTime))));
    }

}
