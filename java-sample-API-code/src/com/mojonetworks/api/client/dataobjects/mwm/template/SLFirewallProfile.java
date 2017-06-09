/*
 * Name: SLFirewallProfile.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Firewall Profile
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;


public class SLFirewallProfile extends MWMBaseObject{
	public static final int DEFUALT_INVALID_ID = -100;
	public static final int DEFAULT_ORDER_ID = -1;
	public static final int DEFAULT_MNC_OID =  0;
	
	public static final int PROTO_ANY=0;
	public static final int PROTO_TCP=1;
	public static final int PROTO_UDP=2;
	public static final int PROTO_OTHER=3;
	
	public static final int ACTION_ALLOW=1;
	public static final int ACTION_BLOCK=2;
	public static final int ACTION_ALLOW_AND_MARK=3;
	
	public static final int DIRECTION_ANY=0;
	public static final int DIRECTION_IN=1;
	public static final int DIRECTION_OUT=2;
	
	public static final int TO_WIRELESS=2;
	public static final int TO_WIRED=1;
	public static final int BOTH=0;
	
	private int oId = DEFUALT_INVALID_ID;
	private int ssid;
	private String ruleName;
	private String hostName;
	private int direction;
	private int protocol;
	private int action;
	private String port;
	private int orderId;
	private boolean isDefaultRule;
	private int mncOid = DEFAULT_MNC_OID;
	private MarkDirection markDirection = MarkDirection.TO_WIRELESS;

	private int dscpValue=DEFUALT_INVALID_ID;
	
	
	public enum MarkDirection {
		TO_WIRELESS(SLFirewallProfile.TO_WIRELESS),
		TO_WIRED(SLFirewallProfile.TO_WIRED),
		BOTH(SLFirewallProfile.BOTH);
		
		int value;
		private MarkDirection(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
		public static MarkDirection valueOf(int value){
			for(MarkDirection md:values()) {
				if(md.value == value) return md;
			}
			throw new IllegalArgumentException("" + value);
		}
	}
	
	
	public SLFirewallProfile() {
	}
	
	public boolean isDefaultRule() {
		return isDefaultRule;
	}

	public void setDefaultRule(boolean isDefaultRule) {
		this.isDefaultRule = isDefaultRule;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOId() {
		return oId;
	}

	public void setOId(int id) {
		this.oId = id;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getProtocol() {
		return protocol;
	}

	public void setProtocol(int protocol) {
		this.protocol = protocol;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public String getName() {
		return ruleName;
	}

	public void setName(String name) {
		this.ruleName = name;
	}

	public int getSsid() {
		return ssid;
	}

	public void setSsid(int vapId) {
		this.ssid = vapId;
	}

	public int getMncOid() {
		return mncOid;
	}

	public void setMncOid(int mncOid) {
		this.mncOid = mncOid;
	}
	
	
	public MarkDirection getMarkDirection() {
		return markDirection;
	}

	public void setMarkDirection(MarkDirection markDirection) {
		this.markDirection = markDirection;
	}

	public int getDscpValue() {
		return dscpValue;
	}

	public void setDscpValue(int dscpValue) {
		this.dscpValue = dscpValue;
	}
}
