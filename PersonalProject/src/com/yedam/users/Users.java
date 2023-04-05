package com.yedam.users;

import java.sql.Date;

public class Users {
	
	private String uId;
	private String uPw;
	private String uName;
	private String uMail;
	private Date uDate;
	private String uGrade;
	private int uAttend;
	private int uPost;
	private int uComment;
	
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuMail() {
		return uMail;
	}
	public void setuMail(String uMail) {
		this.uMail = uMail;
	}
	public Date getuDate() {
		return uDate;
	}
	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}
	public String getuGrade() {
		return uGrade;
	}
	public void setuGrade(String uGrade) {
		this.uGrade = uGrade;
	}
	public int getuAttend() {
		return uAttend;
	}
	public void setuAttend(int uAttend) {
		this.uAttend = uAttend;
	}
	public int getuPost() {
		return uPost;
	}
	public void setuPost(int uPost) {
		this.uPost = uPost;
	}
	public int getuComment() {
		return uComment;
	}
	public void setuComment(int uComment) {
		this.uComment = uComment;
	}
	@Override
	public String toString() {
		return "☞ [Id : " + uId + ", Pw : " + uPw + ", 닉네임 : " + uName + ", Email : " + uMail + ", 가입일자 : " + uDate
				+ ", 등급 : " + uGrade + ", 출석횟수 : " + uAttend + ", 글 수 : " + uPost + ", 댓글수 : " + uComment + "]";
	}


}
