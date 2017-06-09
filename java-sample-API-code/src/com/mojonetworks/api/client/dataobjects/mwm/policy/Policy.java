/*
 * Name: Policy.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for MWM Policy
 */
package com.mojonetworks.api.client.dataobjects.mwm.policy;

import com.mojonetworks.api.client.dataobjects.mwm.LocationId;
import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;

public abstract class Policy extends MWMBaseObject{
	public static final int GLOBAL_POLICY = 1;
	public static final int LOCATION_BASED_POLICY = 2;
	public static final int LOCATION_PROPERTY_POLICY = 3;

	private LocationId policyCreatedAtLocId;
    private PolicyType policyType;
	
	public LocationId getPolicyCreatedAtLocId() {
		return policyCreatedAtLocId;
	}

	public void setPolicyCreatedAtLocId(LocationId policyCreatedAtLocId) {
		this.policyCreatedAtLocId = policyCreatedAtLocId;
	}

	protected Policy(PolicyType policyType){
		this.policyType = policyType;
	}

	public PolicyType getPolicyType() {
		return policyType;
	}
}
