/*
 * Name: NetworkSettings.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Network settings
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;


public class NetworkSettings extends MWMBaseObject{
	private int vlanId;

	private boolean natEnabled;

	private boolean accessPortalEnabled;
	
	private boolean wiredGuestEnabled;
	
	public enum InterApCoordination{
		L2_BROADCAST(0), AMC_SERVER(1), SMART_ROAMING(2);
		
		private int value;
		
		private InterApCoordination(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
		public static InterApCoordination getByValue(int value){
			InterApCoordination[] values = InterApCoordination.values();
			for (InterApCoordination interApCoordinationValue : values) {
				if(interApCoordinationValue.getValue()==value){
					return interApCoordinationValue;
				}
			}
			return L2_BROADCAST;
		} 
	} 
	
	private InterApCoordination interApCoordination = InterApCoordination.L2_BROADCAST;

	private boolean proxyARPEnabled;
	private boolean dgafDisabled;
	private boolean l2tifEnabled = false;
	
	public NetworkSettings() {
	}

	public InterApCoordination getInterApCoordination() {
		return interApCoordination;
	}

	public void setInterApCoordination(InterApCoordination interApCoordination) {
		this.interApCoordination = interApCoordination;
	}

	public int getVlanId() {
		return vlanId;
	}

	public void setVlanId(int vlanId) {
		this.vlanId = vlanId;
	}

	public boolean isNatEnabled() {
		return natEnabled;
	}

	public void setNatEnabled(boolean natEnabled) {
		this.natEnabled = natEnabled;
	}

	public boolean isAccessPortalEnabled() {
		return accessPortalEnabled;
	}

	public void setAccessPortalEnabled(boolean accessPortalEnabled) {
		this.accessPortalEnabled = accessPortalEnabled;
	}
	
	public boolean isWiredGuestEnabled() {
		return wiredGuestEnabled;
	}

	public void setWiredGuestEnabled(boolean wiredGuestEnabled) {
		this.wiredGuestEnabled = wiredGuestEnabled;
	}
	public boolean isProxyARPEnabled() {
		return proxyARPEnabled;
	}

	public void setProxyARPEnabled(boolean proxyARPEnabled) {
		this.proxyARPEnabled = proxyARPEnabled;
	}

	public boolean isDgafDisabled() {
		return dgafDisabled;
	}

	public void setDgafDisabled(boolean dgafEnabled) {
		this.dgafDisabled = dgafEnabled;
	}

	public boolean isL2tifEnabled() {
		return l2tifEnabled;
	}
	
	public void setL2tifEnabled(boolean l2tif) {
		this.l2tifEnabled = l2tif;
	}

	@Override
	public String toString() {
		return "NetworkSettings [vlanId=" + vlanId + ", natEnabled="
				+ natEnabled + ", accessPortalEnabled=" + accessPortalEnabled
				+ ", wiredGuestEnabled=" + wiredGuestEnabled + "]";
	}
}
