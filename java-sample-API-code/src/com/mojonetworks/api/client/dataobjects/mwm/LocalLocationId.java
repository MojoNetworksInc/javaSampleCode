/*
 * Name: LocalLocationId.java
 *
 * Created by sabhtarsha on 24-May-2017
 *
 * Description: Object to hold Location location id
 *
 *
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LocalLocationId extends LocationId {

	private int id;
	
	public static final int ROOT_LOCATION_ID = 0;
	
	public LocalLocationId() {
	}
	
	public LocalLocationId(int id) {
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
		LocalLocationId other = (LocalLocationId) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LocalLocationId [id=" + id + "]";
	}
}
