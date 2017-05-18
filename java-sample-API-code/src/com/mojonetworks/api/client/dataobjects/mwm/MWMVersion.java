/*
 * Name: MWMVersion.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Version Object
 *
 *
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MWMVersion implements Serializable{

	private static final long serialVersionUID = 1L;

	private String version;
	private String build;
	
	public MWMVersion() {
	}
	
	public String getVersion() {
		return version;
	}
	public String getBuild() {
		return build;
	}
	@Override
	public String toString() {
		return "Version:"+version +" Build:"+build;
	}
}
