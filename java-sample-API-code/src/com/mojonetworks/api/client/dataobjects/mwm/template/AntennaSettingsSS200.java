/*
 * Name: AntennaSettingsSS200.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO 
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;


public class AntennaSettingsSS200 extends MWMBaseObject implements AntennaSettings {
	private boolean isDiversityOn;
	
	public AntennaSettingsSS200() {
	}

	public boolean isDiversityOn() {
		return isDiversityOn;
	}

	public void setDiversityOn(boolean isDiversityOn) {
		this.isDiversityOn = isDiversityOn;
	}

	@Override
	public int getPlatformId() {
		return TemplateConstant.PLATFORM_SS_200_AT_01_ID;
	}
}
