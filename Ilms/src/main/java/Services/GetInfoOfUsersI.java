package Services;

import com.domain.ClientBean;

public interface GetInfoOfUsersI {
	 void infoParicularUser(String emailid);
	 void allUsersinfo();
	String datatobewritten(ClientBean u);
}
