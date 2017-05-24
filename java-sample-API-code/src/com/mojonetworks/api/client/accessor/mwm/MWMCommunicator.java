/*
 * Name: MWMCommunicator.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Communicator class for MWM
 *
 *
 */
package com.mojonetworks.api.client.accessor.mwm;

import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.mojonetworks.api.client.accessor.common.ApiClientException;
import com.mojonetworks.api.client.accessor.common.ApiSessionProvider;
import com.mojonetworks.api.client.accessor.common.WebApiUtility;
import com.mojonetworks.api.client.accessor.common.WebHTTPRequestInvoker;
import com.mojonetworks.api.client.accessor.common.WebServiceConstant;
import com.mojonetworks.api.client.dataobjects.mwm.AP;
import com.mojonetworks.api.client.dataobjects.mwm.Client;
import com.mojonetworks.api.client.dataobjects.mwm.LocationId;
import com.mojonetworks.api.client.dataobjects.mwm.MWMVersion;
import com.mojonetworks.api.client.dataobjects.mwm.session.MWMApiSession;
import com.mojonetworks.api.client.dataobjects.session.ApiSession.SessionState;

public class MWMCommunicator {
	
	/**
	 * Closes a previously opened session. If the application does not use this method explicitly, 
	 * MWM uses session time out to terminate the session and release resources. 
	 * @throws ApiClientException
	 */
	public static void disconnect(MWMApiSession apiSession) throws ApiClientException {
		if(apiSession.getSessionState()!=SessionState.SESSION_ESTABLISHED){
			throw new ApiClientException("API Session not established");
		}
		try{
			String uri = apiSession.getTarget().getUri().toString() + WebServiceConstant.MWM_LOGOUT;
			Response response = WebHTTPRequestInvoker.post(apiSession.getTarget(), uri, null, null);
			if(response.getStatus()>=Status.OK.getStatusCode()){
				apiSession.destroy();
			} else {
				throw new ApiClientException("Unable to disconnect session! Error Info:"+response.getStatusInfo());
			}
			response.close();
		}catch(Exception e){
			throw new ApiClientException("Unable to disconnect session!!", e);
		}
	}
	
	/**
	 * Returns the version of the MWM API Server
	 */
	public static MWMVersion getServerVersion(MWMApiSession apiSession) {
		String uri = apiSession.getTarget().getUri().toString() + WebServiceConstant.MWM_PRODUCT_INFO + WebServiceConstant.MWM_GET_VERSION;
		Response response = WebHTTPRequestInvoker.get(apiSession.getTarget(), uri, null);
		MWMVersion version = response.readEntity(MWMVersion.class);
		response.close();
		return version;
	}

	/**
	 * Keeps the session alive for the API client. 
	 * This could be called on a periodic basis by the API Client to keep the session alive in case 
	 * there are periods of time where the session is idle. 
	 * In case the API Client calls this method on a periodic basis, this period should be less than 
	 * the session timeout value provided by the API Client.
	 * @throws ApiClientException
	 */
	public static void keepSessionAlive(MWMApiSession apiSession) throws ApiClientException {
		String uri = apiSession.getTarget().getUri().toString() + WebServiceConstant.MWM_LOGIN + WebServiceConstant.MWM_KEEP_ALIVE;
		Response response = WebHTTPRequestInvoker.get(apiSession.getTarget(), uri, null);
		response.close();
	}
	
	
	public static void getLocationTree(MWMApiSession apiSession) throws ApiClientException{
//		String uri = apiSession.getTarget().getUri().toString() + WebServiceConstant.MWM_PRODUCT_INFO + WebServiceConstant.MWM_GET_VERSION;
//		Response response = WebHTTPRequestInvoker.get(apiSession.getTarget(), uri, null);
//		MWMVersion version = response.readEntity(MWMVersion.class);
//		response.close();
	}
	
	
	/**
	 * Download Visibility analytics data.
	 * @param session
	 * @param startTime
	 * @param endTime
	 * @param locationId - The visibility analytics data will be fetched for location subtree corresponding to this location id.
	 * @param outputStrem - The visibility analytics data is written to this output stream.
	 * @throws ApiClientException
	 */
	public static void getVisibilityAnalyticsData(MWMApiSession session, long startTime, long endTime, LocationId locationId, OutputStream outputStrem) throws ApiClientException{
		try {
			String uri = session.getTarget().getUri().toString() + WebServiceConstant.MWM_ANALYTICS + WebServiceConstant.MWM_VISIBILITY_DATA;
			Map<String, String> queryParams = new HashMap<String, String>();
			queryParams.put(WebServiceConstant.MWM_LOCATION_QUERYPARAM, WebApiUtility.convertDOToJSON(locationId));
			queryParams.put(WebServiceConstant.MWM_HASH_MAC_PARAM, WebApiUtility.convertDOToJSON(false));
			Response response = WebHTTPRequestInvoker.get( session.getTarget(), uri, queryParams, ""+startTime, ""+endTime);
			String reponseurl = response.readEntity(String.class);
			response.close();
			String fileDownloadURL= session.getTarget().getUri().toString();
			fileDownloadURL= fileDownloadURL.substring(0,fileDownloadURL.indexOf("webservice"));
			ApiSessionProvider.downloadURLResource(session, fileDownloadURL+ reponseurl, outputStrem);
		} catch (ApiClientException e) {
			throw new ApiClientException("Error fetching Analytics data:"+ e.getMessage(),e);
		}
	}
	
