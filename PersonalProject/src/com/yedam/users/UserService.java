package com.yedam.users;

import java.util.List;
import java.util.Scanner;

public class UserService {

	public static Users userInfo = null;
	Scanner sc = new Scanner(System.in);
	
	//로그인 기능
	public void login() {
		Users u = null;
		System.out.print("ID > ");
		String uId = sc.nextLine();
		System.out.print("PW > ");
		String uPw = sc.nextLine();
		
		u = UserDAO.getInstance().login(uId);
		
		if(u != null) {
			if(u.getuPw().equals(uPw)) {
				System.out.println("로그인 완료.");
				userInfo = u;

				System.out.println("☆♬○♩●♪♩"+grade(userInfo)+" '"+UserService.userInfo.getuName()+"'님 환영합니다.♩♪●♩○♬☆");
			}else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}
	
	//회원가입 기능
	public void join() {
		Users u = new Users();
		
		System.out.println("♬♩♪♩*﹤　회원가입　﹥*♩♪♩♬");
		System.out.println("아이디(5자 이상) > ");
		String id = sc.nextLine();
		while(id.length()<5) {
			System.out.println("아이디는 5글자 이상이여야 합니다.");
			System.out.println("아이디(5자 이상) > ");
			id = sc.nextLine();
		}
		u.setuId(id);		
		System.out.println("비밀번호 > ");
		String pw = sc.nextLine();
		System.out.println("비밀번호 확인 >");
		if(pw.equals(sc.nextLine())) {
			u.setuPw(pw);
			
			System.out.println("닉네임 > ");
			u.setuName(sc.nextLine());
			System.out.println("메일주소 > ");
			u.setuMail(sc.nextLine());
			
			int result = UserDAO.getInstance().joinUser(u);
			
			if(result == 2) {
				System.out.println("이미 존재하는 ID입니다.");
			}else if(result == 3) {
				System.out.println("이미 존재하는 닉네임입니다.");
			}else if(result == 1) {
				System.out.println("♬♩♪♩*회원 가입 성공*♩♪♩♬ 환영합니다!");
			}else {
				System.out.println("회원 가입 실패 문제가 지속되면 관리자에게 문의하세요.");
			}
		}else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
	}
	
	//로그아웃
	public void loguot() {
		System.out.println("☆○o。 성공적으로 로그아웃 되었습니다 。o○☆\n");
		userInfo = null;
	}
	
	//등급에 따른 표시
	public String grade(Users u) {
		String result = null;
		String grade = u.getuGrade();
		switch(grade) {
		case "a" :
			result = "관리자";
			break;
		case "b" :
			result = "특별회원";
			break;
		case "c" :
			result = "우수회원";
			break;
		case "d" :
			result = "정회원";
			break;
		case "e" :
			result = "준회원";
			break;
		}
		return result;
	}
	
	//관리자 - 전체 회원 조회
	public void getUserList() {
		List<Users> list = UserDAO.getInstance().getUserList();
		System.out.println("★………★………★………★………★………★………★………★");
		for(Users u : list) {
			System.out.println(u.toString());
		}
	}
	
	//관리자 - 개인 조회
	public void getUser() {
		System.out.println("1.아이디로 조회 | 2.닉네임으로 조회");
		System.out.print("입력 > ");
		int sel = Integer.parseInt(sc.nextLine());
		String kind = null;
		if(sel == 2) {
			kind = "u_name";
			System.out.print("조회할 닉네임을 입력하세요 > ");
		}else {
			kind = "u_id";
			System.out.print("조회할 아이디를 입력하세요 > ");
		}
		String user = sc.nextLine();
		Users u = UserDAO.getInstance().getUser(kind, user);
		if(u == null) {
			System.out.println("일치하는 회원이 존재하지 않습니다.");
		}else {
			System.out.println("회원 ID : "+u.getuId());
			System.out.println("닉네임  : "+u.getuName());
			System.out.println("메일주소 : "+u.getuMail());
			System.out.println("가입일자 : "+u.getuDate());
			System.out.println("회원등급 : "+grade(u));
			System.out.println("출석 수 : "+u.getuAttend());
			System.out.println("작성글수 : "+u.getuPost());
			System.out.println("댓글 수 : "+u.getuComment());
		}
	}
		
	//관리자 - 회원 정보 수정
	public void updateUser() {
		Users u = new Users();
		System.out.println("정보를 수정 할 ID > ");
		u.setuId(sc.nextLine());
		System.out.println("1.등급 변경 | 2.닉네임 변경");
		int menu = Integer.parseInt(sc.nextLine());
		String kind = null;
		if(menu == 1) {
			kind = "u_grade";
			System.out.println(u.getuId()+"님의 현재 등급은 "+grade(u)+"("+u.getuGrade()+")입니다.");
			System.out.print("변경 할 등급 > ");
			u.setuGrade(sc.nextLine());
		}else if(menu == 2) {
			kind = "u_name";
			System.out.println(u.getuId()+"님의 현재 등급은 "+u.getuName()+"입니다.");
			System.out.println("변경 할 닉네임 > ");
			u.setuName(sc.nextLine());
		}
		int result = UserDAO.getInstance().updateUser(kind, u);
		
		if(result == 0) {
			System.out.println("회원 정보 수정 실패");
		}else if(result == 3){
			System.out.println("이미 존재하는 닉네임입니다");
		}else {
			System.out.println("회원 정보 수정 성공");
		}
	}
	
	//관리자 - 강제 탈퇴
	public void deleteUser() {
		System.out.println("========< 회원탈퇴　>========");
		System.out.println("탈퇴 처리 할 ID > ");
		int result = UserDAO.getInstance().deleteUser(sc.nextLine());
		
		if(result > 0) {
			System.out.println("강제 탈퇴 완료");
		}else {
			System.out.println("강제 탈퇴 실패");
		}
	}
	
	//회원 - 마이페이지
	public void myPage() {
		int menu = 0;
		while(menu != 6) {
			System.out.println("1.출석체크 | 2.등업신청 | 3.내 정보 조회 | 4.내 정보 수정 | 5.회원탈퇴 | 6.뒤로가기");
			System.out.println("이동을 원하는 메뉴를 입력하세요 > ");
			menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1:
				attendCheck();
				break;
			case 2:
				gradeUp();
				break;
			case 3:
				getMyInfo();
				break;
			case 4:
				editMyInfo();
				break;
			case 5:
				delMyInfo();
				break;
			case 6:
				break;
			default:
				System.out.println("바르지 않은 명령어입니다.");
				break;
			}
		}
	}
	
