/*
 * Name: AntennaSettingsC10.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for C10 platform AntennaSettings information
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;


public class AntennaSettingsC10 extends AntennaSettingsC60 {
	private int port;
	private String antennaModel2_4;
	private String antennaModel5;
	
	@Override
	public int getPlatformId() {
		return TemplateConstant.PLATFORM_SS_300_AT_C_10_ID;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getAntennaModel2_4() {
		return antennaModel2_4;
	}

	public void setAntennaModel2_4(String antennaModel2_4) {
		this.antennaModel2_4 = antennaModel2_4;
	}

	public String getAntennaModel5() {
		return antennaModel5;
	}

	public void setAntennaModel5(String antennaModel5) {
		this.antennaModel5 = antennaModel5;
	}
}
