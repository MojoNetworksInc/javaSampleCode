/*
 * Name: DeviceTemplateRadioSettings.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Device template radio settings
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import java.util.ArrayList;
import java.util.List;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;

public class DeviceTemplateRadioSettings extends MWMBaseObject{
	private int scanInterval;
	private int apInterval;

	private int platformId;
	private int radioId;
	private int templateId;
	private boolean enableCustomTxPower=false;
	private int customTxPower;
	private String display;
	private int orderId;

	private SmartSteering smartSteering = new SmartSteering();
	private SmartLoadSteering smartLoadSteering = new SmartLoadSteering();
	private MinAssociationRSSI minAssociationRSSI = new MinAssociationRSSI();
	private ClientSteeringCommonParameters clientSteeringParamater = new ClientSteeringCommonParameters();
	
	//radio attrs

	private WireLessMode wirelessMode;
	private ChannelWidth apChannelWidth;
	private ChannelSelection channelSelection = ChannelSelection.AUTO;
	private int operatingChannel;
	private int secondaryOperatingChannel;
	private int fragmentationThreshold;
	// Request to Send frame (RTS) or Clear To Send frame (CTS) threshold.
	private int rtsCtsThreshold;
	private int beaconInterval;
	// delivery traffic indication message period
	private int dtimPeriod;
	private int bandSteeringLoadBalanceThreshold;
	private GuardInterval guardInterval;
	private boolean frameAggregationEnabled;
	private boolean amsduEnabled=true;
	private int autoChannelSelectionInterval;
	private OperatingMode operatingMode;
	private List<SSIDProfile> ssidProfiles = new ArrayList<SSIDProfile>();

	private boolean isConfigured = false;  
	private boolean enableBGScan;
	private List<Channel> acsChannels = new ArrayList<Channel>();
	private boolean enableDcs;

	public enum ChannelWidth {
		CHANNEL_WIDTH_20(1),
		CHANNEL_WIDTH_20_40(2),
		CHANNEL_WIDTH_20_40_80(3),
		CHANNEL_WIDTH_20_40_80_160(4),
		CHANNEL_WIDTH_20_40_80_80(5);

		private int value;

		private ChannelWidth(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

		public static ChannelWidth get(int value) throws IllegalArgumentException {
			for (ChannelWidth i : values()) {
				if (i.value == value) {
					return i;
				}
			}
			throw new IllegalArgumentException("Illegal channel width : " + value);
		}
	}
	
	public enum OperatingMode {
		SENSOR_ONLY("0"),
		AP_SENSOR_COMBO("1");
		private String value;
		private OperatingMode(String value) {
			this.value = value;
		}
		public String getValue() {
			return this.value;
		}

		public void setValue(String value) {
			this.value = value;
		}


	}
	
	public enum WireLessMode {
		WIRELESS_MODE_B_G(1),
		WIRELESS_MODE_A(2),
		WIRELESS_MODE_B_G_N(3),
		WIRELESS_MODE_A_N(4),
		WIRELESS_MODE_A_N_AC(5);

		private int value;

		private WireLessMode(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}


		/**
		 * @param radioOneMode Operating mode of Radio 1
		 * @param radioTwoMode Operating mode of Radio 2
		 * @return true if its valid combination of operating modes for the two radios else return false.
		 */
		public static boolean isValidCombination(WireLessMode radioOneMode, WireLessMode radioTwoMode) {
			if(radioOneMode == radioTwoMode) { // both radio can not operate in same band.
				return false;
			}
			if(((radioOneMode == WireLessMode.WIRELESS_MODE_A) && (radioTwoMode == WireLessMode.WIRELESS_MODE_A_N))
					|| ((radioOneMode == WireLessMode.WIRELESS_MODE_A_N) && (radioTwoMode == WireLessMode.WIRELESS_MODE_A))) { 
				return false;
			} 
			if(((radioOneMode == WireLessMode.WIRELESS_MODE_B_G) && (radioTwoMode == WireLessMode.WIRELESS_MODE_B_G_N))
					|| ((radioOneMode == WireLessMode.WIRELESS_MODE_B_G_N) && (radioTwoMode == WireLessMode.WIRELESS_MODE_B_G))) { 
				return false;
			} 
			return true;
		}

		public static WireLessMode get(int value) throws IllegalArgumentException {
			for (WireLessMode i : values()) {
				if (i.value == value) {
					return i;
				}
			}
			throw new IllegalArgumentException("Illegal wireless mode : " + value);
		}
	}


	public enum ChannelSelection{
		AUTO, MANUAL;
	}

	public DeviceTemplateRadioSettings() {
		super();
	}


	public int getBandSteeringLoadBalanceThreshold() {
		return bandSteeringLoadBalanceThreshold;
	}

	public void setBandSteeringLoadBalanceThreshold(int bandSteeringLoadBalanceThreshold) {
		this.bandSteeringLoadBalanceThreshold = bandSteeringLoadBalanceThreshold;
	}
	
	public void setEnableBGScan(boolean selected) {
		this.enableBGScan = selected;
	}
	
	public boolean isEnableBGScan() {
		return enableBGScan;
	}

	public int getScanInterval() {
		return scanInterval;
	}


	public void setScanInterval(int scanInterval) {
		this.scanInterval = scanInterval;
	}

	public int getApInterval() {
		return apInterval;
	}

	public void setApInterval(int apInterval) {
		this.apInterval = apInterval;
	}


	public boolean isEnableCustomTxPower() {
		return enableCustomTxPower;
	}

	public void setEnableCustomTxPower(boolean enableCustomTxPower) {
		this.enableCustomTxPower = enableCustomTxPower;
	}

	public int getCustomTxPower() {
		return customTxPower;
	}

	public void setCustomTxPower(int customTxPower) {
		this.customTxPower = customTxPower;
	}

	public SmartSteering getSmartSteering() {
		return smartSteering;
	}


	public void setSmartSteering(SmartSteering smartSteering) {
		this.smartSteering = smartSteering;
	}

	public SmartLoadSteering getSmartLoadSteering() {
		return smartLoadSteering;
	}

	public void setSmartLoadSteering(SmartLoadSteering smartLoadSteering) {
	this.smartLoadSteering = smartLoadSteering;
	}
	
	public MinAssociationRSSI getMinAssociationRSSI() {
		return minAssociationRSSI;
	}


	public void setMinAssociationRSSI(MinAssociationRSSI minAssociationRSSI) {
		this.minAssociationRSSI = minAssociationRSSI;
	}

	public int getPlatformId() {
		return platformId;
	}

	public void setPlatformId(int platformId) {
		this.platformId = platformId;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getTemplateId() {
		return templateId;
	}


	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}


	public int getRadioId() {
		return radioId;
	}


	public void setRadioId(int radioId) {
		this.radioId = radioId;
	}


	public WireLessMode getWirelessMode() {
		return wirelessMode;
	}


	public void setWirelessMode(WireLessMode wirelessMode) {
		this.wirelessMode = wirelessMode;
	}


	public ChannelWidth getApChannelWidth() {
		return apChannelWidth;
	}


	public void setApChannelWidth(ChannelWidth apChannelWidth) {
		this.apChannelWidth = apChannelWidth;
	}

	public ChannelSelection getChannelSelection() {
		return channelSelection;
	}
	
	public void setChannelSelection(ChannelSelection channelSelection) {
		this.channelSelection = channelSelection;
	}

	public int getOperatingChannel() {
		return operatingChannel;
	}

	public void setOperatingChannel(int operatingChannel) {
		this.operatingChannel = operatingChannel;
	}

	public int getSecondaryOperatingChannel() {
		return secondaryOperatingChannel;
	}
	
	public void setSecondaryOperatingChannel(int secondOperatingChannel) {
		this.secondaryOperatingChannel = secondOperatingChannel;
	}

	public int getFragmentationThreshold() {
		return fragmentationThreshold;
	}


	public void setFragmentationThreshold(int fragmentationThreshold) {
		this.fragmentationThreshold = fragmentationThreshold;
	}


	public int getRtsCtsThreshold() {
		return rtsCtsThreshold;
	}


	public void setRtsCtsThreshold(int rtsCtsThreshold) {
		this.rtsCtsThreshold = rtsCtsThreshold;
	}


	public int getBeaconInterval() {
		return beaconInterval;
	}


	public void setBeaconInterval(int beaconInterval) {
		this.beaconInterval = beaconInterval;
	}


	public int getDtimPeriod() {
		return dtimPeriod;
	}


	public void setDtimPeriod(int dtimPeriod) {
		this.dtimPeriod = dtimPeriod;
	}


	public GuardInterval getGuardInterval() {
		return guardInterval;
	}


	public void setGuardInterval(GuardInterval guardInterval) {
		this.guardInterval = guardInterval;
	}


	public boolean isFrameAggregationEnabled() {
		return frameAggregationEnabled;
	}


	public void setFrameAggregationEnabled(boolean frameAggregationEnabled) {
		this.frameAggregationEnabled = frameAggregationEnabled;
	}


	public boolean isAmsduEnabled() {
		return amsduEnabled;
	}
	
	public void setAmsduEnabled(boolean amsduEnabled) {
		this.amsduEnabled = amsduEnabled;
	}
	
	public int getAutoChannelSelectionInterval() {
		return autoChannelSelectionInterval;
	}


	public void setAutoChannelSelectionInterval(int autoChannelSelectionInterval) {
		this.autoChannelSelectionInterval = autoChannelSelectionInterval;
	}


	public OperatingMode getOperatingMode() {
		return operatingMode;
	}


	public void setOperatingMode(OperatingMode operatingMode) {
		this.operatingMode = operatingMode;
	}

	public boolean isConfigured() {
		return isConfigured;
	}


	public void setConfigured(boolean isConfigured) {
		this.isConfigured = isConfigured;
	}


	public List<SSIDProfile> getSsidProfiles() {
		return ssidProfiles;
	}


	public void setSsidProfiles(List<SSIDProfile> ssidProfiles) {
		this.ssidProfiles = ssidProfiles;
	}


	public boolean isEnableDcs() {
		return enableDcs;
	}

	public void setEnableDcs(boolean enableDcs) {
		this.enableDcs = enableDcs;
	}

	public enum GuardInterval {
		HALF (1),
		FULL(0);

		private int value;
		private String stringValue = "";
		private GuardInterval (int value){
			this.value = value;
			if(value == 0) {
				this.setStringValue("Full"); 
			} else {
				this.setStringValue("Half"); 

			}
		}

		public int getValue() {
			return this.value;
		}

		public String getStringValue() {
			return stringValue;
		}

		private void setStringValue(String stringValue) {
			this.stringValue = stringValue;
		}

	}

	@Override
	public String toString() {
		return "DeviceTemplateRadioSettings [scanInterval=" + scanInterval + ", apInterval=" + apInterval
				+ ", platformId=" + platformId + ", radioId=" + radioId + ", templateId=" + templateId
				+ ", enableCustomTxPower=" + enableCustomTxPower + ", customTxPower=" + customTxPower + ", display="
				+ display + ", orderId=" + orderId + ", smartSteering=" + smartSteering + ", minAssociationRSSI="
				+ minAssociationRSSI + ", wirelessMode=" + wirelessMode + ", apChannelWidth=" + apChannelWidth
				+ ", operatingChannel=" + operatingChannel + ", fragmentationThreshold=" + fragmentationThreshold
				+ ", rtsCtsThreshold=" + rtsCtsThreshold + ", beaconInterval=" + beaconInterval + ", dtimPeriod="
				+ dtimPeriod + ", bandSteeringLoadBalanceThreshold=" + bandSteeringLoadBalanceThreshold
				+ ", guardInterval=" + guardInterval + ", frameAggregationEnabled=" + frameAggregationEnabled
				+ ", amsduEnabled=" + amsduEnabled + ", autoChannelSelectionInterval=" + autoChannelSelectionInterval
				+ ", operatingMode=" + operatingMode + ", ssidProfiles=" + ssidProfiles + ", isConfigured="
				+ isConfigured + ", enableBGScan=" + enableBGScan + ", acsChannels=" + acsChannels + ", enableDcs="
				+ enableDcs + "]";
	}

	public List<Channel> getAcsChannels() {
		return acsChannels;
	}

	public void setAcsChannels(List<Channel> acsChannels) {
		this.acsChannels = acsChannels;
	}


	public ClientSteeringCommonParameters getClientSteeringParamater() {
		return clientSteeringParamater;
	}


	public void setClientSteeringParamater(ClientSteeringCommonParameters clientSteeringParamater) {
		this.clientSteeringParamater = clientSteeringParamater;
	}
}
