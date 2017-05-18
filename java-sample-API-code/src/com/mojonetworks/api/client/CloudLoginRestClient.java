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

import java.util.HashMap;
import java.util.Map;

import com.mojonetworks.api.client.accessor.CloudServiceLoginAccessor;
import com.mojonetworks.api.client.accessor.common.ApiClientException;
import com.mojonetworks.api.client.accessor.mlp.MLPCommunicator;
import com.mojonetworks.api.client.accessor.mwm.MWMCommunicator;
import com.mojonetworks.api.client.dataobjects.mlp.MLPService;
import com.mojonetworks.api.client.dataobjects.mlp.session.MLPApiSession;
import com.mojonetworks.api.client.dataobjects.mwm.session.MWMApiSession;

public class CloudLoginRestClient {
	private static String keyId="KEY-ATN47-19";
	private static String keyValue="49dc318d65448c649484f1d3f5aca3f5";
	private static String HOT_POTATOES="https://";

	public static void main(String[] args) {
		//Login to MLP
		//Fetch Services
		//Login to service
			//Fetch/Push data to MWM service using the MWMApiSession
		//Disconnect from Service
		//Disconnect from MLP
		
		Map<MLPService.Service,MWMApiSession> mwmSessionMap = new HashMap<>();
		
		MLPApiSession mlpApiSession=null;
		try {
			mlpApiSession = CloudServiceLoginAccessor.mlpKeyLogin("mojo.airtightnw.com", keyId, keyValue);
		} catch (ApiClientException e1) {
			System.err.println("Error logging into the Mojo Launch Pad.");
			e1.printStackTrace();
			System.exit(0);
		}
		
		MLPService[] mwmServices = MLPCommunicator.getAllMWMServices(mlpApiSession).getCustomerServices();
		
		for (MLPService mlpService : mwmServices) {
			String serviceURL = mlpService.getService().getServiceURL();
			if(serviceURL.startsWith(HOT_POTATOES)){
				serviceURL = serviceURL.substring(HOT_POTATOES.length());
			}
			
			MWMApiSession mwmApiSession;
			try {
				mwmApiSession = CloudServiceLoginAccessor.mwmKeyLogin(serviceURL,keyId,keyValue,"TestClient");
			} catch (ApiClientException e) {
				System.err.println("Error logging into the MWM server:"+serviceURL);
				e.printStackTrace();
				continue;
			}
			System.out.println("Logged into MWM: "+serviceURL);
			mwmSessionMap.put(mlpService.getService(),mwmApiSession);
		}
		
		/*
		 * Your code to access various MWM objects here
		 */
		
		
		
		for (Map.Entry<MLPService.Service, MWMApiSession> entry : mwmSessionMap.entrySet()) {
			
			try {
				MWMCommunicator.disconnect(entry.getValue());
			} catch (ApiClientException e) {
				System.err.println("Error logging out of MWM service:"+entry.getKey().getServiceURL());
				e.printStackTrace();
				continue;
			}
		}
		
		//TODO: Logout from MLP? - Check with MLP team
		
		
	}

}

