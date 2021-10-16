/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch._types.query_dsl;

import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ModelTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.Integer;
import java.util.function.Function;

// typedef: _types.query_dsl.SpanFirstQuery
@JsonpDeserializable
public class SpanFirstQuery extends QueryBase implements SpanQueryVariant, QueryVariant {
	private final int end;

	private final SpanQuery match;

	// ---------------------------------------------------------------------------------------------

	private SpanFirstQuery(Builder builder) {
		super(builder);

		this.end = ModelTypeHelper.requireNonNull(builder.end, this, "end");
		this.match = ModelTypeHelper.requireNonNull(builder.match, this, "match");

	}

	public static SpanFirstQuery of(Function<Builder, ObjectBuilder<SpanFirstQuery>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * {@link SpanQuery}, {@link Query} variant type
	 */
	@Override
	public String _variantType() {
		return "span_first";
	}

	/**
	 * Required - API name: {@code end}
	 */
	public final int end() {
		return this.end;
	}

	/**
	 * Required - API name: {@code match}
	 */
	public final SpanQuery match() {
		return this.match;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);
		generator.writeKey("end");
		generator.write(this.end);

		generator.writeKey("match");
		this.match.serialize(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link SpanFirstQuery}.
	 */
	public static class Builder extends QueryBase.AbstractBuilder<Builder> implements ObjectBuilder<SpanFirstQuery> {
		private Integer end;

		private SpanQuery match;

		/**
		 * Required - API name: {@code end}
		 */
		public final Builder end(int value) {
			this.end = value;
			return this;
		}

		/**
		 * Required - API name: {@code match}
		 */
		public final Builder match(SpanQuery value) {
			this.match = value;
			return this;
		}

		/**
		 * Required - API name: {@code match}
		 */
		public final Builder match(Function<SpanQuery.Builder, ObjectBuilder<SpanQuery>> fn) {
			return this.match(fn.apply(new SpanQuery.Builder()).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link SpanFirstQuery}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public SpanFirstQuery build() {
			_checkSingleUse();

			return new SpanFirstQuery(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link SpanFirstQuery}
	 */
	public static final JsonpDeserializer<SpanFirstQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			SpanFirstQuery::setupSpanFirstQueryDeserializer, Builder::build);

	protected static void setupSpanFirstQueryDeserializer(DelegatingDeserializer<SpanFirstQuery.Builder> op) {
		setupQueryBaseDeserializer(op);
		op.add(Builder::end, JsonpDeserializer.integerDeserializer(), "end");
		op.add(Builder::match, SpanQuery._DESERIALIZER, "match");

	}

}