/*
 * Name: APRadio.java
 *
 * Created by sabhtarsha on 24-May-2017
 *
 * Description: AP Radio object
 *
 *
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class APRadio extends CommunicationRadio {

	private boolean dualBand;
	private boolean isPrimary;
	private int numAssocClients=-1;
	
	private int security;
	private int secAuth;
	private int secGCS;
	private int secPWCS;
	private String networkTag;
	private NetworkStatus networkedStatus;
	private String wiredMAC;
	private int capability;
	private long mcsSet11ac;
	
	private boolean isGuest;

	private int supportedRates;

	private int beaconInterval;

	private int channelOffset = -999;

	private String mcsSet11n;
	
	private long extendedAttr;

	private int channelWidth;
	private int centerFrequencyOne;
	private int centerFrequencyZero;
	private float maxDataRateFor11n = INVALID_DATA_RATE_FOR_11n;
	

    public static final float INVALID_DATA_RATE_FOR_11n = -999;
	
    public static final long AP_NETWORKED = 1;
    public static final long AP_NOT_NETWORKED = 2;
    public static final long AP_INDETERMINATE = 0;
    public static final long AP_INTERNAL = 3;

    public static final int POTENTIAL_AUTHRIZED = 3;
	public static final int POTENTIAL_ROGUE = 4;
	public static final int POTENTIAL_EXTERNAL = 2;
	public static final int POTENTIAL_INDETERMINATE = 1;

	public static enum NetworkStatus{

		NETWORKED(AP_NETWORKED, "NETWORKED"),    

		NOT_NETWORKED(AP_NOT_NETWORKED, "NOT_NETWORKED"),    

		INDETERMINATE(AP_INDETERMINATE, "INDETERMINATE"), 

		INTERNAL(AP_INTERNAL, "INTERNAL");  

		private final long value;
		private String stringRepresentation;

		private NetworkStatus(long value, String strValue) {
			this.value=value;
			this.stringRepresentation = strValue;
		}

		public long getValue() {
			return value;
		}
		/**
		 * Converts the given value of networkStatus to the enum variable
		 * @param value
		 * @return
		 */
		public static NetworkStatus valueOf(int value) {
			for (NetworkStatus networkStatus : values()) {
				if(value==networkStatus.value) {
					return networkStatus;
				}
			}
			throw new IllegalArgumentException(""+value);
		}
		
		public static int getNetworkStatusValue(String value) {
			for (NetworkStatus networkStatus : values()) {
				if(value.equals(networkStatus.stringRepresentation)) {
					return ((Long)networkStatus.value).intValue();
				}
			}
			throw new IllegalArgumentException(""+value);
		}
	}
	
	public static enum Security {
		SECURITY_UNKNOWN_VALUE(0),
		SECURITY_OPEN_VALUE(1),
		SECURITY_WEP_VALUE(2),
		SECURITY_WPA_VALUE(4),
		SECURITY_802dot11i_VALUE(8);

		private final int mask;

		private Security(int value) {
			this.mask = value;
		}

		/**
		 * Converts the given value of networkStatus to the enum variable
		 * @param value
		 * @return
		 */
		public static Security valueOf(int value) {
			for (Security security : values()) {
				if(value==security.mask) {
					return security;
				}
			}
			throw new IllegalArgumentException(""+value);
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

	//these values indicate the capability of the radio
    public enum Capabilities{
    	DRAFT_11N(0x01 << 0),
    	STATIC_TURBO(0x01 << 1),
    	DYNAMIC_TURBO(0x01 << 2),
    	SUPER_AG(0x01 << 3),
    	PRE_11N(0x01 << 4),
    	SENSOR_AP_COMBO(0x01 << 5);
    	
    	int mask;
    	private Capabilities(int mask) {
    		this.mask=mask;
		}
		public int getMask() {
			return mask;
		}
    }

	public APRadio() {
	}

	public boolean isSecurityEnabled(Security secSetting) {
		return ((this.security &secSetting.mask)==secSetting.mask);  
	}
	public boolean isDualBand() {
		return dualBand;
	}

	public void setDualBand(Boolean value) {
		this.dualBand = value;
	}

	public boolean isPrimary() {
		return isPrimary;
	}
	public void setPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public int getNumAssocClients() {
		return numAssocClients;
	}
	public void setNumAssocClients(int numAssocClients) {
		this.numAssocClients = numAssocClients;
	}
	public int getSecurity() {
		return security;
	}
	public void setSecurity(int security) {
		this.security = security;
	}
	public int getSecAuth() {
		return secAuth;
	}
	public void setSecAuth(int secAuth) {
		this.secAuth = secAuth;
	}
	public int getSecGCS() {
		return secGCS;
	}
	public void setSecGCS(int secGCS) {
		this.secGCS = secGCS;
	}
	public int getSecPWCS() {
		return secPWCS;
	}
	public void setSecPWCS(int secPWCS) {
		this.secPWCS = secPWCS;
	}

	public String getNetworkTag() {
		return networkTag;
	}
	public void setNetworkTag(String networkTag) {
		this.networkTag = networkTag;
	}
	public NetworkStatus getNetworkedStatus() {
		return networkedStatus;
	}

	public void setNetworkedStatus(NetworkStatus networkedStatus) {
		this.networkedStatus = networkedStatus;
	}

	public String getWiredMAC() {
		return wiredMAC;
	}
	public void setWiredMAC(String wiredMAC) {
		this.wiredMAC = wiredMAC;
	}
	
	
	@Override
	public String toString() {
		return "APRadio [dualBand=" + dualBand + ", isPrimary=" + isPrimary
				+ ", numAssocClients=" + numAssocClients + ", toString()=" + super.toString()
				+ "]";
	}	
	public int getCapability() {
		return capability;
	}

	public void setCapability(Integer capability) {
		if(capability== null){
			this.capability=0;
		}else {
			this.capability = capability;
		}
	}

	public boolean isGuest() {
		return isGuest;
	}

	public int getSupportedRates() {
		return supportedRates;
	}
	public void setGuest(Boolean isGuest) {
		if(isGuest==null) {
			this.isGuest=false;
		}else{
			this.isGuest = isGuest;
		}
	}
	
	public void setSupportedRates(Integer supportedRates) {
		if(supportedRates==null){
			this.supportedRates = 0;
		}else {
			this.supportedRates = supportedRates;
		}
	}
	public int  getBeaconInterval() {
		return beaconInterval;
	}
	public void setBeaconInterval(int beaconInterval) {
		this.beaconInterval = beaconInterval;
	}
	public int getChannelOffset() {
		return channelOffset;
	}
	public void setChannelOffset(int channelOffset) {
		this.channelOffset = channelOffset;
	}
	public String getMcsSet11n() {
		return mcsSet11n;
	}
	public void setMcsSet11n(String mcsSet11n) {
		this.mcsSet11n = mcsSet11n;
	}
	
	public boolean isCapable(Capabilities cp){
		return (capability&cp.getMask())==cp.getMask();
	}
	public float getMaxDataRateFor11n() {
		return maxDataRateFor11n;
	}
	public void setMaxDataRateFor11n(float maxDataRateFor11n) {
		this.maxDataRateFor11n = maxDataRateFor11n;
	}
	
	public long getExtendedAttr() {
		return extendedAttr;
	}
	public void setExtendedAttr(long extendedAttr) {
		this.extendedAttr = extendedAttr;
	}
	/**
	 * @return the mcsSet11ac
	 */
	public long getMcsSet11ac() {
		return mcsSet11ac;
	}
	/**
	 * @param mcsSet11ac the dot11ACCapability to set
	 */
	public void setMcsSet11ac(long mcsSet11ac) {
		this.mcsSet11ac = mcsSet11ac;
	}
	/**
	 * @return the channelWidth
	 */
	public int getChannelWidth() {
		return channelWidth;
	}
	/**
	 * @param channelWidth the channelWidth to set
	 */
	public void setChannelWidth(int channelWidth) {
		this.channelWidth = channelWidth;
	}
	/**
	 * @return the centerFrequencyOne
	 */
	public int getCenterFrequencyOne() {
		return centerFrequencyOne;
	}
	/**
	 * @param centerFrequencyOne the centerFrequencyOne to set
	 */
	public void setCenterFrequencyOne(int centerFrequencyOne) {
		this.centerFrequencyOne = centerFrequencyOne;
	}
	/**
	 * @return the centerFrequencyZero
	 */
	public int getCenterFrequencyZero() {
		return centerFrequencyZero;
	}
	/**
	 * @param centerFrequencyZero the centerFrequencyZero to set
	 */
	public void setCenterFrequencyZero(int centerFrequencyZero) {
		this.centerFrequencyZero = centerFrequencyZero;
	}


	public enum SupportedMSCForStream {
		VHT_MCS_0_7(0),
		VHT_MCS_0_8(1),
		VHT_MCS_0_9(2),
		NOT_SUPPORTED(3);

		long value;

		private SupportedMSCForStream(long value){
			this.value = value;
		}

		public long getValue(){
			return value;
		}

		public static SupportedMSCForStream getSupportedMSCForStream(long value) {
			for(SupportedMSCForStream mscForStream : values()) {
				if(value == mscForStream.getValue()) {
					return mscForStream;
				}
			}
			return null;
		}
	}

	public enum Supported11ACChannelWidth {
		WIDTH_80MHZ(0),
		WIDTH_160MHZ(1),
		WIDTH_160_80_80MHZ(2),
		INVALID(-1);

		int value;

		private Supported11ACChannelWidth(int value){
			this.value = value;
		}

		public int getValue(){
			return value;
		}

		public static Supported11ACChannelWidth getSupported11ACChannelWidth(int value) {
			for(Supported11ACChannelWidth supported11acChannelWidth : values()) {
				if(supported11acChannelWidth.getValue() == value) {
					return supported11acChannelWidth;
				}
			}
			return INVALID;
		}
	}

}