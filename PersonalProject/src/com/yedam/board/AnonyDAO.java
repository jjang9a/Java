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
			String sql = "delete from anonycomm where a_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, a.getaId());
			result = pstmt.executeUpdate();
			sql = "delete from anony where a_id = ?";
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
	public List<Anony> listAnonyComm(int key){
		List<Anony> list = new ArrayList<>();
		Anony a = null;
		try {
			conn();
			String sql = "select a.ac_date, a.ac_body, u_id, a.ac_id, a.a_id, u.u_name\r\n"
					+ "from anonycomm a natural join users u\r\n"
					+ "where a_id = ? \r\n"
					+ "order by ac_id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, key);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = new Anony();
				a.setaId(rs.getInt("a_id"));
				a.setuId(rs.getString("u_id"));
				a.setAcBody(rs.getString("ac_body"));
				a.setAcDate(rs.getDate("ac_date"));
				a.setuName(rs.getString("u_name"));
				list.add(a);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//익명자유게시판 - 댓글달기
	public int addAnonyComm(Anony a) {
		int result = 0;
		try {
			conn();
			String sql = "insert into anonycomm values (sysdate,?,?,anonycomm_seq.nextval,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getAcBody());
			pstmt.setString(2, a.getuId());
			pstmt.setInt(3, a.getaId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}

}
