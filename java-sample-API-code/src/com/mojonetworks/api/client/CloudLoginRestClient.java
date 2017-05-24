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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.mojonetworks.api.client.accessor.CloudServiceLoginAccessor;
import com.mojonetworks.api.client.accessor.common.ApiClientException;
import com.mojonetworks.api.client.accessor.mlp.MLPCommunicator;
import com.mojonetworks.api.client.accessor.mwm.MWMCommunicator;
import com.mojonetworks.api.client.dataobjects.mlp.MLPService;
import com.mojonetworks.api.client.dataobjects.mlp.session.MLPApiSession;
import com.mojonetworks.api.client.dataobjects.mwm.LocalLocationId;
import com.mojonetworks.api.client.dataobjects.mwm.session.MWMApiSession;

public class CloudLoginRestClient {
	private static String keyId="KEY-ATN47-19";
	private static String keyValue="49dc318d65448c649484f1d3f5aca3f5";
	private static String HOT_POTATOES="https://";

	public static void main(String[] args) {
		//Login to MLP
		MLPApiSession mlpApiSession=null;
		try {
			mlpApiSession = CloudServiceLoginAccessor.mlpKeyLogin("mojo.airtightnw.com", keyId, keyValue);
		} catch (ApiClientException e1) {
			System.err.println("Error logging into the Mojo Launch Pad.");
			e1.printStackTrace();
			System.exit(0);
		}
		
		//Fetch Services
		MLPService[] mwmServices = MLPCommunicator.getAllMWMServices(mlpApiSession).getCustomerServices();
		//If you are sure that you have only 1 MWM service, then there is no point in creating this map.
		
		Map<MLPService.Service,MWMApiSession> mwmSessionMap = new HashMap<>();
		
		for (MLPService mlpService : mwmServices) {
			String serviceURL = mlpService.getService().getServiceURL();
			if(serviceURL.startsWith(HOT_POTATOES)){
				serviceURL = serviceURL.substring(HOT_POTATOES.length());
			}
			
			//Login to service
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
		
		//Fetch/Push data to MWM service using the MWMApiSession
		/*
		 * Your code to access various MWM objects here
		 */
		
		//Start time: 1495305000000
		//End time: 1495391400000
		File baseDir= new File("AnalyticsFile");
		long startTime=1495305000000L;
		long endTime=1495391400000L;
		if(!baseDir.exists()){
			baseDir.mkdirs();
		}
		
		for (Map.Entry<MLPService.Service, MWMApiSession> entry : mwmSessionMap.entrySet()) {
			try {
				FileOutputStream fileOutputStream= new FileOutputStream(baseDir.getAbsolutePath()+File.separator+"Visi_"+startTime+"-"+endTime+entry.getKey().getServiceId()+".csv");
				MWMCommunicator.getVisibilityAnalyticsData(entry.getValue(), startTime, endTime, new LocalLocationId(0), fileOutputStream);
			} catch (FileNotFoundException | ApiClientException e) {
				
				e.printStackTrace();
			}
		}
		for (Map.Entry<MLPService.Service, MWMApiSession> entry : mwmSessionMap.entrySet()) {
			try {
				FileOutputStream fileOutputStream= new FileOutputStream(baseDir.getAbsolutePath()+File.separator+"Assoc_"+startTime+"-"+endTime+entry.getKey().getServiceId()+".csv");
				MWMCommunicator.getAssociationAnalyticsData(entry.getValue(), startTime, endTime, new LocalLocationId(0), fileOutputStream);
			} catch (FileNotFoundException | ApiClientException e) {
				
				e.printStackTrace();
			}
		}
		
		
		//Disconnect from Service
		for (Map.Entry<MLPService.Service, MWMApiSession> entry : mwmSessionMap.entrySet()) {
			
			try {
				MWMCommunicator.disconnect(entry.getValue());
				System.out.println("Logged out of MWM service: "+ entry.getKey().getServiceURL());
			} catch (ApiClientException e) {
				System.err.println("Error logging out of MWM service:"+entry.getKey().getServiceURL());
				e.printStackTrace();
				continue;
			}
		}
		
		//Disconnect from MLP
		//TODO: Logout from MLP? - Check with MLP team
	}

}

