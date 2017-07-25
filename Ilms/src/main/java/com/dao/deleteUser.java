package com.dao;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class deleteUser implements deleteUserI {
	final static Logger logger = LoggerFactory.getLogger(deleteUser.class);
	
	public static void main(String args[]){
		//deleteGivenUser(2801957);
		deleteUser del=new deleteUser();
		del.deleteGivenUser(2802066);
	}
	public void deleteGivenUser(int ID)  {
		 try {

				URL url = new URL("https://api.inspiredlms.com/organizations/2424/users?ID="+ID);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("DELETE");	
              conn.setDoInput(true);
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("APILoginID", "1T0vVqIwg0LO/R9Rnfzd6A==");
				conn.setRequestProperty("TransactionKey", "aTxgwb8LW2SLVxbOWAFfeQ==");
				conn.setRequestProperty("OrgID", "2424");
				
		            
				if (conn.getResponseCode() != 200) {
				logger.info("exception:",new RuntimeException("Failed : HTTP error code : "
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
