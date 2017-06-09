/*
 * Name: ClientSteeringCommonParameters.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Client steering common parameter
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;


public class ClientSteeringCommonParameters extends MWMBaseObject{

	private int steeringAttemptsThreshold;
	private int steeringBlackoutPeriod;
	private int steeringRssiThreshold;
	
	public ClientSteeringCommonParameters()
	{
		
	}
	
	public int getSteeringAttemptsThreshold(){
		return steeringAttemptsThreshold;
	}
	
	public void setSteeringAttemptsThreshold(int steeringAttemptsThreshold){
		this.steeringAttemptsThreshold = steeringAttemptsThreshold;
	}
	
	public int getSteeringBlackoutPeriod(){
		return steeringBlackoutPeriod;
	}
	
	public void setSteeringBlackoutPeriod(int steeringBlackoutPeriod){
		this.steeringBlackoutPeriod = steeringBlackoutPeriod;
	}
	
	public int getSteeringRssiThreshold(){
		return steeringRssiThreshold;
	}
	
	public void setSteeringRssiThreshold(int steeringRssiThreshold){
		this.steeringRssiThreshold = steeringRssiThreshold;
	}
	
	
}
