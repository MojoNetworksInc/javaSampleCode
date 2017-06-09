/*
 * Name: WPA2MixedSecurity.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for WPA2 mixed security 
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

public class WPA2MixedSecurity extends WPASecurity {

	public WPA2MixedSecurity() {
		super(WPAAuthType.PSK);
	}
	
	public WPA2MixedSecurity(WPAAuthType authType) {
		super(authType);
	}

	private boolean	okcEnabled;
	private boolean	preAuthenticationEnabled;

	public boolean isOkcEnabled() {
		return okcEnabled;
	}

	public void setOkcEnabled(boolean okcEnabled) {
		this.okcEnabled = okcEnabled;
	}

	public boolean isPreAuthenticationEnabled() {
		return preAuthenticationEnabled;
	}

	public void setPreAuthenticationEnabled(boolean preAuthenticationEnabled) {
		this.preAuthenticationEnabled = preAuthenticationEnabled;
	}
	
	@Override
	public String toString() {
		return "WPA2MixedSecurity [okcEnabled=" + okcEnabled
				+ ", preAuthenticationEnabled=" + preAuthenticationEnabled
				+ ", toString()=" + super.toString() + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (okcEnabled ? 1231 : 1237);
		result = prime * result + (preAuthenticationEnabled ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		WPA2MixedSecurity other = (WPA2MixedSecurity) obj;
		if (okcEnabled != other.okcEnabled)
			return false;
		if (preAuthenticationEnabled != other.preAuthenticationEnabled)
			return false;
		return true;
	}

}
