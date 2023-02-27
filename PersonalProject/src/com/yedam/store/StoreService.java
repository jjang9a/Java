package com.yedam.store;

import java.util.List;
import java.util.Scanner;

import com.yedam.users.UserService;

public class StoreService extends UserService{
	
	Scanner sc = new Scanner(System.in);
	List<Store> list = null;
	
	//맛집 게시판
	public void storeBoard() {
		System.out.println("1.맛집 등록 | 2.내가 쓴 글 | 3.뒤로가기");
		int sel = Integer.parseInt(sc.nextLine());
		if(sel == 3) {
			
		}else if(sel == 1) {
			insertStore();
		}else {
			storeList();
		}
	}
	
	//맛집 글쓰기 기능
	public void insertStore() {
		Store s = new Store();
		System.out.println("==추천할 맛집 등록==");
		System.out.println("1.한식 2.양식 3.일식 4.중식(아시아식) 5.디저트 6.주점 7.퓨전");
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
				s.setsKind("퓨전");
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
		double point = Double.parseDouble(sc.nextLine());
		if(point >= 0 && point <= 10) {
			s.setsPoint(point);		
		}else {
			System.out.println("평가점수는 0~10 사이로 입력해주세요");
			System.out.println("평가 점수(10점 만점) > ");
			point = Double.parseDouble(sc.nextLine());
			s.setsPoint(point);	
		}
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
	
	//우리동네 랭킹맛집
	public void localStore() {
		Store s = new Store();
		System.out.println("1.구별 랭킹 맛집 | 2.음식종류별 랭킹 맛집");
		int menu = Integer.parseInt(sc.nextLine());
		String kind = null;
		String select = null;
		if(menu == 1) {
			kind = "s_location";
			System.out.println("중구 | 북구 | 수성구 | 달서구 | 남구 | 동구 | 서구 | 달성군 > ");
			select = sc.nextLine();
		}else {
			kind = "s_kind";
			System.out.println("1.한식 2.양식 3.일식 4.중식(아시아식) 5.디저트 6.주점 7.퓨전");
			int sel = Integer.parseInt(sc.nextLine());
			switch(sel) {
				case 1:
					select = "한식";
					break;
				case 2:
					select = "양식";
					break;
				case 3:
					select = "일식";
					break;
				case 4:
					select = "중식(아시아식)";
					break;
				case 5:
					select = "디저트";
					break;
				case 6:
					select = "주점";
					break;
				default:
					select = "퓨전";
					break;
			}
		}
		System.out.println("!!! "+select + " 맛집 TOP5 !!!");
		list = StoreDAO.getInstance().rankStore(kind, select);
		for(int i=0; i<list.size(); i++) {
			System.out.println((i+1)+"위 : "+list.get(i).getsLocation()+"에 있는 "+list.get(i).getsKind()+" 전문점 '"
					+list.get(i).getsName()+"' "+avgStar(list.get(i)));
		}
	}
	
	//평점 별찍기
	public String avgStar(Store s) {
		String result = "";
		double avg;
		if(s.getsAvg() != 0) {
			avg = s.getsAvg();
		}else {
			avg = s.getsPoint();
		}
		if(avg > 9) {
			result = "★★★★★("+avg+")";
		}else if(avg > 8) {
			result = "★★★★☆("+avg+")";
		}else if(avg > 7) {
			result = "★★★★("+avg+")";
		}else if(avg > 6) {
			result = "★★★☆("+avg+")";
		}else if(avg > 5) {
			result = "★★★("+avg+")";
		}else if(avg > 4) {
			result = "★★☆("+avg+")";
		}else if(avg > 3) {
			result = "★★("+avg+")";
		}else if(avg > 2) {
			result = "★☆("+avg+")";
		}else if(avg > 1) {
			result = "★("+avg+")";
		}else {
			result = "☆("+avg+")";
		}
		return result;
	}
	
	//맛집 검색
	public void searchStore() {
		System.out.println("1.메뉴로 검색 | 2.가게이름으로 검색");
		int sel = Integer.parseInt(sc.nextLine());
		if(sel == 1) {
			searchMenu();
		}else {
			searchName();
		}
	}
	
	//맛집 검색 - 가게이름으로
	public void searchName() {
		System.out.println("가게명 > ");
		String name = sc.nextLine();
		list = StoreDAO.getInstance().rankStore("s_name", name);
		for(int i=0; i<list.size(); i++) {
			System.out.println("'"+list.get(i).getsName()+"'  위치:"+list.get(i).getsLocation()+"  평점:"+avgStar(list.get(i)));
		}
		list = StoreDAO.getInstance().searchName(name);
		for(int i=0; i<list.size(); i++) {
			System.out.println("==========관련 게시글===========");
			System.out.println(" 가게이름 : " +name);
			System.out.println(" 글쓴이  : " +list.get(i).getuName());
			System.out.println(" 게시일  : " +list.get(i).getsDate());
			System.out.println(" 음식종류 : " +list.get(i).getsKind());
			System.out.println(" 메뉴목록 : " +list.get(i).getsMenu());
			System.out.println(" 가  격 : " +list.get(i).getsMoney());
			System.out.println(" 위  치 : " +list.get(i).getsLocation());
			System.out.println(" 점  수 : " +avgStar(list.get(i)));
			System.out.println("=============================");
		}
	}
	
	//맛집 검색 - 메뉴로
	public void searchMenu() {
		int sel = 0;
		System.out.println("메뉴명 > ");
		String menu = sc.nextLine();
		list = StoreDAO.getInstance().searchMenu(menu);
		System.out.println("=====해당 메뉴를 판매중인 가게 목록=====");
		for(int i=0; i<list.size(); i++) {
			System.out.println("🍒 "+list.get(i).getsLocation()+"에 있는 "+list.get(i).getsKind()+" 전문점 '"
					+list.get(i).getsName()+"' ");
		}
		System.out.println("(레시피 게시판에 '"+menu+"'관련 게시글이 "+ StoreDAO.getInstance().searchMenuPlus(menu) +"건 존재합니다.)");
		System.out.println("===============================");
		while(sel != 3) {
			System.out.println("1.가게이름으로 검색 | 2.다른 메뉴 검색 | 3.뒤로가기");
			sel = Integer.parseInt(sc.nextLine());
			if(sel == 1) {
				searchName();
			}else if(sel == 2){
				searchMenu();
			}else{
				break;
			}
		}
	}
	
	//맛집게시판 내 글 조회
	public void storeList() {
		String id = null;
		if(userInfo.getuGrade().equals("a")) {
			System.out.println("작성자 아이디 > ");
			id = sc.nextLine();
		}else {
			id = userInfo.getuId();
		}
		int sel = 0;
		while(sel != 3) {
			list = StoreDAO.getInstance().storeList(id);
			System.out.println(" 글번호      가게이름       작성자      작성일 ");
			System.out.println("----------------------------------------");
			for(int i=0; i<list.size(); i++) {
				System.out.println("  "+(i+1)+"   "+list.get(i).getsName()+"	 "+list.get(i).getuName()+"   "+list.get(i).getsDate());
			}
			System.out.println("----------------------------------------");
			System.out.print("1.글 읽기 | 2.글 삭제 | 3.뒤로가기");
			sel = Integer.parseInt(sc.nextLine());
			if(sel == 1) {
				readStore();
			}else if(sel == 2) {
				deleteStore();
			}else {
				break;
			}
		}
	}
	
	//맛집게시판 글 읽기
	public void readStore() {
		Store s = new Store();
		System.out.print("글 번호를 입력하세요 > ");
		int num = Integer.parseInt(sc.nextLine());
		s = list.get(num-1);
		System.out.println("=============================");
		System.out.println(" 가게이름 : " +s.getsName());
		System.out.println(" 글쓴이  : " +s.getuName());
		System.out.println(" 게시일  : " +s.getsDate());
		System.out.println(" 음식종류 : " +s.getsKind());
		System.out.println(" 메뉴목록 : " +s.getsMenu());
		System.out.println(" 가  격 : " +s.getsMoney());
		System.out.println(" 위  치 : " +s.getsLocation());
		System.out.println(" 점  수 : " +avgStar(s));
		System.out.println("=============================");
	}
	
	//맛집게시판 글 삭제
	public void deleteStore() {
		Store s = new Store();
		System.out.print("삭제할 글 번호를 입력하세요 > ");
		int num = Integer.parseInt(sc.nextLine());
		s = list.get(num-1);
		int result = StoreDAO.getInstance().deleteStore(s);
		if(result>0) {
			System.out.println("작성글이 삭제되었습니다.");
		}else {
			System.out.println("글 삭제중 오류가 발생하였습니다.");
		}
	}
	
}
