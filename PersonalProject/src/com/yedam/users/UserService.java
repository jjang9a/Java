package com.yedam.users;

import java.util.List;
import java.util.Scanner;

public class UserService {

	public static Users userInfo = null;
	Scanner sc = new Scanner(System.in);
	
	//로그인 기능
	public void login() {
		Users u = null;
		System.out.println("ID > ");
		String uId = sc.nextLine();
		System.out.println("PW > ");
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
	
	//관리자 - 회원 정보 수정
	
	//관리자 - 강제 탈퇴
	
	
	
}
