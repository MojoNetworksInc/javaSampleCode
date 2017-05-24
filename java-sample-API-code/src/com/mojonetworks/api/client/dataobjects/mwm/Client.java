/*
 * Name: Client.java
 *
 * Created by sabhtarsha on 24-May-2017
 *
 * Description: Client Object
 *
 *
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import java.util.Collection;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Client extends Device<ClientRadio>  {
    
	public enum PoorPerformanceReason {
		LOW_DATA_RATE,
		HIGH_RETRY_RATE,
		LOW_RSSI,
		STICKY
	}
	
	private String userName;
	private String vendorName;
	private String cellId;
	private List<String> ipv6Addresses;
	private String ownSensorMac;
	private List<String> allowedSSIDs;
	
	private String role;
	
	private boolean totalCountRequired = false;

	private Boolean isBanned;
	
	private GoogleAuthorizationStatus googleAuthorizationStatus;
	
	private String ipV6Address;
	private Boolean sticky;
	private int averageDataRate;
	private String osType;

	private List<PoorPerformanceReason> poorPerformanceReasons;
	
	
	public Client() {
	}
	
	public static enum GoogleAuthorizationStatus {
		NOT_AVAILABLE((short)0, "NOT_AVAILABLE"),
		YES((short)1, "YES"),
		NO((short)2, "NO");
		
		short value;
		String stringValue;
		
		private GoogleAuthorizationStatus(short v, String strValue) {
			this.value = v;
			this.stringValue = strValue;
		}

		public short getValue() {
			return value;
		}
		
		public String getStringValue() {
			return stringValue;
		}

		public static GoogleAuthorizationStatus valueOf(short value) {
			for(GoogleAuthorizationStatus googleAuthStatus : values()) {
				if(googleAuthStatus.value == value) {
					return googleAuthStatus;
				}
			}
			throw new IllegalArgumentException("" + value);
		}
		
		public static GoogleAuthorizationStatus getGoogleAuthenticationStatusValue(String strValue) {
			for(GoogleAuthorizationStatus e: values()) {
				if(e.stringValue.equals(strValue)) {
					return e;
				}
			}
			throw new IllegalArgumentException("Illegal Google Authorization Status : " + strValue); // not found
		}
	}
	
	public GoogleAuthorizationStatus getGoogleAuthorizationStatus() {
		return googleAuthorizationStatus;
	}
	
	public void setGoogleAuthorizationStatus(GoogleAuthorizationStatus googleAuthorizationStatus) {
		this.googleAuthorizationStatus = googleAuthorizationStatus;
	}

	public ClientRadio getRadio(){
		List<ClientRadio> radios = super.getRadios();
		if(radios==null || radios.isEmpty()){
			return null;
		}
		return radios.get(0);
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	public Boolean isBanned() {
		return isBanned;
	}
	
	public void setBanned(Boolean isBanned) {
		this.isBanned = isBanned;
	}
	
	public String getCellId() {
		return cellId;
	}
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	public boolean isTotalCountRequired() {
		return totalCountRequired;
	}
	public void setTotalCountRequired(boolean totalCountRequired) {
		this.totalCountRequired = totalCountRequired;
	}
	@JsonIgnore
	public List<String> getIpv6Addresses() {
		return ipv6Addresses;
	}
	public void setIpv6Addresses(List<String> ipv6Addresses) {
		this.ipv6Addresses = ipv6Addresses;
	}
	
	public int getAverageDataRate() {
		return averageDataRate;
	}
	
	public void setAverageDataRate(int avgDataRate) {
		this.averageDataRate = avgDataRate;
	}

	public static enum ClientGroup {
		AUTHORIZED(7, "AUTHORIZED"),
		EXTERNAL(8, "EXTERNAL"),
		UNCATEGORIZED(11, "UNCATEGORIZED"),
		ROGUE(12, "ROGUE"),
		GUEST(13, "GUEST"),
		ALL(200, "ALL");

		int value;
		String stringValue;
		
		private ClientGroup(int v, String stringValue) {
			this.value = v;
			this.stringValue = stringValue;
		}

		public int getValue() {
			return value;
		}
		
		public static int getClientGroupValue(String strValue) {
			  for(ClientGroup e: values()) {
			    if(e.stringValue.equals(strValue)) {
			      return e.value;
			    }
			  }
			  throw new IllegalArgumentException("Illegal Client Group : " + strValue); // not found
			}

		public static ClientGroup valueOf(int v) {
			for(ClientGroup group:values()) {
				if(group.value == v) {
					return group;
				}
			}
			throw new IllegalArgumentException("" + v);
		}
	}

	public void setOwnSensorMac(String ownSensorMac) {
		this.ownSensorMac = ownSensorMac;
	}
	
	public String getOwnSensorMac() {
		return ownSensorMac;
	}
	
	
	public Boolean isSticky() {
		return sticky;
	}
	
	public void setSticky(Boolean sticky) {
		this.sticky = sticky;
	}
	public String getIpV6Address() {
		return ipV6Address;
	}
	public void setIpV6Address(String ipV6Address) {
		this.ipV6Address = ipV6Address;
	}
	public List<String> getAllowedSSIDs() {
		return allowedSSIDs;
	}
	public void setAllowedSSIDs(List<String> allowedSSIDs) {
		this.allowedSSIDs = allowedSSIDs;
	}

	public String getOsType() {
		return osType;
	}
	
	public void setOsType(String osType) {
		this.osType = osType;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * This method has been overridden because
	 * 1. In case of clients, the logic of iterating on all radios and finding the best rssi does not make sense, since client has only one radio
	 * 2. The Best RSSI for a client is of some device that can see this client with a better RSSI, hence this value is calculated by the server
	 * 3. The actual RSSI i.e. the RSSI of the AP that the client is currently connected to is stored in radio->signal strength
	 */
	@Override
	public int getBestSignalStrength() {
        Collection<ClientRadio> radios = getRadios();
        ClientRadio clientRadio = radios.iterator().next();
        final Integer bestSignalStrength = clientRadio.getBestSignalStrength();
		return (bestSignalStrength == null ? Radio.MIN_SIG_STR : bestSignalStrength);
	}
	
	public void setBestSignalStrength(int bestSignalStrength) {
		Collection<ClientRadio> radios = getRadios();
        ClientRadio clientRadio = radios.iterator().next();
        clientRadio.setBestSignalStrength(bestSignalStrength);
	}
	
	public List<PoorPerformanceReason> getPoorPerformanceReasons() {
		return poorPerformanceReasons;
	}
	
	public void setPoorPerformanceReasons(
			List<PoorPerformanceReason> poorPerformanceReasons) {
		this.poorPerformanceReasons = poorPerformanceReasons;
	}
	
}


