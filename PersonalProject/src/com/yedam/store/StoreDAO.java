package com.yedam.store;

import java.util.ArrayList;
import java.util.List;

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
	
	//맛집 랭킹
	public List<Store> rankStore(String kind, String sel){
		List<Store> list = new ArrayList<>();
		Store s = null;
		try {
			conn();
			String sql = "select s.s_name, s.s_kind, s.s_location, s.avgp, s.att\n"
					+ "from (\n"
					+ "    select s_name, s_kind, s_location, avg(s_point) avgp, RANK() OVER(ORDER BY avg(s_point) desc) att\n"
					+ "    from store\n"
					+ "    group by s_name, s_kind, s_location\n"
					+ "    )s\n"
					+ "where "+kind+" = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				s = new Store();
				s.setsName(rs.getString("s_name"));
				s.setsKind(rs.getString("s_kind"));
				s.setsLocation(rs.getString("s_location"));
				s.setsAvg(rs.getDouble("avgp"));
				list.add(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//맛집 검색 - 가게이름
	public List<Store> searchName(String name) {
		List<Store> list = new ArrayList<>();
		Store s = null;
		try {
			conn();
			String sql = "select * from store\n"
					+ "where s_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				s = new Store();
				s.setsName(rs.getString("s_name"));
				s.setuName(rs.getString("u_name"));
				s.setsKind(rs.getString("s_kind"));
				s.setsMenu(rs.getString("s_menu"));
				s.setsMoney(rs.getString("s_money"));
				s.setsLocation(rs.getString("s_location"));
				s.setsPoint(rs.getDouble("s_point"));
				s.setsDate(rs.getDate("s_date"));
				list.add(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//맛집 검색 - 메뉴
	public List<Store> searchMenu(String name) {
		List<Store> list = new ArrayList<>();
		Store s = null;
		try {
			conn();
			String sql = "select * from store\n"
					+ "where s_menu like '%"+name+"%'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				s = new Store();
				s.setsName(rs.getString("s_name"));
				s.setsKind(rs.getString("s_kind"));
				s.setsLocation(rs.getString("s_location"));
				list.add(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//레시피게시판에서 관련 글 수 검색
	public int searchMenuPlus(String name) {
		int result = 0;
		try {
			conn();
			String sql = "select count(r_title) num from recipe\n"
					+ "where r_title like '%"+name+"%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
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
	
	//맛집게시판 - 글 목록
	public List<Store> storeList(String id){
		List<Store> list = new ArrayList<>();
		Store s = null;
		try {
			conn();
			String sql = "select * from store where u_id = ? order by s_id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				s = new Store();
				s.setsId(rs.getInt("s_id"));
				s.setuId(rs.getString("u_id"));
				s.setsName(rs.getString("s_name"));
				s.setuName(rs.getString("u_name"));
				s.setsKind(rs.getString("s_kind"));
				s.setsMenu(rs.getString("s_menu"));
				s.setsMoney(rs.getString("s_money"));
				s.setsLocation(rs.getString("s_location"));
				s.setsPoint(rs.getDouble("s_point"));
				s.setsDate(rs.getDate("s_date"));
				list.add(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}

	//맛집게시판 - 글 삭제
	public int deleteStore(Store s) {
		int result = 0;
		try {
			conn();
			String sql = "delete from store where s_id = "+s.getsId();
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}

}
