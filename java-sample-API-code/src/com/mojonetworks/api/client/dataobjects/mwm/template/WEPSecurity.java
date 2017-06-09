/*
 * Name: WEPSecurity.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for WEP security
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;

public class WEPSecurity extends MWMBaseObject implements ISecurityMode{

	public enum WEPType {
		WEP40("WEP40"),
		WEP104("WEP104");

		private String value;
		private WEPType (String value){
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	public enum WEPKeyType {
		ASCII("ASCII"),
		HEX("HEX");

		private String value;
		private WEPKeyType (String value){
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}


	public enum WEPAuthType {
		OPEN_AUTH(1,"Open"),
		SHARED_AUTH(2, "Shared");

		private int value;
		private String stringValue;
		private WEPAuthType (int value, String stringValue){
			this.value = value;
			this.stringValue = stringValue;
		}

		public int getValue() {
			return this.value;
		}
		
		public String getStringValue() {
			return this.stringValue;
		}
		

	}
	private WEPType wepType;
	private WEPKeyType wepKeyType;
	private WEPAuthType wepAuthType;
	private String	wepKey;
	
	
	
	public WEPSecurity() {
		super();
	}

	public WEPSecurity(WEPAuthType authType,WEPType wepType, WEPKeyType keyType, String WEPKey){
		this.wepAuthType = authType;
		this.wepType = wepType;
		this.wepKeyType = keyType;
		this.wepKey = WEPKey;
	}

	public String getWepKey() {
		return wepKey;
	}

	public void setWepKey(String wepKey) {
		this.wepKey = wepKey;
	}

	public WEPType getWepType() {
		return wepType;
	}

	public void setWepType(WEPType wepType) {
		this.wepType = wepType;
	}

	public WEPKeyType getWepKeyType() {
		return wepKeyType;
	}

	public void setWepKeyType(WEPKeyType wepKeyType) {
		this.wepKeyType = wepKeyType;
	}

	public WEPAuthType getWepAuthType() {
		return wepAuthType;
	}

	public void setWepAuthType(WEPAuthType wepAuthType) {
		this.wepAuthType = wepAuthType;
	}

	@Override
	public String toString() {
		return "WEPSecurity [wepType=" + wepType + ", wepKeyType=" + wepKeyType
				+ ", wepAuthType=" + wepAuthType + ", wepKey=" + wepKey + "]";
	}
}
