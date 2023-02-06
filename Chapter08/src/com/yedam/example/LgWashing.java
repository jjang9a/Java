package com.yedam.example;

public class LgWashing implements WashigMachine {

	private int speed;
	
	@Override
	public void start() {
		System.out.println("세탁을 시작합니다.");
	}

	@Override
	public void stop() {
		System.out.println("세탁을 중지합니다.");
	}

	@Override
	public void end() {
		System.out.println("세탁을 종료합니다.");
	}

	@Override
	public void speedChange(int speed) {
		if(speed == 1) {
			this.speed = 20;
		}else if(speed == 2) {
			this.speed = 50;
		}else if(speed == 3) {
			this.speed = 100;
		}
		System.out.println("세탁 속도를 "+this.speed+"으로 변경합니다.");
	}

	@Override
	public void dry() {
		System.out.println("건조를 시작합니다.");
	}

}
