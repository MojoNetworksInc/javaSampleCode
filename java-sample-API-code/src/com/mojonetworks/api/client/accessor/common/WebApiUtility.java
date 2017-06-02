/*
 * Name: WebApiUtility.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Utility Class
 *
 *
 */
package com.mojonetworks.api.client.accessor.common;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.mojonetworks.api.client.dataobjects.mwm.BatchResponseData;

public class WebApiUtility {

	
	public static void closeStream(Closeable inputStream) {
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static <T> String convertDOToJSON(T dataObject) throws ApiClientException {
		try {
			return new ObjectMapper().writeValueAsString(dataObject);
		} catch (JsonGenerationException e) {
			throw new ApiClientException("Invalid data object",e);
		} catch (JsonMappingException e) {
			throw new ApiClientException("Invalid data object",e);
		} catch (IOException e) {
			throw new ApiClientException(e);
		}
	}

	public static boolean isSuccessResponse(BatchResponseData batchResponseData1) {
		return batchResponseData1.getStatus().toString().startsWith("2");
	}

	public static String addRequestInBatch(int contentId, String method, String url, String body) {
		final StringBuilder request = new StringBuilder();
	
		// Add batch headers
		request.append("Content-Type: application/http");
		request.append("\n");
		request.append("Content-ID: "+ contentId);
		request.append("\n");
		request.append("\n");
		
		//Add URL
		request.append(method);
		request.append(" ");
		request.append(url);
		request.append("  HTTP/1.1");
		request.append("\n");
		
		//Add request headers
		request.append("Content-Type: application/json");
		request.append("\n");
		request.append("\n");
		
		//Add request body
		if(body != null){
			request.append(body);
		}
		
		return request.toString();
	}

	public static BatchResponseData buildBatchResponseData(String data) throws ApiClientException {
		BatchResponseData responseData = new BatchResponseData();
		Map<String,String> headers = new HashMap<>();
		
		String[] lines = data.split(System.getProperty("line.separator"));
	
		if(lines.length <= 0) {
			throw new ApiClientException("Invalid response body");
		}
		int i = 0;
		boolean bodyStarted = false;
		StringBuilder responseBody = new StringBuilder();
		while(i < lines.length){
			final String line =  lines[i++].trim();
			if(!bodyStarted){
				if(line.isEmpty()||line.equals("\r")){
					bodyStarted = true;
					continue;
				}
				
				if(line.startsWith("HTTP")){
					final String[] split = line.split(" ");
					responseData.setStatus(split.length >= 2? Status.fromStatusCode(Integer.parseInt(split[1].trim())): null);
					responseData.setErrorMessage(split.length >= 3 ? split[2].trim() : null);
					continue;
				}
				final int indexOfColon = line.indexOf(":");
				if(indexOfColon == -1){
					continue;
				}
				
				//Treat part before first colon as header name and part afterwards as value
				final String headerName = line.substring(0, indexOfColon).trim();
				final String headerValue = line.substring(indexOfColon + 1).trim();
				headers.put(headerName, headerValue);
			}else{
				responseBody.append(line);	
			}
		}
		
		responseData.setBody(responseBody.toString());
		responseData.setHeaders(headers);
		
		return responseData;
	}
}
