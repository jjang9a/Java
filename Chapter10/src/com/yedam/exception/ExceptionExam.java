package com.yedam.exception;

public class ExceptionExam {
	public static void main(String[] args) {
		//NullPointException
		//객체에 데이터가 안 들어간 상태에서 어떤 행동을 하려고 할 때 발생
		
		String date = null;
//		System.out.println(data.toSrting());
		Example example = null;
//		System.out.println(example.toString());
		
		
		//ArrayIndexOutOfBoundsException
		//배열의 범위를 벗어난 인덱스를 호출 할 때 발생
		int[] intAry = new int[3];
		
		intAry[0] = 1;
//		intAry[10] = 10;
		
//		for(int i=0; i<=intAry.length; i++) {
//			System.out.println(intAry[i]);
//		}
		
		//NumberFormatException
		//숫자로 바꿀 수 없는 문자를 바꾸려고 할 때 발생
		//정상
		String str = "123";
		int val = Integer.parseInt(str);
		System.out.println(val);
		//예외
		String str2 = "자바";
//		val = Integer.parseInt(str2);
//		System.out.println(val);
		
		String str3 = "";
//		val = Integer.parseInt(str3);
//		System.out.println(val);
		
		
		//ClassCastException
		//자동타입변환 된 객체를 강제타입 변환 할 때 발생
		//정상
		Example exam = new Exam();
		Exam exam02 = (Exam)exam;
		//예외
		Example exam03 = new Exam();
//		Exam02 exam04 = (Exam02)exam03;
		
		if(exam03 instanceof Exam) {
			Exam exam05 = (Exam) exam03;
		}
		
		//ClassNotFoundException -> Class 파일 찾지 못할 때 발생
		//실행메소드 -> main 못 찾을 때 자주 발생
		
		//ArithmeticException -> 분모가 0일 때 나는 오류
//		double a = 1/0;
		
		//(반복문 종료하지 못하고 무한 루프 등등)
		//OutofMemoryError -> 메모리 부족할 때
		//memory leak
		
		//IOException -> 입출력 오류
		//				 file reading/write
		
		//FileNotFoundException
		//java -> file reading -> 경로를 찾아서 file 읽어야 함.
		//해당경로 찾아갔는데 파일이 존재하지 않을 경우 발생
		
		
		
	}
}
