/*
 * Name: MLPUser.java
 *
 * Created by sabhtarsha on 18-May-2017
 *
 * Description: Holds the user object from MLP
 *
 */


package com.mojonetworks.api.client.dataobjects.mlp;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MLPUser extends MLPData{

	@JsonProperty("email_id")
	private String emailId;
	
	@JsonProperty("username")
	private String userName;
	
	@JsonProperty("display_name")
	private String displayName;
	
	
	
}
