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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;

import com.mojonetworks.api.client.accessor.common.ApiClientException;
import com.mojonetworks.api.client.accessor.common.ApiSessionProvider;
import com.mojonetworks.api.client.accessor.common.WebApiUtility;
import com.mojonetworks.api.client.accessor.common.WebHTTPRequestInvoker;
import com.mojonetworks.api.client.accessor.common.WebServiceConstant;
import com.mojonetworks.api.client.dataobjects.mwm.AP;
import com.mojonetworks.api.client.dataobjects.mwm.BatchResponseData;
import com.mojonetworks.api.client.dataobjects.mwm.Client;
import com.mojonetworks.api.client.dataobjects.mwm.FolderLocation;
import com.mojonetworks.api.client.dataobjects.mwm.LocalLocationId;
import com.mojonetworks.api.client.dataobjects.mwm.Location;
import com.mojonetworks.api.client.dataobjects.mwm.LocationId;
import com.mojonetworks.api.client.dataobjects.mwm.LocationRequestData;
import com.mojonetworks.api.client.dataobjects.mwm.LocationTree;
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

	/**
	 * Batch API sample code which creates Location and fetches location tree.
	 * @param mwmApiSession
	 * @return List of responses
	 * @throws ApiClientException
	 */
	public static List<Object> executeBatchOperation(MWMApiSession mwmApiSession) throws ApiClientException{
		List<Object> batchResponse = new ArrayList<>();
		
		//Step 1a: Create Get Location tree request
		String getLocationTreeUrl = WebServiceConstant.V2_LOCATIONS + WebServiceConstant.TREE;
		final String getLocationTreeRequest = WebApiUtility.addRequestInBatch(1,HttpMethod.GET, getLocationTreeUrl, null);
		
		//Step 1b: Add Location
		LocationRequestData locationRequestData = new LocationRequestData();
		locationRequestData.setParentLocation(new LocalLocationId(0));
		FolderLocation location = new FolderLocation();
		location.setName("New");
		location.setTimezoneId("Asia/Kolkata");
		locationRequestData.setLocation(location);
		
		String addLocationUrl =  WebServiceConstant.V2_LOCATIONS;
		final String addLocationRequest =  WebApiUtility.addRequestInBatch(1,HttpMethod.PUT, addLocationUrl, WebApiUtility.convertDOToJSON(locationRequestData));
		
		//Step 2: Create batch request
		MultipartFormDataOutput batchRequest = new MultipartFormDataOutput();
		batchRequest.addFormData("addLocation", new ByteArrayInputStream(addLocationRequest.getBytes()), MediaType.TEXT_PLAIN_TYPE);
		batchRequest.addFormData("fetchLocationTree", new ByteArrayInputStream(getLocationTreeRequest.getBytes()), MediaType.TEXT_PLAIN_TYPE);

		GenericEntity<MultipartFormDataOutput> entity = new GenericEntity<MultipartFormDataOutput>(batchRequest) { };
		final Entity<GenericEntity<MultipartFormDataOutput>> entity2 = Entity.entity(entity,  new MediaType("multipart", "mixed"));
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("executionmode", "SERIAL");

		//Step 3: Execute batch request
		Response response = WebHTTPRequestInvoker.post(mwmApiSession.getTarget(), "https://"+mwmApiSession.getTarget().getUri().getHost()+ WebServiceConstant.BATCH,entity2,queryParams);

		try {
			ByteArrayDataSource ds;
			ds = new ByteArrayDataSource(new ByteArrayInputStream(response.readEntity(String.class).getBytes("UTF-8")), "multipart/mixed");
			MimeMultipart multipart = new MimeMultipart(ds);
			
			//Step 4a: First response
			BodyPart part1 = multipart.getBodyPart(0);
			final String responseData1 = part1.getDataHandler().getContent().toString();
			BatchResponseData batchResponseData1 = WebApiUtility.buildBatchResponseData(responseData1);
			
			if(WebApiUtility.isSuccessResponse(batchResponseData1)){
				batchResponse.add(new ObjectMapper().readValue(batchResponseData1.getBody(), LocationTree.class));
			}
			batchResponse.add(batchResponseData1.getBody());
			
			////Step 4b: First response
			BodyPart part2 = multipart.getBodyPart(1);
			final String responseData2 = part2.getDataHandler().getContent().toString();
			BatchResponseData batchResponseData2 = WebApiUtility.buildBatchResponseData(responseData2);
			
			if(WebApiUtility.isSuccessResponse(batchResponseData2)){
				batchResponse.add(new ObjectMapper().readValue(batchResponseData2.getBody(), Location.class));
			}
			
			batchResponse.add(batchResponseData2.getBody());
		} catch (IOException | MessagingException e) {
			throw new ApiClientException("Error occured while executing batch operation:",e);
		}
		response.close();
		return batchResponse;
	}
}
