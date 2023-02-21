package com.yedam.club;

import java.util.Scanner;

public class ClubService {
	public static Club clubInfo = null;
	Scanner sc = new Scanner(System.in);
	
	//로그인 기능
	public void login() {
		Club club = null;
		System.out.println("ID > ");
		String clubId = sc.nextLine();
		
		club = ClubDAO.getInstance().login(clubId);
		
		if(club != null && club.getcId().equals("system")) {
			System.out.println("관리자 계정으로 접속하였습니다.");
			clubInfo = club;
		}else {
			System.out.println("관리자가 아닙니다.");
		}
	}
	
	//새 회원 등록
	
	//모든 회원 조회 (가입일순)
	
	//아이디로 회원 조회
	
	//이메일 변경
	
	//소모임 강제 탈퇴
	
	
}
