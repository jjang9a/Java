package com.yedam.map;

import java.rmi.StubNotFoundException;

public class Student {
	//필드
	public int sno;
	public String sname;
	//생성자
	public Student(int sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}
	//매소드
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student) obj;
			return (sno == std.sno) && (sname.equals(std.sname));
		}
		return false;
	}
	@Override
	public int hashCode() {
		return sno + sname.hashCode();
	}
	
	
	
}
