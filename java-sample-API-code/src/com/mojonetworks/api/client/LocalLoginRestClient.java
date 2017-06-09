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

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mojonetworks.api.client.accessor.OnPremServiceLoginAccessor;
import com.mojonetworks.api.client.accessor.common.ApiClientException;
import com.mojonetworks.api.client.accessor.common.WebApiUtility;
import com.mojonetworks.api.client.accessor.mwm.MWMCommunicator;
import com.mojonetworks.api.client.dataobjects.mwm.AP;
import com.mojonetworks.api.client.dataobjects.mwm.Client;
import com.mojonetworks.api.client.dataobjects.mwm.LocalLocationId;
import com.mojonetworks.api.client.dataobjects.mwm.policy.DeviceConfigPolicy;
import com.mojonetworks.api.client.dataobjects.mwm.session.MWMApiSession;
import com.mojonetworks.api.client.dataobjects.mwm.template.DeviceTemplate;
import com.mojonetworks.api.client.dataobjects.mwm.template.DeviceTemplateRadioSettings;
import com.mojonetworks.api.client.dataobjects.mwm.template.SSIDProfile;
import com.mojonetworks.api.client.dataobjects.mwm.template.SensorPassword;
import com.mojonetworks.api.client.dataobjects.mwm.template.TemplateType;
import com.mojonetworks.api.client.dataobjects.mwm.template.WPA2Security;
import com.mojonetworks.api.client.dataobjects.mwm.template.WirelessProfile.SecurityMode;

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
			List<Object> responses = MWMCommunicator.executeBatchOperation(mwmApiSession);
			System.out.println("List of responses:"+ responses);
		} catch (ApiClientException e1) {
			e1.printStackTrace();
		}

		
		//Configure WIFI profile
		configureWIFIProfile(mwmApiSession);
		
		//Disconnect from Service
		try {
			MWMCommunicator.disconnect(mwmApiSession);
			System.out.println("Disconnected session with MWM Server:"+mwmApiSession.getServerHostName());
		} catch (ApiClientException e) {
			System.err.println("Error disconnecting with MWM Server:"+mwmHost);
			e.printStackTrace();
		}
	}

	/**
	 * In order to configure SSID profile, following steps needs to be done
	 * 1. Create SSID 
	 *    a. Get system default SSID profile for reference
	 *    b. Create new SSID using system default template
	 *    c. (Optional) Update SSID template as per requirement
	 * 
	 * 2. Create Device template
	 *    a. Get system default device template for reference
	 *    b. Create new Device template using system default device template
	 *    c. Add created SSID in step 1 in device template
	 * 
	 * 3. Mark template created in step 2 as default template using device config policy
	 *    a. Get current device config policy for location id where we want to mark it as default
	 *    b. Update device config policy with previously created device template  
	 */
	private static void configureWIFIProfile(MWMApiSession mwmApiSession) {
		try {
			
			System.out.println("===Configuring SSID profile ....===");
			System.out.println("===1. Creating SSID ....===");
			System.out.println("===1a. Getting system default SSID profile ....===");
			SSIDProfile systemSSID = (SSIDProfile) MWMCommunicator.getTemplate(mwmApiSession,-1, TemplateType.SSID_PROFILE);
			System.out.println("===System default profile:"+WebApiUtility.convertDOToJSON(systemSSID));
	
			System.out.println("===1b. Create new SSID ....===");
			systemSSID.setTemplateName("newssid");
			systemSSID.setSsid("newssid");
			systemSSID.setDescription("my new ssid");
			
			SSIDProfile newSSID = (SSIDProfile) MWMCommunicator.addTemplate(mwmApiSession, systemSSID);
			System.out.println("=== Created SSID Profile:"+WebApiUtility.convertDOToJSON(newSSID));
			
			System.out.println("===1c. Updating SSID ....===");
			final WPA2Security securityMode = new WPA2Security();
			securityMode.setPskPassphrase("test1234");
			newSSID.getWirelessProfile().setSecurityMode(securityMode);
			newSSID.getWirelessProfile().setApSecurityMode(SecurityMode.SECURITY_MODE_WPA2.getValue());
			SSIDProfile updatedSSID = (SSIDProfile) MWMCommunicator.updateTemplate(mwmApiSession, newSSID);
			System.out.println("=== Updated SSID Profile:"+WebApiUtility.convertDOToJSON(updatedSSID));
			
			
			System.out.println("===2. Creating Device template ....===");
			System.out.println("===2a. Getting system default device template ....===");
			DeviceTemplate systemTemplate = (DeviceTemplate) MWMCommunicator.getTemplate(mwmApiSession,-1, TemplateType.DEVICE_TEMPLATE);
			System.out.println("== System default device template:"+WebApiUtility.convertDOToJSON(systemTemplate));
			
			System.out.println("===2b. Creating new device template ....===");
			systemTemplate.setTemplateName("newtemplate");
			systemTemplate.setDescription("newtemplate");
			systemTemplate.setSensorPassword(new SensorPassword("welcome"));
			DeviceTemplate newTemplate = (DeviceTemplate) MWMCommunicator.addTemplate(mwmApiSession, systemTemplate);
			System.out.println("== Created device template:"+WebApiUtility.convertDOToJSON(newTemplate));
			
			System.out.println("===2c. Adding SSID in previously created device template ....===");
			final Map<Integer, Collection<DeviceTemplateRadioSettings>> platformToRadioSettingsMap = newTemplate.getPlatformToRadioSettingsMapper().getPlatformToRadioSettingsMap();
			for (Entry<Integer, Collection<DeviceTemplateRadioSettings>> entry : platformToRadioSettingsMap.entrySet()) {
				for (DeviceTemplateRadioSettings radioSetting : entry.getValue()) {
					radioSetting.setConfigured(true);
					radioSetting.setSsidProfiles(Arrays.asList(updatedSSID));
				}
			}

			DeviceTemplate updaDeviceTemplate = (DeviceTemplate) MWMCommunicator.updateTemplate(mwmApiSession, newTemplate);
			System.out.println("=== Updated device template:"+WebApiUtility.convertDOToJSON(updaDeviceTemplate));
			
			System.out.println("===3. Mark device template as default ....===");
			System.out.println("===3a. Getting device config policy ....===");
			DeviceConfigPolicy deviceConfigPolicy = MWMCommunicator.geDeviceConfigPolicy(mwmApiSession, new LocalLocationId(0), false);
			System.out.println("=== Device config policy:"+WebApiUtility.convertDOToJSON(deviceConfigPolicy));
		
			System.out.println("===3b. Update device config policy with previously created template ....===");
			deviceConfigPolicy.setDefaultTemplateId(updaDeviceTemplate.getTemplateId());
			MWMCommunicator.modifyDeviceConfigPolicy(mwmApiSession, deviceConfigPolicy, new LocalLocationId(0), false);
			DeviceConfigPolicy updatedConfigPolicy = MWMCommunicator.geDeviceConfigPolicy(mwmApiSession, new LocalLocationId(0), false);
			System.out.println("=== Updated device config policy:"+WebApiUtility.convertDOToJSON(updatedConfigPolicy));
			
			System.out.println("===Configuration successfull===");
		} catch (ApiClientException e1) {
			e1.printStackTrace();
		}
	}

}

