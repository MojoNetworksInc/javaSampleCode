/*
 * Name: WebServiceConstant.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Constants Holder
 *
 *
 */
package com.mojonetworks.api.client.accessor.common;

public interface WebServiceConstant {
	
	public static final String MLP_BASE_URL="/rest/api/v2"; 
	public static final String MLP_KEY_LOGIN="/kvs/login";
	public static final String MLP_KEY_ID="key_id";
	public static final String MLP_KEY_VALUE="key_value";
	public static final String MLP_SERVICES="/services";
	public static final String MLP_SESSION_DATA="/session_data";
	
	public static final String MWM_BASE_URL="/new/webservice";
	public static final String MWM_LOGIN = "/login";
	public static final String MWM_KEEP_ALIVE = "/keepsessionalive";
	public static final String MWM_LOGOUT = "/logout";
	public static final String MWM_PRODUCT_INFO = "/productinfo";
	public static final String MWM_GET_VERSION = "/version";
	public static final String MWM_INSTANCE_ID_REQUEST_ATTR = "IID";
	public static final int MWM_DEFAULT_TIMEOUT = 5*60;
	public static final String JSESSION_ID = "JSESSIONID";

	public static final String PROTOCOL_SSL = "TLSv1.2";
	public static final String HTTPS_PROTOCOLS = "https.protocols";
	
	
}
