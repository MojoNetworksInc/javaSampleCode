/*
 * Name: WebHTTPRequestInvoker.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Generic HTTP Request Invoker
 *
 *
 */
package com.mojonetworks.api.client.accessor.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.RedirectionException;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.internal.ClientInvocation;
import org.jboss.resteasy.client.jaxrs.internal.ClientInvocationBuilder;

public class WebHTTPRequestInvoker {
	
	public static Response get(ResteasyWebTarget baseTarget, String uri, Map<String, String> queryParams, String...pathParams) {
		ResteasyWebTarget newTarget =  baseTarget.getResteasyClient().target(uri);
		newTarget = putPathParams(newTarget, pathParams);
		newTarget = putQueryParams(newTarget, queryParams);
		Response response = newTarget.request().get();
		return handleResponse(response);
	}
	
	public static <T> Response post(ResteasyWebTarget baseTarget, String uri, Entity<T> entity, Map<String, String> queryParams, String...pathParams) {
		ResteasyWebTarget newTarget =  baseTarget.getResteasyClient().target(uri);
		newTarget = putPathParams(newTarget, pathParams);
		newTarget = putQueryParams(newTarget, queryParams);
		Response response = newTarget.request().post(entity);
		return handleResponse(response);
	}
	
	public static <T> Response put(ResteasyWebTarget baseTarget, String uri, Entity<T> entity, Map<String, String> queryParams, String...pathParams) {
		ResteasyWebTarget newTarget =  baseTarget.getResteasyClient().target(uri);
		newTarget = putPathParams(newTarget, pathParams);
		newTarget = putQueryParams(newTarget, queryParams);
		Response response = newTarget.request().put(entity);
		return handleResponse(response);
	}
	
	public static <T> Response delete(ResteasyWebTarget baseTarget, String uri, Entity<T> entity, Map<String, String> queryParams, String...pathParams) {
		ResteasyWebTarget newTarget =  baseTarget.getResteasyClient().target(uri);
		newTarget = putPathParams(newTarget, pathParams);
		newTarget = putQueryParams(newTarget, queryParams);
		ClientInvocation clInvocation = ((ClientInvocationBuilder)newTarget.request()).getInvocation();
//		directly creating and invoking request as ClientInvocationBuilder does not set entity in case of http DELETE method.
		clInvocation.setMethod(HttpMethod.DELETE);
		clInvocation.setEntity(entity);
		Response response = clInvocation.invoke();
		return handleResponse(response);
	}
	
	private static ResteasyWebTarget putPathParams(ResteasyWebTarget target, String...pathParams) {
		if(pathParams != null) {
			for(String param : pathParams) {
				target = target.path(param);
			}
		}
		return target;
	}
	
	private static ResteasyWebTarget putQueryParams(ResteasyWebTarget target, Map<String, String> queryParams) {
		if(queryParams != null) {
			for(Map.Entry<String, String> entry : queryParams.entrySet()) {
				String value = getEncodedString(entry.getValue());
				target = target.queryParam(entry.getKey(), value);
			}
		}
		return target;
	}
	
	private static String getEncodedString(String value) {
		try {
			if(!value.matches("\\d+")) {
				value = URLEncoder.encode(value, "ISO-8859-1");
			}
		} catch (UnsupportedEncodingException e) {

		}
		return value;
	}
	
	
	private static Response handleResponse(Response response) {
		int responseStatus = response.getStatus();
		if(responseStatus >= 300 && responseStatus < 400) {
			throw new RedirectionException(response);
		} 
		else if(responseStatus >= 400) {
			handleErrorStatus(response);
		}
		return response;
	}
	
	private static void handleErrorStatus(Response response) {
		int status = response.getStatus();
		String error = response.readEntity(String.class);
		response.close();
		
		 switch (status)
	      {
	         case 400:	
	            throw new BadRequestException(error, response);
	         case 401:
	            throw new NotAuthorizedException(error, response);
	         case 404:
	            throw new NotFoundException(error, response);
	         case 405:
	            throw new NotAllowedException(error, response);
	         case 406:
	            throw new NotAcceptableException(error, response);
	         case 415:
	            throw new NotSupportedException(error, response);
	         case 500:
	            throw new InternalServerErrorException(error, response);
	         case 503:
	            throw new ServiceUnavailableException(error, response);
	         default:
	            break;
	      }

	      if (status >= 400 && status < 500) throw new ClientErrorException(response);
	      if (status >= 500) throw new ServerErrorException(response);

	      throw new WebApplicationException(response);
	}
}
