package com.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class ClientBean {
private int ID;
private Profile Profile;
private  String UserStatus;
@JsonProperty("ID")
public int getUserid() {
	return ID;
}
@JsonProperty("Profile")
public Profile getProfile() {
	return Profile;
}
public void setUserid(int userid) {
	this.ID = userid;
}
public void setProfile(Profile profile) {
	this.Profile = profile;
}
@JsonProperty("UserStatus")
public String getUserStatus() {
	return UserStatus;
}
public void setUserStatus(String userStatus) {
	UserStatus = userStatus;
}

}
