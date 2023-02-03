package com.yedam.poly;

public class Car {
	//필드
	Tire fLT = new Tire("앞왼쪽", 6);
	Tire fRT = new Tire("앞오른쪽", 2);
	Tire bLT = new Tire("뒤왼쪽", 3);
	Tire bRT = new Tire("뒤오른쪽", 4);
	
	//생성자
	
	//메소드
	int run() {
		System.out.println("[자동차가 달립니다.]");
		if(fLT.roll()==false) {stop(); return 1;}
		if(fRT.roll()==false) {stop(); return 2;}
		if(bLT.roll()==false) {stop(); return 3;}
		if(bRT.roll()==false) {stop(); return 4;}
		return 0;
	}
	
	void stop() {
		System.out.println("[자동차가 멈춥니다.]");
	}
	
}
