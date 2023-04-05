package com.yedam.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yedam.store.StoreDAO;
import com.yedam.users.UserService;

public class SuggestService extends UserService{
	
	Scanner sc = new Scanner(System.in);
	List<Suggest> list = new ArrayList<>();
	Suggest ggpost = null;
	
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
		Suggest gg = new Suggest();
		gg.setuId(userInfo.getuId());
		gg.setuName(userInfo.getuName());
		System.out.println("\n1.신고 | 2.건의 | 3.기타문의");
		String mal = sc.nextLine();
		if(mal.equals("1")) {
			gg.setSuKind("신고");
		}else if(mal.equals("2")) {
			gg.setSuKind("건의");
		}else {
			gg.setSuKind("기타문의");
		}
		System.out.print("글 제목 > ");
		gg.setSuTitle(sc.nextLine());
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
		gg.setSuBody(body);
		int result = SuggestDAO.getInstance().postSuggest(gg);
		if(result > 0) {
			System.out.println("글 작성 완료");
			postCheck();
		}else {
			System.out.println("글 작성 실패. 오류가 지속되면 관리자에게 문의하세요.");
		}
	}
	
	//건의게시판(회원) - 내가 쓴 글 조회
	public void suggestRead() {
		String id = null;
		if(userInfo.getuGrade().equals("a")) {
			System.out.println("작성자 아이디 > ");
			id = sc.nextLine();
		}else {
			id = userInfo.getuId();
		}
		int sel = 0;
		while(sel != 3) {
			list = SuggestDAO.getInstance().myfnqList(id);
			System.out.println("글번호  종류\t  제목       작성자      작성일 \t처리상태 ");
			System.out.println("---------------------------------------------------------------");
			for(int i=0; i<list.size(); i++) {
				System.out.println("  "+(i+1)+"   "+list.get(i).getSuKind()+"  "+list.get(i).getSuTitle()+"	 "+list.get(i).getuName()+"   "+list.get(i).getSuDate()+"   "+countSuggestComm(list.get(i)));
			}
			System.out.println("---------------------------------------------------------------");
			System.out.print("1.글 읽기 | 2.글 삭제 | 3.뒤로가기");
			sel = Integer.parseInt(sc.nextLine());
			if(sel == 1) {
				readSuggest();
			}else if(sel == 2) {
				delSuggest();
			}else {
				break;
			}
		}
	}

	//건의 게시판(관리자) - 글목록
	public void suggestList() {
		int sel = 0;
		while(sel != 3) {
			list = SuggestDAO.getInstance().fnqList();
			System.out.println("글번호  종류\t  제목       작성자      작성일 \t처리상태 ");
			System.out.println("---------------------------------------------------------------");
			for(int i=0; i<list.size(); i++) {
				System.out.println("  "+(i+1)+"   "+list.get(i).getSuKind()+"  "+list.get(i).getSuTitle()+" \t"
						+list.get(i).getuName()+"   "+list.get(i).getSuDate()+"   "+countSuggestComm(list.get(i)));
			}
			System.out.println("---------------------------------------------------------------");
			System.out.print("1.글 읽기 | 2.글 삭제 | 3.뒤로가기");
			sel = Integer.parseInt(sc.nextLine());
			if(sel == 1) {
				readSuggest();
			}else if(sel == 2) {
				delSuggest();
			}else {
				break;
			}
		}
	}
	
	//글읽기
	private void readSuggest() {
		ggpost = new Suggest();
		int sel = 0;
		System.out.print("조회할 글 번호 > ");
		int num = Integer.parseInt(sc.nextLine());
		ggpost = list.get(num-1);
		while(sel != 2) {
			System.out.println("=====================================================");
			System.out.println(" ["+ggpost.getSuKind()+"] "+ggpost.getSuTitle());
			System.out.println(" "+ggpost.getuName()+"		"+ggpost.getSuDate());
			System.out.println("-----------------------------------------------------");
			System.out.println(" "+ggpost.getSuBody());
			System.out.println("== ▼ 댓글 ==========================================");
			List<Suggest> listcomm = SuggestDAO.getInstance().listSuggestComm(ggpost.getSuId());
			for(int i=0; i<listcomm.size(); i++) {
				System.out.println("ㄴ "+listcomm.get(i).getSucBody()+"\t("+listcomm.get(i).getuName()+")");
			}
			System.out.println("\n-----------1.댓글작성----------2.뒤로가기------------");
			sel = Integer.parseInt(sc.nextLine());
			if(sel == 1) {
				addSuggestComm();
			}else {
				break;
			}
		}	
	}
	
	//글삭제
	public void delSuggest() {
		Suggest gg = new Suggest();
		System.out.print("삭제할 글 번호 > ");
		int num = Integer.parseInt(sc.nextLine());
		gg = list.get(num-1);
		if(gg.getuId().equals(userInfo.getuId()) || userInfo.getuGrade().equals("a")){
			int result = SuggestDAO.getInstance().delSuggest(gg);
			if(result>0) {
				System.out.println("작성글이 삭제되었습니다.");
			}else {
				System.out.println("글 삭제중 오류가 발생하였습니다.");
			}
		}else {
			System.out.println("본인이 작성한 글만 삭제할 수 있습니다.");
		}
	}
	
	//건의게시판(관리자) - 댓글달기
	public void addSuggestComm() {
		Suggest su = new Suggest();
		su.setuId(userInfo.getuId());
		su.setSuId(ggpost.getSuId());
		System.out.println("댓글내용 >	");
		su.setSucBody(sc.nextLine());
		int result = SuggestDAO.getInstance().addSuggestComm(su);
		if(result > 0) {
			System.out.println("댓글 작성 완료");
			commentCheck();
		}else {
			System.out.println("댓글 작성 실패. 오류가 지속되면 관리자에게 문의하세요.");
		}
	}
	
	//댓글수 카운트
	public String countSuggestComm(Suggest gg) {
		String result = null;
		int count = SuggestDAO.getInstance().countSuComm(gg.getSuId());
		if(count > 0 ) {
			result = "처리완료";
		}else {
			result = "처리중";
		}
		return result;
	}
	
}
