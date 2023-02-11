package Hw0208;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class StringAPI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//	문제 1] 문자열 압축
//예시 : 입력 >"YYYEEDDDYYYMMMAAA";
//       출력 >Y3E2D3Y3M3A3

		
		
		
		
		
//문제 2] 생년월일 입력 후 나이 출력하기(220101 -> 2022년생, 230202 -> 1923년생)
//     (단, 오늘 날짜 기준으로 생일이 지났으면 +1살, 안 지났으면 +0로 한다.)
//     (올해 기준 +- 100살까지만 구한다.)
//  예시) 
//       입력> 950101 
//       출력> 29
//       입력> 001013
//       출력> 23
		
		System.out.print("입력> ");
		String birth = sc.nextLine();
		int byear = Integer.parseInt(birth.substring(0,2));
		int bday = Integer.parseInt(birth.substring(2));
		int fullYear = 0;
		int age = 0;
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int md = (month*100) + day;
		
		fullYear = (byear <= 23) ? 2000 + byear : 1900 + byear;
		age = (bday > md) ? year - fullYear : year - fullYear + 1 ;

		System.out.println("출력> "+age);
		

//문제 3] 중복 문자 갯수 세기
//      입력> aaabbccceedddd
//      출력> a 3개, b 2개, c 3개, e 2개, d 4개
		
		String num3 = "aaabbccceedddd";
		System.out.println("입력> aaabbccceedddd");
		
		List<Character> abc = new ArrayList<>();
		int[] index = new int[26];
		
		for(int i=0; i<num3.length(); i++) {
			if(num3.indexOf(num3.charAt(i)) == i) {
				abc.add(num3.charAt(i));
				int in = abc.indexOf(num3.charAt(i));
				index[in]++;
			}else {
				int in = abc.indexOf(num3.charAt(i));
				index[in]++;
			}
		}
		System.out.print("출력> ");
		for(int i=0; i<abc.size(); i++) {
			System.out.print(abc.get(i)+" ");
			System.out.print(index[i]+"개   ");
		}
	}
}
