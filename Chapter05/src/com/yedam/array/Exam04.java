package com.yedam.array;

import java.util.Scanner;

public class Exam04 {
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] score = null;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("--------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------");
			System.out.println("선택>");
			
			int selecNo = Integer.parseInt(scanner.nextLine());
			
			if(selecNo ==1) {
				System.out.println("학생수>");
				studentNum = Integer.parseInt(scanner.nextLine());
			}else if(selecNo ==2) {
				score = new int[studentNum];
				for(int i=0; i<studentNum; i++) {
					System.out.println("score["+i+"]> ");
					score[i] = Integer.parseInt(scanner.nextLine());
				}
			}else if(selecNo ==3) {
				for(int i=0; i<studentNum; i++) {;
					System.out.println("score["+i+"]> "+score[i]);
				}
			}else if(selecNo ==4) {
				int sum = 0;
				int max = 0;
				for(int var : score) {
					if(var>max) {
						max = var;
					}
					sum += var;
				}
				double avg = (double)(sum)/score.length;
				System.out.println("최고 점수 : "+max);
				System.out.println("평균 점수 : "+avg);
			}else if(selecNo ==5) {
				run = false;
			}

		}
		
		System.out.println("프로그램 종료");
		
	}
}
