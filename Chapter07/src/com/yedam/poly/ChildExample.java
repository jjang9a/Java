package com.yedam.poly;

public class ChildExample {
	public static void main(String[] args) {
		

	/* 클래스 간의 자동 타입 변환
	 * Parent p1 = new child();
	 * Child의 생성자로 객체 생성을 하고 이 객체를 Parent로 모습이 변한다.
	 */
	/* 다형성
	 * - 부모 클래스에 있는 내용을 사용하되, 만약 자식 클래스에 부모 메소드가 재정의(오버라이딩)가 되어있다면
	 *   부모 클래스의 메소드를 사용하지 않고!! 자식 클래스의 메소드를 다용
	 * - 위의 성질을 활용하여 하나의 타입(부모)로 다양한 모습을 만든다.
	 * - 많은 자식들로부터 다양한 형태를 만들 수 있다.
	 */
	
	Parent p1 = new Child();
	p1.method01();
	p1.method02();
//	p1.field2 = "A"; Parent에 원래 있었으나 재정의 된 것만 가져옴. Child에서 새로 만들어진 것은 사용불가!
	p1.field = "A";
	
	System.out.println("다른 형태의 객체");
	p1= new Child02();
	p1.method01();
	p1.method02();
	
	}
}
