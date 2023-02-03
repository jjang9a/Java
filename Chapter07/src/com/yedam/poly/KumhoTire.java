package com.yedam.poly;

public class KumhoTire extends Tire {

	//필드
	//생성자
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	//메소드
	@Override
	public boolean roll() {
		++accumulteRotation;
		if(accumulteRotation<maxRotation) {
			System.out.println(location + " KunhoTire 수명 : " + (maxRotation-accumulteRotation)+"회");
			return true;
		}else {
			System.out.println("*** "+location+" KunhoTire 펑크 ***");
			return false;
		}
		
	}
}
