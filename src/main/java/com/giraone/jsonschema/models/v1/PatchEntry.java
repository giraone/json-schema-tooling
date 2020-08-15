package com.giraone.jsonschema.models.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A JSONPatch document as defined by RFC 6902.
 */
@ApiModel(description = "A JSONPatch document as defined by RFC 6902.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-15T10:15:19.103680200+02:00[Europe/Berlin]")
public class PatchEntry   {
  /**
   * The operation to be performed.
   */
  public enum OpEnum {
    ADD("add"),
    
    REMOVE("remove"),
    
    REPLACE("replace"),
    
    MOVE("move"),
    
    COPY("copy"),
    
    TEST("test");

    private String value;

    OpEnum(String value) {
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
    public static OpEnum fromValue(String value) {
      for (OpEnum b : OpEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("op")
  private OpEnum op;

  @JsonProperty("path")
  private String path;

  @JsonProperty("value")
  private Object value;

  @JsonProperty("from")
  private String from;

  public PatchEntry op(OpEnum op) {
    this.op = op;
    return this;
  }

  /**
   * The operation to be performed.
   * @return op
  */
  @ApiModelProperty(required = true, value = "The operation to be performed.")
  @NotNull


  public OpEnum getOp() {
    return op;
  }

  public void setOp(OpEnum op) {
    this.op = op;
  }

  public PatchEntry path(String path) {
    this.path = path;
    return this;
  }

  /**
   * A JSON-Pointer.
   * @return path
  */
  @ApiModelProperty(required = true, value = "A JSON-Pointer.")
  @NotNull


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public PatchEntry value(Object value) {
    this.value = value;
    return this;
  }

  /**
   * The value to be used within the operations.
   * @return value
  */
  @ApiModelProperty(value = "The value to be used within the operations.")


  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public PatchEntry from(String from) {
    this.from = from;
    return this;
  }

  /**
   * A string containing a JSON Pointer value.
   * @return from
  */
  @ApiModelProperty(value = "A string containing a JSON Pointer value.")


  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatchEntry patchEntry = (PatchEntry) o;
    return Objects.equals(this.op, patchEntry.op) &&
        Objects.equals(this.path, patchEntry.path) &&
        Objects.equals(this.value, patchEntry.value) &&
        Objects.equals(this.from, patchEntry.from);
  }

  @Override
  public int hashCode() {
    return Objects.hash(op, path, value, from);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatchEntry {\n");
    
    sb.append("    op: ").append(toIndentedString(op)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
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

