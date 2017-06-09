/*
 * Name: MinAssociationRSSI.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for min association RSSI
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;

public class MinAssociationRSSI extends MWMBaseObject{
	private int minAssoRssiThreshold;
	private int minAssoDesperateClientInterval;
	private int minAssoDesperateClientTimeout;
	private int minAssociationMaxRetries;
	
	public int getMinAssoRssiThreshold() {
		return minAssoRssiThreshold;
	}
	public void setMinAssoRssiThreshold(int minAssoRssiThreshold) {
		this.minAssoRssiThreshold = minAssoRssiThreshold;
	}
	public int getMinAssoDesperateClientInterval() {
		return minAssoDesperateClientInterval;
	}
	public void setMinAssoDesperateClientInterval(int minAssoDesperateClientInterval) {
		this.minAssoDesperateClientInterval = minAssoDesperateClientInterval;
	}
	public int getMinAssoDesperateClientTimeout() {
		return minAssoDesperateClientTimeout;
	}
	public void setMinAssoDesperateClientTimeout(int minAssoDesperateClientTimeout) {
		this.minAssoDesperateClientTimeout = minAssoDesperateClientTimeout;
	}
	public int getMinAssociationMaxRetries() {
		return minAssociationMaxRetries;
	}
	public void setMinAssociationMaxRetries(int minAssociationMaxRetries) {
		this.minAssociationMaxRetries = minAssociationMaxRetries;
	}
}
