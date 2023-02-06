package com.yedam.inter;

public class MyClassExample {
	public static void main(String[] args) {
		System.out.println("p.380 (1)=======");
		
		//클래스 내부의 인터페이스를 활용하여 필드로 선언
		MyClass myClass1 = new MyClass();
		
		myClass1.rc.turnOn();
		myClass1.rc.setVolume(5);
		
		
		System.out.println("\n======(2)=======");
		
		MyClass myClass2 = new MyClass(new Audio());
		
		System.out.println("\n======(3)=======");
		
		MyClass myClass3 = new MyClass();
		myClass3.methodA();
		
		System.out.println("\n======(4)=======");
		MyClass myClass4 = new MyClass();
		myClass4.methodB(new Television());
		myClass4.methodB(new Audio());
		
		
	}
}
