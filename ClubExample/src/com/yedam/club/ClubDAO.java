package com.yedam.club;

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
	
	//모든 회원 조회 (가입일순)
	
	//아이디로 회원 조회
	
	//이메일 변경
	
	//소모임 강제 탈퇴
	
	
}
