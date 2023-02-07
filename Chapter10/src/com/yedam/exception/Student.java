package com.yedam.exception;

public class Student {
	
	//p.509 3번
	
	//필드
	public String studentNum;
	//생성자
	public Student(String studentNum) {
		this.studentNum = studentNum;
	}
	//매소드
	public String getStudentNum() {
		return studentNum;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student stu = (Student)obj;
			//equals를 사용한 객체의 id와 매개변수의 객체 id를 비교
			if(studentNum.equals(stu.studentNum)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		return studentNum.hashCode();
	}

	
}
