package com.yedam.employees.service;

import java.sql.Date;

public class Employees {
	private int employeeId;
	private String lastName;
	private String jobId ;
	private int salary;
	private String email;
	private Date hireDate;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	//java.sql.Date vs java.util.Date 차이
	//	연월일			연월일시분초
	//사용하는 방식이 조금 다름
	
	//필드를 일부만 생성 할 때는 NOT NULL 제약조건인 애들은 꼭 만들어야 함
	
}
