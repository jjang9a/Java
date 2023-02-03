package com.yedam.inheri;

public class Application01 {
	public static void main(String[] args) {
		//자식 클래스를 객체로 생성
		DmbCellPhone dmb = new DmbCellPhone("자바폰", "검정", 10);
		
		//부모 클래스에서 받아 온 필드 출력
		System.out.println("모델 : "+dmb.model);
		System.out.println("색상 : "+dmb.color);
		
		//자식 클래스(본인)의 필드 출력
		System.out.println("채널 : "+dmb.channel);
		
		//부모 클래스에서 받아온 메소드 사용
		dmb.powerOn();
		dmb.powerOff();
		dmb.hangUp();
		
		//자식 클래스에 구현한 메소드 사용
		dmb.turnOnBmb();
		dmb.turnOffBmb();
		
		
	}
}
