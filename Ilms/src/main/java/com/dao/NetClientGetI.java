package com.dao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.text.ParseException;

import com.domain.AllUsers;
import com.domain.ClientBean;
import com.domain.UsefulNames;

public interface NetClientGetI {
	ClientBean getOneUser(String emailid)throws ParseException;
	AllUsers getAllUsers()throws ParseException;
	String getJsonStringfromInputstream(HttpURLConnection conn)throws IOException;
	void mapToUseful(ClientBean cl,UsefulNames use);
	void setproperties();
}
