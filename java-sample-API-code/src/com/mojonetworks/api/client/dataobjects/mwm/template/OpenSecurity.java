/*
 * Name: OpenSecurity.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for open security
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;

public class OpenSecurity extends MWMBaseObject implements ISecurityMode {
	private String nasId;
	private boolean	radiusAccountingEnabled;
	private String	accPrimaryRadiusServerIP;
	private String	accPrimaryRadiusSecret;
	private int	accPrimaryRadiusPort = 1813;
	private String	accSecondaryRadiusServerIP;
	private String	accSecondaryRadiusSecret;
	private int	accSecondaryRadiusPort = 1813;
	private String calledStationId;

	public void setRadiusAccountingEnabled(boolean radiusAccountingEnabled) {
		this.radiusAccountingEnabled = radiusAccountingEnabled;
	}


	public boolean isRadiusAccountingEnabled() {
		return radiusAccountingEnabled;
	}

	public String getNasId() {
		return nasId;
	}


	public void setNasId(String nasId) {
		this.nasId = nasId;
	}


	public String getAccPrimaryRadiusServerIP() {
		return accPrimaryRadiusServerIP;
	}


	public void setAccPrimaryRadiusServerIP(String accPrimaryRadiusServerIP) {
		this.accPrimaryRadiusServerIP = accPrimaryRadiusServerIP;
	}


	public String getAccPrimaryRadiusSecret() {
		return accPrimaryRadiusSecret;
	}


	public void setAccPrimaryRadiusSecret(String accPrimaryRadiusSecret) {
		this.accPrimaryRadiusSecret = accPrimaryRadiusSecret;
	}


	public int getAccPrimaryRadiusPort() {
		return accPrimaryRadiusPort;
	}


	public void setAccPrimaryRadiusPort(int accPrimaryRadiusPort) {
		this.accPrimaryRadiusPort = accPrimaryRadiusPort;
	}


	public String getAccSecondaryRadiusServerIP() {
		return accSecondaryRadiusServerIP;
	}


	public void setAccSecondaryRadiusServerIP(String accSecondaryRadiusServerIP) {
		this.accSecondaryRadiusServerIP = accSecondaryRadiusServerIP;
	}


	public String getAccSecondaryRadiusSecret() {
		return accSecondaryRadiusSecret;
	}


	public void setAccSecondaryRadiusSecret(String accSecondaryRadiusSecret) {
		this.accSecondaryRadiusSecret = accSecondaryRadiusSecret;
	}

	public int getAccSecondaryRadiusPort() {
		return accSecondaryRadiusPort;
	}


	public void setAccSecondaryRadiusPort(int accSecondaryRadiusPort) {
		this.accSecondaryRadiusPort = accSecondaryRadiusPort;
	}


	public String getCalledStationId() {
		return calledStationId;
	}


	public void setCalledStationId(String calledStationId) {
		this.calledStationId = calledStationId;
	}
}
