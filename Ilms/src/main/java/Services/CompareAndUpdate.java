package Services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dao.NetClientGet;
import com.dao.NetClientGetI;
import com.dao.UpdateUser;
import com.dao.UpdateUserI;
import com.domain.ClientBean;
import com.domain.UserDomain;


public class CompareAndUpdate implements CompareAndUpdateI{
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
                    Date newdate=bu.getProfile().getF032();
                    Date newdate1=newdate;
                    String cc=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S").format(newdate);
                    DateFormat outnewdate=new SimpleDateFormat("MM/dd/yy");
                    String aa=outnewdate.format(newdate1);
                    String bb=outnewdate.format(u.getStartDate());
                  /*  if(u.getFirstName()!=bu.getProfile().getF001()+bu.getProfile().getF002()){
                    	payload+="\"key\":\"F001\",\"value\":\""+u.getFirstName()+"\"}";
  ///confusion for middle name
                    	c=1;
                    }*/
                    id=bu.getUserid();
                   //System.out.println(bu.getProfile().getF003());
                 if(!(u.getLastName().equals(bu.getProfile().getF003()))){
                	
                    	//if(c==1)
                    		payload+="{";
                    	 payload+="\"key\":\"F003\",\"value\":\""+u.getLastName()+"\"}";
                    	c=1;
                    }
                 
             if(!u.getJobTitle().equals(bu.getProfile().getF007())){
                      	if(c==1)
                      		payload+=",{";
                      		else payload+="{";
                      	 payload+="\"key\":\"F007\",\"value\":\""+u.getJobTitle()+"\"}";
                      	c=1;
                      }
             
             if(!bb.equals(aa)){
            	 String newdd="20"+bb.substring(6, 7)+"-"+bb.substring(0, 1)+"-"+bb.substring(3, 4);
               	if(c==1)
               		payload+=",{";
               		else payload+="{";
               	 payload+="\"key\":\"F032\",\"value\":\""+newdd+"\"}";
               	c=1;
               }
             
             	if(!u.getOfficeLocAdd1().equals(bu.getProfile().getF008())){
                      	if(c==1)
                      		payload+=",{";
                      		else payload+="{";
                      	 payload+="\"key\":\"F008\",\"value\":\""+u.getOfficeLocAdd1()+"\"}";
                      	c=1;
                      }
                	if(!u.getOfficeLocAdd2().equals(bu.getProfile().getF009())){
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                      	payload+="\"key\":\"F009\",\"value\":\""+u.getOfficeLocAdd2()+"\"}";
                      	c=1;
                      }
                	 if(!u.getOfficeCity().equals(bu.getProfile().getF010())){
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                      	payload+="\"key\":\"F010\",\"value\":\""+u.getOfficeCity()+"\"}";
                      	c=1;
                      }
                 if(!u.getOfficeCountry().equals(bu.getProfile().getF011())){
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                      	payload+="\"key\":\"F011\",\"value\":\""+u.getOfficeCountry()+"\"}";
                      	c=1;
                      }
               if(!u.getDivision().equals(bu.getProfile().getF020())){
            	  
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                       payload+="\"key\":\"F020\",\"value\":\""+u.getDivision()+"\"}";
                      	c=1;
                      }
             if(!u.getDepatrment().equals(bu.getProfile().getF021())){
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                      	 payload+="\"key\":\"F021\",\"value\":\""+u.getDepatrment()+"\"}";
                      	c=1;
                      }
  if(!u.getSubsidiaryCompany().equals(bu.getProfile().getF022())){
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                      	 payload+="\"key\":\"F022\",\"value\":\""+u.getSubsidiaryCompany()+"\"}";
                      	c=1;
                      }
              if(!u.getReportingToNAME().equals(bu.getProfile().getF033())){
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                      	 payload+="\"key\":\"F033\",\"value\":\""+u.getReportingToNAME()+"\"}";
                      	c=1;
                      }
           if(!u.getReportingToEmail().equals(bu.getProfile().getF034())){
                      	if(c==1)
                      		payload+=",{";
                      	else payload+="{";
                      	 payload+="\"key\":\"F034\",\"value\":\""+u.getReportingToEmail()+"\"}";
                      	c=1;
                      }
                
                	  
                	  
          if(!u.getUserStatus().equals(bu.getUserStatus()+" "+"Employee")){
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
