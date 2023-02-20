package com.yedam.service;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class CoffeeDAO extends DAO{
	//Coffee 테이블에 접근 할 때 쓰는 객체
	
	//java -> jdbc -> db -> coffee table 에 접근 -> CRUD 발생
	
	//SingleTon
	//coffee 테이블에 단 한명만 접근 할 수 있게 해당 패턴을 적용
	private static CoffeeDAO coffeeDao = null;
	private CoffeeDAO() {
		
	}
	//싱글톤 -> static 영역에 생성 -> coffee테이블에 접근하는 경우, 안하는 경우
	//만약 coffee테이블에 CRUD가 발생하지 않는다면 굳이 coffeeDAO객체를 생성할 이유가 없기 때문
	//null 처리
	public static CoffeeDAO getInstance() {
		if(coffeeDao == null){
			coffeeDao = new CoffeeDAO();
		}
		return coffeeDao;
	}
	
	//coffee테이블에서 어떤 CRUD를 할 건지에 대해 정의
	//구현 중인 프로그램에서 어떠한 CRUD가 필요한지 파악
	//CRUD (Create, Read, Update, Delete)
	//전체 메뉴 조회(R), 상세(한건) 조회(R), 등록(C), 판매(U), 삭제(D), 매출(U)
	
	//상세(한건, 단건) 조회(R)
	public Coffee getCoffee(String name) {
		Coffee coffee = null;
		try {
			conn();
			//preparedstatement 를 이용해 조회하는 경우
			String sql = "select * from coffee where coffee_menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			//Query문 실행
			rs = pstmt.executeQuery(); //select문 -> 반환(결과)값 : ResultSet			
			if(rs.next()) {
				coffee = new Coffee();
				coffee.setCoffeeMenu(rs.getString("coffee_menu"));
				coffee.setCoffeePrice(rs.getInt("coffee_price"));
				coffee.setCoffeeExplain(rs.getString("coffee_explain"));
				coffee.setCoffeeSales(rs.getInt("coffee_sales"));
				}
			//statement 를 이용해 조회하는 경우
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return coffee;
	}
	
	//전체 메뉴 조회(R)
	//전체 조회 -> 조건에 맞는 데이터를 모두 Reading
	//ex) select * from employees;
	//List를 활용
	
	public List<Coffee> getCoffeeList(){
		//Coffee객체를 list에 담는 용도
		List<Coffee> list = new ArrayList<>();
		//DB에서 하나의 row에 대한 데이터를 담는 용도
		Coffee coffee = null;
		
		try {
			conn();
			String sql = "select * from coffee";		
			//1. statement  - 조건이 없는 select문에서 쓰면 편함
//			String sql = "select * from coffee where coffee_id = '" + coffeeId + 
//							"AND coffee_name = '" + coffeeName + "'";
			//2. preparedstatement - where절에 의해 변동데는 데이터를 입력 할 때 편함
//			String sql = "select * from coffee where coffee_id = ?"
			
			//statement 사용하기 위해서 연걸
			stmt = conn.createStatement();
			
			//Query문(sql) 실행 및 결과 반환
			rs = stmt.executeQuery(sql);
			
			//rs.next() 메소드 활용해서 쿼리문 조회 결과 확인
			while(rs.next()) {
				//db에 데이터가 한 건 이상 조회되었다
				
				//서로 다른 row 데이터를 서로 다른 객체(주소)에 데이터를 담아주기 위함
				coffee = new Coffee();
				
				coffee.setCoffeeMenu(rs.getString("coffee_menu"));
				coffee.setCoffeePrice(rs.getInt("coffee_price"));
				coffee.setCoffeeExplain(rs.getString("coffee_explain"));
				coffee.setCoffeeSales(rs.getInt("coffee_sales"));
				coffee.setCoffeeId(rs.getInt("coffee_id"));
				
				list.add(coffee);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return list;
	}
	
	//등록(C)
	public int insertCoffee(Coffee coffee) {
		int result = 0;
		try {
			conn();
			//preratedstatement
			String sql = "INSERT INTO coffee VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, coffee.getCoffeeId());
			pstmt.setString(2, coffee.getCoffeeMenu());
			pstmt.setInt(3, coffee.getCoffeePrice());
			pstmt.setString(4, coffee.getCoffeeExplain());
			pstmt.setInt(5, coffee.getCoffeeSales());
			
			//DML 사용할 때 뜨는 query 메소드 : executeUpdate()
			//select -> executeQuery()
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;

	}
	
	//삭제(D)
	public int menuDelete(String menu) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM coffee WHERE coffee_menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu);
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//판매(U)
	public int salesCoffee(Coffee coffee) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE coffee" + " SET coffee_sales = coffee_sales+ ?"
						+" WHERE coffee_menu =?"; //띄어쓰기 주의해야함 SET 앞에 띄어쓰기 있어야..
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  coffee.getCoffeeSales());
			pstmt.setString(2, coffee.getCoffeeMenu());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}

	
	
	
	
	
}
