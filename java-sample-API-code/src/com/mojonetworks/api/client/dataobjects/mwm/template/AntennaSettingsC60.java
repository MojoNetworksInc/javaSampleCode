/*
 * Name: AntennaSettingsC60.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for C-60 platform's antenna settings 
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;


public class AntennaSettingsC60 extends MWMBaseObject implements AntennaSettings {
	private boolean isExternal;

	public AntennaSettingsC60() {
	}

	@Override
	public int getPlatformId() {
		return TemplateConstant.PLATFORM_SS_300_AT_C_60_ID;
	}
	
	public boolean isExternal() {
		return isExternal;
	}
	public void setExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}


}
