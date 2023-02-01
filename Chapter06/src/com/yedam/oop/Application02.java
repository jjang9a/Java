package com.yedam.oop;

public class Application02 {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		cal.sum(10, 20);
		int result = cal.sum2(10, 30);
		System.out.println(result);
		
		cal.sum3(new int[]{1,2,3,4,5,6});
		cal.sum4(1,2,3,4,5,6);
		
		//클래스 외부에서 avg 메소드 호출
		cal.avg();
		//클래스 외부에서 필드 사용하는 법
		//cal.필드;
		
		Book book = new Book("혼자 공부하는 자바", "학습서", 24000, 0001, "한빛 미디어");
		book.getInfo();
		
		Student stu = new Student("김또치", 20230201, 100, 75, 68);
		stu.getInfo();
		
	}
}
