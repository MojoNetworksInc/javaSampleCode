/*
 * Name: MLPLoginData.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Data implementation for Login response from MLP
 *
 *
 */
package com.mojonetworks.api.client.dataobjects.mlp;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MLPLoginData extends MLPData {

	private int errorCode;
	private String message;
	
	public MLPLoginData() {
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "MLPLoginData [errorCode=" + errorCode + ", message=" + message + "]";
	}
	
	
	
}
