/*
 * Name: FloorLocation.java
 *
 * Created by sabhtarsha on 24-May-2017
 *
 * Description: Object to hold Floor Location
 *
 *
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FloorLocation extends Location {

	public FloorLocation() {
	}
	
	public FloorLocation(FloorLocation floorLocation) {
		super(floorLocation);
	}
}