	/**
	 * Download Visibility analytics data.
	 * @param session
	 * @param startTime
	 * @param endTime
	 * @param locationId - The visibility analytics data will be fetched for location subtree corresponding to this location id.
	 * @param outputStrem - The visibility analytics data is written to this output stream.
	 * @throws ApiClientException
	 */
	public static void getAssociationAnalyticsData(MWMApiSession session, long startTime, long endTime, LocationId locationId, OutputStream outputStrem) throws ApiClientException{
		try {
			String uri = session.getTarget().getUri().toString() + WebServiceConstant.MWM_ANALYTICS + WebServiceConstant.MWM_ASSOCIATION_DATA;
			Map<String, String> queryParams = new HashMap<String, String>();
			queryParams.put(WebServiceConstant.MWM_LOCATION_QUERYPARAM, WebApiUtility.convertDOToJSON(locationId));
			queryParams.put(WebServiceConstant.MWM_HASH_MAC_PARAM, WebApiUtility.convertDOToJSON(false));
			Response response = WebHTTPRequestInvoker.get( session.getTarget(), uri, queryParams, ""+startTime, ""+endTime);
			String reponseurl = response.readEntity(String.class);
			response.close();
			String fileDownloadURL= session.getTarget().getUri().toString();
			fileDownloadURL= fileDownloadURL.substring(0,fileDownloadURL.indexOf("webservice"));
			ApiSessionProvider.downloadURLResource(session, fileDownloadURL+ reponseurl, outputStrem);
		} catch (ApiClientException e) {
			throw new ApiClientException("Error fetching Analytics data:"+ e.getMessage(),e);
		}
	}
	
	/**
	 * @param session
	 * @param locationId
	 * @return
	 * @throws ApiClientException
	 */
	public static Collection<AP> getAPs(MWMApiSession session, LocationId locationId) throws ApiClientException{
		try{
			String uri = session.getTarget().getUri().toString() + WebServiceConstant.DEVICE + WebServiceConstant.APS_AT_LOCATION;
			Map<String, String> queryParams = new HashMap<String, String>();
			queryParams.put(WebServiceConstant.LOCATION_PARAM, WebApiUtility.convertDOToJSON(locationId));
			Response response = WebHTTPRequestInvoker.get(session.getTarget(), uri, queryParams);
			List<AP> listAPs = response.readEntity(new GenericType<List<AP>>(){});
			response.close();
			return listAPs;
		} catch(ApiClientException e){
			throw e;
		}
	}
	/**
	 * @param session
	 * @return
	 * @throws ApiClientException
	 */
	public static Collection<Client> getClients(MWMApiSession session) throws ApiClientException {
		String uri = session.getTarget().getUri().toString() + WebServiceConstant.DEVICE + WebServiceConstant.CLIENTS;
		Response response = WebHTTPRequestInvoker.get(session.getTarget(), uri, null);
		List<Client> listClients = response.readEntity(new GenericType<List<Client>>(){});
		response.close();
		return listClients;
	}
	
}
