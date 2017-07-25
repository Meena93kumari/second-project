package Services;

import com.dao.CreateNewUser;
import com.dao.CreateNewUserI;

public class AddUser implements AddUserI {
  public int AddNewUser(){
	  CreateNewUserI cr=new CreateNewUser();
	  return cr.createUser();
  }
}
