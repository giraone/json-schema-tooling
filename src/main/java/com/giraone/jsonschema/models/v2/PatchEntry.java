
package com.giraone.jsonschema.models.v2;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * A JSONPatch document as defined by RFC 6902.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "op",
    "path",
    "value",
    "from"
})
public class PatchEntry {

    /**
     * The operation to be performed.
     * (Required)
     * 
     */
    @JsonProperty("op")
    @JsonPropertyDescription("The operation to be performed.")
    private PatchEntry.Op op;
    /**
     * A JSON-Pointer.
     * (Required)
     * 
     */
    @JsonProperty("path")
    @JsonPropertyDescription("A JSON-Pointer.")
    private String path;
    /**
     * The value to be used within the operations.
     * 
     */
    @JsonProperty("value")
    @JsonPropertyDescription("The value to be used within the operations.")
    private Value value;
    /**
     * A string containing a JSON Pointer value.
     * 
     */
    @JsonProperty("from")
    @JsonPropertyDescription("A string containing a JSON Pointer value.")
    private String from;

    /**
     * The operation to be performed.
     * (Required)
     * 
     */
    @JsonProperty("op")
    public PatchEntry.Op getOp() {
        return op;
    }

    /**
     * The operation to be performed.
     * (Required)
     * 
     */
    @JsonProperty("op")
    public void setOp(PatchEntry.Op op) {
        this.op = op;
    }

    public PatchEntry withOp(PatchEntry.Op op) {
        this.op = op;
        return this;
    }

    /**
     * A JSON-Pointer.
     * (Required)
     * 
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * A JSON-Pointer.
     * (Required)
     * 
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    public PatchEntry withPath(String path) {
        this.path = path;
        return this;
    }

    /**
     * The value to be used within the operations.
     * 
     */
    @JsonProperty("value")
    public Value getValue() {
        return value;
    }

    /**
     * The value to be used within the operations.
     * 
     */
    @JsonProperty("value")
    public void setValue(Value value) {
        this.value = value;
    }

    public PatchEntry withValue(Value value) {
        this.value = value;
        return this;
    }

    /**
     * A string containing a JSON Pointer value.
     * 
     */
    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    /**
     * A string containing a JSON Pointer value.
     * 
     */
    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    public PatchEntry withFrom(String from) {
        this.from = from;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PatchEntry.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("op");
        sb.append('=');
        sb.append(((this.op == null)?"<null>":this.op));
        sb.append(',');
        sb.append("path");
        sb.append('=');
        sb.append(((this.path == null)?"<null>":this.path));
        sb.append(',');
        sb.append("value");
        sb.append('=');
        sb.append(((this.value == null)?"<null>":this.value));
        sb.append(',');
        sb.append("from");
        sb.append('=');
        sb.append(((this.from == null)?"<null>":this.from));
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
        result = ((result* 31)+((this.op == null)? 0 :this.op.hashCode()));
        result = ((result* 31)+((this.path == null)? 0 :this.path.hashCode()));
        result = ((result* 31)+((this.from == null)? 0 :this.from.hashCode()));
        result = ((result* 31)+((this.value == null)? 0 :this.value.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PatchEntry) == false) {
            return false;
        }
        PatchEntry rhs = ((PatchEntry) other);
        return (((((this.op == rhs.op)||((this.op!= null)&&this.op.equals(rhs.op)))&&((this.path == rhs.path)||((this.path!= null)&&this.path.equals(rhs.path))))&&((this.from == rhs.from)||((this.from!= null)&&this.from.equals(rhs.from))))&&((this.value == rhs.value)||((this.value!= null)&&this.value.equals(rhs.value))));
    }


    /**
     * The operation to be performed.
     * 
     */
    public enum Op {

        ADD("add"),
        REMOVE("remove"),
        REPLACE("replace"),
        MOVE("move"),
        COPY("copy"),
        TEST("test");
        private final String value;
        private final static Map<String, PatchEntry.Op> CONSTANTS = new HashMap<String, PatchEntry.Op>();

        static {
            for (PatchEntry.Op c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Op(String value) {
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
        public static PatchEntry.Op fromValue(String value) {
            PatchEntry.Op constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
