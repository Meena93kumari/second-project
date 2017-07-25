package com.dao;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.domain.*;

import ch.qos.logback.core.boolex.Matcher;

import java.util.*;
import java.util.regex.Pattern;

public class NetClientGet implements NetClientGetI{
	final static Logger logger = LoggerFactory.getLogger(NetClientGet.class);
	private String APILoginID;
	private String TransactionKey;
	private String OrgID;
	
	public static void main(String[] args) throws ParseException {
		try{
	NetClientGet net=new NetClientGet();
		ClientBean user=net.getOneUser("meena.kumari@appdirect.com");
		Profile profile=user.getProfile();
		/*AllUsers allusers=net.getAllUsers();
		ClientBean user1=(allusers.getClientbean())[0];
		Profile profile=user1.getProfile();
		System.out.println("firstname:"+profile.getF032());*/
		System.out.println(profile.getF003());
		System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S").format(profile.getF032()));
		TimeZone.setDefault(TimeZone.getTimeZone("(GMT-06.00) Central Time (US & Canada)"));
		Date newdate=profile.getF032();
        /* DateFormat outnewdate=new SimpleDateFormat("M/d/yy");
         String aa=outnewdate.format(newdate);
         newdate=outnewdate.parse(aa);*/
		String aa=newdate.toString();
         System.out.println(aa);
		}
		catch(ParseException e){
			logger.info("exception",e);
		}

	}
	public void setproperties(){
		String comSep[]={};
		try{
    	FileInputStream ff = new FileInputStream("/Users/meena.kumari/prop.text");
        InputStreamReader ir = new InputStreamReader(ff);
        BufferedReader b = new BufferedReader(ir);
        String r = b.readLine();
        while (r != null) {
        	 comSep = r.split(",");
        	 r=b.readLine();
        }
        this.APILoginID=comSep[0];
        
        this.TransactionKey=comSep[1];
        this.OrgID=comSep[2];
        }
		catch(Exception e){
			logger.info("exception",e);
		}
	}
public ClientBean getOneUser(String emailid)throws ParseException{
	Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	java.util.regex.Matcher m = p.matcher(emailid);
	ClientBean user=new ClientBean();
	 try {
		 this.setproperties();
if(!m.find()){
	logger.info("invalid email id");
	return null;
}
			URL url = new URL("https://api.inspiredlms.com/organizations/2424/users?F015="+emailid);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("APILoginID", this.APILoginID);
			conn.setRequestProperty("TransactionKey", this.TransactionKey);
			conn.setRequestProperty("OrgID", this.OrgID);
		
			
			if (conn.getResponseCode() != 200) {
				logger.info("exception:",new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode()));
			}
			
			TimeZone.setDefault(TimeZone.getTimeZone("(GMT-06.00) Central Time (US & Canada)"));
			
			String jsonString=getJsonStringfromInputstream( conn);
		String newstring=jsonString.substring(1, jsonString.length()-1);
			 user=new ClientBean();
			System.out.println(jsonString);
			ObjectMapper mapper = new ObjectMapper();
			user = mapper.readValue(newstring, ClientBean.class);
			
			conn.disconnect();

		  } catch (MalformedURLException e) {

			  logger.info("exception:",e);

		  } catch (IOException e) {

			  logger.info("exception:",e);

		  }
		  return  user;
	
}

public AllUsers getAllUsers()throws ParseException{
	AllUsers alu=null;
	try {
        this.setproperties();
		URL url = new URL("https://api.inspiredlms.com/organizations/2424/users");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("APILoginID", this.APILoginID);
		conn.setRequestProperty("TransactionKey", this.TransactionKey);
		conn.setRequestProperty("OrgID", this.OrgID);
	
		
		if (conn.getResponseCode() != 200) {
			logger.info("exception:",new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode()));
		}
		
		TimeZone.setDefault(TimeZone.getTimeZone("(GMT-06.00) Central Time (US & Canada)"));
		
		String jsonString=getJsonStringfromInputstream( conn);
		//System.out.println(jsonString);
		
	    ObjectMapper mapper = new ObjectMapper();
	    alu=new AllUsers();
		alu.setClientbean(mapper.readValue(jsonString, ClientBean[].class));
		
		
		conn.disconnect();

	  } catch (MalformedURLException e) {

		  logger.info("exception:",e);

	  } catch (IOException e) {

		  logger.info("exception:",e);

	  }
	return alu;

	
}





public String getJsonStringfromInputstream(HttpURLConnection conn)throws IOException{
    String json="";
try{
	BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

    String line=br.readLine();
    while(line!=null){
        json=json+line;
        line=br.readLine();
    }
    br.close();
}
catch(IOException e){
	logger.info("exception:",e);
}
return json;
}
public void mapToUseful(ClientBean cl,UsefulNames use){
	Profile pro=cl.getProfile();
	use.setAddress1(pro.getF008());
	use.setAddress2(pro.getF009());
	use.setCity(pro.getF010());
	use.setCompany(pro.getF022());
	use.setCountry(pro.getF011());
	use.setCustomField1(pro.getF024());
	use.setCustomField2(pro.getF025());
	use.setCustomField3(pro.getF026());
	use.setDepartment(pro.getF021());
	use.setDepartment_Id(pro.getF021_ID());
	use.setDivision(pro.getF020());
	use.setDivision_Id(pro.getF020_ID());
	use.setEmailId(pro.getF015());
	use.setEmployeeId(pro.getF004());
	use.setFax(pro.getF018());
	use.setFirstName(pro.getF001());
	use.setHiringDate(pro.getF005());
	use.setID(cl.getUserid());
	use.setJobTitle(pro.getF007());
	use.setLanguage(pro.getF006());
	use.setLastName(pro.getF003());
	use.setMiddleName(pro.getF002());
	use.setPassword(pro.getF016());
	use.setPhone(pro.getF017());
	use.setPostalCode(pro.getF014());
	use.setProvince(pro.getF013());
	use.setRegion(pro.getF019());
	use.setRegion_Id(pro.getF019_ID());
	use.setRegistrationDate(pro.getF032());
	use.setRegistrationType(pro.getF031());
	use.setState(pro.getF012());
	use.setSupervisorEmail(pro.getF034());
	use.setSupervisorName(pro.getF033());
	use.setUserStatus(cl.getUserStatus());
	
	
}

}