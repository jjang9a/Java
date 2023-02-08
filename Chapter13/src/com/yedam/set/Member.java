package com.yedam.set;

public class Member {
	//필드
	public String name;
	public int age;
	
	//생성자
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	//메소드
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member)obj;
			if(member.name.equals(name) && member.age == age) {
				return true;
			}
			//위는 이름과 나이 모두 같아야 같은 객체, 아래는 이름만 같으면 같은 객체로 취급
//			if(member.name.equals(name)) {
//				return true;
//			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		//name = "또치" -> 100번지 -> hashcode값 : 10
		//age = 20 이라면
		//이 멤버의 해시코드 값은 10+20 = 30이 됨.
		return name.hashCode() + age;
//		return name.hashCode();
	}

	
}
