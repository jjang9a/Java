package com.yedam.API;

public class SystemExample {
	public static void main(String[] args) {
		//System클래스
		//강제 종료 : System.exit(0);
		
//		for(int i=0; i<=10; i++) {
//			System.out.println(i);
//			if(i==5) {
//				System.exit(0);
//			}	
//		}
//		System.out.println("프로그램 종료");
		
		//현재 시간 읽기
		long time = System.nanoTime();
		int sum = 0;
		for(int i=0; i<=1000000; i++) {
			sum+=1;
		}
		long time2 = System.nanoTime();
		
		System.out.println(time);
		System.out.println(time2);
		System.out.println("1~1000000의 합 : "+sum);
		System.out.println("소요 시간 : "+(time2-time)+"나노초 소요");
		
		//현재시간 -> 중복되지 않는 데이터를 구할 때 이용가능
		
		System.out.println(System.currentTimeMillis());
				
	}
}
