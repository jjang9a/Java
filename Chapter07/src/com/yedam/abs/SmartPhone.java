package com.yedam.abs;

public class SmartPhone extends Phone{

	public SmartPhone(String onwer) {
		super(onwer);
	}
	
	public void internetSearch() {
		System.out.println("인터넷 검색합니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("반드시 구현한 turnOff메소드");
	}
	
	
	
}
