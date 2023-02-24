package com.yedam.store;

import java.util.Scanner;

import com.yedam.users.UserService;

public class StoreService extends UserService{
	
	Scanner sc = new Scanner(System.in);
	
	//맛집 게시판
	public void storeBoard() {
		System.out.println("1.맛집 등록 | 2.최신글 보기 | 3.내가 쓴 글 삭제");
		int sel = Integer.parseInt(sc.nextLine());
		if(sel == 3) {
			
		}else if(sel == 1) {
			insertStore();
		}else {
			
		}
	}
	
	//맛집 글쓰기 기능
	public void insertStore() {
		Store s = new Store();
		System.out.println("==추천할 맛집 등록==");
		System.out.println("1.한식 2.양식 3.일식 4.중식(아시아식) 5.디저트 6.주점 7.기타");
		int sel = Integer.parseInt(sc.nextLine());
		switch(sel) {
			case 1:
				s.setsKind("한식");
				break;
			case 2:
				s.setsKind("양식");
				break;
			case 3:
				s.setsKind("일식");
				break;
			case 4:
				s.setsKind("중식(아시아식)");
				break;
			case 5:
				s.setsKind("디저트");
				break;
			case 6:
				s.setsKind("주점");
				break;
			default:
				s.setsKind("기타");
				break;
		}
		System.out.println("가게이름 > ");
		s.setsName(sc.nextLine());
		System.out.println("메뉴 입력(여러개일시 ,로 구분해서 적어주시면 됩니다) >");
		s.setsMenu(sc.nextLine());
		System.out.println("가격대 > ");
		s.setsMoney(sc.nextLine());
		System.out.println("위치(구) > ");
		s.setsLocation(sc.nextLine());
		System.out.println("평가 점수(10점 만점) > ");
		s.setsPoint(Double.parseDouble(sc.nextLine()));
		s.setuId(userInfo.getuId());
		s.setuName(userInfo.getuName());	
		
		int result = StoreDAO.getInstance().insertStore(s);
		if(result > 0) {
			System.out.println("작성글이 등록되었습니다.");
			postCheck();
		}else {
			System.out.println("작성글 등록 중 오류가 발생하였습니다.");
		}
	}
	
	//우리동네 맛집
	public void localStore() {
		Store s = new Store();
		System.out.println("1.구별 랭킹 맛집 | 2.음식종류별 랭킹 맛집");
		int menu = Integer.parseInt(sc.nextLine());
		if(menu == 1) {
			System.out.println("");
			
		}else {
			System.out.println("1.한식 2.양식 3.일식 4.중식(아시아식) 5.디저트 6.주점 7.기타");
			int sel = Integer.parseInt(sc.nextLine());
			switch(sel) {
				case 1:
					s.setsKind("한식");
					break;
				case 2:
					s.setsKind("양식");
					break;
				case 3:
					s.setsKind("일식");
					break;
				case 4:
					s.setsKind("중식(아시아식)");
					break;
				case 5:
					s.setsKind("디저트");
					break;
				case 6:
					s.setsKind("주점");
					break;
				default:
					s.setsKind("기타");
					break;
			}
		}
	}
	
	//메뉴 검색
	public void searchMenu() {
		
	}
	
}
