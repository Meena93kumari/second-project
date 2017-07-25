package Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dao.NetClientGet;
import com.dao.NetClientGetI;
import com.dao.UpdateUser;
import com.dao.UpdateUserI;
import com.domain.ClientBean;
import com.domain.UsefulNames;
import com.domain.UserDomain;

public class CompareUpdate2 {
	final static Logger logger = LoggerFactory.getLogger(CompareAndUpdate.class);
	public void clientfns( )throws Exception {
	      
       
        UpdateUserI oj = new UpdateUser();
        int id;
        
        	
            try {
            	NetClientGetI net=new NetClientGet();
            	
            	int c=0;
           
                CSVRead cr = new CSVRead();
              
                List<UserDomain> newusers = cr.readCsvUserFile();
              
                for (UserDomain u : newusers) {
                	System.out.println(u.getLastName());
                	String payload="[";
                    String emailid=u.getCompanyEmail();
                    ClientBean bu=net.getOneUser(emailid);
                    UsefulNames buu=null;
                    net.mapToUseful(bu, buu);
                  /*  if(u.getFirstName()!=bu.getProfile().getF001()+bu.getProfile().getF002()){
                    	payload+="\"key\":\"F001\",\"value\":\""+u.getFirstName()+"\"}";
  ///confusion for middle name
                    	c=1;
                    }*/
                    id=bu.getUserid();
                   //System.out.println(bu.getProfile().getF003());
                 if(!(u.getLastName().equals(buu.getLastName()))){
                	
                    	//if(c==1)
                    		payload+="{";
                    	 payload+="\"key\":\"F003\",\"value\":\""+u.getLastName()+"\"}";
                    	c=1;
                    }
                 
             if(!u.getJobTitle().equals(buu.getJobTitle())){
                      	if(c==1)
                      		payload+=",{";
                      		else payload+="{";
                      	 payload+="\"key\":\"F007\",\"value\":\""+u.getJobTitle()+"\"}";
                      	c=1;
                      }
                	 
             	if(!u.getOfficeLocAdd1().equals(buu.getAddress1())){
                      	if(c==1)
                      		payload+=",{";
                      		else payload+="{";
                      	 payload+="\"key\":\"F008\",\"value\":\""+u.getOfficeLocAdd1()+"\"}";
                      	c=1;
                      }
                	if(!u.getOfficeLocAdd2().equals(buu.getAddress2())){
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                      	payload+="\"key\":\"F009\",\"value\":\""+u.getOfficeLocAdd2()+"\"}";
                      	c=1;
                      }
                	 if(!u.getOfficeCity().equals(buu.getCity())){
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                      	payload+="\"key\":\"F010\",\"value\":\""+u.getOfficeCity()+"\"}";
                      	c=1;
                      }
                 if(!u.getOfficeCountry().equals(buu.getCountry())){
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                      	payload+="\"key\":\"F011\",\"value\":\""+u.getOfficeCountry()+"\"}";
                      	c=1;
                      }
               if(!u.getDivision().equals(buu.getDivision())){
            	  
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                       payload+="\"key\":\"F020\",\"value\":\""+u.getDivision()+"\"}";
                      	c=1;
                      }
             if(!u.getDepatrment().equals(buu.getDepartment())){
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                      	 payload+="\"key\":\"F021\",\"value\":\""+u.getDepatrment()+"\"}";
                      	c=1;
                      }
  if(!u.getSubsidiaryCompany().equals(buu.getCompany())){
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                      	 payload+="\"key\":\"F022\",\"value\":\""+u.getSubsidiaryCompany()+"\"}";
                      	c=1;
                      }
              if(!u.getReportingToNAME().equals(buu.getSupervisorName())){
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                      	 payload+="\"key\":\"F033\",\"value\":\""+u.getReportingToNAME()+"\"}";
                      	c=1;
                      }
           if(!u.getReportingToEmail().equals(buu.getEmailId())){
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                      	 payload+="\"key\":\"F034\",\"value\":\""+u.getReportingToEmail()+"\"}";
                      	c=1;
                      }
                
                	  
                	  
          if(!u.getUserStatus().equals(buu.getUserStatus()+" "+"Employee")){
            	  System.out.println("gkd");
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                      	 payload+="\"key\":\"UserStatus\",\"value\":\""+u.getUserStatus()+"\"}";
                      	c=1;
                      }
                  
                   payload+="]";
                    	if(c==1)
                    	{
                    	oj.updateUser(id, payload);
                    	}
               // }
            }
            }

            catch (Exception q) {
                logger.info("exception",q);
            }
        }
}

