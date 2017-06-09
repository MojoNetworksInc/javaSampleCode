/*
 * Name: SensorPassword.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Sensor Password
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;

public class SensorPassword extends MWMBaseObject{
	private String password;
    private int passwordLength;
    
    public SensorPassword() {
    }
    
    public SensorPassword(String password) {
        this.password = password;
        if(password == null)
            passwordLength = 0;
        else 
            passwordLength = password.length();
    }

    public String getPassword() {
        return password;
    }

    public int getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    public void setPassword(String password) {
        this.password = password;
        if(password == null)
            passwordLength = 0;
        else 
            passwordLength = password.length();
    }
}
