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

import java.util.Collection;
import java.util.List;

import com.mojonetworks.api.client.accessor.OnPremServiceLoginAccessor;
import com.mojonetworks.api.client.accessor.common.ApiClientException;
import com.mojonetworks.api.client.accessor.common.WebApiUtility;
import com.mojonetworks.api.client.accessor.mwm.MWMCommunicator;
import com.mojonetworks.api.client.dataobjects.mwm.AP;
import com.mojonetworks.api.client.dataobjects.mwm.Client;
import com.mojonetworks.api.client.dataobjects.mwm.LocalLocationId;
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
		 * Your code to access various MWM objects here using the MWMCommunicator
		 * 
		 */
		
		try {
			// Fetch APs at the root location
			Collection<AP> aPs = MWMCommunicator.getAPs(mwmApiSession, new LocalLocationId(0));
			System.out.println("List of APs:"+WebApiUtility.convertDOToJSON(aPs));
		} catch (ApiClientException e1) {
			e1.printStackTrace();
		}
		
		try {
			// Fetch All Clients
			Collection<Client> clients = MWMCommunicator.getClients(mwmApiSession);
			System.out.println("List of Clients:"+WebApiUtility.convertDOToJSON(clients));
		} catch (ApiClientException e1) {
			e1.printStackTrace();
		}
		
		//Add location and  fetch locations using batch
		try {
			List<Object> responses = MWMCommunicator.executeBatchOperation(mwmApiSession);;
			System.out.println("List of responses:"+ responses);
		} catch (ApiClientException e1) {
			e1.printStackTrace();
		}

		
		
		
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

