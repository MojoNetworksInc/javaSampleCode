/*
 * Name: ApiSessionProvider.java
 *
 * Created by sabhtarsha on 17-May-2017
 *
 * Description: Session Provider
 *
 */

package com.mojonetworks.api.client.accessor.common;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.mojonetworks.api.client.dataobjects.auth.AuthenticationInfo;
import com.mojonetworks.api.client.dataobjects.auth.KeyCredentialsAuth;
import com.mojonetworks.api.client.dataobjects.mlp.MLPLoginData;
import com.mojonetworks.api.client.dataobjects.mlp.MLPResponse;
import com.mojonetworks.api.client.dataobjects.mlp.session.MLPApiSession;
import com.mojonetworks.api.client.dataobjects.mwm.MWMUser;
import com.mojonetworks.api.client.dataobjects.mwm.session.MWMApiSession;
import com.mojonetworks.api.client.dataobjects.session.ApiSession.SessionState;

/**
 * This class provides the session objects for various Mojo Services
 * @author sabhtarsha
 *
 */
public class ApiSessionProvider {
	private static HostnameVerifier hostNameVerifier=null;
	private static TrustManager trustManager=null;

	public static MWMApiSession getMWMAPISession(String mwmHost, AuthenticationInfo authInfo, String clientIdPrefix, long timeout) throws ApiClientException {
		return connectMWM(mwmHost, authInfo, clientIdPrefix, timeout);
	}
	
	public static MLPApiSession getMLPApiSession(String hostName, KeyCredentialsAuth authInfo) throws ApiClientException{
		return connectMLP(hostName, authInfo);
	}

	private static MLPApiSession connectMLP(String hostName, KeyCredentialsAuth authInfo) throws ApiClientException{
		ResteasyClient client = buildClient();
		ResteasyWebTarget target = client.target("https://"+hostName + WebServiceConstant.MLP_BASE_URL);
		return authenticateToMLP(hostName, target, authInfo);
	}
	
	private static MWMApiSession connectMWM(String hostName, AuthenticationInfo authInfo, String cliendIdentifierPrefix, long timeout) throws ApiClientException {
		ResteasyClient client = buildClient();
		ResteasyWebTarget target = client.target("https://"+hostName + WebServiceConstant.MWM_BASE_URL);
		return authenticateToMWM(hostName,target,authInfo,cliendIdentifierPrefix,timeout);
	}
	
	private static MLPApiSession authenticateToMLP(String hostName, ResteasyWebTarget target, KeyCredentialsAuth authInfo) throws ApiClientException{
		Response loginResponse= null;
		try{
			Map<String, String> queryParams = new HashMap<>();
			queryParams.put(WebServiceConstant.MLP_KEY_ID, authInfo.getKeyId());
			queryParams.put(WebServiceConstant.MLP_KEY_VALUE, authInfo.getKeyValue());
			
			String uri= target.getUri().toString() + WebServiceConstant.MLP_KEY_LOGIN;
			loginResponse = WebHTTPRequestInvoker.get(target, uri, queryParams, (String[])null);
			
			
		}catch (Exception e){
			throw new ApiClientException("Session not established", e);	
		}
		
		if(loginResponse!=null && loginResponse.getStatus()==Status.OK.getStatusCode()){
			MultivaluedMap<String, Object> map = loginResponse.getHeaders();
			List<Object> oList =  map.get("Set-Cookie");
			String jsessionid = ((oList.get(0).toString().split(";"))[0]).split("=")[1];
			MLPResponse<MLPLoginData> mlpLoginResponse= loginResponse.readEntity(new GenericType<MLPResponse<MLPLoginData>>(){});
			loginResponse.close();
			//set the cookie to the target object
			target.request().cookie(new Cookie(WebServiceConstant.JSESSION_ID, jsessionid));
			
			return new MLPApiSession(authInfo, hostName, target, jsessionid, mlpLoginResponse);
		} else if(loginResponse!=null && loginResponse.getStatus()==Status.UNAUTHORIZED.getStatusCode()){
			loginResponse.close();
			throw new ApiClientException("Unauthorized!! -" +loginResponse.getStatusInfo());
		} else if (loginResponse!=null){
			loginResponse.close();
			throw new ApiClientException("Failed to login -" +loginResponse.getStatusInfo());
		}else {
			throw new ApiClientException("Failed to login!!");
		}
	}
	
