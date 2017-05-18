/*
 * Name: LocalLoginRestClient.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Main Class for Login 
 *
 *
 */
package com.mojonetworks.api.client;

import com.mojonetworks.api.client.accessor.OnPremServiceLoginAccessor;
import com.mojonetworks.api.client.accessor.common.ApiClientException;
import com.mojonetworks.api.client.accessor.mwm.MWMCommunicator;
import com.mojonetworks.api.client.dataobjects.mwm.session.MWMApiSession;

public class LocalLoginRestClient {
	private static final String mwmHost = "192.168.8.147";
	private static final String loginId = "admin";
	private static final String passwd = "admin";

	public static void main(String[] args) {
		//Login to service
		MWMApiSession mwmApiSession=null;
		try {

			mwmApiSession =OnPremServiceLoginAccessor.mwmUserNamePasswordLogin(mwmHost, loginId, passwd,"TestClient");
			System.out.println("Logged in to MWM Server:"+mwmHost);
		} catch (ApiClientException e) {
			e.printStackTrace();
		}

		/*
		 * Your code to access various MWM objects here
		 */
		
		

		//Disconnect from Service
		try {
			MWMCommunicator.disconnect(mwmApiSession);
			System.out.println("Disconnected session with MWM Server:"+mwmApiSession.getServerHostName());
		} catch (ApiClientException e) {
			System.err.println("Error disconnecting with MWM Server:"+mwmHost);
			e.printStackTrace();
		}
	}

}

