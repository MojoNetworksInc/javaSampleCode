/*
 * Name: TemplateType.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: Template type enum
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

public enum TemplateType {
	DEVICE_TEMPLATE(6),
	SSID_PROFILE(10); 
	
	private int value;
	
	private TemplateType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static TemplateType getTemplateType(int value) {
		if(value == TemplateType.DEVICE_TEMPLATE.getValue()) {
			return TemplateType.DEVICE_TEMPLATE;
		} else if(value == TemplateType.SSID_PROFILE.getValue()) {
			return TemplateType.SSID_PROFILE;
		}
		return null;
	}
}
