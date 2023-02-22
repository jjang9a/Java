package com.yedam.exe;

import java.util.Scanner;

import com.yedam.users.UserService;

public class ExeApp {
	
	UserService us = new UserService();
	Scanner sc = new Scanner(System.in);
	int menu = 0;
	boolean run = true;
	
	public ExeApp() {
		run();
	}
	
	public void run() {
		while(run) {
			if(UserService.userInfo == null) {
				//로그인 전 메뉴
				logoutMenu();
			}else if(UserService.userInfo != null && UserService.userInfo.getuGrade().equals("a")) {
				//관리자로 로그인
				systemMenu();				
			}else {
				//일반회원으로 로그인
				loginMenu();
			}
		}
	}
	
	private void logoutMenu() {
		System.out.println("1.로그인 🍭 | 2.회원가입 🍭 | 3.나가기 🍭");
		System.out.println("원하시는 서비스를 입력해주세요 > ");
		menu = Integer.parseInt(sc.nextLine());
		if(menu == 1) {
			//로그인 메소드
			us.login();
		}else if(menu == 2) {
			//회원가입 메소드
			us.join();
		}else {
			run = false;
			System.out.println("또 만나요! (*ˊᗜˋ*)/ᵗᑋᵃᐢᵏ ᵞᵒᵘ*");
		}
		
	}
	
	private void systemMenu() {
		System.out.println("1.관리모드 진입 | 2.일반모드 진입");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
		if(menu == 1) {
			System.out.println("관리자 모드로 진입하셨습니다");
			System.out.println("1.전체 회원 정보 | 2.회원 조회 | 3.회원 등급 조정 | 4.강제탈퇴 | 5.글, 댓글 삭제 | 6.일반모드로 전환");
			System.out.println("입력 >");
			int sel = Integer.parseInt(sc.nextLine());
			
			switch(sel) {
			case 1 :
				//전체 회원 정보
				us.getUserList();
				break;
			case 2 :
				//기준 조건에 맞는 회원 조회(order by ?)
				
				break;
			case 3 :
				//회원 등급 조정
				
				break;
			case 4 :
				//강제 탈퇴
			
				break;
			case 5 : 
				//글, 댓글 삭제
				
				break;
			case 6 :
				//일반모드로 전환
				loginMenu();
				break;
			}
		}else if(menu == 2) {
			loginMenu();
		}else {
			System.out.println("잘못 입력하셨습니다");
		}
	}

	private void loginMenu() {
		System.out.println("일반모드");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
		if(menu == 6) {
			us.loguot();
		}
	}
}
