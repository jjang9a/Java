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
		
		System.out.println("<<<1번>>>");
		String[] test1 = new String[3];
		for(int i=0; i<test1.length; i++) {
			System.out.print("입력> ");
			test1[i] = sc.nextLine().toLowerCase();
		}
		int min = test1[0].length();
		int index = 0;
		for(int i=1; i<test1.length; i++) {
			if(min > test1[i].length()) {
				min = test1[i].length();
				index = i;
			}
		}
		System.out.println("출력> 가장 짧은 단어는 "+test1[index]+"이며, 길이는 "+min+"입니다.");
		

//		// 2) 문자열 개수 세기
//		-> 입력 문자열에서 알파벳, 숫자, 공백의 개수를 구하시오.

		System.out.println("\n<<<2번>>>");
		System.out.print("입력> ");
		String test2 = sc.nextLine().toLowerCase();
//		String test2 = "1a2b3c4d 5e";
//		System.out.println("입력> 1a2b3c4d 5e");
		byte[] byte1 = test2.getBytes();
		int str = 0;
		int num = 0;
		int blank = 0;

		//아스키 코드 - 숫자 48~57, 영소문자 97~122, 공백 32
		for(byte temp : byte1) {
			if(temp == 32) {
				blank++;
			}else if(temp >=48 && temp <=57) {
				num++;
			}else {
				str++;
			}
		}
		System.out.println("출력> 문자 : "+str+"개, 숫자 : "+num+"개, 공백 : "+blank+"개");
		

//		//3) 중복되는 문자가 없는 문자열에서 두 문자사이의 거리 구하기

		System.out.println("\n<<<3번>>>");
		String test3 = "abcdefghijklmnopqrstuvwxyz";
		System.out.println("입력> abcdefghijklmnopqrstuvwxyz");
		System.out.println("-------------------------------");
		
		System.out.print("첫번째 문자> ");
		String str1 = sc.nextLine().toLowerCase();
		System.out.print("두번째 문자> ");
		String str2 = sc.nextLine().toLowerCase();
		
		int fir = test3.indexOf(str1);
		int sec = test3.indexOf(str2);
		System.out.println("두 문자간의 거리 : "+Math.abs(fir-sec));
		System.out.println("-------------------------------");
		
//		//4) 중복문자 제거
//		입력 : aaabbccceedddd
//		출력 : abcd
		
		System.out.println("\n<<<4번>>>");
//		System.out.print("입력> ");
//		String test4 = sc.nextLine().toLowerCase();
		String test4 = "aaabbccceedddd";
		System.out.println("입력> aaabbccceedddd");
		
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<test4.length(); i++) {
			String aaa = String.valueOf(test4.charAt(i));
			if(sb.indexOf(aaa) == -1) {sb.append(aaa);}
		}
		
		System.out.println("출력> "+sb);

	}
}
