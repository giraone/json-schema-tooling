
package com.giraone.jsonschema.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * GeoLocation
 * <p>
 * Geographical coordinates.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "latitude",
    "longitude"
})
public class GeoLocation {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("latitude")
    private double latitude;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("longitude")
    private double longitude;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("latitude")
    public double getLatitude() {
        return latitude;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("latitude")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public GeoLocation withLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("longitude")
    public double getLongitude() {
        return longitude;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("longitude")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public GeoLocation withLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GeoLocation.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("latitude");
        sb.append('=');
        sb.append(this.latitude);
        sb.append(',');
        sb.append("longitude");
        sb.append('=');
        sb.append(this.longitude);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.latitude)^(Double.doubleToLongBits(this.latitude)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.longitude)^(Double.doubleToLongBits(this.longitude)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GeoLocation) == false) {
            return false;
        }
        GeoLocation rhs = ((GeoLocation) other);
        return ((Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(rhs.latitude))&&(Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(rhs.longitude)));
    }

}
