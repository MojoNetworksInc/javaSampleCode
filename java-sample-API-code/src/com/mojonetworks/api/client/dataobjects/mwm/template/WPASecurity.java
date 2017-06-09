/*
 * Name: WPASecurity.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO WPA security
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;

public abstract class WPASecurity extends MWMBaseObject implements ISecurityMode {

	public enum WPAAuthType {
		PSK("PSK"),
		EAP("EAP");

		private String value;
		private WPAAuthType (String value){
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	private boolean coaEnabled = false;
	private WPAAuthType authType;
	private String	pskPassphrase;

	private String	authPrimaryRadiusServerIP;
	private String	authPrimaryRadiusSecret;
	private int	authPrimaryRadiusPort = 1812;
	private String	authSecondaryRadiusServerIP;
	private String	authSecondaryRadiusSecret;
	private int	authSecondaryRadiusPort = 1812;
	private String	accPrimaryRadiusServerIP;
	private String	accPrimaryRadiusSecret;
	private int	accPrimaryRadiusPort = 1813;
	private String	accSecondaryRadiusServerIP;
	private String	accSecondaryRadiusSecret;
	private int	accSecondaryRadiusPort = 1813;
	private boolean	radiusAccountingEnabled;
	
	private String nasId;
	public static final int RADIUS_802_1X_RETRY_TIMEOUT_DEFAULT = 2;
	public static final int RADIUS_802_1X_MAX_RETRIES_DEFAULT = 4;
	public static final int RADIUS_802_1X_MIN = 1;
	public static final int RADIUS_802_1X_MAX = 10;
	private String calledStationId;
	
	private int radius802_1XRetryTimeout = RADIUS_802_1X_RETRY_TIMEOUT_DEFAULT; 
	private int radius802_1XMaxRetries = RADIUS_802_1X_MAX_RETRIES_DEFAULT;
	
	public String getCalledStationId() {
		return calledStationId;
	}

	public void setCalledStationId(String calledStationId) {
		this.calledStationId = calledStationId;
	}
	
	public int getRadius802_1XRetryTimeout() {
		return radius802_1XRetryTimeout;
	}

	public void setRadius802_1XRetryTimeout(int radius802_1xRetryTimeout) {
		radius802_1XRetryTimeout = radius802_1xRetryTimeout;
	}

	public int getRadius802_1XMaxRetries() {
		return radius802_1XMaxRetries;
	}

	public void setRadius802_1XMaxRetries(int radius802_1xMaxRetries) {
		radius802_1XMaxRetries = radius802_1xMaxRetries;
	}
	
	public WPASecurity(WPAAuthType authType) {
		this.authType = authType;
	}

	public WPASecurity() {
	}

	public String getPskPassphrase() {
		return pskPassphrase;
	}

	public void setPskPassphrase(String pskPassphrase) {
		this.pskPassphrase = pskPassphrase;
	}

	public String getAuthPrimaryRadiusServerIP() {
		return authPrimaryRadiusServerIP;
	}

	public void setAuthPrimaryRadiusServerIP(String authPrimaryRadiusServerIP) {
		this.authPrimaryRadiusServerIP = authPrimaryRadiusServerIP;
	}

	public String getAuthPrimaryRadiusSecret() {
		return authPrimaryRadiusSecret;
	}

	public void setAuthPrimaryRadiusSecret(String authPrimaryRadiusSecret) {
		this.authPrimaryRadiusSecret = authPrimaryRadiusSecret;
	}

	public int getAuthPrimaryRadiusPort() {
		return authPrimaryRadiusPort;
	}

	public void setAuthPrimaryRadiusPort(int authPrimaryRadiusPort) {
		this.authPrimaryRadiusPort = authPrimaryRadiusPort;
	}
	
	public String getAuthSecondaryRadiusServerIP() {
		return authSecondaryRadiusServerIP;
	}

	public void setAuthSecondaryRadiusServerIP(String authSecondaryRadiusServerIP) {
		this.authSecondaryRadiusServerIP = authSecondaryRadiusServerIP;
	}

	public String getAuthSecondaryRadiusSecret() {
		return authSecondaryRadiusSecret;
	}
	
	public void setAuthSecondaryRadiusSecret(String authSecondaryRadiusSecret) {
		this.authSecondaryRadiusSecret = authSecondaryRadiusSecret;
	}

	public int getAuthSecondaryRadiusPort() {
		return authSecondaryRadiusPort;
	}

	public void setAuthSecondaryRadiusPort(int authSecondaryRadiusPort) {
		this.authSecondaryRadiusPort = authSecondaryRadiusPort;
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

	public boolean isRadiusAccountingEnabled() {
		return radiusAccountingEnabled;
	}

	public void setRadiusAccountingEnabled(boolean radiusAccountingEnabled) {
		this.radiusAccountingEnabled = radiusAccountingEnabled;
	}

	public WPAAuthType getAuthType() {
		return authType;
	}

	public String getNasId() {
		return nasId;
	}

	public void setNasId(String nasId) {
		this.nasId = nasId;
	}

	public boolean isCoaEnabled() {
		return coaEnabled;
	}

	public void setCoaEnabled(boolean coaEnabled) {
		this.coaEnabled = coaEnabled;
	}

	public void setAuthType(WPAAuthType authType) {
		this.authType = authType;
	}
	
	@Override
	public String toString() {
		return "WPASecurity [coaEnabled=" + coaEnabled + ", authType=" + authType + ", pskPassphrase=" + pskPassphrase
				+ ", nasId=" + nasId + ", calledStationId="
				+ calledStationId + ", radius802_1XRetryTimeout="
				+ radius802_1XRetryTimeout + ", radius802_1XMaxRetries=" + radius802_1XMaxRetries + "]";
	}
}