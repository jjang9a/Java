package com.yedam.inter;

public interface RemoteControl {
	//상수 => static final이 생략
	public int MAX_VOLUME = 10; //상수의 변수 명은 대문자이고 두 단어를 조합할때는 언더바(_)이용
	public static final int MIN_VOLUME = 0;
	
	//추상 메소드 => abstract 생략
	public void turnOn();
	public abstract void turnOff();
	public void setVolume(int volume);
	
	
	
	
}
