package com.yedam.board;

import java.util.ArrayList;
import java.util.List;

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
	public List<Anony> anonyList(){
		List<Anony> list = new ArrayList<>();
		Anony a = null;
		try {
			conn();
			String sql = "select * from anony order by a_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = new Anony();
				a.setaId(rs.getInt("a_id"));
				a.setuId(rs.getString("u_id"));
				a.setaTitle(rs.getString("a_title"));
				a.setaBody(rs.getString("a_body"));
				a.setaDate(rs.getDate("a_date"));
				list.add(a);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
		
	//익명자유게시판 - 글 삭제
	public int delAnony(Anony a) {
		int result = 0;
		try {
			conn();
			String sql = "delete from anony where a_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, a.getaId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//익명자유게시판 - 댓글
	
	
	//익명자유게시판 - 댓글달기
	
	//익명자유게시판 - 댓글삭제

	
	
	
	
	

}
