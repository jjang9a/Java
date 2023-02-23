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
			System.out.println("1.건의게시판 | 2.회원 조회 | 3.회원 정보 수정 | 4. 글, 댓글 수정 | 5.글, 댓글 삭제 | 6.강제탈퇴 | 7.일반모드로 전환");
			System.out.println("입력 >");
			int sel = Integer.parseInt(sc.nextLine());
			
			switch(sel) {
			case 1 :
				//건의 게시판
				//글 읽기, 댓글 달기
				
				break;
			case 2 :
				//회원정보 조회
				//1. 전체 회원 조회
				//2. 기준 조건에 맞는 회원 조회(order by ?)
				System.out.println("1.전체 회원 조회 | 2.특정 회원 조회");
				System.out.println("입력 > ");
				int select = Integer.parseInt(sc.nextLine());
				if(select == 1) {
					us.getUserList();
				}else {
					us.getUser();
				}
				break;
			case 3 :
				//회원 정보 수정
				
				break;
			case 4 :
				//글, 댓글 수정
			
				break;
			case 5 : 
				//글, 댓글 삭제
				
				break;
			case 6 :
				//강제 탈퇴
				
				break;
			case 7 :
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
		System.out.println("\n1.맛집 등록 게시판 | 2.우리동네맛집 | 3.메뉴검색 | 4.익명자유게시판 | 5.레시피게시판 | 6.건의게시판 | 7.마이페이지 | 8.명예의전당 | 9.로그아웃");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
		switch(menu) {
		case 1 :
			//맛집 등록 게시판
			
			break;
		case 2 :
			//우리동네 맛집
			
			break;
		case 3 : 
			//메뉴 검색
			
			break;
		case 4 :
			//익명 자유게시판
			
			break;
		case 5 : 
			//레시피 게시판
			
			break;
		case 6 :
			//건의 게시판
			
			break;
		case 7 :
			//마이페이지
			us.myPage();
			break;
		case 8 : 
			//명예의 전당
			us.fame();
			break;
		case 9 :
			//로그아웃
			us.loguot();
			break;
		}
	}
}
