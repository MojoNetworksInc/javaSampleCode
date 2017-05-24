/*
 * Name: Device.java
 *
 * Created by sabhtarsha on 24-May-2017
 *
 * Description: Device Object
 *
 *
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = AP.class, name = "ap"), 
	@Type(value = Client.class, name = "client")})

public abstract class Device<R extends Radio>  {
	private long boxId;
	private String name;
	private List<R> radios = new ArrayList<R>();
	private LocationId locationId;
	private String deviceNote;
	private String ipAddress;
	private Boolean activeStatus;
	private Integer deviceCapability;

	public long getBoxId() {
		return boxId;
	}
	public void setBoxId(long boxId) {
		this.boxId = boxId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<R> getRadios() {
		return radios;
	}
	public void setRadios(List<R> radios) {
		this.radios = radios;
	}
  	public LocationId getLocationId() {
		return locationId;
	}
	public void setLocationId(LocationId locationId) {
		this.locationId = locationId;
	}
    public String getDeviceNote() {
		return deviceNote;
	}
	public void setDeviceNote(String deviceNote) {
		this.deviceNote = deviceNote;
	}

	public String getIpAddress() {
		return ipAddress;
	}
	
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	/**
	 * @return true if any one radio isActive 
	 * @see R#isActive()
	 */
	public boolean isActive(){
		List<R> allRadios = getRadios();
		if(allRadios!=null){
			for (R r : allRadios) {
				if(r.isActive()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int getBestSignalStrength() {
        int bestSignalStr = Radio.MIN_SIG_STR;
        Collection<R> radios = getRadios();

        for (Iterator<R> it = radios.iterator(); it.hasNext();) { 
            Radio radio = (Radio) it.next();
            int signal = radio.getSignalStrength();
            if ((signal > bestSignalStr) && radio.isActive()) { 
                bestSignalStr = signal;
            }
        }
        return bestSignalStr;
    }
	
	public Boolean getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	public Integer getDeviceCapability() {
		return deviceCapability;
	}
	public void setDeviceCapability(Integer deviceCapability) {
		this.deviceCapability = deviceCapability;
	}
	@Override
	public String toString() {
		return "Device [boxId=" + boxId + ", name=" + name + ", radios="
				+ radios + ", locationId=" + locationId + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (boxId ^ (boxId >>> 32));
		result = prime * result
				+ ((locationId == null) ? 0 : locationId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		Device other = (Device) obj;
		if (boxId != other.boxId)
			return false;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} 
		return true;
	}
}
