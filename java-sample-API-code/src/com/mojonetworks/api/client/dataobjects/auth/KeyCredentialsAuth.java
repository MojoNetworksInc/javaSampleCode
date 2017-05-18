/*
 * Name: KeyCredentialsAuth.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Key Credentials Authentication Object
 *
 *
 */

package com.mojonetworks.api.client.dataobjects.auth;

public class KeyCredentialsAuth extends AuthenticationInfo {

	private static final long serialVersionUID = 1L;
	
	private String keyId;
	private String keyValue;
	private final String type="apikeycredentials";
	
	public KeyCredentialsAuth(String keyId, String keyValue) {
		setKeyId(keyId);
		setKeyValue(keyValue);
	}
	
	public String getKeyId() {
		return keyId;
	}
	
	private void setKeyId(String keyId) {
		this.keyId = keyId;
	}
	
	public String getKeyValue() {
		return keyValue;
	}
	
	private void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public String getType() {
		return type;
	}
	
}
