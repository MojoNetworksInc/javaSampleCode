/*
 * Name: SSIDProfile.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for SSID profile
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import java.util.ArrayList;
import java.util.List;

public class SSIDProfile extends Template {

	public static final int SYSTEM_DEFAULT_SSID_PROFILE_ID = -1;

	private int ssidProfileId = SYSTEM_DEFAULT_SSID_PROFILE_ID;

	private WirelessProfile wirelessProfile = new WirelessProfile();

	private NetworkSettings networkSettings = new NetworkSettings();
	
	private boolean firewallEnable;
	
	private boolean applicationFirewallEnable;
	
	private List<SLFirewallProfile> firewallProfile;
	
	private List<ApplicationFirewallRule> applicationFirewallRules;
	
	private String ssid ="";
	
	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	
	public boolean isFirewallEnable() {
		return firewallEnable;
	}

	public void setAppFirewallEnable(final boolean applicationFirewallEnable) {
		this.applicationFirewallEnable = applicationFirewallEnable;
	}
	
	public boolean isAppFirewallEnable() {
		return applicationFirewallEnable;
	}
	

	public void setFirewallEnable(final boolean firewallEnable) {
		this.firewallEnable = firewallEnable;
	}

	public int getSsidProfileId() {
		return ssidProfileId;
	}

	public void setSsidProfileId(final int ssidProfileId) {
		this.ssidProfileId = ssidProfileId;
	}

	public SSIDProfile() {
		super(TemplateType.SSID_PROFILE);
		this.networkSettings = new NetworkSettings();
		this.wirelessProfile = new WirelessProfile();
		firewallProfile = new ArrayList<SLFirewallProfile>();
	}

	public List<SLFirewallProfile> getFirewallProfile() {
		return firewallProfile;
	}

	public void setFirewallProfile(final List<SLFirewallProfile> firewallProfile) {
		this.firewallProfile = firewallProfile;
	}
	
	public List<ApplicationFirewallRule> getApplicationFirewallRules() {
		return applicationFirewallRules;
	}

	public void setApplicationFirewallRules(final List<ApplicationFirewallRule> applicationFirewallRules) {
		this.applicationFirewallRules = applicationFirewallRules;
	}
	
	public WirelessProfile getWirelessProfile() {
		return wirelessProfile;
	}

	public void setWirelessProfile(final WirelessProfile wirelessProfile) {
		this.wirelessProfile = wirelessProfile;
	}

	public NetworkSettings getNetworkSettings() {
		return networkSettings;
	}

	public void setNetworkSettings(final NetworkSettings networkSettings) {
		this.networkSettings = networkSettings;
	}
	
	@Override
	public int getTemplateId() {
		return getSsidProfileId();
	}

	@Override
	public void setTemplateId(final int templateID) {
		setSsidProfileId(templateID);
	}


	@Override
	public String toString() {
		return "SSIDProfile [ssidProfileId=" + ssidProfileId
				+ ", browserNotificationSettings="
				+ wirelessProfile + ", networkSettings=" + networkSettings
				+ ", firewallEnable=" + firewallEnable
				+ ", applicationFirewallEnable=" + applicationFirewallEnable
				+ ", firewallProfile=" + firewallProfile
				+ ", applicationFirewallRules=" + applicationFirewallRules
				+ ", ssid=" + ssid
				+ "]";
	}

}
