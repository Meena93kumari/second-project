package clientUser;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dao.*;
import com.domain.*;

import Services.AddUser;
import Services.AddUserI;
import Services.CompareAndUpdate;
import Services.CompareAndUpdateI;
import Services.DeleteAuser;
import Services.DeleteAuserI;
import Services.GetInfoOfUsers;
import Services.GetInfoOfUsersI;
public class MainClass {
	
	final Logger logger = LoggerFactory.getLogger(MainClass.class);
	public static void main(String[] args) throws Exception {
		CompareAndUpdateI cmp=new CompareAndUpdate();
		AddUserI add=new AddUser();
		DeleteAuserI del=new DeleteAuser();
		GetInfoOfUsersI get1=new GetInfoOfUsers();
		
		  Scanner sc=new Scanner(System.in);
	        int choice =sc.nextInt();
	        if(choice==1){
		cmp.clientfns( );}
		if(choice==2)
		{
			int id=add.AddNewUser();
		}
		if(choice==3){
			String email_id=sc.nextLine();
			del.deleteAnUser(email_id);
		}
		if(choice==4){
			int subchoice=sc.nextInt();
			if(subchoice==1){
				String email_id=sc.nextLine();
				get1.infoParicularUser("meena.kumari@appdirect.com");
			}
			else if(choice==2){
				get1.allUsersinfo();
			}
		}
	}                	
}
