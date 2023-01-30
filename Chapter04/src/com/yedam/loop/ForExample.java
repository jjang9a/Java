package com.yedam.loop;

public class ForExample {
	public static void main(String[] args) {
		//반복문
		//일정한 행동을 계속 반복
		//반복을 할 때 어떠한 규칙에 따라 행동 반복
		//규칙 찾는게 중요.
		
		//1~5 누적 합 구하기
		int sum = 0;
		
//		sum = sum +1;
//		sum = sum +2;
//		sum = sum +3;
//		sum = sum +4;
//		sum = sum +5;
		
		//for문
		for(int i =1; i<=5; i++) {
			sum += i;
		}
		
		System.out.println("누적 합 : " + sum);
		
		//1~100 사이에서 짝수 구하는 반복문
		//1~100 -> 1~100까지 반복
		
		for(int i = 1; i<=100; i++) {
			if(i % 2 == 0) {
				System.out.print(i + "\t");
			}
		}
		
		System.out.println();
		
		//1~100 사이의 홀수 구하는 반복문
		
		for(int i = 1; i<=100; i++) {
			if(i%2 ==1) {
				System.out.print(i + "\t");
			}
		}
		
		System.out.println();
		
		//l~100 사이에서 2의 배수 또는 3의 배수 찾기
		//2의 배수 => 어떤 값을 2로 나누었을 때 나머지가 0인 수들
		//3의 배수 => 어떤 값을 3로 나누었을 때 나머지가 0인 수들
		for(int i=1; i<=100; i++) {
			if(i%2 ==0 || i%3 ==0) {
				System.out.println("2 또는 3의 배수 : " + i);
			}
		}
		
		
		//구구단 출력하기
		// 2*1 = 2
		// 2*2 = 4...
		// 2*i = X
		
		for(int i=1; i<10; i++) {
			System.out.println("2 X " + i + " = " + (2*i));
		}
		
		//중첩 for문
		//반복문 안에 반복문이 들어가는 형태
		
		//2단 -> 2*1, 2*2, 2*3...
		//3단 -> 3*1, 3*2, 3*3...
		//4단 -> 4*1, 4*2, 4*3...
		
		//2단~9단까지를 출력하는 반복문
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.println(i+" X "+j+" = "+(i*j));
			}
		}
		
		//구구단 세로로 찍기
		//줄 수를 의미하는 for문
		for(int i=1; i<=9; i++) {
			//해당 줄에서 한 칸씩 늘어나는 for문
			for(int j=2; j<=5; j++) {
				System.out.print(j+" X "+i+" = "+(i*j) + "\t");
			}
			System.out.print("\n");
		}
		
		
		//공포의 별찍기
		
		//*****
		//*****
		//*****
		//*****
		//*****
		
		//한칸씩 내려 갈 때 쓰는 반복문
		for(int i=0; i<5; i++) {
			//별 출력할 때 쓰는 반복문
			String star = "";
			for(int j=0; j<5; j++) {
				//+연산자를 활용해서 *****만듦
//				star += "*";
				System.out.print("*");
			}
//			System.out.println(star);
			System.out.println();
		}
		
		//*
		//**
		//***
		//****
		//*****
		
		for(int i=1; i<=5; i++) {
			String star = "";
			for(int j=0; j<i; j++) {
				star += "*";
			}
			System.out.println(star);
		}
		
		//*****
		//****
		//***
		//**
		//*
		
		for(int i=5; i>=1; i--) {
			String star = "";
			for(int j=0; j<i; j++) {
				star += "*";
			}
			System.out.println(star);
		}
		
			   //i	   //j  조건 i<j 활용
		//    *  1 4,1 = 5
		//   **  2 3,2 = 5
		//  ***  3 2,3 = 5
		// ****  4 1,4 = 5
		//*****  5 0,5 = 5
		
//		for(int i=1; i<=5; i++) {
//			String star = "";
//			String blank = "";
//			for(int b=0; b<5-i; b++) {
//				blank += " ";
//			}
//			for(int j=0; j<i; j++) {
//				star += "*";
//			}
//			System.out.println(blank + star);
//		}
		
		for(int i=5; i>0; i--) {
			for(int j=1; j<=5; j++) {
				if(i>j) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
				
			}
			System.out.println();
		}
		
		
		

		
		
		
		
		
		
		
	}
}