	//회원 - 본인 정보 조회
	public void getMyInfo() {
		Users u = userInfo;
		System.out.println("★………★………★………★………★………★………★………★");
		System.out.println("회원 ID : "+u.getuId());
		System.out.println("닉네임  : "+u.getuName());
		System.out.println("메일주소 : "+u.getuMail());
		System.out.println("가입일자 : "+u.getuDate());
		System.out.println("회원등급 : "+grade(u));
		System.out.println("출석 수 : "+u.getuAttend());
		System.out.println("작성글수 : "+u.getuPost());
		System.out.println("댓글 수 : "+u.getuComment());
	}
	
	//회원 - 개인 정보 수정
	public void editMyInfo() {
		Users u = userInfo;
		System.out.println("비밀번호를 입력하세요 > ");
		String uPw = sc.nextLine();
		String kind = null;
		int result = 0;
		if(userInfo.getuPw().equals(uPw)) {
			System.out.println("1.비밀번호 변경 | 2.닉네임 변경 | 3.이메일 변경");	
			System.out.println("입력 > ");
			int sel = Integer.parseInt(sc.nextLine());
			switch(sel) {
			case 1 : 
				kind = "u_pw";
				System.out.println("변경 할 비밀번호 > ");
				String pw = sc.nextLine();
				System.out.println("비밀번호 확인 >");
				if(sc.nextLine().equals(pw)) {
					u.setuPw(pw);
					
					result = UserDAO.getInstance().updateUser(kind, u);
					if(result > 0) {
						System.out.println("비밀번호 변경 완료");
					}else {
						System.out.println("비밀번호 변경 실패");
					}	
				}else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
				break;
			case 2 :
				kind = "u_name";
				System.out.println("현재 닉네임은 '"+u.getuName()+"'입니다.");
				System.out.println("변경 할 닉네임 > ");
				u.setuName(sc.nextLine());
				result = UserDAO.getInstance().updateUser(kind, u);
				if(result == 0) {
					System.out.println("닉네임 변경 실패");
				}else if(result == 3){
					System.out.println("이미 존재하는 닉네임입니다");
				}else {
					System.out.println("닉네임 변경 성공♡♥");	
				}
				break;
			case 3 : 
				kind = "u_mail";
				System.out.println("현재 메일주소는 '"+u.getuMail()+"'입니다.");
				System.out.println("변경 할 메일주소 > ");
				u.setuMail(sc.nextLine());
				result = UserDAO.getInstance().updateUser(kind, u);
				if(result > 0) {
					System.out.println("메일 정보 수정 완료");
				}else {
					System.out.println("메일 정보 수정 실패");
				}	
				break;
			}
		}else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
	}
	
	//회원 - 회원 탈퇴
	public void delMyInfo() {
		System.out.println("비밀번호를 입력하세요 > ");
		String uPw = sc.nextLine();
		if(userInfo.getuPw().equals(uPw)) {
			System.out.println("정말로 우리를 떠나실건가요?ㅠ0ㅠ (Y/N)");
			String yn = sc.nextLine();
			if(yn.equals("y")||yn.equals("Y")) {
				int result = UserDAO.getInstance().deleteUser(userInfo.getuId());
				if(result > 0) {
					userInfo = null;
					System.out.println("감사합니다♡♥ 다음에 또 만나요!");
				}
			}else {
				System.out.println("감사합니다♡♥ 앞으로도 잘 부탁 드려요!");
			}
		}else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
	}
	
