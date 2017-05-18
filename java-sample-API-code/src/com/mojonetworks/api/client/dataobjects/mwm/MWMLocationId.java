/*
 * Name: MWMLocationId.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Location Id object fetched from MWM
 *
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MWMLocationId {
	public static final int ROOT_LOCATION_ID = 0;

	private String type;
	private int id;
	//TODO: Handle Remote location Id - Will be done while handling MSU location tree
	
	public MWMLocationId() {
	}
	
	public MWMLocationId(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		MWMLocationId other = (MWMLocationId) obj;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LocationId [type=" + type + ", id=" + id + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
