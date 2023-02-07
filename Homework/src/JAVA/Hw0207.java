package JAVA;

import java.util.Scanner;

public class Hw0207 {
	public static void main(String[] args) {
//		#모든 문자열은 소문자로 받아서 진행 한다.
//		//1) 세 개의 단어를 입력 받아 그 중 가장 짧은 단어와 길이 리턴하기
//		예시 )  입력> tiger
//		          입력> lion
//		          입력> rabbit
//		          출력> 가장 짧은 단어는 lion이며, 길이는 4 입니다.
		Scanner sc = new Scanner(System.in);
		
//		String[] test1 = new String[3];
//		for(int i=0; i<test1.length; i++) {
//			System.out.println("입력>");
//			test1[i] = sc.nextLine().toLowerCase();
//		}
//		int min = test1[0].length();
//		int index = 0;
//		for(int i=1; i<test1.length; i++) {
//			if(min > test1[i].length()) {
//				min = test1[i].length();
//				index = i;
//			}
//		}
//		System.out.println("출력 > 가장 짧은 단어는 "+test1[index]+"이며, 길이는 "+min+"입니다.");
		

//		// 2) 문자열 개수 세기
//		-> 입력 문자열에서 알파벳, 숫자, 공백의 개수를 구하시오.
//		예시) 
//		-> 입력 : 1a2b3c4d 5e
//		-> 출력 : 문자 :5개, 숫자:5개, 공백 : 1개
		System.out.println("\n<<<2번>>>\n");
		System.out.println("입력>");
		String test2 = sc.nextLine().toLowerCase();
		byte[] byte1 = test2.getBytes();
		int str = 0;
		int num = 0;
		int blank = 0;
		for(byte tamp : byte1) {
			System.out.println(tamp);
		}
		for(byte tamp : byte1) {

		}
		
		
		
		
		
		
		
		
		
		
		
//		//3) 중복되는 문자가 없는 문자열에서 두 문자사이의 거리 구하기
//		조건 : 입력되는 두 문자를 제외한 가운데 문자의 갯수를 두 문자간 거리로 한다.
//		예시)
//		-> 입력 : "abcdefghijklmnopqrstuvwxyz"
//		-----------------------------------
//		-> 입력 : 첫번째 문자 : c
//		-> 입력 : 두번째 문자 : f
//		-> 출력 : 두 문자간의 거리 : 2
//		------------------------------------
//		-> 입력 : 첫번째 문자 : e
//		-> 입력 : 두번째 문자 : a
//		-> 출력 : 두 문자간의 거리 : 3


		
		
//		//4) 중복문자 제거
//		입력 : aaabbccceedddd
//		출력 : abcd
		
		
		
	}
}
