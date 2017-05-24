/*
 * Name: AP.java
 *
 * Created by sabhtarsha on 24-May-2017
 *
 * Description: AP Object
 *
 *
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class AP extends Device<APRadio> {

	private boolean placed;
	private boolean wiredPortBlocked;
	private long ownSensorBoxId;
	private long apTemplateId;
	private String apTemplateName;
	private String vendorName;
	private Boolean isBanned;
	public AP() {
	}

	public long getOwnSensorBoxId() {
		return ownSensorBoxId;
	}

	public void setOwnSensorBoxId(long ownSensorBoxId) {
		this.ownSensorBoxId = ownSensorBoxId;
	}
	
	public long getApTemplateId() {
		return apTemplateId;
	}

	public void setApTemplateId(long apTemplateId) {
		this.apTemplateId = apTemplateId;
	}

	public void setApTemplateName(String apTemplateName) {
		this.apTemplateName = apTemplateName;
	}
	
	public String getApTemplateName() {
		return apTemplateName;
	}
	

	public boolean isWiredPortBlocked() {
		return wiredPortBlocked;
	}

	public void setWiredPortBlocked(boolean wiredPortBlocked) {
		this.wiredPortBlocked = wiredPortBlocked;
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
	
	public boolean isPlaced() {
		return placed;
	}
	
	public void setPlaced(Boolean isPlaced) {
		this.placed = isPlaced;
	}
	
	
	/********* SPECIAL GETTERS/SETTERS ***********/
	
	/**
	 * Returns the primary radio set in the list of radios, If single radio then return the single radio
	 * @return the primary radio
	 */
	public APRadio getPrimaryRadio(){
		List<APRadio> radios = (List<APRadio>) getRadios();
		if(radios==null || radios.isEmpty()){
			return null;
		}
		if(radios.size()==1) {
			return radios.iterator().next();		
		}
		for(APRadio radio:radios) {
			if(radio.isPrimary()){
				return radio;
			}
		}
		return radios.iterator().next();	// Return the first radio if none is found to be primary
	}
	
	public boolean isGuest() {
		for (APRadio apRadio : getRadios()) {
			if(!apRadio.isGuest()){
				return false;
			}
		}
		return true;
	}
	
	public boolean isMergedAP() {
		boolean mergedAP = false;
		List<APRadio> radios = getRadios();
		if(radios != null && radios.size() > 1) {
			mergedAP = true;
		}
		return mergedAP;
	}

	public Set<String> getSSIDs(){
		List<APRadio> radios = getRadios();
		Set<String> ssids = new HashSet<String>();
		for(APRadio radio: radios){
			if(radio.getSsid()!=null){
				ssids.add(radio.getSsid());
			}
		}
		return ssids;
	}

	
}
