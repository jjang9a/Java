package com.yedam.poly;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i=1; i<=5; i++) {
			int problemLocation = car.run();
			
			switch(problemLocation) {
				case 1:
					System.out.println("앞왼쪽 HankookTire로 교체");
					//car.fLT => Tire fLT
					//Tire fLT = new HankookTire("앞왼쪽", 15);
					//Tire fLT = new KunhoTire("앞왼쪽", 15);
					car.fLT = new HankookTire("앞왼쪽", 15);
					break;
				case 2:
					System.out.println("앞오른쪽 KunhoTire로 교체");
					car.fRT = new HankookTire("앞오른쪽", 13);
					break;
				case 3:
					System.out.println("뒤왼쪽 HankookTire로 교체");
					car.bLT = new HankookTire("뒤왼쪽", 14);
					break;
				case 4:
					System.out.println("뒤오른쪽 KunhoTire로 교체");
					car.bRT = new HankookTire("뒤오른쪽", 17);
					break;
			}
			System.out.println("---------------------------");
			
		}

	}

}
