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
				System.out.println(".₊̣̇.ෆ˟̑*̑˚̑*̑˟̑ෆ."+grade(userInfo)+" '"+UserService.userInfo.getuName()+"'님 환영합니다.ෆ˟̑*̑˚̑*̑˟̑ෆ.₊̣̇.");
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
		
		System.out.println("===회원 가입===");
		System.out.println("아이디 > ");
		u.setuId(sc.nextLine());
		System.out.println("비밀번호 > ");
		u.setuPw(sc.nextLine());
		System.out.println("닉네임 > ");
		u.setuName(sc.nextLine());
		System.out.println("메일주소 > ");
		u.setuMail(sc.nextLine());
		
		int result = UserDAO.getInstance().joinUser(u);
		
		if(result == 2) {
			System.out.println("회원 가입 실패 : 이미 존재하는 ID입니다.");
		}else if(result == 3) {
			System.out.println("회원 가입 실패 : 이미 존재하는 닉네임입니다.");
		}else if(result == 1) {
			System.out.println("회원 가입 성공! 환영합니다~");
		}else {
			System.out.println("회원 가입 실패");
		}
	}
	
	//로그아웃
	public void loguot() {
		System.out.println("성공적으로 로그아웃 되었습니다.\n");
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
		System.out.println(".₊̣̇.ෆ˟̑*̑˚̑*̑˟̑ෆ.₊̣̇.ෆ˟̑*̑˚̑*̑˟̑ෆ.₊̣̇.ෆ˟̑*̑˚̑*̑˟̑ෆ.₊̣̇.ෆ˟̑*̑˚̑*̑˟̑ෆ.₊̣̇");
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
	
	
	
	
	//관리자 - 강제 탈퇴
	
	
	//회원 - 마이페이지
	public void myPage() {
		System.out.println("1.출석체크 | 2.등업신청 | 3.내 정보 조회 | 4.내 정보 수정 | 5.회원탈퇴");
		System.out.print("이동을 원하는 메뉴를 입력하세요 > ");
		int menu = Integer.parseInt(sc.nextLine());
		switch(menu) {
		case 1:
			
			break;
		case 2:
			
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
		}
		
	}
	
	//회원 - 본인 정보 조회
	public void getMyInfo() {
		Users u = userInfo;
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
					
					int result = UserDAO.getInstance().updateUser(kind, u);
					if(result > 0) {
						System.out.println("비밀번호 수정 완료");
					}else {
						System.out.println("비밀번호 수정 실패");
					}	
				}else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
				break;
			case 2 :
				kind = "u_name";
				break;
			case 3 : 
				kind = "u_mail";
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
			System.out.println("정말로 우리를 떠나실건가요?ㅠ0ㅠ");	
		}else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
	}
	
	//회원 - 출석체크
	
	//회원 - 등급업
	
}
