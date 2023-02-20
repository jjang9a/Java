package com.yedam.employees.service;

import java.util.List;
import java.util.Scanner;

import com.yedam.departments.service.Departments;
import com.yedam.departments.service.DepartmentsDAO;

public class EmployeesService {
	Scanner sc = new Scanner(System.in);
	
	//모든 사원 조회
	public void getDepartmentsList(){
		List<Employees> list = EmployeesDAO.getInstance().getEmployeesList();
		System.out.println("==================================");
		for(int i=0; i<list.size(); i++) {
			System.out.println("사원 번호 : "+list.get(i).getEmployeeId());
			System.out.println("사원 이름 : "+list.get(i).getFirstName());
			System.out.println("직   업 : "+list.get(i).getJobId());
			System.out.println("월   급 : "+list.get(i).getSalary());
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
			System.out.println("사원 이름 : "+emp.getFirstName());
			System.out.println("직   업 : "+emp.getJobId());
			System.out.println("월   급 : "+emp.getSalary());
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
	public void modifyDept() {
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
	
	
}
