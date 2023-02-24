package com.yedam.board;

import com.yedam.common.DAO;

public class AnonyDAO extends DAO{
	//싱글톤
	private static AnonyDAO bDao = new AnonyDAO();
	
	private AnonyDAO() {
		
	}
	public static AnonyDAO getInstance() {
		return bDao;
	}
	
	//익명자유게시판 - 글쓰기
	public int postAnony(Anony anony) {
		int result = 0;
		try {
			conn();
			String sql = "insert into anony values (anony_seq.nextval,sysdate,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, anony.getaTitle());
			pstmt.setString(2, anony.getaBody());
			pstmt.setString(3, anony.getuId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//익명자유게시판 - 글 목록
	
	//익명자유게시판 - 글 읽기
	public Anony readAnony() {
		Anony a = new Anony();
		
		return a;
	}
	//익명자유게시판 - 댓글
	
	//익명자유게시판 - 글 삭제
	
	//익명자유게시판 - 댓글달기
	
	//익명자유게시판 - 댓글삭제

	
	
	
	
	

}
