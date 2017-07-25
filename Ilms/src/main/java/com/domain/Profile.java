package com.domain;
import java.util.*;

import org.codehaus.jackson.annotate.JsonProperty;
public class Profile {
//String FirstName;
private String F001;
//String MiddleName;
private String F002;
//String LastName;
private String F003;
//String EmployeeId;
private String F004;
//Date HiringDate;
private Date F005;
//String Language;
private String F006;
//String JobTitle;
private String F007;
//String Address1;
private String F008;
//String Address2;
private String F009;
//String City;
private String F010;
//String Country;
private String F011;
//String State;//US OR CANADA
private String F012;
//String Province;//non US
private String F013;
//String PostalCode;
private String F014;
//String EmailId;
private String F015;
//String Password;
private String F016;
//String Phone;
private String F017;
//String Fax;
private String F018;
//String Region;
private String F019;
//int Region_Id;
private int F019_ID;
//String Division;
private String F020;
//int Division_Id;
private int F020_ID;
//String Department;
private String F021;
//int Department_Id;
private int F021_ID;
//String Company;
private String F022;
//String TimeZone;
private String F023;
//String CustomField1;
private String F024;
//String CustomField2;
private String F025;
//String CustomField3;
private String F026;
//String CustomField4;
private String F027;
//String RegistrationType;
private String F031;
//Date RegistrationDate;
private Date F032;
//String SupervisorName;
private String F033;
//String SupervisorEmail;
private String F034;

@JsonProperty("F001")
public String getF001() {
	return this.F001;
}
@JsonProperty("F002")
public String getF002() {
	return F002;
}
@JsonProperty("F003")
public String getF003() {
	return F003;
}
@JsonProperty("F004")
public String getF004() {
	return F004;
}
@JsonProperty("F005")
public Date getF005() {
	return F005;
}
@JsonProperty("F006")
public String getF006() {
	return F006;
}
@JsonProperty("F007")
public String getF007() {
	return F007;
}
@JsonProperty("F008")
public String getF008() {
	return F008;
}
@JsonProperty("F009")
public String getF009() {
	return F009;
}
@JsonProperty("F010")
public String getF010() {
	return F010;
}
@JsonProperty("F011")
public String getF011() {
	return F011;
}
@JsonProperty("F012")
public String getF012() {
	return F012;
}
@JsonProperty("F013")
public String getF013() {
	return F013;
}
@JsonProperty("F014")
public String getF014() {
	return F014;
}
@JsonProperty("F015")
public String getF015() {
	return F015;
}
@JsonProperty("F016")
public String getF016() {
	return F016;
}
@JsonProperty("F017")
public String getF017() {
	return F017;
}
@JsonProperty("F018")
public String getF018() {
	return F018;
}
@JsonProperty("F019")
public String getF019() {
	return F019;
}
@JsonProperty("F019_ID")
public int getF019_ID() {
	return F019_ID;
}
@JsonProperty("F020")
public String getF020() {
	return F020;
}
@JsonProperty("F020_ID")
public int getF020_ID() {
	return F020_ID;
}
@JsonProperty("F021")
public String getF021() {
	return F021;
}
@JsonProperty("F021_ID")
public int getF021_ID() {
	return F021_ID;
}
@JsonProperty("F022")
public String getF022() {
	return F022;
}
@JsonProperty("F023")
public String getF023() {
	return F023;
}
@JsonProperty("F024")
public String getF024() {
	return F024;
}
@JsonProperty("F025")
public String getF025() {
	return F025;
}
@JsonProperty("F026")
public String getF026() {
	return F026;
}
@JsonProperty("F027")
public String getF027() {
	return F027;
}
@JsonProperty("F031")
public String getF031() {
	return F031;
}
@JsonProperty("F032")
public Date getF032() {
	return F032;
}
@JsonProperty("F033")
public String getF033() {
	return F033;
}
@JsonProperty("F034")
public String getF034() {
	return F034;
}
public void setF001(String f001) {
	F001 = f001;
}
public void setF002(String f002) {
	F002 = f002;
}
public void setF003(String f003) {
	F003 = f003;
}
public void setF004(String f004) {
	F004 = f004;
}
public void setF005(Date f005) {
	F005 = f005;
}
public void setF006(String f006) {
	F006 = f006;
}
public void setF007(String f007) {
	F007 = f007;
}
public void setF008(String f008) {
	F008 = f008;
}
public void setF009(String f009) {
	F009 = f009;
}
public void setF010(String f010) {
	F010 = f010;
}
public void setF011(String f011) {
	F011 = f011;
}
public void setF012(String f012) {
	F012 = f012;
}
public void setF013(String f013) {
	F013 = f013;
}
public void setF014(String f014) {
	F014 = f014;
}
public void setF015(String f015) {
	F015 = f015;
}
public void setF016(String f016) {
	F016 = f016;
}
public void setF017(String f017) {
	F017 = f017;
}
public void setF018(String f018) {
	F018 = f018;
}
public void setF019(String f019) {
	F019 = f019;
}
public void setF019_ID(int f019_ID) {
	F019_ID = f019_ID;
}
public void setF020(String f020) {
	F020 = f020;
}
public void setF020_ID(int f020_ID) {
	F020_ID = f020_ID;
}
public void setF021(String f021) {
	F021 = f021;
}
public void setF021_ID(int f021_ID) {
	F021_ID = f021_ID;
}
public void setF022(String f022) {
	F022 = f022;
}
public void setF023(String f023) {
	F023 = f023;
}
public void setF024(String f024) {
	F024 = f024;
}
public void setF025(String f025) {
	F025 = f025;
}
public void setF026(String f026) {
	F026 = f026;
}
public void setF027(String f027) {
	F027 = f027;
}
public void setF031(String f031) {
	F031 = f031;
}
public void setF032(Date f032) {
	F032 = f032;
}
public void setF033(String f033) {
	F033 = f033;
}
public void setF034(String f034) {
	F034 = f034;
}

}
