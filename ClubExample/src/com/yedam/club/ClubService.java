package com.yedam.club;

import java.util.List;
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
	public void insertClub() {
		Club c = new Club();
		
		System.out.println("======신규 회원 등록======");
		System.out.println("ID > ");
		c.setcId(sc.nextLine());
		System.out.println("이름 > ");
		c.setcName(sc.nextLine());
		System.out.println("메일 주소 > ");
		c.setcMail(sc.nextLine());
		System.out.println("나이 > ");
		c.setcAge(Integer.parseInt(sc.nextLine()));
		
		int result = ClubDAO.getInstance().insertClub(c);
		
		if(result > 0) {
			System.out.println("회원 등록 완료");
		}else {
			System.out.println("회원 등록 실패");
		}
	}
	
	//모든 회원 조회 (가입일순)
	public void getClubList() {
		List<Club> list = ClubDAO.getInstance().getClubList();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}

	//아이디로 회원 조회
	public void getClub() {
		System.out.println("조회 할 ID > ");
		Club c = ClubDAO.getInstance().getClub(sc.nextLine());
		if(c == null) {
			System.out.println("해당 데이터 없음");
		}else {
			System.out.println(c.toString());
		}
	}

	//이메일 변경
	public void updateClub() {
		Club c = new Club();
		System.out.println("======메일 정보 수정======");
		System.out.println("정보를 수정 할 ID > ");
		c.setcId(sc.nextLine());
		System.out.println("새 메일 주소 > ");
		c.setcMail(sc.nextLine());
		int result = ClubDAO.getInstance().updateClub(c);
		
		if(result > 0) {
			System.out.println("메일 정보 수정 완료");
		}else {
			System.out.println("메일 정보 수정 실패");
		}	
	}
	
	//소모임 강제 탈퇴
	public void deleteClub() {
		System.out.println("======회원 강제 탈퇴======");
		System.out.println("탈퇴 처리 할 ID > ");
		int result = ClubDAO.getInstance().deleteClub(sc.nextLine());
		
		if(result > 0) {
			System.out.println("강제 탈퇴 완료");
		}else {
			System.out.println("강제 탈퇴 실패");
		}
	}
	//로그아웃
	public void loguot() {
		clubInfo = null;
		System.out.println("성공적으로 로그아웃 되었습니다.");
	}
}
