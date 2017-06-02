/*
 * Name: LocationIdSerializer.java
 * 
 * Created by manojg on Jun 2, 2017
 * 
 * Description: Key serializer used in LocationTree
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;

public class LocationIdSerializer extends JsonSerializer<LocationId> {

	@Override
	public void serialize(LocationId value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		jgen.writeFieldName(mapper.writeValueAsString(value));
	}

}