package com.yedam.student;

import java.util.List;
import java.util.Scanner;

public class StudentService {
	Scanner sc = new Scanner(System.in);
	
	//전체 학생 정보 조회
	public void getStudentList() {
		List<Student> list = StudentDAO.getInstance().getStudentList();
		System.out.println("==================================");
		for(int i=0; i<list.size(); i++) {
			System.out.println("학 번 : " + list.get(i).getStdId());
			System.out.println("이 름 : " + list.get(i).getStdName());
			System.out.println("전 공 : " + list.get(i).getStdMajor());
			System.out.println("학 점 : " + list.get(i).getStdPoint());
			System.out.println("==================================");
		}
//		for(Student std : list) {
//			System.out.println(std.toString());
//		}
	}
	
	//학번 조회
	public void getStudent() {
		System.out.println("조회할 학번 입력 > ");
		int stdNo = Integer.parseInt(sc.nextLine());
		Student std = StudentDAO.getInstance().getStudent(stdNo);
		if(std == null) {
			System.out.println("조회된 결과 없음");
		}else {
			System.out.println("학 번 : " + std.getStdId());
			System.out.println("이 름 : " + std.getStdName());
			System.out.println("전 공 : " + std.getStdMajor());
			System.out.println("학 점 : " + std.getStdPoint());
			
//			System.out.println(std.toString());
		}
	}
	
	//학생 등록
	public void insertStd() {
		Student std = new Student();
		
		System.out.println("==============학생 등록==============");
		System.out.println("학번 > ");
		std.setStdId(Integer.parseInt(sc.nextLine()));
		System.out.println("이름 > ");
		std.setStdName(sc.nextLine());
		System.out.println("전공 > ");
		std.setStdMajor(sc.nextLine());
		System.out.println("학점 > ");
		std.setStdPoint(Double.parseDouble(sc.nextLine()));	
		
		int result = StudentDAO.getInstance().insertStd(std);
		
		if(result > 0) {
			System.out.println("학생 등록 완료");
		}else {
			System.out.println("학생 등록 실패");
		}
	}
	
	//학생 제적
	public void deleteStd() {
		System.out.println("==============학생 제적==============");
		System.out.println("제적 처리 할 학번 > ");
//		int stdNo = Integer.parseInt(sc.nextLine());
//		int result = StudentDAO.getInstance().deleteStd(stdNo);
		int result =
		StudentDAO.getInstance().deleteStd(Integer.parseInt(sc.nextLine()));
		
		if(result > 0) {
			System.out.println("학생 제적 완료");
		}else {
			System.out.println("학생 제적 실패");
		}
	}
	
	//학생 전공변경
	public void updateStd() {
		Student std = new Student();
		System.out.println("============학생 전공 변경============");
		System.out.println("전공 변경 할 학번 > ");
		std.setStdId(Integer.parseInt(sc.nextLine()));
//		int stdNo = Integer.parseInt(sc.nextLine());
//		std.setStdId(stdNo);
		System.out.println("변경 할 전공 > ");
		std.setStdMajor(sc.nextLine());
//		String change = sc.nextLine();
//		std.setStdMajor(change);

		int result = StudentDAO.getInstance().updateStd(std);
		
		if(result > 0) {
			System.out.println("학생 정보 수정 완료");
		}else {
			System.out.println("학생 정보 수정 실패");
		}		
	}
	
	//전공별 성적 합계, 평균
	public void getAnalyze() {
		List<Student> list =
		StudentDAO.getInstance().getAnalyze();
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("천공 : " + list.get(i).getStdMajor());
			System.out.println("합계 : " + list.get(i).getStdSum());
			System.out.println("평균 : " + list.get(i).getStdAvg());	
		}
	}
	
}
