/*
 * Name: Radio.java
 *
 * Created by sabhtarsha on 24-May-2017
 *
 * Description: Radio base object
 *
 *
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = APRadio.class, name = "apradio"), @Type(value = ClientRadio.class, name = "clientradio") })
public abstract class Radio {

	private String macaddress;
	private Protocol protocol;
	private int channel;
	private boolean isActive;
	private long firstDetectedTime;
	private long upSince;
	private int signalStrength;
	
	public static final int IP_MANUAL_STATUS_FLAG 		= 0x01<<0; /** if LSB value is 1 then Manual disabled */
	public static final int IP_AUTOMATIC_STATUS_FLAG  	= 0x01<<1; /** if 2nd LSB value is 1 then Automatic disabled */
	public static final int MIN_SIG_STR = -5000;

	public static enum Protocol {
		UNKNOWN(0, "UNKNOWN"),
		A(1, "A"),
		B(2, "B"),
		BG(6, "BG"),
		CLIENT(11, "CLIENT"), 	//Special value for client
		SENSOR(10, "SENSOR"),		//Special value for sensor
		ATTACKER(12, "ATTACKER");		
		
		int value;
		String stringValue;
		private Protocol(int v, String strValue) {
			value = v;
			this.stringValue = strValue;
		}
		
		public int getValue() {
			return value;
		}
		
		public static int getProtocolValue(String v) {
			for(Protocol p:values()) {
				if(p.getStringValue().equals(v)) {
					return p.value;
				}
			}
			return Protocol.UNKNOWN.value;
		}
		
		public static Protocol valueOf(int v) {
			for(Protocol p:values()) {
				if(p.value == v) {
					return p;
				}
			}
//				TODO: add all possible protocol values in enum
			return Protocol.UNKNOWN;
//			throw new IllegalArgumentException("" + v);
		}

		public String getStringValue() {
			return stringValue;
		}
	}
	
	public String getMacaddress() {
		return macaddress;
	}
	public void setMacaddress(String macaddress) {
		this.macaddress = macaddress;
	}
	public Protocol getProtocol() {
		return protocol;
	}
	
	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public long getFirstDetectedTime() {
		return firstDetectedTime;
	}
	
	public void setFirstDetectedTime(Long firstDetectedTime) {
		this.firstDetectedTime = firstDetectedTime;
	}
	

	public long getUpSince() {
		return upSince;
	}
	
	public int getSignalStrength() {
		return signalStrength;
	}
	public void setSignalStrength(int signalStrength) {
		this.signalStrength = signalStrength;
	}
	
	public void setUpSince(Long upSince) {
		this.upSince = upSince;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((macaddress == null) ? 0 : macaddress.hashCode());
		result = prime * result
				+ ((protocol == null) ? 0 : protocol.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Radio other = (Radio) obj;
		if (macaddress == null) {
			if (other.macaddress != null)
				return false;
		} else if (!macaddress.equals(other.macaddress))
			return false;
		if (protocol != other.protocol)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Radio [macaddress=" + macaddress + ", protocol=" + protocol
				+ ", channel=" + channel + ", isActive=" + isActive
				+ ", firstDetectedTime=" + firstDetectedTime + ", upSince="
				+ upSince + ", signalStrength=" + signalStrength + "]";
	}
}
