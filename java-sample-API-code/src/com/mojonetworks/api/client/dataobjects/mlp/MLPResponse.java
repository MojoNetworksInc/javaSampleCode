/*
 * Name: MLPResponse.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Response object from MLP
 *
 *
 */
package com.mojonetworks.api.client.dataobjects.mlp;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MLPResponse<T extends MLPData> {
	public MLPResponse() {
		super();
	}
	
	private boolean success;
	private String message;
	private T data;
	
	public boolean isSuccess() {
		return success;
	}
	public String getMessage() {
		return message;
	}
	@Override
	public String toString() {
		return "MLPResponse [success=" + success + ", message=" + message + ", data=" + data + "]";
	}
	public T getData() {
		return data;
	}
	
}
