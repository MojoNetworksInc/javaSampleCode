/*
 * Name: MLPCommunicator.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Communicator class for MLP
 *
 *
 */
package com.mojonetworks.api.client.accessor.mlp;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import com.mojonetworks.api.client.accessor.common.WebHTTPRequestInvoker;
import com.mojonetworks.api.client.accessor.common.WebServiceConstant;
import com.mojonetworks.api.client.dataobjects.mlp.MLPResponse;
import com.mojonetworks.api.client.dataobjects.mlp.MLPServices;
import com.mojonetworks.api.client.dataobjects.mlp.MLPUser;
import com.mojonetworks.api.client.dataobjects.mlp.session.MLPApiSession;

public class MLPCommunicator {
	
	public static MLPServices getAllServices(MLPApiSession apiSession) {
		String uri = apiSession.getTarget().getUri().toString() + WebServiceConstant.MLP_SERVICES;
		
		Response response = WebHTTPRequestInvoker.get(apiSession.getTarget(), uri, null);
		MLPResponse<MLPServices> services= response.readEntity(new GenericType<MLPResponse<MLPServices>>(){});
	
		response.close();
		return services.getData();
	}
	
	public static MLPServices getAllMWMServices(MLPApiSession apiSession) {
		String uri = apiSession.getTarget().getUri().toString() + WebServiceConstant.MLP_SERVICES;
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("type","amc");
		Response response = WebHTTPRequestInvoker.get(apiSession.getTarget(), uri, queryParams);
		MLPResponse<MLPServices> services= response.readEntity(new GenericType<MLPResponse<MLPServices>>(){});
		response.close();
		return services.getData();
	}
	public static MLPUser getMLPUser(MLPApiSession apiSession){
		String uri = apiSession.getTarget().getUri().toString() + WebServiceConstant.MLP_SESSION_DATA;
		
		Response response = WebHTTPRequestInvoker.get(apiSession.getTarget(), uri, null);
		MLPResponse<MLPUser> services= response.readEntity(new GenericType<MLPResponse<MLPUser>>(){});
	
		response.close();
		return services.getData();
		
	}
}
