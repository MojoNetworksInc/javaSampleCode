/*
 * Name: BatchResponseData.java
 * 
 * Created by manojg on Jun 2, 2017
 * 
 * Description: POJO to hold batch response details
 */
package com.mojonetworks.api.client.dataobjects.mwm;

import java.util.Map;

import javax.ws.rs.core.Response.Status;

public class BatchResponseData {
	private Map<String,String> headers;
	private String body;
	private Status status;
	private String errorMessage;
	
	public Map<String,String> getHeaders() {
		return headers;
	}
	public void setHeaders(Map<String,String> headers) {
		this.headers = headers;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
