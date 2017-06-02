/*
 * Name: LocationIdDeSerializer.java
 * 
 * Created by manojg on Jun 2, 2017
 * 
 * Description: Key Deserializer for location object used in LocationTree
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.ObjectMapper;

public class LocationIdDeSerializer extends KeyDeserializer {
	
	@Override
	public Object deserializeKey(String jsonStr, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		LocationId locationId = objectMapper.readValue(jsonStr, LocationId.class);
		return locationId;
	}
}