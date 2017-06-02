/*
 * Name: LocationTree.java
 * 
 * Created by manojg on Jun 2, 2017
 * 
 * Description: POJO to hold location tree details
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LocationTree{

	private LocationId rootLocationId;
	
	@JsonSerialize(keyUsing = LocationIdSerializer.class)
	@JsonDeserialize(keyUsing = LocationIdDeSerializer.class)
	private Map<LocationId, Location> locations = new HashMap<LocationId, Location>();

	public LocationTree() {
	}
	
	public LocationId getRootLocationId() {
		return rootLocationId;
	}
	
	public Map<LocationId, Location> getLocations() {
		return locations;
	}

	@Override
	public String toString() {
		return "LocationTree [rootLocationId=" + rootLocationId
				+ ", locations=" + locations + "]";
	}
}
