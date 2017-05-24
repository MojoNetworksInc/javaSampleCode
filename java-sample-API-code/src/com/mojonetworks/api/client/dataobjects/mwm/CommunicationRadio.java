/*
 * Name: CommunicationRadio.java
 *
 * Created by sabhtarsha on 24-May-2017
 *
 * Description: Communication radio
 *
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class CommunicationRadio extends Radio {

	private String ssid;
	private Protocol opprotocol;
	
	private int dot11NCapability = Dot11NCapability.INVALID.getValue();
	private int dot11ACCapability;
	
	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	
	
	/**
	 * @return the opprotocol
	 */
	public Protocol getOpprotocol() {
		return opprotocol;
	}
	/**
	 * @param opprotocol the opprotocol to set
	 */
	public void setOpprotocol(Protocol opprotocol) {
		this.opprotocol = opprotocol;
	}
	
	public Integer getDot11NCapability() {
		return dot11NCapability;
	}
	
	public void setDot11NCapability(Integer dot11nCapability) {
		if(dot11nCapability==null) {
			dot11NCapability = 0;
		}
		else {
			dot11NCapability = dot11nCapability;
		}
	}
	
	/**
	 * @return the dot11ACCapability
	 */
	public int getDot11ACCapability() {
		return dot11ACCapability;
	}
	
	/**
	 * @param dot11acCapability the dot11ACCapability to set
	 */
	public void setDot11ACCapability(Integer dot11acCapability) {
		if(dot11acCapability==null) {
			dot11acCapability = 0;
		} else {
			dot11ACCapability = dot11acCapability;
		}
	}

	public enum Dot11NCapability{
		VALID_CAPABILITY_INFORMATION(0x01 << 0),
		GREEN_FIELD_MODE(0x01 << 1),
		BEAM_FORMING(0x01 << 2),
		SHORT_GI_20MHz(0x01 << 3),
		SHORT_GI_40MHz(0x01 << 4),
		TX_STBC(0x01 << 8),
		RX_STBC((0x01 << 9) | (0x01 << 10)),
		INVALID(0x00);

		int value;

		private Dot11NCapability(int value){
			this.value = value;
		}

		public int getValue(){
			return value;
		}
	}

	public enum Dot11ACCapability{
		VALID_CAPABILITY_INFORMATION(0x01 << 0),
		SUPPORTED_CHANNEL_WIDTH( (0x01 << 1) | (0x01 << 2) ),
		SHORT_GI_80MHz(0x01 << 3),
		SHORT_GI_160MHz(0x01 << 4),
		TX_STBC(0x01 << 5),
		RX_STBC( (0x01 << 6) | (0x01 << 7) | (0x01 << 8) ),
		SU_BEAMFORMER(0x01 << 9),
		SU_BEAMFORMEE(0x01 << 10),
		MU_BEAMFORMER(0x01 << 11),
		MU_BEAMFORMEE(0x01 << 12),
		INVALID(0x00);

		int value;

		private Dot11ACCapability(int value){
			this.value = value;
		}

		public int getValue(){
			return value;
		}
	}

	public enum RxSTBC {
		SUPPORTED_STREAMS_1(1),
		SUPPORTED_STREAMS_2(2),
		SUPPORTED_STREAMS_3(3),
		SUPPORTED_STREAMS_4(4),
		INVALID(0x00);

		int value;

		private RxSTBC(int value){
			this.value = value;
		}

		public int getValue(){
			return value;
		}

		public static RxSTBC getRxSTBC(int value) {
			for(RxSTBC rxSTBC : values()) {
				if(rxSTBC.getValue() == value) {
					return rxSTBC;
				}
			}
			return null;
		}
	}
	
	public boolean isDot11NCapability(Dot11NCapability validCapabilityInformation) {
		if((dot11NCapability & validCapabilityInformation.getValue()) == 0){
			return false;
		}else{
			return true;
		}
	}
	
	@Override
	public String toString() {
		return "CommunicationRadio [ssid=" + ssid
				+ ", dot11NCapability="
				+ dot11NCapability + ", dot11ACCapability=" + dot11ACCapability
				+ "]";
	}
	
	

}