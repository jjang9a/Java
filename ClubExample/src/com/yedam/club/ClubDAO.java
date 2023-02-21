package com.yedam.club;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class ClubDAO extends DAO{
	//싱글톤
	private static ClubDAO cDao = new ClubDAO();
	
	private ClubDAO() {
		
	}
	
	public static ClubDAO getInstance() {
		return cDao;
	}
	
	//로그인 기능
	public Club login(String id) {
		Club c = null;
		
		try {
			conn();
			String sql = "SELECT *\r\n"
					+ "FROM club\r\n"
					+ "WHERE c_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				c = new Club();
				c.setcId(rs.getString("c_id"));
				c.setcName(rs.getString("c_name"));
				c.setcDate(rs.getDate("c_date"));
				c.setcMail(rs.getString("c_mail"));
				c.setcAge(rs.getInt("c_age"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return c;
	}

	//새 회원 등록
	public int insertClub(Club c) {
		int result = 0;
		try {
			conn();
			String sql = "insert into club values (?,?,sysdate,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getcId());
			pstmt.setString(2, c.getcName());
			pstmt.setString(3, c.getcMail());
			pstmt.setInt(4, c.getcAge());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
		
	//모든 회원 조회 (가입일순)
	public List<Club> getClubList(){
		List<Club> list = new ArrayList<>();
		Club c = null;
		try {
			conn();
			String sql = "SELECT *\n"
					+ "FROM club\n"
					+ "ORDER BY c_date";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				c = new Club();
				c.setcId(rs.getString("c_id"));
				c.setcName(rs.getString("c_name"));
				c.setcDate(rs.getDate("c_date"));
				c.setcMail(rs.getString("c_mail"));
				c.setcAge(rs.getInt("c_age"));
				
				list.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;		
	}

	//아이디로 회원 조회
	public Club getClub(String key) {
		Club c = null;
		try {
			conn();
			String sql = "select * from club where c_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			c = new Club();
			c.setcId(rs.getString("c_id"));
			c.setcName(rs.getString("c_name"));
			c.setcDate(rs.getDate("c_date"));
			c.setcMail(rs.getString("c_mail"));
			c.setcAge(rs.getInt("c_age"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return c;
	}

	//이메일 변경
	public int updateClub(Club c) {
		int result = 0;
		try {
			conn();
			String sql = "update club set c_mail = ? where c_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getcMail());
			pstmt.setString(2, c.getcId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//소모임 강제 탈퇴
	public int deleteClub(String cId) {
		int result = 0;
		try {
			conn();
			String sql = "delete from club where c_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cId);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

}
