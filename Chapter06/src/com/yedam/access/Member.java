package com.yedam.access;

public class Member {
	//다음의 조건에 맞추어 Member 클래스를 작성하세요.
	//어떠한 사이트 회원에 대한 정보를 담는 객체 생성 용도
	//아이디, 비밀번호, 이름, 나이
	//생성자는 기본 생성자를 쓴다
	//getter, setter 활용하여 정보를 읽고 저장 할 수 있는 메소드
	//1) 나이를 입력 할 때 데이터의 무결성을 지켜주기 위하여 0보다 작은 수가 입력되면 0으로 처리한다
	//2) 나이를 출력할때는 입력한 값에 +1 하여 출력한다
	
	//필드
	private String id;
	private String pw;
	private String name;
	private int age;
	
	//생성자
	public Member() {
		
	}

	//메소드
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age+1;
	}

	public void setAge(int age) {
		this.age = (age <= 0) ? 0 : age;
	}
	
}
