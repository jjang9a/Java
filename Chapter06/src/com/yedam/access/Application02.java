package com.yedam.access;

public class Application02 {
	public static void main(String[] args) {
		//인스턴스 생성
		Student std = new Student();
		
		std.setStdName("김또치");
		std.setStdGrade("2학년");
		std.setMajor("컴퓨터공학과");
		std.setProgramming(-100);
		std.setDataBase(90);
		std.setOs(100);
		
		System.out.println("이름 : " + std.getStdName());
		System.out.println("학과 : " + std.getMajor());
		System.out.println("학년 : " + std.getStdGrade());
		System.out.println("프로그래밍 : " + std.getProgramming());
		System.out.println("데이터베이스 : " + std.getDataBase());
		System.out.println("운영체제 : " + std.getOs());
		
	}
}
