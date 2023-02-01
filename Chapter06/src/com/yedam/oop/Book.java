package com.yedam.oop;

public class Book {
	//book이라는 클래스는 아래의 정보를 가져야합니다.
	// 책 이름, 책 종류, 가격, 도서번호, 출판사
	
	//생성자는 3개정도 생성
	//1) 기본 생성자
	//데이터(매개변수) -> 필드를 초기화 할 수 있게끔 생성자
	//2) 모든 데이터를 초기화 할 수 있는 생성자
	//3) 책 이름, 가격, 도서번호를 받아오는 생성자
	
	//메소드는 getInfo()라는 메소드를 가진다
	//getInfo()메소드를 클래스 외부에서 실행 하였을 때, 다음과 같은 출력물이 나오도록 구현하시오
		
	//필드
	String name; //책 이름
	String kate; //책 종류
	int price; //가격
	int isbn; //도서번호
	String pub; //출판사
	
	//생성자
	public Book() {
	}
	
	public Book(String name, String kate, int price, int isbn, String pub) {
		this.name = name;
		this.kate = kate;
		this.price = price;
		this.isbn = isbn;
		this.pub = pub;
	}
	
	public Book(String name,int price, int isbn) {
		this.name = name;
		this.price = price;
		this.isbn = isbn;
	}
	
	
	
	
	//메소드
	/*
	 * 책 이름 : 혼자 공부하는 자바
	 * # 내용
	 * 1) 종류 : 학습서
	 * 2) 가격 : 24000원
	 * 3) 출판사 : 한빛 미디어
	 * 4) 도서번호 : 0001
	 */
	void getInfo() {
		System.out.println("책 이름 : "+name);
		System.out.println("# 내용");
		System.out.println("1) 종류 : "+kate);
		System.out.println("2) 가격 : "+price+"원");
		System.out.println("3) 출판사 : "+pub);
		System.out.println("4) 도서번호 : "+isbn);
	}
	
}