	//회원 - 출석체크
	public void attendCheck() {
		Users u = userInfo;
		int att = UserDAO.getInstance().attendCount(u.getuId());
		UserDAO.getInstance().attendLog(u.getuId());
		int att2 = UserDAO.getInstance().attendCount(u.getuId());
		if(att == att2) {
			System.out.println("♧오늘 이미 출석체크를 하셨습니다.");
			System.out.println("현재 출석수 : "+u.getuAttend()+"회");
		}else {
			u.setuAttend(u.getuAttend()+1);
			int result = UserDAO.getInstance().attendCheck(u);
			if(result > 0) {
				System.out.println("♧"+u.getuAttend()+"회 출석 완료되었습니다-`♡´-");
			}else {
				System.out.println("출석체크 중 오류가 발생하였습니다 관리자에게 문의하세요.");
			}
		}
	}
	
	//회원 - 글 수
	public void postCheck() {
		Users u = userInfo;
		u.setuPost(u.getuPost()+1);
		int result = UserDAO.getInstance().postCheck(u);
		if(result < 1) {
			System.out.println("글 수 업데이트 중 오류가 발생하였습니다 관리자에게 문의하세요.");
		}
	}
	
	//회원 - 댓글 수
	public void commentCheck() {
		Users u = userInfo;
		u.setuComment(u.getuComment()+1);
		int result = UserDAO.getInstance().commentCheck(u);
		if(result < 1) {
			System.out.println("댓글 수 업데이트 중 오류가 발생하였습니다 관리자에게 문의하세요.");
		}
	}
	
	//회원 - 등급업
	public void gradeUp() {
		System.out.println("============< 등급 기준 >============");
		System.out.println("	 출석수 	 글 수      댓글수");
		System.out.println("정회원     15회     10회     20회");
		System.out.println("우수회원   50회     40회     50회");
		System.out.println("특별회원   70회    100회    150회");
		System.out.println("=====================================");
		Users u = userInfo;
		String now = u.getuGrade();
		int result = 0;
		if(u.getuAttend() >= 70 && u.getuPost() >= 100 && u.getuComment() >= 150) {
			if(!now.equals("b")) {
				u.setuGrade("b");
				result = UserDAO.getInstance().gradeUp(u, "b");
			}
		}else if(u.getuAttend() >= 50 && u.getuPost() >= 40 && u.getuComment() >= 50) {
			if(!now.equals("c")) {
				u.setuGrade("c");
				result = UserDAO.getInstance().gradeUp(u, "c");
			}
		}else if(u.getuAttend() >= 15 && u.getuPost() >= 10 && u.getuComment() >= 20) {
			if(!now.equals("d")) {
				u.setuGrade("d");
				result = UserDAO.getInstance().gradeUp(u, "d");
			}
		}
		if(result > 0) {
			System.out.println("☆★레벨업을 축하합니다☆★ '"+grade(u)+"'등급이 되셨습니다.\n");
		}else {
			System.out.println("♧회원님의 현재 등급은 '"+grade(u)+"'입니다. 조건을 만족하시면 등급업이 가능합니다.\n");
			System.out.println("현재 출석 수 : "+u.getuAttend()+"글 수 :"+u.getuPost()+"댓글 수"+u.getuComment());
		}
	}
	
	//회원 - 명예의 전당
	public void fame() {
		System.out.println("‥…━━━━━━━☆ 출석 랭킹 TOP3 ☆━━━━━━━…‥");
		List<Users> list = UserDAO.getInstance().fameAttend();
		for(int i=0; i<list.size(); i++) {
			System.out.println((i+1)+"위 : "+list.get(i).getuName()+"("+guard(list.get(i).getuId())+")님 "+list.get(i).getuAttend()+"회");
		}
		System.out.println("\n‥…━━━━━━━☆ 글작성 랭킹 TOP3 ☆━━━━━━━…‥");
		list = UserDAO.getInstance().famePost();
		for(int i=0; i<list.size(); i++) {
			System.out.println((i+1)+"위 : "+list.get(i).getuName()+"("+guard(list.get(i).getuId())+")님 "+list.get(i).getuPost()+"회");
		}
		System.out.println("\n‥…━━━━━━━☆ 댓글 랭킹 TOP3 ☆━━━━━━━…‥");
		list = UserDAO.getInstance().fameComment();
		for(int i=0; i<list.size(); i++) {
			System.out.println((i+1)+"위 : "+list.get(i).getuName()+"("+guard(list.get(i).getuId())+")님 "+list.get(i).getuComment()+"회");
		}
	}
	
	//정보보안
	public String guard(String str) {
		String result = "***" + str.substring(3);
		return result;
	}
	
}
