package com.yedam.board;

import com.yedam.common.DAO;

public class SuggestDAO extends DAO{
	//싱글톤
	private static SuggestDAO suDao = new SuggestDAO();
	
	private SuggestDAO() {
	}
	
	public static SuggestDAO getInstance() {
		return suDao;
	}
	
	//회원 - 글쓰기
	public int postSuggest(Suggest su) {
		int result = 0;
		try {
			conn();
			String sql = "insert into anony values (suggest_seq.nextval,sysdate,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, su.getSuKind());
			pstmt.setString(2, su.getSuTitle());
			pstmt.setString(3, su.getSuBody());
			pstmt.setString(4, su.getuId());
			pstmt.setString(5, su.getuName());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//회원 - 내가 쓴 글
	
	//운영진 - 건의 게시판 전체 목록
		
	//건의게시판 - 댓글 달기
}
