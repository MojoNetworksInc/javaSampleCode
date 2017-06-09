/*
 * Name: PolicyType.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: Available policy types
 */
package com.mojonetworks.api.client.dataobjects.mwm.policy;

public enum PolicyType {
	DEVICE_CONFIG(Policy.LOCATION_BASED_POLICY);
	
	int policyCategory;
	boolean copyable;
	
	private PolicyType(int policyCategory) {
		this(policyCategory, false);
	}
	
	private PolicyType(int policyCategory, boolean copyable) {
		this.policyCategory = policyCategory;
		this.copyable = copyable;
	}
	public int getPolicyCategory() {
		return policyCategory;
	}
	
	public boolean isCopyable() {
		return copyable;
	}
}
