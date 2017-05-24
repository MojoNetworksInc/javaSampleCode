/*
 * Name: RemoteLocationId.java
 *
 * Created by sabhtarsha on 24-May-2017
 *
 * Description: Object to hold the remote location object available only in the cluster deployments
 *
 *
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RemoteLocationId extends LocalLocationId {

	private int childId;

	public void setChildId(int childId) {
		this.childId = childId;
	}

	public RemoteLocationId() {
		super();
	}

	public RemoteLocationId(int id, int childId) {
		super(id);
		this.childId = childId;
	}

	public int getChildId() {
		return childId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + childId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RemoteLocationId other = (RemoteLocationId) obj;
		if (childId != other.childId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RemoteLocationId [childId=" + childId + ", toString()="
				+ super.toString() + "]";
	}
}
