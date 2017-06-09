/*
 * Name: WPA2Security.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for WPA2 security
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.template.OSENSecurity.GroupManagementCipherSuite;
import com.mojonetworks.api.client.dataobjects.mwm.template.OSENSecurity.ManagementFrameProtection;

public class WPA2Security extends WPASecurity  {
	public WPA2Security() {
		super(WPAAuthType.PSK);
	}
	
	public WPA2Security(WPAAuthType authType) {
		super(authType);
	}

	private boolean	okcEnabled;
	private boolean	preAuthenticationEnabled;
	
	private ManagementFrameProtection mgmtFrameProtection80211w;
	private GroupManagementCipherSuite groupMgmtCipherSuite;
	private int saQueryMaxTimeout;
	private int saQueryRetryTimeout;
	private boolean enable11r;
	private boolean overTheDS;
	private boolean mixedMode;

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

	public ManagementFrameProtection getMgmtFrameProtection80211w() {
		return mgmtFrameProtection80211w;
	}

	public void setMgmtFrameProtection80211w(ManagementFrameProtection mgmtFrameProtection80211w) {
		this.mgmtFrameProtection80211w = mgmtFrameProtection80211w;
	}

	public GroupManagementCipherSuite getGroupMgmtCipherSuite() {
		return groupMgmtCipherSuite;
	}

	public void setGroupMgmtCipherSuite(GroupManagementCipherSuite groupMgmtCipherSuite) {
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
	

	@Override
	public String toString() {
		return "WPA2Security [okcEnabled=" + okcEnabled
				+ ", preAuthenticationEnabled=" + preAuthenticationEnabled
				+ ", mgmtFrameProtection80211w=" + mgmtFrameProtection80211w
				+ ", groupMgmtCipherSuite=" + groupMgmtCipherSuite
				+ ", saQueryMaxTimeout=" + saQueryMaxTimeout 
				+ ", saQueryRetryTimeout=" + saQueryRetryTimeout
				+ ",  toString()=" + super.toString() + "]";
	}
}
