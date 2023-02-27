package com.yedam.board;

import java.util.ArrayList;
import java.util.List;

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
			String sql = "insert into suggest values (suggest_seq.nextval,sysdate,?,?,?,?,?)";
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
	public List<Suggest> myfnqList(String id){
		List<Suggest> list = new ArrayList<>();
		Suggest gg = null;
		try {
			conn();
			String sql = "select * from suggest where u_id = ? order by su_id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				gg = new Suggest();
				gg.setSuId(rs.getInt("su_id"));
				gg.setSuDate(rs.getDate("su_date"));
				gg.setSuKind(rs.getString("su_kind"));
				gg.setSuTitle(rs.getString("su_title"));
				gg.setSuBody(rs.getString("su_body"));
				gg.setuId(rs.getString("u_id"));
				gg.setuName(rs.getString("u_name"));
				list.add(gg);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//운영진 - 건의 게시판 전체 목록
	public List<Suggest> fnqList(){
		List<Suggest> list = new ArrayList<>();
		Suggest gg = null;
		try {
			conn();
			String sql = "select * from suggest order by su_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				gg = new Suggest();
				gg.setSuId(rs.getInt("su_id"));
				gg.setSuDate(rs.getDate("su_date"));
				gg.setSuKind(rs.getString("su_kind"));
				gg.setSuTitle(rs.getString("su_title"));
				gg.setSuBody(rs.getString("su_body"));
				gg.setuId(rs.getString("u_id"));
				gg.setuName(rs.getString("u_name"));
				list.add(gg);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//글삭
	public int delSuggest(Suggest gg) {
		int result = 0;
		try {
			conn();
			String sql = "delete from suggestcomm where su_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gg.getSuId());
			result = pstmt.executeUpdate();
			sql = "delete from suggest where su_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gg.getSuId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//건의게시판 - 댓글 달기
	public int addSuggestComm(Suggest gg) {
		int result = 0;
		try {
			conn();
			String sql = "insert into suggestcomm values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gg.getSucBody());
			pstmt.setString(2, gg.getuId());
			pstmt.setInt(3, gg.getSuId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//댓글목록
	public List<Suggest> listSuggestComm(int key){
		List<Suggest> list = new ArrayList<>();
		Suggest gg = null;
		try {
			conn();
			String sql = "select a.suc_body, u_id, a.su_id, u.u_name\r\n"
					+ "from suggestcomm a natural join users u\r\n"
					+ "where su_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, key);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				gg = new Suggest();
				gg.setSuId(rs.getInt("su_id"));
				gg.setuId(rs.getString("u_id"));
				gg.setSucBody(rs.getString("suc_body"));
				gg.setuName(rs.getString("u_name"));
				list.add(gg);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//댓글수 카운트
	public int countSuComm(int key) {
		int result = 0;
		try {
			conn();
			String sql = "select count(suc_body) num\r\n"
					+ "from suggestcomm\r\n"
					+ "where su_id = ?\r\n"
					+ "group by su_id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, key);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("num");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
}
