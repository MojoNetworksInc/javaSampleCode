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
 
public interface WebServiceConstant{
	
	String MLP_BASE_URL="/rest/api/v2"; 
	String MLP_KEY_LOGIN="/kvs/login";
	String MLP_KEY_ID="key_id";
	String MLP_KEY_VALUE="key_value";
	String MLP_SERVICES="/services";
	String MLP_SESSION_DATA="/session_data";
	
	int MWM_DEFAULT_TIMEOUT = 5*60;
	String MWM_BASE_URL="/new/webservice/v4";
	String MWM_LOGIN = "/login";
	String MWM_KEEP_ALIVE = "/keepsessionalive";
	String MWM_LOGOUT = "/logout";
	String MWM_PRODUCT_INFO = "/productinfo";
	String MWM_GET_VERSION = "/version";
	String MWM_INSTANCE_ID_REQUEST_ATTR = "IID";
	String MWM_LOCATION_TREE="/locations/tree";
	String MWM_ANALYTICS = "/analytics";
	String MWM_VISIBILITY_DATA = "/visibilitydata";
	String MWM_ASSOCIATION_DATA = "/associationdata";
	String MWM_LOCATION_QUERYPARAM = "location";
	String MWM_HASH_MAC_PARAM = "tohashmac";
	String DEVICE = "/device";
	String V2_LOCATIONS = "/v2/locations";
	String TREE = "/tree";
	String BATCH = "/new/webservice/batch";
	String APS = "/aps";
	String CLIENTS = "/clients";
	String AT_LOCATION = "/atlocation";
	String CLIENTS_AT_LOCATION = CLIENTS + AT_LOCATION;
	String APS_AT_LOCATION = APS + AT_LOCATION;
	String LOCATION_PARAM = "location";
	
	String JSESSION_ID = "JSESSIONID";
	String PROTOCOL_SSL = "TLSv1.2";
	String HTTPS_PROTOCOLS = "https.protocols";
	
	String TEMPLATES = "/templates";
	String POLICIES = "/policies";
	String DEVICE_CONFIG = "/deviceconfig";
}
