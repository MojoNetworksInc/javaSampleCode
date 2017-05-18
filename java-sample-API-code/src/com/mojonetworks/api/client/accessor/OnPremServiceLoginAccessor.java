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
import com.mojonetworks.api.client.accessor.mwm.MWMCommunicator;
import com.mojonetworks.api.client.dataobjects.auth.AuthenticationInfo;
import com.mojonetworks.api.client.dataobjects.auth.UserCredentialsAuth;
import com.mojonetworks.api.client.dataobjects.mwm.MWMVersion;
import com.mojonetworks.api.client.dataobjects.mwm.session.MWMApiSession;

public class OnPremServiceLoginAccessor {
	public static MWMApiSession mwmUserNamePasswordLogin(String mwmHost, String loginId, String passwd,String clIdentifier) throws ApiClientException{
		UserCredentialsAuth auth= new UserCredentialsAuth(loginId, passwd);
		return authenticateToMWM(mwmHost, auth, clIdentifier);
	}
	
	private static MWMApiSession authenticateToMWM(String mwmHost, AuthenticationInfo auth, String clIdentifier) throws ApiClientException {
		MWMApiSession apiSession = ApiSessionProvider.getMWMAPISession(mwmHost, auth, clIdentifier,WebServiceConstant.MWM_DEFAULT_TIMEOUT);

		MWMVersion version= MWMCommunicator.getServerVersion(apiSession);
		System.out.println("Version:"+version);
		System.out.println("Logged in user: "+apiSession.getUser());
		return apiSession;
	}

}
