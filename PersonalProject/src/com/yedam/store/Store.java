package com.yedam.store;

import java.sql.Date;

public class Store {
//	S_ID       NOT NULL NUMBER(5)     
//	S_NAME     NOT NULL VARCHAR2(50)  
//	S_KIND     NOT NULL VARCHAR2(20)  
//	S_MENU              VARCHAR2(100) 
//	S_MONEY             VARCHAR2(50)  
//	S_LOCATION NOT NULL VARCHAR2(15)  
//	S_POINT    NOT NULL NUMBER(4)     
//	U_ID       NOT NULL VARCHAR2(30)  
//	u_name string
	
	private int sId;
	private String sName;
	private String sKind;
	private String sMenu;
	private String sMoney;
	private String sLocation;
	private double sPoint;
	private String uId;
	private String uName;
	private Date sDate;
	private double sAvg;
	
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsKind() {
		return sKind;
	}
	public void setsKind(String sKind) {
		this.sKind = sKind;
	}
	public String getsMenu() {
		return sMenu;
	}
	public void setsMenu(String sMenu) {
		this.sMenu = sMenu;
	}
	public String getsMoney() {
		return sMoney;
	}
	public void setsMoney(String sMoney) {
		this.sMoney = sMoney;
	}
	public String getsLocation() {
		return sLocation;
	}
	public void setsLocation(String sLocation) {
		this.sLocation = sLocation;
	}
	public double getsPoint() {
		return sPoint;
	}
	public void setsPoint(double sPoint) {
		this.sPoint = sPoint;
	}
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
	public Date getsDate() {
		return sDate;
	}
	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}
	public double getsAvg() {
		return sAvg;
	}
	public void setsAvg(double sAvg) {
		this.sAvg = sAvg;
	}
	
}
