package com.yedam.array;

public class Exam05 {
	public static void main(String[] args) {
		//최대값 또는 최소값이 위치하는 인덱스 구하기
		int[] array = {20,50,70,80,30,10,90,100};
		int max = 0;
		int min = 0;
		for(int i=0; i<array.length; i++) {
			int maxVar = array[0];
			if(array[i]>maxVar) {
				maxVar = array[i];
				max = i;}
			int minVar = array[0];
			if(array[i]<minVar) {
				minVar = array[i];
				min = i;}
			}
		System.out.println("최대값의 인덱스 : "+max+", 최소값의 인덱스 : "+min);
		
		//명령 라인 출력 테스트
		for(int i=0; i<args.length; i++) {
			System.out.println("명령 라인 출력 : " + args[i]);
		}
		
		
	}
}
