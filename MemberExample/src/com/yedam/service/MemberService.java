package com.yedam.service;

import java.util.Scanner;

public class MemberService {
	// 멤버의 정보를 자바 전역에 공유하기 위해서 static 사용
	// 1. memberInfo -> null 이 아니다 / null 이다
	// null이면 로그인이 안 된 상태
	// null이 아니면 로그인이 되어 있는 상태

	public static Member memberInfo = null;
	Scanner sc = new Scanner(System.in);

	// 로그인
	public void login() {
		Member member = null;
		System.out.println("ID > ");
		String memberId = sc.nextLine();
		System.out.println("PW > ");
		String memberPw = sc.nextLine();

		member = MemberDAO.getInstance().login(memberId);

		//ID를 통해 회원정보를 조회하고 조회 된 결과에 따라 login여부를 정함
		// ID를 통해 조회가 됨 = 회원 정보가 존재
		// => 입력한 비밀번호와 회원정보의 비밀번호가 동일하면 login 진행
		
		// ID를 통해 조회가 되지 않음 = 회원 정보가 없다
		// => login실페 - memberInfo는 null로 유지

		if (member != null) { // 데이터가 조회 되었다.
			if (member.getMemberPw().equals(memberPw)) {
				System.out.println("정상 로그인 되었습니다.");
				System.out.println(member.getMemberId() + "님 환영합니다.");
				memberInfo = member;
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		} else {
			System.out.println("존재하지 않는 아이디 입니다.");
		}
	}
	
	//회원 정보 조회
	public void getMember() {
		Member member = MemberDAO.getInstance().getMember();
		System.out.println(member.toString());
	}
	
	//회원 정보 수정
	public void modifyMember() {
		Member member = new Member();
		System.out.println("연락처 > ");
		member.setMemberPhone(sc.nextLine());
		System.out.println("회원 ID > ");
		member.setMemberId(sc.nextLine());
		
		int result = MemberDAO.getInstance().modifyMember(member);
		
		if(result > 0) {
			System.out.println("연락처 수정 완료");
		}else {
			System.out.println("연락처 수정 실패");
		}
	}
	
	//회원 탈퇴
	public void deleteMember() {
		System.out.println("회원 ID > ");
		int result = MemberDAO.getInstance().deleteMember(sc.nextLine());
		
		//자신의 ID를 넣음
		//로그인 되어 있는 상태에서 회원 탈퇴 -> 로그아웃
		if(result > 0) {
			MemberService.memberInfo = null; //로그아웃
			System.out.println("회원 ID 삭제 완료");
		}else {
			System.out.println("회원 ID 삭제 실패");
		}
		
	}

}
