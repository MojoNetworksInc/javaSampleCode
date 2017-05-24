/*
 * Name: FolderLocation.java
 *
 * Created by sabhtarsha on 24-May-2017
 *
 * Description: Object to hold Folder location
 *
 *
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import java.util.LinkedList;
import java.util.List;

public class FolderLocation extends Location {

	private List<LocationId> children = new LinkedList<LocationId>();

	public FolderLocation() {

	}

	public FolderLocation(FolderLocation l) {
		super(l);
		for(LocationId childId:l.children) {
			this.children.add(childId);
		}
	}

	public List<LocationId> getChildren() {
		return children;
	}

	public void addChild(LocationId child) {
		children.add(child);
	}

	@Override
	public String toString() {
		return "FolderLocation [children=" + children + ", toString()="
				+ super.toString() + "]";
	}
}
