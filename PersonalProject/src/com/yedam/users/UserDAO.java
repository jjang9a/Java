package com.yedam.users;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class UserDAO extends DAO{
	//싱글톤
	private static UserDAO uDao = new UserDAO();
	
	private UserDAO() {
	}
	public static UserDAO getInstance() {
		return uDao;
	}
	
	//로그인 기능
	public Users login(String id) {
		Users u = null;
		try {
			conn();
			String sql = "SELECT *\r\n"
					+ "FROM users\r\n"
					+ "WHERE u_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				u = new Users();
				u.setuId(rs.getString("u_id"));
				u.setuPw(rs.getString("u_pw"));
				u.setuName(rs.getString("u_name"));
				u.setuMail(rs.getString("u_mail"));
				u.setuDate(rs.getDate("u_date"));
				u.setuGrade(rs.getString("u_grade"));
				u.setuAttend(rs.getInt("u_attend"));
				u.setuPost(rs.getInt("u_post"));
				u.setuComment(rs.getInt("u_comment"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return u;
	}

	//회원가입 중복 체크 - 가입
	public int joinUser(Users u) {
		int result = 0;
		try {
			conn();
			String sql = "select count(u_id)\r\n"
					+ "from users\r\n"
					+ "where u_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getuId());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt("count(u_id)") != 0) {
					result = 2;
				}else {
					sql = "select count(u_name)\r\n"
							+ "from users\r\n"
							+ "where u_name = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, u.getuName());
					
					rs = pstmt.executeQuery();
					if(rs.next()) {
						if(rs.getInt("count(u_name)") != 0) {
							result = 3;
						}else {
							sql = "insert into users values (?,?,?,?,sysdate,'e',0,0,0)";
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, u.getuId());
							pstmt.setString(2, u.getuPw());
							pstmt.setString(3, u.getuName());
							pstmt.setString(4, u.getuMail());
							result = pstmt.executeUpdate();
						}
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}

	//관리자 - 전체 회원 조회
	public List<Users> getUserList(){
		List<Users> list = new ArrayList<>();
		Users u = null;
		try {
			conn();
			String sql = "select * from users";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				u = new Users();
				u.setuId(rs.getString("u_id"));
				u.setuPw(rs.getString("u_pw"));
				u.setuName(rs.getString("u_name"));
				u.setuMail(rs.getString("u_mail"));
				u.setuDate(rs.getDate("u_date"));
				u.setuGrade(rs.getString("u_grade"));
				u.setuAttend(rs.getInt("u_attend"));
				u.setuPost(rs.getInt("u_post"));
				u.setuComment(rs.getInt("u_comment"));
				list.add(u);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//관리자 - 개인 조회
	public Users getUser(String kind, String user) {
		Users u = null;
		try {
			conn();
			String sql = "select * from users where "+kind+" = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				u = new Users();
				u.setuId(rs.getString("u_id"));
				u.setuName(rs.getString("u_name"));
				u.setuMail(rs.getString("u_mail"));
				u.setuDate(rs.getDate("u_date"));
				u.setuGrade(rs.getString("u_grade"));
				u.setuAttend(rs.getInt("u_attend"));
				u.setuPost(rs.getInt("u_post"));
				u.setuComment(rs.getInt("u_comment"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return u;
	}
	
	//회원 정보 수정
	//등급, 닉네임, 비밀번호
	public int updateUser(String kind, Users u) {
		int result = 0;
		try {
			conn();
			if(kind.equals("u_name")) {
				String sql = "select count(u_name)\r\n"
						+ "from users\r\n"
						+ "where u_name = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, u.getuName());
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getInt("count(u_name)") != 0) {
						result = 3;
					}else {
						sql = "update users set u_name = ? where u_id = ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, u.getuName());
						pstmt.setString(2, u.getuId());
						
						result = pstmt.executeUpdate();
					}
				}
			}else {
				String sql = "update users set "+kind+" = ? where u_id = ?";
				pstmt = conn.prepareStatement(sql);
				if(kind.equals("u_grade")) {
					pstmt.setString(1, u.getuGrade());
				}else if(kind.equals("u_pw")) {
					pstmt.setString(1, u.getuPw());
				}else if(kind.equals("u_mail")) {
					pstmt.setString(1, u.getuMail());
				}
				pstmt.setString(2, u.getuId());
				
				result = pstmt.executeUpdate();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;	
	}
	
	//회원 탈퇴 (강제, 자의)
	public int deleteUser(String uId) {
		int result = 0;
		try {
			conn();
			String sql = "delete from users where u_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uId);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//회원 - 출석체크
	public int attendCheck(Users u) {
		int result = 0;
		try {
			conn();
			String sql = "update users set u_attend = ? where u_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, u.getuAttend());
			pstmt.setString(2, u.getuId());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//회원 - 레벨업
	public int gradeUp(Users u, String grade) {
		int result = 0;
		try {
			conn();
			String sql = "update users set u_grade = ? where u_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, grade);
			pstmt.setString(2, u.getuId());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//회원 - 명예의 전당(출석)
	public Users[] fameAttend() {
		Users[] list = new Users[3];
		Users u = null;
		try {
			conn();
			String sql = "select u_id, u_name, u_attend\n"
					+ "from users\n"
					+ "where u_attend != 0\n"
					+ "order by u_attend desc;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				for(int i=0; i<3; i++) {
					u = new Users();
					u.setuId(rs.getString("u_id"));
					u.setuName(rs.getString("u_name"));
					u.setuAttend(rs.getInt("u_attend"));
					list[i] = u;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//회원 - 명예의 전당(글)
	public Users famePost() {
		Users u = null;
		try {
			conn();
			String sql = "select u_id, u_name, u_post\n"
					+ "from users\n"
					+ "where u_post != 0\n"
					+ "order by u_post desc;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				u = new Users();
				u.setuId(rs.getString("u_id"));
				u.setuName(rs.getString("u_name"));
				u.setuPost(rs.getInt("u_post"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return u;
	}
	//회원 - 명예의 전당(댓글)
	public Users[] fameComment() {
		Users[] list = new Users[3];
		Users u = null;
		try {
			conn();
			String sql = "select u_id, u_name, u_comment\n"
					+ "from users\n"
					+ "where u_comment != 0\n"
					+ "order by u_comment desc;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				for(int i=0; i<3; i++) {
					u = new Users();
					u.setuId(rs.getString("u_id"));
					u.setuName(rs.getString("u_name"));
					u.setuComment(rs.getInt("u_comment"));
					list[i] = u;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//관리자 - 글 댓글 수정
	
	//관리자 - 글 댓글 삭제
	
}
