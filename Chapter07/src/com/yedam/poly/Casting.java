package com.yedam.poly;

public class Casting {
	public static void main(String[] args) {
		//강제 타입변환(Casting)
		//부모 타입으로 만들어진 다형성을 (부모가 가진 내용만 사용가능)
		//자식이 가진 내용도 쓰고 싶어서 하는 방식
		
		//자동 타입 변환(다형성)
		Parent parent = new Child();
		
		if(parent instanceof Parent) {
			System.out.println("부모 타입");
		}
		if(parent instanceof Child) {
			System.out.println("자식 타입");
		}
		
		parent.field = "부모필드";
		parent.method01();
		parent.method02();
//		parent.field2 = "자식필드";
//		parent.method03();
		
		//강제 타입 변환
		//조건 : 클래스간의 자동타입변환 발생 후에 사용 가능.
		Child child = (Child)parent;
		
		child.field2 = "자식필드";
		child.method03();
		child.field = "강제타입 부모필드";
		
		//같은 인스턴스인지 확인할 때 쓰는 문법
		//instanceof
		//== : 객체가 같은 주소를 가지는지 확인
		//instanceof : 같은 타입의 객체인지 확인
		
		Parent p1 = new Parent();
		Parent p2 = new Parent();
		
		if(p1 == p2) {
			System.out.println("주소가 같습니다.");
		}else {
			System.out.println("주소가 다릅니다.");
		}
		if(p1 instanceof Parent) {
			System.out.println("같은 타입의 객체입니다.");
		}
		
	}
}
