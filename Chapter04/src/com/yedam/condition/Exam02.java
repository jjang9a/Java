package com.yedam.condition;

import java.util.Scanner;

public class Exam02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("성적입력>");
		
		//입력한 문자열 변수에 저장하는 과정
		String point = sc.nextLine();
		//문자열은 int형으로 형 변환 하는 과정
		int scores = Integer.parseInt(point);
		
		String pass = "";
		
		//switch문 부등호 사용 못함
		//효율적으로 코딩(1~100 해당 되는 case문 만들지 말라)

		int score = scores/10;
		
		switch(score) {
		case 10 :
		case 9 :
			pass = "A";
			break;
		case 8 :
			pass = "B";
			break;
		case 7 :
			pass = "C";
			break;
		default :
			pass = "D";
			break;	
		}
		
		System.out.println(pass);
		
		
		
		
		
		
		
	}
}
