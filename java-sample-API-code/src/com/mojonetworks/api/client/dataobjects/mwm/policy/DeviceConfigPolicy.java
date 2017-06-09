/*
 * Name: DeviceConfigPolicy.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Device configuration policy
 */
package com.mojonetworks.api.client.dataobjects.mwm.policy;

public class DeviceConfigPolicy extends Policy {
	private int defaultTemplateId = -1;
	private boolean applyToExistingDevices;

	public DeviceConfigPolicy() {
		super(PolicyType.DEVICE_CONFIG);
	}

	public int getDefaultTemplateId() {
		return defaultTemplateId;
	}

	public void setDefaultTemplateId(int defaultTemplateId) {
		this.defaultTemplateId = defaultTemplateId;
	}

	public void setApplyToExistingDevices(boolean applyToExistingDevices) {
		this.applyToExistingDevices = applyToExistingDevices;
	}

	public boolean isApplyToExistingDevices() {
		return applyToExistingDevices;
	}

}
