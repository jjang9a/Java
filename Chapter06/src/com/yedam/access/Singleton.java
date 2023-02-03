package com.yedam.access;

public class Singleton {
	//외부에서 접근은 못하지만 공유는 가능하다
	//내가 미리 만들어둔 단 하나의 객체
	//객체 생성 -> 객체가 존재하고있는 주소값
	//sington -> 100번지
	private static Singleton sington = new Singleton();
	//외부에서 객체를 생성하지 못하도록 막는 역할
	private Singleton() {
	}
	//Singleton 내부에서 만든 객체(8번줄에서 생성한)를 외부에 전달하는 용도
	//계속 100번지만 전달함
	public static Singleton getInstance() {
		return sington;
	}
	
	public void getInfo() {
		System.out.println("싱글톤 내부 getInfo메소드 실행");
	}
	
	
}
