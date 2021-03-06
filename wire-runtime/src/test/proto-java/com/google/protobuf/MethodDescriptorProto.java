// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: ../wire-runtime/src/test/proto/google/protobuf/descriptor.proto at 196:1
package com.google.protobuf;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

/**
 * Describes a method of a service.
 */
public final class MethodDescriptorProto extends Message<MethodDescriptorProto, MethodDescriptorProto.Builder> {
  public static final ProtoAdapter<MethodDescriptorProto> ADAPTER = new ProtoAdapter<MethodDescriptorProto>(FieldEncoding.LENGTH_DELIMITED, MethodDescriptorProto.class) {
    @Override
    public int encodedSize(MethodDescriptorProto value) {
      return (value.name != null ? ProtoAdapter.STRING.encodedSize(1, value.name) : 0)
          + (value.doc != null ? ProtoAdapter.STRING.encodedSize(5, value.doc) : 0)
          + (value.input_type != null ? ProtoAdapter.STRING.encodedSize(2, value.input_type) : 0)
          + (value.output_type != null ? ProtoAdapter.STRING.encodedSize(3, value.output_type) : 0)
          + (value.options != null ? MethodOptions.ADAPTER.encodedSize(4, value.options) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, MethodDescriptorProto value) throws IOException {
      if (value.name != null) ProtoAdapter.STRING.encodeTagged(writer, 1, value.name);
      if (value.doc != null) ProtoAdapter.STRING.encodeTagged(writer, 5, value.doc);
      if (value.input_type != null) ProtoAdapter.STRING.encodeTagged(writer, 2, value.input_type);
      if (value.output_type != null) ProtoAdapter.STRING.encodeTagged(writer, 3, value.output_type);
      if (value.options != null) MethodOptions.ADAPTER.encodeTagged(writer, 4, value.options);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public MethodDescriptorProto decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.name(ProtoAdapter.STRING.decode(reader)); break;
          case 5: builder.doc(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.input_type(ProtoAdapter.STRING.decode(reader)); break;
          case 3: builder.output_type(ProtoAdapter.STRING.decode(reader)); break;
          case 4: builder.options(MethodOptions.ADAPTER.decode(reader)); break;
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public MethodDescriptorProto redact(MethodDescriptorProto value) {
      Builder builder = value.newBuilder();
      if (builder.options != null) builder.options = MethodOptions.ADAPTER.redact(builder.options);
      builder.clearUnknownFields();
      return builder.build();
    }
  };

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_NAME = "";

  public static final String DEFAULT_DOC = "";

  public static final String DEFAULT_INPUT_TYPE = "";

  public static final String DEFAULT_OUTPUT_TYPE = "";

  public final String name;

  /**
   * Doc string for generated code.
   */
  public final String doc;

  /**
   * Input and output type names.  These are resolved in the same way as
   * FieldDescriptorProto.type_name, but must refer to a message type.
   */
  public final String input_type;

  public final String output_type;

  public final MethodOptions options;

  public MethodDescriptorProto(String name, String doc, String input_type, String output_type, MethodOptions options) {
    this(name, doc, input_type, output_type, options, ByteString.EMPTY);
  }

  public MethodDescriptorProto(String name, String doc, String input_type, String output_type, MethodOptions options, ByteString unknownFields) {
    super(unknownFields);
    this.name = name;
    this.doc = doc;
    this.input_type = input_type;
    this.output_type = output_type;
    this.options = options;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.name = name;
    builder.doc = doc;
    builder.input_type = input_type;
    builder.output_type = output_type;
    builder.options = options;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof MethodDescriptorProto)) return false;
    MethodDescriptorProto o = (MethodDescriptorProto) other;
    return equals(unknownFields(), o.unknownFields())
        && equals(name, o.name)
        && equals(doc, o.doc)
        && equals(input_type, o.input_type)
        && equals(output_type, o.output_type)
        && equals(options, o.options);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (name != null ? name.hashCode() : 0);
      result = result * 37 + (doc != null ? doc.hashCode() : 0);
      result = result * 37 + (input_type != null ? input_type.hashCode() : 0);
      result = result * 37 + (output_type != null ? output_type.hashCode() : 0);
      result = result * 37 + (options != null ? options.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (name != null) builder.append(", name=").append(name);
    if (doc != null) builder.append(", doc=").append(doc);
    if (input_type != null) builder.append(", input_type=").append(input_type);
    if (output_type != null) builder.append(", output_type=").append(output_type);
    if (options != null) builder.append(", options=").append(options);
    return builder.replace(0, 2, "MethodDescriptorProto{").append('}').toString();
  }

  public static final class Builder extends com.squareup.wire.Message.Builder<MethodDescriptorProto, Builder> {
    public String name;

    public String doc;

    public String input_type;

    public String output_type;

    public MethodOptions options;

    public Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Doc string for generated code.
     */
    public Builder doc(String doc) {
      this.doc = doc;
      return this;
    }

    /**
     * Input and output type names.  These are resolved in the same way as
     * FieldDescriptorProto.type_name, but must refer to a message type.
     */
    public Builder input_type(String input_type) {
      this.input_type = input_type;
      return this;
    }

    public Builder output_type(String output_type) {
      this.output_type = output_type;
      return this;
    }

    public Builder options(MethodOptions options) {
      this.options = options;
      return this;
    }

    @Override
    public MethodDescriptorProto build() {
      return new MethodDescriptorProto(name, doc, input_type, output_type, options, buildUnknownFields());
    }
  }
}
