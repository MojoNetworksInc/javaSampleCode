/*
 * Name: ClientRadio.java
 *
 * Created by sabhtarsha on 24-May-2017
 *
 * Description: Client Radio object
 *
 *
 */

package com.mojonetworks.api.client.dataobjects.mwm;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class ClientRadio extends CommunicationRadio {

	private String associatedAPName;
	private String associatedApMac;
	private long assocManagedDeviceBoxId;
	private int uplinkDataRate; 
	private int downlinkDataRate;
	private int uplinkUsage;
	private int downlinkUsage;
	private double retryRate; 
	private OperatingMode opMode;
	private int capability;
    private int connectionStatus; //TODO Check if this is SAFE Connection status
	private boolean clientBridged;
	private List<Integer> failureCodes; //TODO Check what this is 
	private Integer failureCount;
	private Integer successCount;
	private Boolean lastConnectionSuccessful;
	@JsonIgnore
	private Integer bestSignalStrength;
	private Integer lastFailureType;
	
	public static enum OperatingMode{
		OP_MODE_BSS(1),     
		OP_MODE_ADHOC(2),    
		OP_MODE_UNKNOWN(3);

		private final int mode;

		private OperatingMode(int mode) {
			this.mode = mode;
		}

		public static OperatingMode valueOf(Integer mode) {
			for (OperatingMode opMode : values()) {
				if(opMode.getMode()==mode){
					return opMode;
				}
			}
			return OP_MODE_UNKNOWN;//TODO to be removed
		}

		public int getMode() {
			return mode;
		}
	}



	
	
	public ClientRadio() {
	}
	
	public boolean isClientBridged() {
		return clientBridged;
	}

	public void setClientBridged(boolean clientBridged) {
		this.clientBridged = clientBridged;
	}

	public int getCapability() {
		return capability;
	}
	public void setCapability(Integer capability) {
		this.capability = capability;
	}
	public String getAssociatedAPName() {
		return associatedAPName;
	}

	public void setAssociatedAPName(String associatedAPName) {
		this.associatedAPName = associatedAPName;
	}

	public OperatingMode getOpMode() {
		return opMode;
	}
	public void setOpMode(OperatingMode opMode) {
		this.opMode = opMode;
	}

	/**
	 * @return the connectionStatus
	 */
	public int getConnectionStatus() {
		return connectionStatus;
	}

	/**
	 * @param connectionStatus the connectionStatus to set
	 */
	public void setConnectionStatus(int connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	public int getUplinkDataRate() {
		return uplinkDataRate;
	}
	public void setUplinkDataRate(int uplinkDataRate) {
		this.uplinkDataRate = uplinkDataRate;
	}
	public int getDownlinkDataRate() {
		return downlinkDataRate;
	}
	public void setDownlinkDataRate(int downlinkDataRate) {
		this.downlinkDataRate = downlinkDataRate;
	}
	public String getAssociatedApMac() {
		return associatedApMac;
	}
	public void setAssociatedApMac(String associatedApMac) {
		this.associatedApMac = associatedApMac;
	}
	public int getUplinkUsage() {
		return uplinkUsage;
	}
	public void setUplinkUsage(int uplinkUsage) {
		this.uplinkUsage = uplinkUsage;
	}
	public int getDownlinkUsage() {
		return downlinkUsage;
	}
	public void setDownlinkUsage(int downlinkUsage) {
		this.downlinkUsage = downlinkUsage;
	}
	public double getRetryRate() {
		return retryRate;
	}
	public void setRetryRate(double retryRate) {
		this.retryRate = retryRate;
	}
	
	public long getAssocManagedDeviceBoxId() {
		return assocManagedDeviceBoxId;
	}

	public void setAssocManagedDeviceBoxId(long assocManagedDeviceBoxId) {
		this.assocManagedDeviceBoxId = assocManagedDeviceBoxId;
	}

	public List<Integer> getFailureCodes() {
		return failureCodes;
	}

	public void setFailureCodes(List<Integer> failureCodes) {
		this.failureCodes = failureCodes;
	}

	public Integer getFailureCount() {
		return failureCount;
	}

	public void setFailureCount(Integer failureCount) {
		this.failureCount = failureCount;
	}

	public Integer getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((super.getMacaddress() == null) ? 0 : super.getMacaddress().hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Radio other = (Radio) obj;
		if (super.getMacaddress() == null) {
			if (other.getMacaddress() != null)
				return false;
		} else if (!super.getMacaddress().equals(other.getMacaddress()))
			return false;
		return true;
	}

	public Boolean getLastConnectionSuccessful() {
		return lastConnectionSuccessful;
	}

	public void setLastConnectionSuccessful(Boolean lastConnectionSuccessful) {
		this.lastConnectionSuccessful = lastConnectionSuccessful;
	}
	
	public Integer getBestSignalStrength() {
		return bestSignalStrength;
	}
	
	public void setBestSignalStrength(int bestSignalStrength) {
		this.bestSignalStrength = bestSignalStrength;
	}
	
	public Integer getLastFailureType() {
		return lastFailureType;
	}

	public void setLastFailureType(Integer lastFailureType) {
		this.lastFailureType = lastFailureType;
	}

	@Override
	public String toString() {
		return "ClientRadio [associatedAPName=" + associatedAPName + ", associatedApMac=" + associatedApMac
				+ ", assocManagedDeviceBoxId=" + assocManagedDeviceBoxId + ", opMode=" + opMode + ", capability="
				+ capability + ", lastConnectionSuccessful=" + lastConnectionSuccessful + ", bestSignalStrength="
				+ bestSignalStrength + "]";
	}
}
