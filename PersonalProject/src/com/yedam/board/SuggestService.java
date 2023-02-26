package com.yedam.board;

import java.util.Scanner;

import com.yedam.users.UserService;

public class SuggestService extends UserService{
	
	Scanner sc = new Scanner(System.in);
	
	//건의게시판
	public void suggestBoard() {
		int sel = 0;
		while(sel != 3) {
			System.out.print("1.글쓰기 | 2.내 문의 확인 | 3.뒤로가기");
			sel = Integer.parseInt(sc.nextLine());
			if(sel == 1) {
				postSug();
			}else if(sel == 2) {
				suggestRead();
			}else {
				break;
			}
		}
	}
	
	//건의게시판 - 글쓰기
	public void postSug() {
		
	}
	
	//건의게시판(회원) - 내가 쓴 글 조회
	public void suggestRead() {
		
	}
		
	//건의 게시판(관리자) - 글목록
	public void suggestList() {
		
	}
	
	//건의게시판(관리자) - 댓글달기
}
