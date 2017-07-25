package Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dao.NetClientGet;
import com.dao.NetClientGetI;
import com.dao.deleteUser;
import com.dao.deleteUserI;
import com.domain.ClientBean;

public class DeleteAuser implements DeleteAuserI {
	final static Logger logger = LoggerFactory.getLogger(DeleteAuser.class);
public void deleteAnUser(String emailid){
	try{
		NetClientGetI net=new NetClientGet();
		deleteUserI del=new deleteUser();
	 ClientBean bu=net.getOneUser(emailid);
	 int id=bu.getUserid();
	 del.deleteGivenUser(id);
}
	catch(Exception e){
		logger.info("exception",e);
	}
}
}