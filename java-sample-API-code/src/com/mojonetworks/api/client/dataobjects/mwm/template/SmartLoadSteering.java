/*
 * Name: SmartLoadSteering.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Smart LOad Steering
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;


public class SmartLoadSteering extends MWMBaseObject{
	private int clientLoadSteering;
	private int deltaClientLoadSteering;
	
	public int getClientLoadSteering() {
		return clientLoadSteering;
	}
	
	public void setClientLoadSteering(int clientLoadSteering) {
		this.clientLoadSteering = clientLoadSteering;
	}
	
	public int getDeltaClientLoadSteering() {
		return deltaClientLoadSteering;
	}
	
	public void setDeltaClientLoadSteering(int deltaClientLoadSteering) {
		this.deltaClientLoadSteering = deltaClientLoadSteering;
	}
	
}
