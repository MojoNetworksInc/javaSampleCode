/*
 * Name: ApiSession.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Generic API Session object
 *
 */

package com.mojonetworks.api.client.dataobjects.session;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.mojonetworks.api.client.dataobjects.auth.AuthenticationInfo;

public class ApiSession {
	
	protected SessionState state=SessionState.SESSION_NOT_ESTABLISHED;
	protected AuthenticationInfo authInfo=null;
	protected String serverHostName=null;
	protected ResteasyWebTarget target=null;
	protected String jsessionid=null;

	public enum SessionState {
		SESSION_NOT_ESTABLISHED,
		SESSION_ESTABLISHED,
		SESSION_EXPIRED;
	}

	public ApiSession(SessionState state, AuthenticationInfo authInfo, 
			String hostName, ResteasyWebTarget target, String jsessionid) {
		super();
		this.state = state;
		this.authInfo = authInfo;
		this.serverHostName = hostName;
		this.target = target;
		this.jsessionid = jsessionid;
	}
	
	public void destroy(){
		this.state=SessionState.SESSION_NOT_ESTABLISHED;
		this.authInfo=null;
		this.serverHostName=null;
		this.target=null;
		this.jsessionid=null;
	}

	public AuthenticationInfo getAuthInfo() {
		return authInfo;
	}

	public SessionState getSessionState(){
		return state;
	}

	public String getServerHostName() {
		return serverHostName;
	}

	public ResteasyWebTarget getTarget(){
		return target;
	}

	public boolean isConnected() {
		if(state == SessionState.SESSION_ESTABLISHED){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jsessionid == null) ? 0 : jsessionid.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		ApiSession other = (ApiSession) obj;
		if (jsessionid == null) {
			if (other.jsessionid != null)
				return false;
		} else if (!jsessionid.equals(other.jsessionid))
			return false;
		if (state != other.state)
			return false;
		return true;
	}

	public String getJsessionid() {
		return jsessionid;
	}

}
