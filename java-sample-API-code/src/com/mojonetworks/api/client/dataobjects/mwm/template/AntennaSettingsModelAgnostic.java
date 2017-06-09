/*
 * Name: AntennaSettingsModelAgnostic.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Model Agnostic antenna settings
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;


public class AntennaSettingsModelAgnostic extends MWMBaseObject implements AntennaSettings {
	private boolean isExternal;

	public AntennaSettingsModelAgnostic() {
	}

	@Override
	public int getPlatformId() {
		return TemplateConstant.PLATFORM_SS_300_AT_MODEL_AGNOSTIC_ID;
	}
	
	public boolean isExternal() {
		return isExternal;
	}
	public void setExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}


}
