/*
 * Name: Location.java
 *
 * Created by sabhtarsha on 24-May-2017
 *
 * Description: Object to hold the Location node
 *
 *
 */

package com.mojonetworks.api.client.dataobjects.mwm;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = FloorLocation.class, name = "floorlocation"), @Type(value = FolderLocation.class, name = "folderlocation") })
public abstract class Location{

	private LocationId id;
	private LocationId parentId;
	private String name;
	private boolean accessibleToUser;
	private boolean defaultLocation;
	private String timezoneId;
	private String locationTag;
	
	public Location() {
		
	}
	
	public Location(Location l) {
		this.id = l.id;
		this.parentId = l.parentId;
		this.name = l.name;
		this.accessibleToUser = l.accessibleToUser;
		this.defaultLocation = l.defaultLocation;
		this.timezoneId = l.timezoneId;
	}
	
	public Location(LocationId id) {
		super();
		this.id = id;
	}

	public LocationId getId() {
		return id;
	}

	public void setId(LocationId id) {
		this.id = id;
	}

	public LocationId getParentId() {
		return parentId;
	}

	public void setParentId(LocationId parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAccessibleToUser() {
		return accessibleToUser;
	}
	public void setAccessibleToUser(boolean currentUserHasRights) {
		this.accessibleToUser = currentUserHasRights;
	}
	public boolean isDefaultLocation() {
		return defaultLocation;
	}

	public void setDefaultLocation(boolean defaultLocation) {
		this.defaultLocation = defaultLocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", parentId=" + parentId + ", name="
				+ name + ", accessibleToUser=" + accessibleToUser
				+ ", defaultLocation=" + defaultLocation + ", timezoneId="
				+ timezoneId + "]";
	}

	public void setTimezoneId(String timezoneId) {
		this.timezoneId = timezoneId;
	}

	public String getTimezoneId() {
		return timezoneId;
	}

	public String getLocationTag() {
		return locationTag;
	}

	public void setLocationTag(String locationTag) {
		this.locationTag = locationTag;
	}
}