	private static MWMApiSession authenticateToMWM(String hostName,ResteasyWebTarget target, AuthenticationInfo authInfo, String clientIdPrefix, long timeout) 
			throws ApiClientException {
		
		Response loginResponse = null;
		try {
			Map<String, String> queryParams = new HashMap<>();
			queryParams.put(WebServiceConstant.MWM_INSTANCE_ID_REQUEST_ATTR, WebApiUtility.convertDOToJSON(0));//Hard coded to 0, this is required 
			
			String uri = target.getUri().toString() + WebServiceConstant.MWM_LOGIN;
			loginResponse = WebHTTPRequestInvoker.post(target, uri, Entity.json(authInfo), queryParams, clientIdPrefix, ""+timeout);
		
		} catch (Exception e) {
			throw new ApiClientException("Session not established", e);
		}

		if(loginResponse!=null && loginResponse.getStatus()==Status.OK.getStatusCode()){
			MultivaluedMap<String, Object> map = loginResponse.getHeaders();
			List<Object> oList =  map.get("Set-Cookie");
			String jsessionid = ((oList.get(0).toString().split(";"))[0]).split("=")[1];
			
			MWMUser user= loginResponse.readEntity(MWMUser.class);
			
			loginResponse.close();
			
			//set the cookie to the target object
			target.request().cookie(new Cookie(WebServiceConstant.JSESSION_ID, jsessionid));
			
			return new MWMApiSession(SessionState.SESSION_ESTABLISHED,authInfo, user, clientIdPrefix, hostName, target, timeout, jsessionid);
		} else if(loginResponse!=null && loginResponse.getStatus()==Status.UNAUTHORIZED.getStatusCode()){
			loginResponse.close();
			throw new ApiClientException("Unauthorized!! -" +loginResponse.getStatusInfo());
		} else if (loginResponse!=null){
			loginResponse.close();
			throw new ApiClientException("Failed to login -" +loginResponse.getStatusInfo());
		}else {
			//loginResponse is null
			throw new ApiClientException("Failed to login!!");
		}
	}
	
	
	
	public static void downloadURLResource(MWMApiSession session, String url, OutputStream outputStream) throws ApiClientException{
		InputStream inputStream = null;
		try {
			SSLContext sc = getSSLContext(); 
			URL fileUrl = new URL(url);
			HttpsURLConnection conn = (HttpsURLConnection)fileUrl.openConnection();
			conn.setSSLSocketFactory(sc.getSocketFactory());
			conn.setHostnameVerifier(getHostNameVerifier());
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestProperty("Cookie", WebServiceConstant.JSESSION_ID+"="+session.getJsessionid());
			inputStream = conn.getInputStream();
			int readBytes;
	
			byte[] src_bytes=new byte[1024];
			while((readBytes=inputStream.read(src_bytes,0,1024))!=-1){
				outputStream.write(src_bytes,0,readBytes);
			}
	
		} catch (Exception e) {
			throw new ApiClientException("Error downloading the file from URL:"+url,e);
		} finally{
			WebApiUtility.closeStream(outputStream);
			WebApiUtility.closeStream(inputStream);
		}
	}
	
	
	private static ResteasyClient buildClient() throws ApiClientException {
		SSLContext ctx = getSSLContext();
		ResteasyClientBuilder resteasyClientBuilder = new ResteasyClientBuilder();
		resteasyClientBuilder.connectionPoolSize(10);
		resteasyClientBuilder.sslContext(ctx);
		resteasyClientBuilder.hostnameVerifier(getHostNameVerifier());
		ResteasyClient client = resteasyClientBuilder.build();
		return client;
	}

	private static SSLContext getSSLContext() throws ApiClientException {
		try{
			System.setProperty(WebServiceConstant.HTTPS_PROTOCOLS, WebServiceConstant.PROTOCOL_SSL);
			TrustManager trustManager[] = {getTrustManager()};
			SSLContext ctx = SSLContext.getInstance(WebServiceConstant.PROTOCOL_SSL);
			ctx.init(null,trustManager, null );
			return ctx;
		} catch (KeyManagementException | NoSuchAlgorithmException e) {
			throw new ApiClientException("Error creating the SSL Context", e);
		}
	}
	
	synchronized private static HostnameVerifier getHostNameVerifier() {
		if(hostNameVerifier==null){
			hostNameVerifier = new PseudoNameVerifier();
		}
		return hostNameVerifier;
	}
 	synchronized private static TrustManager getTrustManager() {
		if(trustManager==null){
			trustManager = new CompleteTrustManager();
		}
		return trustManager;
	}

	
	/*
	 * This is a allow any server certificate trust manager, We suggest you modify this 
	 * appropriately to trust only the Mojo Service certificates
	 */
	
	public  static class CompleteTrustManager implements X509TrustManager {
		public CompleteTrustManager() {
			// create/load keystore
		}
		public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws CertificateException {
		}
		public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws CertificateException {
		}
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}
	
	private static class PseudoNameVerifier implements HostnameVerifier {
		public boolean verify(String arg0, SSLSession arg1) {
			return true;
		}
	}
}
