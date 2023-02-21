package com.yedam.club;

import java.sql.Date;

public class Club {
//	C_ID   NOT NULL VARCHAR2(30)  
//	C_NAME NOT NULL VARCHAR2(15)  
//	C_DATE          DATE          
//	C_MAIL          VARCHAR2(100) 
//	C_AGE           NUMBER(3)     
	
	private String cId;
	private String cName;
	private Date cDate;
	private String cMail;
	private int cAge;
	
	
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public String getcMail() {
		return cMail;
	}
	public void setcMail(String cMail) {
		this.cMail = cMail;
	}
	public int getcAge() {
		return cAge;
	}
	public void setcAge(int cAge) {
		this.cAge = cAge;
	}
	

}
