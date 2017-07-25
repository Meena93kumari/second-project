package com.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.domain.AllUsers;
import com.domain.ClientBean;
import com.domain.Profile;

public class CreateNewUser implements CreateNewUserI{
	final static Logger logger = LoggerFactory.getLogger(CreateNewUser.class);
	public static int createUserProfile(){
        NetClientGet nt = new NetClientGet();
        String payload = "";
        
        try{
        	FileInputStream ff = new FileInputStream("/Users/meena.kumari/Downloads/create.json");
        
        InputStreamReader ir = new InputStreamReader(ff);
        BufferedReader b = new BufferedReader(ir);
        payload = b.readLine();
        }catch(Exception e){
        	logger.info("exception",e);
        }
        
        int responseCode = -1;
        
       System.out.println(payload);
        String fqdn = "https://api.inspiredlms.com/organizations/2424/users";
        try{
          URL url = new URL(fqdn);
          HttpURLConnection conn = (HttpURLConnection) url.openConnection();
          conn.setRequestMethod("POST");
          conn.setDoOutput(true);
          conn.setRequestProperty("Content-Type", "application/json");
          conn.setRequestProperty("Accept", "application/json");
          conn.setRequestProperty("APILoginID", "1T0vVqIwg0LO/R9Rnfzd6A==");
          conn.setRequestProperty("TransactionKey", "aTxgwb8LW2SLVxbOWAFfeQ==");
          conn.setRequestProperty("OrgID", "2424");
        
          OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
          writer.write(payload);
          writer.close();
            
          if (conn.getResponseCode() != 201) {
            logger.info("exception:",new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode() + " "+ conn.getErrorStream()));
          }
          
          responseCode = conn.getResponseCode();
          
          BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
          String output;
          System.out.println("Output from Server .... \n");
          output = br.readLine();
          System.out.println(output);
          conn.disconnect();
        }catch (MalformedURLException e) {
        	logger.info("exception:",e);
          }catch (IOException e) {
        	  logger.info("exception:",e);
          }
        
          return responseCode;
    }
	
	public int createUser() {
int id=0;
		  try {
			  NetClientGetI net=new NetClientGet();
			URL url = new URL("https://api.inspiredlms.com/organizations/2424/users");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			//conn.setDoInput(true);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("APILoginID", "1T0vVqIwg0LO/R9Rnfzd6A==");
			conn.setRequestProperty("TransactionKey", "aTxgwb8LW2SLVxbOWAFfeQ==");
			conn.setRequestProperty("OrgID", "2424");
			
			FileInputStream ff = new FileInputStream("/Users/meena.kumari/Downloads/create.json");
            InputStreamReader ir = new InputStreamReader(ff);
            BufferedReader b = new BufferedReader(ir);
            String payload = b.readLine();
		
            System.out.println(payload);
		OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
        osw.write(payload);
        //osw.flush();
        osw.close();
        
			
			if (conn.getResponseCode() != 200) {
				logger.info("exception:",new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode()));
			}

			
			
			 
		/*	String jsonString=net.getJsonStringfromInputstream( conn);
			ClientBean user=new ClientBean();
			System.out.println(jsonString);
			ObjectMapper mapper = new ObjectMapper();
			user = mapper.readValue(jsonString, ClientBean.class);
			System.out.println("UserStatus:"+user.getUserStatus());
			id=user.getUserid();
			System.out.println("id:"+id);*/
			
			conn.disconnect();

		  } catch (MalformedURLException e) {

			  logger.info("exception:",e);

		  } catch (IOException e) {

			  logger.info("exception:",e);

		  }
		  
return id;
		}
		

	public static void main(String[] args) {
		CreateNewUser cr=new CreateNewUser();
		int r=cr.createUser();
		
	}
	

}
