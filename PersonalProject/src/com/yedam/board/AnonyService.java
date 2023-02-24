package com.yedam.board;

import java.util.Scanner;

import com.yedam.users.UserService;

public class AnonyService extends UserService{
	
	Scanner sc = new Scanner(System.in);
	
	//익명자유게시판 - 목록
	public void anonyBoard() {
		listAnony();
		System.out.print("1.새글쓰기 2.글읽기 3.글삭제 > ");
		int menu = Integer.parseInt(sc.nextLine());
		switch(menu) {
		case 1 :
			postAnony();
			break;
		case 2 :
			readAnony();
			break;
		case 3 :
			delAnony();
			break;
		}
	}
	
	//익명자유게시판 - 글 목록
	public void listAnony() {
		
	}
	//익명자유게시판 - 글 쓰기
	public void postAnony() {
		Anony anony = new Anony();
		System.out.println("====글쓰기====");
		anony.setuId(userInfo.getuId());
		System.out.print("글 제목 >");
		anony.setaTitle(sc.nextLine());
		System.out.println("본문 >");
		System.out.println("(작성을 끝내시려면 '/완료' 를 입력하세요.)");
		String body = "";
		while(true) {
			String temp = sc.nextLine();
			if(temp.equals("/완료")) {
				break;
			}else {
				body += temp + "\n";
			}
		}
		anony.setaBody(body);
		
		int result = AnonyDAO.getInstance().postAnony(anony);
		if(result > 0) {
			System.out.println("글 작성 완료");
		}else {
			System.out.println("글 작성 실패. 오류가 지속되면 관리자에게 문의하세요.");
		}
	}
	
	//익명자유게시판 - 글 읽기
	public void readAnony() {
		
	}
	
	//익명자유게시판 - 글 읽기 목록
	
	
	//익명자유게시판 - 글 삭제
	public void delAnony() {
		
	}
	
	//익명자유게시판 - 댓글보기
	
	
	//익명자유게시판 - 댓글달기
	
	//익명자유게시판 - 댓글삭제
}
