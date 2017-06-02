/*
 * Name: LocationRequestData.java
 * 
 * Created by manojg on Jun 2, 2017
 * 
 * Description: POJO to hold add location request data
 */
package com.mojonetworks.api.client.dataobjects.mwm;

public class LocationRequestData{
	LocationId parentLocation;
	Location location;
	
	public LocationRequestData() {
	}
	
	public LocationRequestData(LocationId parent, Location location) {
		this.parentLocation = parent;
		this.location = location;
	}
	
	public LocationId getParentLocation() {
		return parentLocation;
	}
	public void setParentLocation(LocationId parentLocation) {
		this.parentLocation = parentLocation;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
}
