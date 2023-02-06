package com.yedam.inter2;

public class Example {
	public static void main(String[] args) {
		ImplementsC impl = new ImplementsC();
		
		//interface A~C까지 impl을 사용해서 메소드 호출
		
		//1) InterfaceA -> A가 가지고 있는 method01만 실행
		InterfaceA ia = impl;
		ia.method01();
		
		//2) InterfaceB -> B가 가지고 있는 method02만 실행
		InterfaceB ib = impl;
		ib.method02();
		
		//3) InterfaceC
		InterfaceC ic = impl;
		ic.method01();
		ic.method02();
		ic.method03();
		
		
	}
}
