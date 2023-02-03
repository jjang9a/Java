package com.yedam.inheri;

public class Parent {
	//필드
	String firstName;
	
	//생성자
	public Parent(String firstName){
		this.firstName = firstName;
	}
	
	//메소드
	public void getInfo(){
		System.out.println("우리 가족의 성씨는 \'"+firstName+"\'입니다");
	}
	
}
