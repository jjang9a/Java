package com.yedam.board;

import java.sql.Date;

public class Suggest {
//	SU_ID    NOT NULL NUMBER(5)     
//	SU_DATE           DATE          
//	SU_KIND           CHAR(6)       
//	SU_TITLE NOT NULL VARCHAR2(30)  
//	SU_BODY  NOT NULL VARCHAR2(255) 
//	U_ID     NOT NULL VARCHAR2(30) 
	
//	SUC_BODY NOT NULL VARCHAR2(100) 
//	U_ID     NOT NULL VARCHAR2(30)  
//	SU_ID    NOT NULL NUMBER(5)     
	
	String uId;
	String uName;
	
	int suId;
	Date suDate;
	String suTitle;
	String suBody;

	String sucBody;

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

	public int getSuId() {
		return suId;
	}

	public void setSuId(int suId) {
		this.suId = suId;
	}

	public Date getSuDate() {
		return suDate;
	}

	public void setSuDate(Date suDate) {
		this.suDate = suDate;
	}

	public String getSuTitle() {
		return suTitle;
	}

	public void setSuTitle(String suTitle) {
		this.suTitle = suTitle;
	}

	public String getSuBody() {
		return suBody;
	}

	public void setSuBody(String suBody) {
		this.suBody = suBody;
	}

	public String getSucBody() {
		return sucBody;
	}

	public void setSucBody(String sucBody) {
		this.sucBody = sucBody;
	}
	
}
