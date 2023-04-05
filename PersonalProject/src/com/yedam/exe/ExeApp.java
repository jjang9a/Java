package com.yedam.exe;

import java.util.Scanner;

import com.yedam.board.AnonyService;
import com.yedam.board.RecipeService;
import com.yedam.board.SuggestService;
import com.yedam.store.StoreService;
import com.yedam.users.UserService;

public class ExeApp {
	
	Scanner sc = new Scanner(System.in);
	int menu = 0;
	boolean run = true;
	
	UserService us = new UserService();
	StoreService ss = new StoreService();
	AnonyService as = new AnonyService();
	RecipeService rs = new RecipeService();
	SuggestService gg = new SuggestService();
	
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
		System.out.println("1.로그인♧ | 2.회원가입♧ | 3.나가기♧ ");
		System.out.println("원하시는 서비스를 입력해주세요 > ");
		menu = Integer.parseInt(sc.nextLine());
		if(menu == 1) {
			//로그인 메소드
			us.login();
		}else if(menu == 2) {
			//회원가입 메소드
			us.join();
		}else if(menu == 4) {
			
		}else {
			run = false;
			System.out.println("또 만나요! (*^▽^*)/ thank you!");
		}
		
	}
	
	private void systemMenu() {
		System.out.println("1.관리자 전용 모드 진입 | 2.일반모드 진입");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
			if(menu == 1) {
			System.out.println("관리자 모드로 진입하셨습니다");
			int sel = 0;
			while(sel != 6) {
				System.out.println("1.건의게시판 | 2.회원 조회 | 3.회원 정보 수정 | 4.강제탈퇴 | 5.일반모드로 전환 | 6.로그아웃");
				System.out.println("입력 >");
				sel = Integer.parseInt(sc.nextLine());
				switch(sel) {
				case 1 :
					//건의 게시판
					//글 읽기, 댓글 달기
					gg.suggestList();
					break;
				case 2 :
					//회원정보 조회
					//1. 전체 회원 조회
					//2. 기준 조건에 맞는 회원 조회(order by ?)
					System.out.println("1.전체 회원 조회 | 2.특정 회원 조회 ");
					System.out.println("입력 > ");
					int select = Integer.parseInt(sc.nextLine());
					if(select == 1) {
						us.getUserList();
					}else if(select == 2){
						us.getUser();
					}
					break;
				case 3 :
					//회원 정보 수정
					us.updateUser();
					break;
				case 4 :
					//강제 탈퇴
					us.deleteUser();
					break;
				case 5 : 
					//일반모드로 전환
					loginMenu();
					break;
				case 6 :
					us.loguot();
					break;
				default:
					System.out.println("바르지 않은 명령어입니다.");
					break;
				}
			}
		}else if(menu == 2) {
			loginMenu();
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	private void loginMenu() {
		while(menu != 9) {
			System.out.println("\n1.맛집 등록 게시판 | 2.우리동네 맛집랭킹 | 3.맛집검색 | 4.익명자유게시판 | 5.레시피게시판 | 6.건의게시판 | 7.마이페이지 | 8.명예의전당 | 9.로그아웃");
			System.out.println("입력 > ");
			menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 :
				//맛집 게시판
				ss.storeBoard();
				break;
			case 2 :
				//우리동네 맛집
				ss.localStore();
				break;
			case 3 : 
				//메뉴 검색
				ss.searchStore();
				break;
			case 4 :
				//익명 자유게시판
				as.anonyBoard();
				break;
			case 5 : 
				//레시피 게시판
				rs.recipeBoard();
				break;
			case 6 :
				//건의 게시판
				gg.suggestBoard();
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
			default:
				System.out.println("바르지 않은 명령어입니다.");
				break;
			}
		}
	}
}
