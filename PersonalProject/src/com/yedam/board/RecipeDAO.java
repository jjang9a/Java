package com.yedam.board;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class RecipeDAO extends DAO{
	//싱글톤
	private static RecipeDAO rDao = new RecipeDAO();
	
	private RecipeDAO() {
	}
	
	public static RecipeDAO getInstance() {
		return rDao;
	}
	
	//레시피 게시판 - 글 작성
	public int postRecipe(Recipe r) {
		int result = 0;
		try {
			conn();
			String sql = "insert into recipe values (recipe_seq.nextval,sysdate,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getrTitle());
			pstmt.setString(2, r.getrBody());
			pstmt.setString(3, r.getuId());
			pstmt.setString(4, r.getuName());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//레시피게시판 - 글목록
	public List<Recipe> recipeList(){
		List<Recipe> list = new ArrayList<>();
		Recipe a = null;
		try {
			conn();
			String sql = "select * from recipe order by r_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = new Recipe();
				a.setrId(rs.getInt("r_id"));
				a.setuId(rs.getString("u_id"));
				a.setrTitle(rs.getString("r_title"));
				a.setrBody(rs.getString("r_body"));
				a.setrDate(rs.getDate("r_date"));
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
	
	//작성자로 검색
	public List<Recipe> recipeSearch1(String key){
		List<Recipe> list = new ArrayList<>();
		Recipe a = null;
		try {
			conn();
			String sql = "select * from recipe where u_name =? order by r_id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = new Recipe();
				a.setrId(rs.getInt("r_id"));
				a.setuId(rs.getString("u_id"));
				a.setrTitle(rs.getString("r_title"));
				a.setrBody(rs.getString("r_body"));
				a.setrDate(rs.getDate("r_date"));
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
	
	//제목으로 검색
	public List<Recipe> recipeSearch2(String key){
		List<Recipe> list = new ArrayList<>();
		Recipe a = null;
		try {
			conn();
			String sql = "select * from recipe\n"
					+ "where r_title like '%"+key+"%'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = new Recipe();
				a.setrId(rs.getInt("r_id"));
				a.setuId(rs.getString("u_id"));
				a.setrTitle(rs.getString("r_title"));
				a.setrBody(rs.getString("r_body"));
				a.setrDate(rs.getDate("r_date"));
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
	
	//글 삭제
	public int delRecipe(Recipe re) {
		int result = 0;
		try {
			conn();
			String sql = "delete from recipe where r_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, re.getrId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//좋아요 카운트
	public int countLike(int key) {
		int result = 0;
		try {
			conn();
			String sql = "select count(u_id) num\r\n"
					+ "from recipelike\r\n"
					+ "where r_id = ?\r\n"
					+ "group by r_id";
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
	
	//좋아요 누르기
	public int addLike(int key,String id) {
		int result = 0;
		try {
			conn();
			String sql = "insert into recipelike values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, key);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
}
