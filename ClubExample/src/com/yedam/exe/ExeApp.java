package com.yedam.exe;

import java.util.Scanner;

import com.yedam.club.ClubService;

public class ExeApp {

	private ClubService cs = new ClubService();
	private int menu = 0;
	private Scanner sc = new Scanner(System.in);
	private boolean run = true;
	
	
	public ExeApp() {
		run();
	}
	
	public void run() {
		while(run) {
			if(ClubService.clubInfo != null) { //로그인 된 상태
				//로그인 후 메뉴
				loginMenu();
			}else if(ClubService.clubInfo == null) { //로그인 안 된 상태
				//로그인 전 메뉴
				logoutMenu();
			}
		}
	}
	
	private void loginMenu() {
		System.out.println("*** 관리자 시스템 메뉴 ***");
		System.out.println("1.신규 등록 | 2.회원 조회 | 3.아이디 조회 | 4.이메일 변경 | 5.강제탈퇴 | 6.로그아웃\n");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
		
		switch(menu) {
		case 1 :
			//신규 등록
			cs.insertClub();
			break;
		case 2 :
			//회원 조회
			cs.getClubList();
			break;
		case 3 :
			//아이디로 조회
			cs.getClub();
			break;
		case 4 :
			//이메일 변경
			cs.updateClub();
			break;
		case 5 :
			//강제 탈퇴
			cs.deleteClub();
			break;
		case 6 :
			//로그아웃
			cs.loguot();
			break;
		}
	}
	private void logoutMenu() {
		System.out.println("1. 로그인 | 2. 종료");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
		if(menu == 1) {
			cs.login();
		}else if(menu == 2) {
			run = false;
			System.out.println("프로그램 종료");
		}
	} 

}
