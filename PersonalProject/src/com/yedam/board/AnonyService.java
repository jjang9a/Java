package com.yedam.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yedam.users.UserService;

public class AnonyService extends UserService{
	
	Scanner sc = new Scanner(System.in);
	List<Anony> list = new ArrayList<>();
	Anony apost = new Anony();
	
	//익명자유게시판 - 목록
	public void anonyBoard() {
		int sel = 0;
		while(sel != 4) {
		list = AnonyDAO.getInstance().anonyList();
		System.out.println(" 글번호      제목       작성자     작성일 ");
		System.out.println("--------------------------------------------------");
		for(int i=0; i<list.size(); i++) {
			System.out.println("  "+(i+1)+"   "+list.get(i).getaTitle()+"\t  (익명)  "+list.get(i).getaDate());
		}
		System.out.println("--------------------------------------------------");

			System.out.print("1.글읽기 | 2.새글쓰기 | 3.글 삭제 | 4.뒤로가기");
			sel = Integer.parseInt(sc.nextLine());
			if(sel == 1) {
				readAnony();
			}else if(sel == 3) {
				delAnony();
			}else if(sel == 2){
				postAnony();
			}else {
				break;
			}
		}
	}

	//익명자유게시판 - 글 쓰기
	public void postAnony() {
		Anony anony = new Anony();
		anony.setuId(userInfo.getuId());
		System.out.print("\n글 제목 > ");
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
		apost = new Anony();
		int sel = 0;
		System.out.print("조회할 글 번호 > ");
		int num = Integer.parseInt(sc.nextLine());
		apost = list.get(num-1);
		while(sel != 2) {
			System.out.println("=====================================================");
			System.out.println(" 제목 : " +apost.getaTitle());
			System.out.println(" (익명)		"+apost.getaDate());
			System.out.println("-----------------------------------------------------");
			System.out.println(apost.getaBody());
			System.out.println("== ▼ 댓글 ==========================================");
			List<Anony> listcomm = AnonyDAO.getInstance().listAnonyComm(apost.getaId());
			for(int i=0; i<listcomm.size(); i++) {
				System.out.println("ㄴ "+listcomm.get(i).getAcBody()+"\t(익명)");
			}
			System.out.println("\n-----------1.댓글작성----------2.뒤로가기------------");
			sel = Integer.parseInt(sc.nextLine());
			if(sel == 1) {
				addAnonyComm();
			}else {
				break;
			}
		}
	}

	//익명자유게시판 - 글 삭제
	public void delAnony() {
		Anony a = new Anony();
		System.out.print("삭제할 글 번호 > ");
		int num = Integer.parseInt(sc.nextLine());
		a = list.get(num-1);
		if(a.getuId().equals(userInfo.getuId()) || userInfo.getuGrade().equals("a")){
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

	//익명자유게시판 - 댓글달기
	public void addAnonyComm() {
		Anony anony = new Anony();
		anony.setuId(userInfo.getuId());
		anony.setaId(apost.getaId());
		System.out.println("댓글내용 >	");
		anony.setAcBody(sc.nextLine());
		int result = AnonyDAO.getInstance().addAnonyComm(anony);
		if(result > 0) {
			System.out.println("댓글 작성 완료");
			commentCheck();
		}else {
			System.out.println("댓글 작성 실패. 오류가 지속되면 관리자에게 문의하세요.");
		}
	}
}
