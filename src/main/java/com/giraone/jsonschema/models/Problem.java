
package com.giraone.jsonschema.models;

import java.net.URI;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "title",
    "status",
    "detail",
    "instance"
})
public class Problem {

    /**
     * An absolute URI that identifies the problem type.  When dereferenced,
     * it SHOULD provide human-readable documentation for the problem type
     * (e.g., using HTML).
     * 
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("An absolute URI that identifies the problem type.  When dereferenced,\nit SHOULD provide human-readable documentation for the problem type\n(e.g., using HTML).\n")
    private URI type = URI.create("about:blank");
    /**
     * A short, summary of the problem type. Written in english and readable
     * for engineers (usually not suited for non technical stakeholders and
     * not localized); example: Service Unavailable
     * 
     * 
     */
    @JsonProperty("title")
    @JsonPropertyDescription("A short, summary of the problem type. Written in english and readable\nfor engineers (usually not suited for non technical stakeholders and\nnot localized); example: Service Unavailable\n")
    private String title;
    /**
     * The HTTP status code generated by the origin server for this occurrence
     * of the problem.
     * 
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("The HTTP status code generated by the origin server for this occurrence\nof the problem.\n")
    private int status;
    /**
     * A human readable explanation specific to this occurrence of the
     * problem.
     * 
     * 
     */
    @JsonProperty("detail")
    @JsonPropertyDescription("A human readable explanation specific to this occurrence of the\nproblem.\n")
    private String detail;
    /**
     * An absolute URI that identifies the specific occurrence of the problem.
     * It may or may not yield further information if dereferenced.
     * 
     */
    @JsonProperty("instance")
    @JsonPropertyDescription("An absolute URI that identifies the specific occurrence of the problem.\nIt may or may not yield further information if dereferenced.")
    private URI instance;

    /**
     * An absolute URI that identifies the problem type.  When dereferenced,
     * it SHOULD provide human-readable documentation for the problem type
     * (e.g., using HTML).
     * 
     * 
     */
    @JsonProperty("type")
    public URI getType() {
        return type;
    }

    /**
     * An absolute URI that identifies the problem type.  When dereferenced,
     * it SHOULD provide human-readable documentation for the problem type
     * (e.g., using HTML).
     * 
     * 
     */
    @JsonProperty("type")
    public void setType(URI type) {
        this.type = type;
    }

    public Problem withType(URI type) {
        this.type = type;
        return this;
    }

    /**
     * A short, summary of the problem type. Written in english and readable
     * for engineers (usually not suited for non technical stakeholders and
     * not localized); example: Service Unavailable
     * 
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * A short, summary of the problem type. Written in english and readable
     * for engineers (usually not suited for non technical stakeholders and
     * not localized); example: Service Unavailable
     * 
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Problem withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * The HTTP status code generated by the origin server for this occurrence
     * of the problem.
     * 
     * 
     */
    @JsonProperty("status")
    public int getStatus() {
        return status;
    }

    /**
     * The HTTP status code generated by the origin server for this occurrence
     * of the problem.
     * 
     * 
     */
    @JsonProperty("status")
    public void setStatus(int status) {
        this.status = status;
    }

    public Problem withStatus(int status) {
        this.status = status;
        return this;
    }

    /**
     * A human readable explanation specific to this occurrence of the
     * problem.
     * 
     * 
     */
    @JsonProperty("detail")
    public String getDetail() {
        return detail;
    }

    /**
     * A human readable explanation specific to this occurrence of the
     * problem.
     * 
     * 
     */
    @JsonProperty("detail")
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Problem withDetail(String detail) {
        this.detail = detail;
        return this;
    }

    /**
     * An absolute URI that identifies the specific occurrence of the problem.
     * It may or may not yield further information if dereferenced.
     * 
     */
    @JsonProperty("instance")
    public URI getInstance() {
        return instance;
    }

    /**
     * An absolute URI that identifies the specific occurrence of the problem.
     * It may or may not yield further information if dereferenced.
     * 
     */
    @JsonProperty("instance")
    public void setInstance(URI instance) {
        this.instance = instance;
    }

    public Problem withInstance(URI instance) {
        this.instance = instance;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Problem.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(this.status);
        sb.append(',');
        sb.append("detail");
        sb.append('=');
        sb.append(((this.detail == null)?"<null>":this.detail));
        sb.append(',');
        sb.append("instance");
        sb.append('=');
        sb.append(((this.instance == null)?"<null>":this.instance));
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
        result = ((result* 31)+((this.detail == null)? 0 :this.detail.hashCode()));
        result = ((result* 31)+((this.instance == null)? 0 :this.instance.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+ this.status);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Problem) == false) {
            return false;
        }
        Problem rhs = ((Problem) other);
        return ((((((this.detail == rhs.detail)||((this.detail!= null)&&this.detail.equals(rhs.detail)))&&((this.instance == rhs.instance)||((this.instance!= null)&&this.instance.equals(rhs.instance))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&(this.status == rhs.status));
    }

}
