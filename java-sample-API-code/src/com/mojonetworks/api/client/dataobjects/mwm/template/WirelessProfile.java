/*
 * Name: WirelessProfile.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Wireless profile
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import java.util.List;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;

public class WirelessProfile extends MWMBaseObject {

	private int vapId;
	private int vlanId = 0;
	
	private boolean	vapEnabled = false;
	private boolean ssidBroadcast = true;
	private boolean wmm = true;
	private boolean clientIsolation = false;
	private boolean profileEnabled;
	private boolean associtationLimited;
	private int associationLimitValue;
	private int apSecurityMode = SecurityMode.SECURITY_MODE_OPEN.getValue();
	private boolean isDynamicVlansEnabled;
	private List<Integer> listDynamicVlans;
	private boolean p2pCrossConnectionEnabled = true;
	
	public enum SecurityMode{
		SECURITY_MODE_OPEN(0,"Open"),
		SECURITY_MODE_WEP(1,"WEP"),
		SECURITY_MODE_WPA2(3,"WPA2"),
		SECURITY_MODE_WPA_WPA2_MIXED(4,"WPA and WPA2 Mixed mode"),
		SECURITY_MODE_OSEN(5, "Hotspot 2.0 OSEN");

		private int value;
		private String secModeString; //This is a display string on ui.

		private SecurityMode(int value,String secMode) {
			this.value = value;
			this.secModeString = secMode;
		}

		public int getValue() {
			return this.value;
		}

		public String getsecModeString() {
			return this.secModeString;
		}

		public static SecurityMode get(int value) throws IllegalArgumentException {
			for (SecurityMode i : values()) {
				if (i.value == value) {
					return i;
				}
			}
			throw new IllegalArgumentException("Illegal Security mode : " + value);
		}
		public static SecurityMode valueOfType(ISecurityMode mode) {
			if(mode instanceof OpenSecurity) {
				return SECURITY_MODE_OPEN;
			} else if(mode instanceof WEPSecurity) {
				return SECURITY_MODE_WEP;
			} else if(mode instanceof WPA2MixedSecurity) {
				return SECURITY_MODE_WPA_WPA2_MIXED;
			} else if(mode instanceof WPA2Security) {
				return SECURITY_MODE_WPA2;
			} else if(mode instanceof OSENSecurity) {
				return SECURITY_MODE_OSEN;
			}
			return SECURITY_MODE_OPEN;

		}

	}
	
	private SecAuthSettings secAuthSettings;
	private boolean secAuthenticationEnabled;
	private ISecurityMode securityMode = new OpenSecurity();
	
	public WirelessProfile() {
	}
	
	public SecAuthSettings getSecAuthSettings() {
		return secAuthSettings;
	}

	public void setSecAuthSettings(SecAuthSettings secAuthSettings) {
		this.secAuthSettings = secAuthSettings;
	}

	public boolean isSecAuthenticationEnabled() {
		return secAuthenticationEnabled;
	}

	public void setSecAuthenticationEnabled(boolean secAuthenticationEnabled) {
		this.secAuthenticationEnabled = secAuthenticationEnabled;
	}

	public ISecurityMode getSecurityMode() {
		return securityMode;
	}

	public void setSecurityMode(ISecurityMode securityMode) {
		this.securityMode = securityMode;
	}
	
	/**
	 * @return the apSecurityMode
	 */
	public int getApSecurityMode() {
		return apSecurityMode;
	}

	/**
	 * @param apSecurityMode the apSecurityMode to set
	 */
	public void setApSecurityMode(int apSecurityMode) {
		this.apSecurityMode = apSecurityMode;
	}
	
	public boolean isProfileEnabled() {
		return profileEnabled;
	}

	public void setProfileEnabled(boolean profileEnabled) {
		this.profileEnabled = profileEnabled;
	}
	
	public int getVapId() {
		return vapId;
	}

	public void setVapId(int vapId) {
		this.vapId = vapId;
	}

	public int getVlanId() {
		return vlanId;
	}

	public void setVlanId(int vlanId) {
		this.vlanId = vlanId;
	}

	public boolean isVapEnabled() {
		return vapEnabled;
	}

	public void setVapEnabled(boolean vapEnabled) {
		this.vapEnabled = vapEnabled;
	}

	public boolean isSsidBroadcast() {
		return ssidBroadcast;
	}

	public void setSsidBroadcast(boolean ssidBroadcast) {
		this.ssidBroadcast = ssidBroadcast;
	}

	public boolean isWmm() {
		return wmm;
	}

	public void setWmm(boolean wmm) {
		this.wmm = wmm;
	}

	public boolean isClientIsolation() {
		return clientIsolation;
	}

	public void setClientIsolation(boolean clientIsolation) {
		this.clientIsolation = clientIsolation;
	}

	public boolean isAssociationLimited() {
		return associtationLimited;
	}

	public int getAssociationLimitValue() {
		return associationLimitValue;
	}

	public void setAssociationLimited(boolean selected) {
		this.associtationLimited = selected;
	}

	public void setAssociationLimitValue(int value) {
		this.associationLimitValue = value;
	}
	
	public boolean isDynamicVlansEnabled() {
		return isDynamicVlansEnabled;
	}

	public void setDynamicVlansEnabled(boolean isDynamicVlansEnabled) {
		this.isDynamicVlansEnabled = isDynamicVlansEnabled;
	}

	public List<Integer> getListDynamicVlans() {
		return listDynamicVlans;
	}

	public void setListDynamicVlans(List<Integer> listDynamicVlans) {
		this.listDynamicVlans = listDynamicVlans;
	}

	public boolean isP2pCrossConnectionEnabled() {
		return p2pCrossConnectionEnabled;
	}
	
	public void setP2pCrossConnectionEnabled(boolean p2pCrossConnection) {
		this.p2pCrossConnectionEnabled = p2pCrossConnection;
	}	

	@Override
	public String toString() {
		return "WirelessProfile [vapId=" + vapId + ", vlanId=" + vlanId
				+ ", vapEnabled=" + vapEnabled
				+ ",ssidBroadcast="
				+ ssidBroadcast + ", wmm=" + wmm + ", clientIsolation="
				+ clientIsolation + ", profileEnabled=" + profileEnabled
				+ ", apSecurityMode=" + apSecurityMode + ", securityMode="
				+ securityMode + ", secondaryAuthenticationEnabled="
				+ secAuthenticationEnabled
				+ ", secondaryAuthenticationSettings="
				+ secAuthSettings + "]";
	}
	
	
	
}
