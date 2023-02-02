package com.yedam.oop;

public class Application07 {
	public static void main(String[] args) {
		Person p1 = new Person("11211-111111", "김또치");
//		p1.nation = "미국";
//		p1.ssn = "123-123";
		//개명말고는 할 수 있는게 없다
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		//지구의 반지름
		System.out.println("지구의 반지름 : "+StaticCal.PI);
		//지구의 표면적(원넓이 : pi*r*r)
		System.out.println("지구의 표면적 : "+StaticCal.PI*StaticCal.EARTH_RADIOUS*StaticCal.EARTH_RADIOUS);
		
//		StaticCal.PI = 100; 	final이기때문에 값 변경 못함
		
		
		
		
	}
}
