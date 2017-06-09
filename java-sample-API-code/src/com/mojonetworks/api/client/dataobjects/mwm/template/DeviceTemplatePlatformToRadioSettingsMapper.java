/*
 * Name: DeviceTemplatePlatformToRadioSettingsMapper.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: Sample code for devicte template radio setting mapper
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;

public class DeviceTemplatePlatformToRadioSettingsMapper extends MWMBaseObject{
	/**
	 * Platform Id to radio settings collection map.
	 */
	private Map<Integer, Collection<DeviceTemplateRadioSettings>> platformToRadioSettingsMap = new HashMap<Integer, Collection<DeviceTemplateRadioSettings>>();
	
	
	/**
	 * For Serialization
	 */
	public DeviceTemplatePlatformToRadioSettingsMapper() {
		super();
	}

	public Map<Integer, Collection<DeviceTemplateRadioSettings>> getPlatformToRadioSettingsMap() {
		return platformToRadioSettingsMap;
	}

	public void setPlatformToRadioSettingsMap(
			Map<Integer, Collection<DeviceTemplateRadioSettings>> platformToRadioSettingsMap) {
		this.platformToRadioSettingsMap = platformToRadioSettingsMap;
	}

	@Override
	public String toString() {
		return "DeviceTemplatePlatformToRadioSettingsMapper [platformToRadioSettingsMap="
				+ platformToRadioSettingsMap + "]";
	}
}
