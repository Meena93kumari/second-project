package Services;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dao.NetClientGet;
import com.dao.NetClientGetI;
import com.domain.AllUsers;
import com.domain.ClientBean;
import com.domain.Profile;

public class GetInfoOfUsers implements GetInfoOfUsersI {
	final static Logger logger = LoggerFactory.getLogger(GetInfoOfUsers.class);
public void infoParicularUser(String emailid){
	ClientBean cb=null;
	try{
		NetClientGetI net=new NetClientGet();
	cb= net.getOneUser(emailid);
	String data=datatobewritten(cb);
	
	System.out.println(cb.getProfile().getF001());
	  FileWriter fstream = new FileWriter("src/main/java/info1.csv", true);
      BufferedWriter out = new BufferedWriter(fstream);
      out.newLine();
      out.write(data);
      out.newLine();
      out.close();
	
}
	catch(Exception e){
		logger.info("exception",e);
	}
	
}
public void allUsersinfo(){
	try{
		NetClientGetI net=new NetClientGet();
	AllUsers alu=net.getAllUsers();
	ClientBean[] clu=alu.getClientbean();
	FileWriter fstream = new FileWriter("src/main/java/info2.csv", true);
    BufferedWriter out = new BufferedWriter(fstream);
    out.newLine();
	for(ClientBean u:clu){
		
		String data=datatobewritten(u);
		out.write("\n");
	      out.write(data);
	      
	      out.newLine();
	     	
	}
	out.close();
	
	
	}
	catch(Exception e){
		logger.info("exception",e);
	}
}
public String datatobewritten(ClientBean u){

	String data="";
	Profile profile=u.getProfile();
	String full_name=profile.getF001()+profile.getF002()+profile.getF003();
	
	data+=profile.getF001()+profile.getF002();
	data+=","+profile.getF003()+","+full_name+","+profile.getF015()+","+profile.getF005()+","+profile.getF004()+","+profile.getF021()+","+profile.getF007()+","+profile.getF020()+","+profile.getF033();
	data+=","+profile.getF034()+","+profile.getF010()+","+profile.getF011()+","+profile.getF008();
	data+=","+profile.getF009()+","+u.getUserStatus()+","+profile.getF022();
	return data;
}
}