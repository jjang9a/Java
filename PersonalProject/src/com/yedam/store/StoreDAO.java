package com.yedam.store;

import com.yedam.common.DAO;

public class StoreDAO extends DAO{
	//싱글톤
	private static StoreDAO sDao = new StoreDAO();
	
	private StoreDAO() {
	}
	public static StoreDAO getInstance() {
		return sDao;
	}
	
	//맛집 등록 기능(글쓰기)
	public int insertStore(Store s) {
		int result = 0;
		try {
			conn();
			String sql = "insert into store values (store_seq.nextval, ?,?,?,?,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getsName());
			pstmt.setString(2, s.getsKind());
			pstmt.setString(3, s.getsMenu());
			pstmt.setString(4, s.getsMoney());
			pstmt.setString(5, s.getsLocation());
			pstmt.setDouble(6, s.getsPoint());
			pstmt.setString(7, s.getuId());
			pstmt.setString(8, s.getuName());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
}
