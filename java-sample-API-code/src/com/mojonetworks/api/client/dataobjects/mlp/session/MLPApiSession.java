/*
 * Name: MLPApiSession.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: API Session object for MLP
 *
 *
 */
package com.mojonetworks.api.client.dataobjects.mlp.session;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.mojonetworks.api.client.dataobjects.auth.AuthenticationInfo;
import com.mojonetworks.api.client.dataobjects.mlp.MLPLoginData;
import com.mojonetworks.api.client.dataobjects.mlp.MLPResponse;
import com.mojonetworks.api.client.dataobjects.session.ApiSession;

public class MLPApiSession extends ApiSession{
	private MLPResponse<MLPLoginData> mlpLoginResponse;
	
	public MLPApiSession(AuthenticationInfo authInfo, String serverHostName, ResteasyWebTarget target, String jsessionid, MLPResponse<MLPLoginData> mlpLoginResponse) {
		super(SessionState.SESSION_ESTABLISHED,authInfo,serverHostName,target,jsessionid);
		this.mlpLoginResponse = mlpLoginResponse;
	}

	public MLPResponse<MLPLoginData> getMlpLoginResponse() {
		return mlpLoginResponse;
	}

}
