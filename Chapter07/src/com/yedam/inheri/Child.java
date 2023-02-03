package com.yedam.inheri;

public class Child extends Parent{

	//필드
	String lastName;
	String blood;
	int age;
	String habbit;
	
	//생성자
	public Child(String firstName, String lastName, String blood, int age, String habby) {
		super(firstName);
		this.lastName = lastName;
		this.blood = blood;
		this.age = age;
		this.habbit = habby;
	}

	//메소드
	
	@Override
	public void getInfo() {
		super.getInfo();
		System.out.println("내이름 : "+this.lastName);
		System.out.println("혈액형 : "+this.blood+"형");
		System.out.println("나 이 : "+this.age);
		System.out.println("취 미 : "+this.habbit);
	}
	
}
