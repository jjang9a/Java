package com.yedam.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yedam.users.UserService;

public class AnonyService extends UserService{
	
	Scanner sc = new Scanner(System.in);
	List<Anony> list = new ArrayList<>();
	
	//익명자유게시판 - 목록
	public void anonyBoard() {
		int sel = 0;
		while(sel != 4) {
			list = AnonyDAO.getInstance().anonyList();
			System.out.println(" 글번호      가게이름       작성자      작성일 ");
			System.out.println("----------------------------------------");
			for(int i=0; i<list.size(); i++) {
				System.out.println("  "+(i+1)+"   "+list.get(i).getaTitle()+"	(익명)	"+list.get(i).getaDate());
			}
			System.out.println("----------------------------------------");
			System.out.print("1.글쓰기 | 2.읽기 | 3.글 삭제 | 4.뒤로가기");
			sel = Integer.parseInt(sc.nextLine());
			if(sel == 2) {
				readAnony();
			}else if(sel == 3) {
				delAnony();
			}else if(sel == 1){
				postAnony();
			}else {
				break;
			}
		}
	}

	//익명자유게시판 - 글 쓰기
	public void postAnony() {
		Anony anony = new Anony();
		System.out.println("====글쓰기====");
		anony.setuId(userInfo.getuId());
		System.out.print("글 제목 > ");
		anony.setaTitle(sc.nextLine());
		System.out.println("본문 >	(작성을 끝내시려면 '/완료' 를 입력하세요.)");
		System.out.println("");
		String body = "";
		while(true) {
			String temp = sc.nextLine();
			if(temp.equals("/완료")) {
				break;
			}else {
				body += temp + "\n ";
			}
		}
		anony.setaBody(body);
		
		int result = AnonyDAO.getInstance().postAnony(anony);
		if(result > 0) {
			System.out.println("글 작성 완료");
			postCheck();
		}else {
			System.out.println("글 작성 실패. 오류가 지속되면 관리자에게 문의하세요.");
		}
	}
	
	//익명자유게시판 - 글 읽기
	public void readAnony() {
		Anony a = new Anony();
		System.out.print("조회할 글 번호 > ");
		int num = Integer.parseInt(sc.nextLine());
		a = list.get(num-1);
		System.out.println("=============================");
		System.out.println(" 제목 : " +a.getaTitle());
		System.out.println(" (익명)		"+a.getaDate());
		System.out.println("-----------------------------");
		System.out.println(" "+a.getaBody());
		System.out.println("=============================");
	}

	//익명자유게시판 - 글 삭제
	public void delAnony() {
		Anony a = new Anony();
		System.out.print("삭제할 글 번호 > ");
		int num = Integer.parseInt(sc.nextLine());
		a = list.get(num-1);
		if(a.getuId().equals(userInfo.getuId())){
			int result = AnonyDAO.getInstance().delAnony(a);
			if(result>0) {
				System.out.println("작성글이 삭제되었습니다.");
			}else {
				System.out.println("글 삭제중 오류가 발생하였습니다.");
			}
		}else {
			System.out.println("본인이 작성한 글만 삭제할 수 있습니다.");
		}
	}
	
	//익명자유게시판 - 댓글보기
	
	
	//익명자유게시판 - 댓글달기
	
	//익명자유게시판 - 댓글삭제
}
