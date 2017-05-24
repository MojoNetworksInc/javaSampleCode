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

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

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
}
