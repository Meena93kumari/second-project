package Services;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dao.UpdateUser;
import com.domain.UserDomain;

import java.util.*;
public class CSVRead implements CSVReadI{
	final static Logger logger = LoggerFactory.getLogger(CSVRead.class);
	public static void main(String[] args) throws ParseException, IOException {
		try{
			CSVRead csv=new CSVRead();
			List<UserDomain> newusers = csv.readCsvUserFile();
       for (UserDomain u : newusers) {
        	String ss=u.getFirstName();
            System.out.println(ss);
        }
		}
		catch(Exception e){
		logger.info("exception",e);
			
		}
	}
	public List<UserDomain> readCsvUserFile() throws IOException, ParseException,NullPointerException {
       // UserDomain Userslist = new UserDomain();
		 List<UserDomain> Userslist = new ArrayList<UserDomain>();
		//UserDomain u = new UserDomain();
        try {
            FileInputStream ff = new FileInputStream("src/main/java/userCSV.csv");
            InputStreamReader ir = new InputStreamReader(ff);
            BufferedReader b = new BufferedReader(ir);
            String r = b.readLine();
            while(r!=null) {
                String[] comSeperated = r.split(",");
               // int id = Integer.parseInt(comSeperated[0]);
                String firstname = comSeperated[0];
                System.out.println(firstname);
                String lastname = comSeperated[1];
               System.out.println(lastname);
                String fullname = comSeperated[2];
                System.out.println(comSeperated[2]);
                String email = comSeperated[3];
                System.out.println(email);
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                Date startdate = df.parse(comSeperated[4]);
                 String employeetype=comSeperated[5];
                String depatrment=comSeperated[6];
                String jobtitle=comSeperated[7];
                String division=comSeperated[8];
                 String reportingtname=comSeperated[9];
                 String reportingtoemail=comSeperated[10];
                String officecity=comSeperated[11];
                 String officecountry=comSeperated[12];
                 String officeLocAdd1=comSeperated[13];
                 String officeLocAdd2=comSeperated[14];
                 String userStatus=comSeperated[15];
              String subsidiaryCompany=comSeperated[16];

                UserDomain u = new UserDomain();
                u.setFirstName(firstname);
                u.setLastName(lastname);
                u.setFullName(fullname);
                u.setCompanyEmail(email);
                u.setStartDate(startdate);
                u.setEmployeeType(employeetype);
                u.setDepatrment(depatrment);
                u.setJobTitle(jobtitle);
                u.setDivision(division);
                u.setReportingToNAME(reportingtname);
                u.setReportingToEmail(reportingtoemail);
                u.setOfficeCity(officecity);
                u.setOfficeCountry(officecountry);
                u.setOfficeLocAdd1(officeLocAdd1);
                u.setOfficeLocAdd2(officeLocAdd2);
               u.setUserStatus(userStatus);
               u.setSubsidiaryCompany(subsidiaryCompany);
               Userslist.add(u);
                r = b.readLine();

            }
            b.close();
        } catch (NullPointerException e) {
        	logger.info("exception",e);
           
        }

        return Userslist;
    }
}
