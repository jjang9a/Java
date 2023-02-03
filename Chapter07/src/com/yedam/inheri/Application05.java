package com.yedam.inheri;

public class Application05 {
	public static void main(String[] args) {
		//parent class
		//child class
		//상속 -> firstName, getInfo()
		//					=>우리 성씨는 OOO입니다.
		//개인적으로 가지는 정보
		//lastName, 혈액형, 나이, 취미
		//데이터 초기화는 원하는 방식으로
		//getInfo() -> 우리 성씨는 OOO입니다.
		//				내이름 : OOO
		//				혈액형 : OOO
		
		Child child = new Child("이", "또치", "O", 20, "Coding");
		child.getInfo();
		
		VIPPerson vip = new VIPPerson();
		vip.memberInfo();
	
	
	}
}
