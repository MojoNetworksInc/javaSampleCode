/*
 * Name: RadiusConfiguration.java
 * 
 * Created by manojg on Jun 8, 2017
 * 
 * Description: POJO for Radius configuration
 */
package com.mojonetworks.api.client.dataobjects.mwm.template;

import com.mojonetworks.api.client.dataobjects.mwm.MWMBaseObject;

public class RadiusConfiguration extends MWMBaseObject{

	private String	serverIP;
	private String	secret;
	private int	port;
	
	public RadiusConfiguration() {
	}
	
	public RadiusConfiguration(int port){
		setPort(port);
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + port;
		result = prime * result + ((secret == null) ? 0 : secret.hashCode());
		result = prime * result
				+ ((serverIP == null) ? 0 : serverIP.hashCode());
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
		RadiusConfiguration other = (RadiusConfiguration) obj;
		if (port != other.port)
			return false;
		if (secret == null) {
			if (other.secret != null)
				return false;
		} else if (!secret.equals(other.secret))
			return false;
		if (serverIP == null) {
			if (other.serverIP != null)
				return false;
		} else if (!serverIP.equals(other.serverIP))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RadiusConfiguration [serverIP=" + serverIP + ", secret="
				+ secret + ", port=" + port + "]";
	}
}
