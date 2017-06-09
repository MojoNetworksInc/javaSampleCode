/*
 * Name: Country.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for country information
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;

public class Country extends MWMBaseObject{

	public static final int UNRESTRICTED_COUNTRY_CODE=9999;
	private int newCode;
	private String name;
	
	public Country() {
	}

	public Country(int code, int newCode, String name) {
		this.newCode = newCode;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNewCode() {
		return newCode;
	}

	public void setNewCode(int newCode) {
		this.newCode = newCode;
	}

	@Override
	public String toString() {
		return name;
	}
}
