package com.yedam.inter;

public class InterfaceExample {
	public static void main(String[] args) {
		RemoteControl rc;
		rc = new Television();
		rc = new Audio();
		
		rc.turnOn();
		rc.setVolume(5);
		rc.setVolume(12);
		rc.setVolume(-1);
		rc.turnOff();
		
		SmartTelevision tv = new SmartTelevision();
		
		//SmartTelevision -> 2개의 인터페이스를 상속
		//누구를 타입으로 해서 변수를 만들어야 할 지에 대한 고민 有
		// => 둘 다 가능하긴 함 but 하나의 클래스에 만들어 져 있다고 해도 두 개의 기능을 한번에 사용할수는 X
		//기능에 맞는애로 끌어와서 써야 함
		
		RemoteControl rc2 = tv;
		Seachable search = tv;
		
		rc2.setVolume(10);
		rc2.turnOn();
//		rc2.search("www.naver.com");
		search.search("www.naver.com");
		
	}
}
