/*
 * Name: MLPServices.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Services object
 *
 *
 */
package com.mojonetworks.api.client.dataobjects.mlp;

import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class MLPServices extends MLPData {
	private int totalCount;
	private MLPService[] customerServices;

	public MLPServices() {
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public MLPService[] getCustomerServices() {
		return customerServices;
	}

	public void setCustomerServices(MLPService[] customerServices) {
		this.customerServices = customerServices;
	}

	@Override
	public String toString() {
		return "MLPServices [totalCount=" + totalCount + ", customerServices=" + Arrays.toString(customerServices)
				+ "]";
	}
	
	

}
