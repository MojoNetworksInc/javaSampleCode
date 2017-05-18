/*
 * Name: ApiClientException.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Generic Exception 
 *
 *
 */
package com.mojonetworks.api.client.accessor.common;

public class ApiClientException extends Exception {

	private static final long serialVersionUID = 1L;
	public ApiClientException(String errorMsg) {
		super(errorMsg);
	}

	public ApiClientException() {
		super();
	}

	public ApiClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiClientException(Throwable cause) {
		super(cause);
	}


}
