/*
 * Name: AntennaSettingsC50.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for C-50 platform's antenna settings 
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;


public class AntennaSettingsC50 extends AntennaSettingsC60 {
	private int port;
	private String antennaModel;

	public AntennaSettingsC50() {
	}

	@Override
	public int getPlatformId(){
		return TemplateConstant.PLATFORM_SS_300_AT_C_50_ID;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getAntennaModel() {
		return antennaModel;
	}

	public void setAntennaModel(String antennaModel) {
		this.antennaModel = antennaModel;
	}
}
