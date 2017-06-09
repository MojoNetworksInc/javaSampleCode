/*
 * Name: ApplicationFirewallProfile.java
 *
 * Created by yagneshg on 21-May-2016
 *
 * Description:  yagneshg
 *
 * Copyright (C) 2003-2016 AirTight Networks, Inc. All rights reserved.
 *
 * The information and contents of this file are the
 * proprietary information of AirTight Networks and may not
 * be disclosed or used without the formal written approval of
 * AirTight Networks.
 *
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import java.util.List;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;
import com.mojonetworks.api.client.dataobjects.mwm.template.SLFirewallProfile.MarkDirection;

public class ApplicationFirewallRule extends MWMBaseObject{
	
	public static final int DEFUALT_INVALID_ID = -100;
	private int orderId;
	private FirewallAction action = FirewallAction.ALLOW;
	private MarkDirection markDirection = MarkDirection.TO_WIRELESS;
	private int dscpValue = DEFUALT_INVALID_ID ;
	private String category; 
	private List<Integer> applicationIds;
	private String ruleName;

	public enum FirewallAction {
		ALLOW(SLFirewallProfile.ACTION_ALLOW),
		BLOCK(SLFirewallProfile.ACTION_BLOCK),
		ALLOW_AND_MARK(SLFirewallProfile.ACTION_ALLOW_AND_MARK);
		
		int value;
		private FirewallAction(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
		public static FirewallAction valueOf(int value){
			for(FirewallAction fa:values()) {
				if(fa.value == value) return fa;
			}
			throw new IllegalArgumentException("" + value);
		}
	}
	
	public ApplicationFirewallRule() {
	}
	
	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public FirewallAction getAction() {
		return action;
	}

	public void setAction(FirewallAction action) {
		this.action = action;
	}

	public MarkDirection getMarkDirection() {
		return markDirection;
	}

	public void setMarkDirection(MarkDirection markDirection) {
		this.markDirection = markDirection;
	}

	public int getDscpValue() {
		return dscpValue;
	}

	public void setDscpValue(int dscpValue) {
		this.dscpValue = dscpValue;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public List<Integer> getApplicationIds() {
		return applicationIds;
	}
	
	public void setApplicationIds(List<Integer> applicationIds) {
		this.applicationIds = applicationIds;
	}
}
