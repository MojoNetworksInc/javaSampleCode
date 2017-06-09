/*
 * Name: AccessRadioException.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Access Radio Exception
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;


public class AccessRadioException extends MWMBaseObject{

	private int singleRadioBand = 6;
	private boolean comboModeEnabled;
	private int dualRadioComboBand = 1;
	
    public AccessRadioException() {
		
	}
	
	public int getSingleRadioBand() {
		return singleRadioBand;
	}

	public void setSingleRadioBand(int singleRadioBand) {
		this.singleRadioBand = singleRadioBand;
	}

	public int getDualRadioComboBand() {
		return dualRadioComboBand;
	}

	public void setDualRadioComboBand(int dualRadioComboBand) {
		this.dualRadioComboBand = dualRadioComboBand;
	}

	public boolean isComboModeEnabled() {
		return comboModeEnabled;
	}

	public void setComboModeEnabled(boolean comboModeEnabled) {
		this.comboModeEnabled = comboModeEnabled;
	}
	
}
