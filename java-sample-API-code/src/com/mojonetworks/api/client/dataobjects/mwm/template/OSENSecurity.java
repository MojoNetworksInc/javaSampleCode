/*
 * Name: OSENSecurity.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for OSEN
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;


public class OSENSecurity extends MWMBaseObject implements ISecurityMode {

	public static final int RADIUS_802_1X_RETRY_TIMEOUT_DEFAULT = 2;
	public static final int RADIUS_802_1X_MAX_RETRIES_DEFAULT = 4;
	public static final int RADIUS_802_1X_MIN = 1;
	public static final int RADIUS_802_1X_MAX = 10;
	
	private boolean coaEnabled = false;
	private RadiusConfiguration authPrimaryRadiusConfig;
	private RadiusConfiguration authSecondaryRadiusConfig;
	private RadiusConfiguration accPrimaryRadiusConfig;
	private RadiusConfiguration accSecondaryRadiusConfig;
	private boolean	radiusAccountingEnabled;
	
	private String nasId;
	private int radiusRetryTimeout = RADIUS_802_1X_RETRY_TIMEOUT_DEFAULT; 
	private int radiusMaxRetries = RADIUS_802_1X_MAX_RETRIES_DEFAULT;
	private boolean	okcEnabled;
	private boolean	preAuthenticationEnabled;
	private ManagementFrameProtection mgmtFrameProtection80211w;
	private GroupManagementCipherSuite groupMgmtCipherSuite;
	private int saQueryMaxTimeout;
	private int saQueryRetryTimeout;
	private boolean enable11r;
	private boolean overTheDS;
	private boolean mixedMode;

	public enum ManagementFrameProtection {
		DISABLED(0),
		OPTIONAL(1),
		REQUIRED(2);

		private int value;

		private ManagementFrameProtection(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public static ManagementFrameProtection get(int value) throws IllegalArgumentException {
			for (ManagementFrameProtection i : values()) {
				if (i.value == value) {
					return i;
				}
			}
			throw new IllegalArgumentException("Illegal value for 802.11w Management Frame Protection : " + value);
		}
	}

	public enum GroupManagementCipherSuite {
		AES128CMAC(0, "AES-128-CMAC", true),
		BIPGMAC128(1, "BIP-GMAC-128", false),
		BIPGMAC256(2, "BIP-GMAC-256", false),
		BIPCMAC256(3, "BIP-CMAC-256", false);

		private int value;
		private String displayString;
		private boolean enabled;

		private GroupManagementCipherSuite(int value, String displayString, boolean enabled) {
			this.value = value;
			this.displayString = displayString;
			this.enabled = enabled;
		}

		public String getDisplayString() {
			return displayString;
		}

		public boolean isEnabled() {
			return enabled;
		}

		public int getValue() {
			return value;
		}

		public static GroupManagementCipherSuite get(int value) throws IllegalArgumentException {
			for (GroupManagementCipherSuite i : values()) {
				if (i.value == value) {
					return i;
				}
			}
			throw new IllegalArgumentException("Illegal value for Group Management Cipher Suite : " + value);
		}
	}
	public OSENSecurity() {
	}

	public boolean isCoaEnabled() {
		return coaEnabled;
	}

	public void setCoaEnabled(boolean coaEnabled) {
		this.coaEnabled = coaEnabled;
	}
	
	public boolean isRadiusAccountingEnabled() {
		return radiusAccountingEnabled;
	}

	public void setRadiusAccountingEnabled(boolean radiusAccountingEnabled) {
		this.radiusAccountingEnabled = radiusAccountingEnabled;
	}

	public String getNasId() {
		return nasId;
	}

	public void setNasId(String nasId) {
		this.nasId = nasId;
	}

	public boolean isOkcEnabled() {
		return okcEnabled;
	}

	public void setOkcEnabled(boolean okcEnabled) {
		this.okcEnabled = okcEnabled;
	}

	public boolean isPreAuthenticationEnabled() {
		return preAuthenticationEnabled;
	}

	public void setPreAuthenticationEnabled(boolean preAuthenticationEnabled) {
		this.preAuthenticationEnabled = preAuthenticationEnabled;
	}

	public ManagementFrameProtection getMgmtFrameProtection80211w() {
		return mgmtFrameProtection80211w;
	}

	public void setMgmtFrameProtection80211w(
			ManagementFrameProtection mgmtFrameProtection80211w) {
		this.mgmtFrameProtection80211w = mgmtFrameProtection80211w;
	}

	public GroupManagementCipherSuite getGroupMgmtCipherSuite() {
		return groupMgmtCipherSuite;
	}

	public void setGroupMgmtCipherSuite(
			GroupManagementCipherSuite groupMgmtCipherSuite) {
		this.groupMgmtCipherSuite = groupMgmtCipherSuite;
	}

	public int getSaQueryMaxTimeout() {
		return saQueryMaxTimeout;
	}

	public void setSaQueryMaxTimeout(int saQueryMaxTimeout) {
		this.saQueryMaxTimeout = saQueryMaxTimeout;
	}

	public int getSaQueryRetryTimeout() {
		return saQueryRetryTimeout;
	}

	public void setSaQueryRetryTimeout(int saQueryRetryTimeout) {
		this.saQueryRetryTimeout = saQueryRetryTimeout;
	}

	public boolean isEnable11r() {
		return enable11r;
	}

	public void setEnable11r(boolean enable11r) {
		this.enable11r = enable11r;
	}

	public boolean isOverTheDS() {
		return overTheDS;
	}

	public void setOverTheDS(boolean overTheDS) {
		this.overTheDS = overTheDS;
	}

	public boolean isMixedMode() {
		return mixedMode;
	}

	public void setMixedMode(boolean mixedMode) {
		this.mixedMode = mixedMode;
	}
	
	public RadiusConfiguration getAuthPrimaryRadiusConfig() {
		return authPrimaryRadiusConfig;
	}

	public void setAuthPrimaryRadiusConfig(RadiusConfiguration authPrimaryRadiusConfig) {
		this.authPrimaryRadiusConfig = authPrimaryRadiusConfig;
	}

	public RadiusConfiguration getAuthSecondaryRadiusConfig() {
		return authSecondaryRadiusConfig;
	}

	public void setAuthSecondaryRadiusConfig(RadiusConfiguration authSecondaryRadiusConfig) {
		this.authSecondaryRadiusConfig = authSecondaryRadiusConfig;
	}

	public RadiusConfiguration getAccPrimaryRadiusConfig() {
		return accPrimaryRadiusConfig;
	}

	public void setAccPrimaryRadiusConfig(RadiusConfiguration accPrimaryRadiusConfig) {
		this.accPrimaryRadiusConfig = accPrimaryRadiusConfig;
	}

	public RadiusConfiguration getAccSecondaryRadiusConfig() {
		return accSecondaryRadiusConfig;
	}

	public void setAccSecondaryRadiusConfig(RadiusConfiguration accSecondaryRadiusConfig) {
		this.accSecondaryRadiusConfig = accSecondaryRadiusConfig;
	}

	public int getRadiusRetryTimeout() {
		return radiusRetryTimeout;
	}

	public void setRadiusRetryTimeout(int radiusRetryTimeout) {
		this.radiusRetryTimeout = radiusRetryTimeout;
	}

	public int getRadiusMaxRetries() {
		return radiusMaxRetries;
	}

	public void setRadiusMaxRetries(int radiusMaxRetries) {
		this.radiusMaxRetries = radiusMaxRetries;
	}

	@Override
	public String toString() {
		return "OSENSecurity [coaEnabled=" + coaEnabled + ", radiusServerGroup="+", nasId="
				+ nasId + ", radiusRetryTimeout=" + radiusRetryTimeout + ", radiusMaxRetries=" + radiusMaxRetries
				+ ", okcEnabled=" + okcEnabled + ", preAuthenticationEnabled=" + preAuthenticationEnabled
				+ ", mgmtFrameProtection80211w=" + mgmtFrameProtection80211w + ", groupMgmtCipherSuite="
				+ groupMgmtCipherSuite + ", saQueryMaxTimeout=" + saQueryMaxTimeout + ", saQueryRetryTimeout="
				+ saQueryRetryTimeout + ", enable11r=" + enable11r + ", overTheDS=" + overTheDS + ", mixedMode="
				+ mixedMode + "]";
	}
}
