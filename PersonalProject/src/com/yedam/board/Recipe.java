package com.yedam.board;

import java.sql.Date;

public class Recipe {
//	R_ID    NOT NULL NUMBER(5)      
//	R_DATE           DATE           
//	R_TITLE NOT NULL VARCHAR2(60)   
//	R_BODY  NOT NULL VARCHAR2(1200) 
//	U_ID    NOT NULL VARCHAR2(30)
	
//	R_ID NOT NULL NUMBER(5)    
//	U_ID NOT NULL VARCHAR2(30) 
	
	private String uId;
	private String uName;
	
	private int rId;
	private Date rDate;
	private String rTitle;
	private String rBody;
	
	private int rLike;
	
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
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	public String getrTitle() {
		return rTitle;
	}
	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}
	public String getrBody() {
		return rBody;
	}
	public void setrBody(String rBody) {
		this.rBody = rBody;
	}
	public int getrLike() {
		return rLike;
	}
	public void setrLike(int rLike) {
		this.rLike = rLike;
	}
	
}
