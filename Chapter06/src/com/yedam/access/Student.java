package com.yedam.access;

public class Student {
	//다음 조건을 만족하는 Student 클래스 작성
	//이름, 학과, 학년, 과목별 점수
	//과목 설정
	//programming, database, OS
	//필드들은 모두 private
	//setter를 통해 필드 초기화
	//getter를 통해 데이터 reading
	//getInfo() 학생의 정보를 출력하는 기능
	
	//필드
	private String stdName;
	private String major;
	private String stdGrade;
	private int programming;
	private int dataBase;
	private int os;
	
	//생성자
	
	//메소드
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getStdGrade() {
		return stdGrade;
	}
	public void setStdGrade(String stdGrade) {
		this.stdGrade = stdGrade;
	}
	public int getProgramming() {
		return programming;
	}
	//프로그래밍 점수가 0보다 작은 점수가 들어 올 경우에는 프로그래밍 점수는 0으로 처리하겠다.
	public void setProgramming(int programming) {
//		if(programming <= 0) {
//			this.programming = 0;
//			return;
//		}
//		this.programming = programming;
		
		this.programming = (programming <= 0) ? 0 : programming;
		
	}
	public int getDataBase() {
		return dataBase;
	}
	public void setDataBase(int dataBase) {
		this.dataBase = dataBase;
	}
	public int getOs() {
		return os;
	}
	public void setOs(int os) {
		this.os = os;
	}
	

	
	
}
