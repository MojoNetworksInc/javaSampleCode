/*
 * Name: SmartSteering.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Smart steering
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;


public class SmartSteering extends MWMBaseObject{

	private int roamRssiThreshold;
	private int roamThresholdInterval;
	private int roamThresholdPacket;

	public int getRoamRssiThreshold() {
		return roamRssiThreshold;
	}
	public void setRoamRssiThreshold(int roamRssiThreshold) {
		this.roamRssiThreshold = roamRssiThreshold;
	}
	public int getRoamThresholdInterval() {
		return roamThresholdInterval;
	}
	public void setRoamThresholdInterval(int roamThresholdInterval) {
		this.roamThresholdInterval = roamThresholdInterval;
	}
	public int getRoamThresholdPacket() {
		return roamThresholdPacket;
	}
	public void setRoamThresholdPacket(int roamThresholdPacket) {
		this.roamThresholdPacket = roamThresholdPacket;
	}
}