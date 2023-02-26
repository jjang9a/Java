package com.yedam.board;

import java.sql.Date;

public class Anony {
//	A_ID    NOT NULL NUMBER(5)     
//	A_DATE           DATE          
//	A_TITLE NOT NULL VARCHAR2(60)  
//	A_BODY  NOT NULL VARCHAR2(900) 
//	U_ID    NOT NULL VARCHAR2(30)  
	
//	AC_DATE          DATE          
//	AC_BODY NOT NULL VARCHAR2(300) 
//	U_ID    NOT NULL VARCHAR2(30)  
//	AC_ID            NUMBER(5)     
//	A_ID    NOT NULL NUMBER(5)
	
	private String uId;
	private String uName;
	
	private int aId;
	private Date aDate;
	private String aTitle;
	private String aBody;

	private Date acDate;
	private String acBody;
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public Date getaDate() {
		return aDate;
	}
	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}
	public String getaTitle() {
		return aTitle;
	}
	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}
	public String getaBody() {
		return aBody;
	}
	public void setaBody(String aBody) {
		this.aBody = aBody;
	}
	public Date getAcDate() {
		return acDate;
	}
	public void setAcDate(Date acDate) {
		this.acDate = acDate;
	}
	public String getAcBody() {
		return acBody;
	}
	public void setAcBody(String acBody) {
		this.acBody = acBody;
	}

}
