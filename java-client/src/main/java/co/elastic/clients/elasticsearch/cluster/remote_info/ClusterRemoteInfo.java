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

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package co.elastic.clients.elasticsearch.cluster.remote_info;

import co.elastic.clients.json.DelegatingDeserializer;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ModelTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import co.elastic.clients.util.ObjectBuilderBase;
import co.elastic.clients.util.TaggedUnion;
import co.elastic.clients.util.TaggedUnionUtils;
import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: cluster.remote_info.ClusterRemoteInfo
@JsonpDeserializable
public class ClusterRemoteInfo implements TaggedUnion<ClusterRemoteInfoVariant>, JsonpSerializable {

	public static final String PROXY = "proxy";
	public static final String SNIFF = "sniff";

	// Tagged union implementation

	private final String _type;
	private final ClusterRemoteInfoVariant _value;

	@Override
	public final String _type() {
		return _type;
	}

	@Override
	public final ClusterRemoteInfoVariant _get() {
		return _value;
	}

	public ClusterRemoteInfo(ClusterRemoteInfoVariant value) {

		this._type = ModelTypeHelper.requireNonNull(value._variantType(), this, "<variant type>");
		this._value = ModelTypeHelper.requireNonNull(value, this, "<variant value>");

	}

	private ClusterRemoteInfo(Builder builder) {

		this._type = ModelTypeHelper.requireNonNull(builder._type, builder, "<variant type>");
		this._value = ModelTypeHelper.requireNonNull(builder._value, builder, "<variant value>");

	}

	public static ClusterRemoteInfo of(Function<Builder, ObjectBuilder<ClusterRemoteInfo>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Get the {@code proxy} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code proxy} kind.
	 */
	public ClusterRemoteProxyInfo proxy() {
		return TaggedUnionUtils.get(this, PROXY);
	}

	/**
	 * Get the {@code sniff} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code sniff} kind.
	 */
	public ClusterRemoteSniffInfo sniff() {
		return TaggedUnionUtils.get(this, SNIFF);
	}

	@Override
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {

		mapper.serialize(_value, generator);

	}

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ClusterRemoteInfo> {
		private String _type;
		private ClusterRemoteInfoVariant _value;

		public Builder proxy(ClusterRemoteProxyInfo v) {
			this._type = PROXY;
			this._value = v;
			return this;
		}

		public Builder proxy(Function<ClusterRemoteProxyInfo.Builder, ObjectBuilder<ClusterRemoteProxyInfo>> f) {
			return this.proxy(f.apply(new ClusterRemoteProxyInfo.Builder()).build());
		}

		public Builder sniff(ClusterRemoteSniffInfo v) {
			this._type = SNIFF;
			this._value = v;
			return this;
		}

		public Builder sniff(Function<ClusterRemoteSniffInfo.Builder, ObjectBuilder<ClusterRemoteSniffInfo>> f) {
			return this.sniff(f.apply(new ClusterRemoteSniffInfo.Builder()).build());
		}

		public ClusterRemoteInfo build() {
			_checkSingleUse();
			return new ClusterRemoteInfo(this);
		}

	}

	protected static void setupClusterRemoteInfoDeserializer(DelegatingDeserializer<Builder> op) {

		op.add(Builder::proxy, ClusterRemoteProxyInfo._DESERIALIZER, "proxy");
		op.add(Builder::sniff, ClusterRemoteSniffInfo._DESERIALIZER, "sniff");

		op.setTypeProperty("mode");

	}

	public static final JsonpDeserializer<ClusterRemoteInfo> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, ClusterRemoteInfo::setupClusterRemoteInfoDeserializer, Builder::build);
}
