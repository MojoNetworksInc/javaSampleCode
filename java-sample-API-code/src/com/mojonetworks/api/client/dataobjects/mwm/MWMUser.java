/*
 * Name: MWMUser.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: User Object for MWM
 *
 *
 */

package com.mojonetworks.api.client.dataobjects.mwm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class MWMUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private int     userId;
	private String  loginName;
	private int     userRoleId;
    private String  firstName;  
    private String  lastName;
    private String  primaryEmailAddress;
    private String 	timeZone;

    public MWMUser() {
	}
    
    /*
     * Location id required Location Management
     */
    private Collection<MWMLocationId> allowedLocations = new ArrayList<MWMLocationId>();

    public MWMUser(String loginName) {
    	this.loginName = loginName;
    	}
    
	public Collection<MWMLocationId> getAllowedLocations() {
		return allowedLocations;
	}

	public void setAllowedLocations(Collection<MWMLocationId> allowedLocations) {
		this.allowedLocations = allowedLocations;
	}

	/**
     * Returns the login name of the user.  
     * @return The login name of the user
     */
	public String getLoginName() {
		return loginName;
	}
	
	/**
	 * Returns the user role identifier. 
	 * @return The user role identifier
	 */
    public int getUserRoleId() {
		return userRoleId;
	}
	/**
	 * Sets the user role
	 * @param userRoleId
	 */
    public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	/**
	 * Returns the first name of the user.
	 * @return The first name of the user
	 */
    public String getFirstName() {
		return firstName;
	}
	/**
	 * Sets the first name for the user.
	 * @param firstName
	 */
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Returns the last name of the user.
	 * @return The last name of the user
	 */
    public String getLastName() {
		return lastName;
	}
	/**
	 * Sets the last name for the user.
	 * @param lastName
	 */
    public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Returns the primary e-mail address of the user.
	 * @return The primary e-mail address of the user
	 */
    public String getPrimaryEmailAddress() {
		return primaryEmailAddress;
	}
	/**
	 * Sets the primary e-mail address of the user.
	 * @param primaryEmailAddress
	 */
    public void setPrimaryEmailAddress(String primaryEmailAddress) {
		this.primaryEmailAddress = primaryEmailAddress;
	}

	/**
	 * Returns the time zone for the user.
	 * @return The time zone for the user
	 */
    public String getTimeZone() {
		return timeZone;
	}
	/**
	 * Sets the time zone for the user.
	 * @param timeZone
	 */
    public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
   
	@Override
    public boolean equals(Object obj) {
    	if(obj!=null && obj instanceof MWMUser){
    		MWMUser object = (MWMUser)obj;
    		return this.loginName.equals(object.loginName);
    	}
    	return false;
	}

    @Override
	public String toString() {
		return "User [userId=" + userId + ", loginName=" + loginName + ", userRoleId=" + userRoleId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", primaryEmailAddress=" + primaryEmailAddress + ", timeZone="
				+ timeZone + ", allowedLocations=" + allowedLocations + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
