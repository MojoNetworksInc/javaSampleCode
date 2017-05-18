/*
 * Name: ApiSession.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: MWM API Session object
 *
 *
 */

package com.mojonetworks.api.client.dataobjects.mwm.session;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.mojonetworks.api.client.accessor.common.WebServiceConstant;
import com.mojonetworks.api.client.dataobjects.auth.AuthenticationInfo;
import com.mojonetworks.api.client.dataobjects.mwm.MWMUser;
import com.mojonetworks.api.client.dataobjects.session.ApiSession;

public class MWMApiSession extends ApiSession {
	
	private long timeout = WebServiceConstant.MWM_DEFAULT_TIMEOUT;
	private MWMUser user=null;
	private String clientIdPrefix=null;

	public MWMApiSession(SessionState state, AuthenticationInfo authInfo, MWMUser user, String clientIdPrefix,
			String hostName, ResteasyWebTarget target, long timeout, String jsessionid) {
		
		super(state,authInfo,hostName,target,jsessionid);
		this.user = user;
		this.clientIdPrefix = clientIdPrefix;
		this.timeout = timeout;
	}
	
	public void destroy(){
		super.destroy();
		this.user=null;
		this.serverHostName=null;
		this.timeout=WebServiceConstant.MWM_DEFAULT_TIMEOUT;
	}
	
	public MWMUser getUser() {
		return user;
	}

	public long getTimeout() {
		return timeout;
	}

	public String getClientIdentifier() {
		return clientIdPrefix;
	}
}
