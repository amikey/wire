/*
 * Copyright 2015 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.wire;

import com.squareup.wire.protos.person.Person;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import okio.Buffer;
import okio.ByteString;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public final class ProtoAdapterTest {
  @Test public void getFromClass() throws Exception {
    Person person = new Person.Builder()
        .id(99)
        .name("Omar Little")
        .build();
    ByteString encoded = ByteString.decodeHex("0a0b4f6d6172204c6974746c651063");

    ProtoAdapter<Person> personAdapter = ProtoAdapter.get(Person.class);
    assertThat(ByteString.of(personAdapter.encode(person))).isEqualTo(encoded);
    assertThat(personAdapter.decode(encoded.toByteArray())).isEqualTo(person);
  }

  @Test public void getFromClassWrongType() throws Exception {
    Message nonGeneratedMessage = new Message(TagMap.EMPTY) {};
    try {
      ProtoAdapter.get(nonGeneratedMessage.getClass());
      fail();
    } catch (IllegalArgumentException expected) {
      assertThat(expected).hasMessageStartingWith("failed to access ");
    }
  }

  @Test public void nullSafe() throws IOException {
    List<ProtoAdapter<?>> adapters = Arrays.<ProtoAdapter<?>>asList(
        ProtoAdapter.BOOL,
        ProtoAdapter.BYTES,
        ProtoAdapter.DOUBLE,
        ProtoAdapter.FIXED32,
        ProtoAdapter.FIXED64,
        ProtoAdapter.FLOAT,
        ProtoAdapter.INT32,
        ProtoAdapter.INT64,
        ProtoAdapter.SFIXED32,
        ProtoAdapter.SFIXED64,
        ProtoAdapter.SINT32,
        ProtoAdapter.SINT64,
        ProtoAdapter.STRING,
        ProtoAdapter.UINT32,
        ProtoAdapter.UINT64,
        ProtoAdapter.newMessageAdapter(Person.class),
        ProtoAdapter.newEnumAdapter(Person.PhoneType.class)
    );
    Buffer buffer = new Buffer();
    ProtoWriter writer = new ProtoWriter(buffer);
    for (ProtoAdapter<?> adapter : adapters) {
      assertThat(adapter.encodedSize(null)).isZero();
      assertThat(adapter.encodedSize(1, null)).isZero();

      adapter.encode(writer, null);
      assertThat(buffer.size()).isZero();

      adapter.encodeTagged(writer, 1, null);
      assertThat(buffer.size()).isZero();

      assertThat(adapter.redact(null)).isNull();
    }
  }
}
