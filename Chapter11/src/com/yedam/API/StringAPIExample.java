package com.yedam.API;

public class StringAPIExample {
	public static void main(String[] args) {
		//1)문자열 뒤집기
		//String str = "abcdefg" -> "gfedba"
		String stra = "abcdefg";
		
		for(int i=stra.length()-1; i>=0; i--) {
			System.out.print(stra.charAt(i));
		}
	}
}
