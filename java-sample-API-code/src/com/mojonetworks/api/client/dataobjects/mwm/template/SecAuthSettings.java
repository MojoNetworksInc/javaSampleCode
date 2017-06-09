/*
 * Name: SecAuthSettings.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Secondary Authentication Settings
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;

public class SecAuthSettings extends MWMBaseObject{
	private boolean googleEduIntegrationEnabled;
	private boolean radiusMacAuthenticationEnabled;
	private AuthFailedAction authFailedAction;
	private int roleTemplateId;
	private int secAuthConfigId;
	
	public enum AuthFailedAction {
		DE_AUTHORIZE,
		ASSIGN_ROLE
	}
	
	public SecAuthSettings() {
	}

	public SecAuthSettings(AuthFailedAction authFailedAction,
			int roleTemplateId) {
		super();
		this.authFailedAction = authFailedAction;
		this.roleTemplateId = roleTemplateId;
	}

	public AuthFailedAction getAuthFailedAction() {
		return authFailedAction;
	}

	public void setAuthFailedAction(AuthFailedAction authFailedAction) {
		this.authFailedAction = authFailedAction;
	}

	public int getRoleTemplateId() {
		return roleTemplateId;
	}

	public void setRoleTemplateId(int roleTemplateId) {
		this.roleTemplateId = roleTemplateId;
	}

	public int getSecAuthConfigId() {
		return secAuthConfigId;
	}

	public void setSecAuthConfigId(int secAuthConfigId) {
		this.secAuthConfigId = secAuthConfigId;
	}

	@Override
	public String toString() {
		return "SecAuthSettings [googleEduIntegrationEnabled=" + googleEduIntegrationEnabled 
				+ ", radiusMacAuthenticationEnabled="+ radiusMacAuthenticationEnabled 
				+ ", authFailedAction="+ authFailedAction 
				+ ", roleTemplateId=" + roleTemplateId
				+ ", secAuthConfigId=" + secAuthConfigId + "]";
	}

	public boolean isGoogleEduIntegrationEnabled() {
		return googleEduIntegrationEnabled;
	}

	public void setGoogleEduIntegrationEnabled(boolean googleEduIntegrationEnabled) {
		this.googleEduIntegrationEnabled = googleEduIntegrationEnabled;
	}

	public boolean isRadiusMacAuthenticationEnabled() {
		return radiusMacAuthenticationEnabled;
	}

	public void setRadiusMacAuthenticationEnabled(
			boolean radiusMacAuthenticationEnabled) {
		this.radiusMacAuthenticationEnabled = radiusMacAuthenticationEnabled;
	}

}
