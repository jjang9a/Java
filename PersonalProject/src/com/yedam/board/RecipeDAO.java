package com.yedam.board;

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
			String sql = "insert into anony values (suggest_seq.nextval,sysdate,?,?,?,?)";
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
		
	//레시피 게시판- 글읽기
		
	//레시피 게시판 - 글 삭제
		
	//레시피 게시판 - 좋아요
		
}
