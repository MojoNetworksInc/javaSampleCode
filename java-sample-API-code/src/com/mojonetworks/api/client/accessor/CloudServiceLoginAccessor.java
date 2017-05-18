/*
 * Name: CloudServiceLoginAccessor.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Mojo Service accessor
 *
 *
 */
package com.mojonetworks.api.client.accessor;

import com.mojonetworks.api.client.accessor.common.ApiClientException;
import com.mojonetworks.api.client.accessor.common.ApiSessionProvider;
import com.mojonetworks.api.client.accessor.common.WebServiceConstant;
import com.mojonetworks.api.client.accessor.mlp.MLPCommunicator;
import com.mojonetworks.api.client.accessor.mwm.MWMCommunicator;
import com.mojonetworks.api.client.dataobjects.auth.AuthenticationInfo;
import com.mojonetworks.api.client.dataobjects.auth.KeyCredentialsAuth;
import com.mojonetworks.api.client.dataobjects.mlp.MLPServices;
import com.mojonetworks.api.client.dataobjects.mlp.session.MLPApiSession;
import com.mojonetworks.api.client.dataobjects.mwm.MWMVersion;
import com.mojonetworks.api.client.dataobjects.mwm.session.MWMApiSession;

public class CloudServiceLoginAccessor {

	public static MWMApiSession mwmKeyLogin(String mwmHost, String keyId, String keyValue,String clIdentifier) throws ApiClientException{
		KeyCredentialsAuth auth= new KeyCredentialsAuth(keyId, keyValue);
		return authenticateToMWM(mwmHost, auth, clIdentifier);
	}
	
	public static MLPApiSession mlpKeyLogin(String mlpHost, String keyId, String KeyValue) throws ApiClientException{
		KeyCredentialsAuth auth= new KeyCredentialsAuth(keyId, KeyValue);
		MLPApiSession mlpApiSession = ApiSessionProvider.getMLPApiSession(mlpHost, auth);
		System.out.println("Logged into MLP, response:" +mlpApiSession.getMlpLoginResponse());

		MLPServices allServices = MLPCommunicator.getAllMWMServices(mlpApiSession);
		System.out.println("Service:"+allServices);
		return mlpApiSession;
	}
	
	private static MWMApiSession authenticateToMWM(String mwmHost, AuthenticationInfo auth, String clIdentifier) throws ApiClientException {
		MWMApiSession apiSession = ApiSessionProvider.getMWMAPISession(mwmHost, auth, clIdentifier,WebServiceConstant.MWM_DEFAULT_TIMEOUT);

		MWMVersion version= MWMCommunicator.getServerVersion(apiSession);
		System.out.println("Version:"+version);
		System.out.println("Logged in user: "+apiSession.getUser());
		return apiSession;
	}
	

}
