package com.yedam.employees.service;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.yedam.departments.service.Departments;
import com.yedam.departments.service.DepartmentsDAO;

public class EmployeesService {
	Scanner sc = new Scanner(System.in);
	
	//모든 사원 조회
	public void getEmployeesList(){
		List<Employees> list = EmployeesDAO.getInstance().getEmployeesList();
		System.out.println("==================================");
		for(int i=0; i<list.size(); i++) {
			System.out.println("사원 번호 : "+list.get(i).getEmployeeId());
			System.out.println("사원 이름 : "+list.get(i).getLastName());
			System.out.println("메일 주소 : "+list.get(i).getEmail());
			System.out.println("입 사 일 : "+list.get(i).getHireDate());
			System.out.println("직    책 : "+list.get(i).getJobId());
			System.out.println("월    급 : "+list.get(i).getSalary());
			System.out.println("==================================");
		}
	}
	
	//한 사원 조회
	public void getEmployee() {
		System.out.println("사원 번호 > ");
		int empNo = Integer.parseInt(sc.nextLine());
		Employees emp = EmployeesDAO.getInstance().getEmployees(empNo);
		if(emp == null) {
			System.out.println("조회된 결과 없음");
		}else {
			System.out.println("사원 번호 : "+emp.getEmployeeId());
			System.out.println("사원 이름 : "+emp.getLastName());
			System.out.println("메일 주소 : "+emp.getEmail());
			System.out.println("입 사 일 : "+emp.getHireDate());
			System.out.println("직    책 : "+emp.getJobId());
			System.out.println("월    급 : "+emp.getSalary());
		}
	}
	
	//사원 삭제
	public void deleteEmp() {
		System.out.println("==============사원 삭제==============");
		System.out.println("삭제 사원 번호 > ");
		int empNo = Integer.parseInt(sc.nextLine());
		
		Employees emp = new Employees();
		emp.setEmployeeId(empNo);
		
		int result = EmployeesDAO.getInstance().deleteEmp(emp);
		
		if(result > 0) {
			System.out.println("사원 삭제 완료");
		}else {
			System.out.println("사원 삭제 실패");
		}
	}
	
	//수정
	public void modifyEmp() {
		System.out.println("==============사원 수정==============");
		System.out.println("수정 사원 번호 > ");
		int deptNo = Integer.parseInt(sc.nextLine());
		System.out.println("수정 할 월급 > ");
		int mgrNo = Integer.parseInt(sc.nextLine());
		
		Departments dept = new Departments();
		dept.setDepartmentId(deptNo);
		dept.setManagerId(mgrNo);
		
		int result = DepartmentsDAO.getInstance().modifyDept(dept);
		
		if(result > 0) {
			System.out.println("부서 수정 완료");
		}else {
			System.out.println("부서 수정 실패");
		}
	}
	
	//등록
	public void insertEmp() {
		Employees emp = new Employees();
		
		System.out.println("==============사원 등록==============");
		
		System.out.println("사원 번호 > ");
		emp.setEmployeeId(Integer.parseInt(sc.nextLine()));
		
		System.out.println("사원 이름 > ");
		emp.setLastName(sc.nextLine());
		
		System.out.println("메일 주소 > ");
		emp.setEmail(sc.nextLine());
		
		//데이터를 입력 할 때 기준으로 자동 생성 -> sysdate 이용
		//	EmployeesDAO클래스의 등록쪽에서 ?대신 sysdate를 이용하고 등록받는 칸 없앰
		//데이터를 직접 입력할지
		System.out.println("입사일 > ");
		emp.setHireDate(Date.valueOf(sc.nextLine()));
		
		System.out.println("직책 > ");
		emp.setJobId(sc.nextLine());
		
		System.out.println("월급 > ");
		emp.setSalary(Integer.parseInt(sc.nextLine()));

		int result = EmployeesDAO.getInstance().insertEmp(emp);
		
		if(result > 0) {
			System.out.println("사원 등록 완료");
		}else {
			System.out.println("사원 등록 실패");
		}
	}
}
