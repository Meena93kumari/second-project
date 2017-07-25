package com.dao;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.*;
import org.omg.CORBA.portable.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UpdateUser implements UpdateUserI {
	final static Logger logger = LoggerFactory.getLogger(UpdateUser.class);
	public static void main(String args[]){
		UpdateUser up=new UpdateUser();
		int id=2566738;
		String payload = "[{\"Key\":\"F003\",\"Value\":\"xyz\"}]";
		up.updateUser(id,payload);
	}
	public void updateUser(int id,String payload)  {
		 try {

				URL url = new URL("https://api.inspiredlms.com/organizations/2424/users?ID="+id);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("PUT");
				
				conn.setDoOutput(true);
//				conn.setDoInput(true);
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("APILoginID", "1T0vVqIwg0LO/R9Rnfzd6A==");
				conn.setRequestProperty("TransactionKey", "aTxgwb8LW2SLVxbOWAFfeQ==");
				conn.setRequestProperty("OrgID", "2424");
				

		           OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
		            osw.write(payload);
		            osw.flush();
		            osw.close();
		            
				if (conn.getResponseCode() != 204) {
					logger.info("exception:", new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode()));
				}
				
					
								
			    conn.disconnect();
		 }catch (MalformedURLException e) {

				logger.info("exception:",e);

			  } catch (IOException e) {

				  logger.info("exception:",e);

			  }
		
		 
		 
			
}
	}