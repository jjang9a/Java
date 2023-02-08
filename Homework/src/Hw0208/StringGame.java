package Hw0208;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringGame {
	//필드
	char charData;
	String strData;
	List<Character> word = new ArrayList<>();
	String str = null;
	String tryStr = "";
		
	//생성자
	public StringGame(){
	}
		
	//메소드
	public void setCharData(char charData) {
		this.charData = charData;
		if(word.contains(charData)) {
			System.out.println("문자열을 구성하는 문자입니다.");
			tryStr += charData;
		}else {
			System.out.println("문자열을 구성하는 문자가 아닙니다.");
		}
	}

	public void setStrData(String strData) {
		this.strData = strData;
		if(strData.equals(str)) {
			System.out.println("정답입니다.");
		}else {
			for (int i = 0; i < word.size(); i++) {
				if(word.get(i) == strData.charAt(i)) {
					System.out.print('O');
				}else {
					System.out.print('X');
				}
			}
			System.out.println();
		}
	}
	
	public void showCharData() {
		System.out.println("현재까지 확인된 문자열의 문자들은 다음과 같습니다.");
		System.out.println(tryStr);
	}
	public void init() {
		word.clear();
		tryStr = "";
		int random = (int)(Math.random()*4+1);
		switch(random) {
		case 1 :
			str = "orange";
			break;
		case 2 :
			str = "game";
			break;
		case 3 :
			str = "phone";
			break;
		case 4 :
			str = "smart";
			break;
		}
		for(int i=0; i<str.length(); i++) {
			word.add(str.charAt(i));
		}
	}
	
	
	
	public static void main(String[] args) {
		/*
		 문제) Orange, Game, Phone, Smart 중 랜덤으로 선택한 단어를 맞추는 프로그램을 구현하세요.
		 메뉴 구성은 1.문자하나 | 2.단어 | 3.입력내역 | 4.새 게임 | 5.종료 로
		 각 메뉴의 기능은 아래와 같습니다. 
		 1. 문자하나 : 문자 단위로 입력을 받으며 정답에 포함된 문자인지 확인
		 2. 단어    : 단어 단위로 입력을 받으며 정답인지 확인
		 3. 입력내역 : 게임이 진행되는 동안 입력된 문자를 입력 순으로 출력
		 4. 새 게임  : 기존에 선택한 단어 대신 랜덤으로 새 단어를 선택하며 입력내역을 초기화
		 5. 종료     : 프로그램을 종료
		 
		 현재 실행코드와 실행결과를 참고하여 StringGame 클래스를 완성하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		StringGame game = new StringGame();
		
		game.init();
		
		while(run) {
			System.out.println("---------------------------------------------");
			System.out.println(" 1.문자하나 | 2.단어 | 3.입력내역 | 4.새 게임 | 5.종료 ");
			System.out.println("---------------------------------------------");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				game.showCharData();
				if(game.tryStr.length() == game.word.size()) {
					System.out.println("문자열을 구성하는 문자를 다 입력하셨습니다.");
				}else {
					System.out.print("입력 값>> ");
					char one = sc.next().charAt(0);		
					game.setCharData(one);
				}
				break;
			case 2:
				game.showCharData();
				System.out.print("입력 값>> ");
				String two = sc.next();
				if(two.length() != game.str.length()){
					System.out.println("\n입력된 문자열의 길이가 정답과 다릅니다.");
				}else {
					game.setStrData(two);
				}
				break;
			case 3:
				game.showCharData();
				break;
			case 4:
				game.init();
				break;
			case 5:
				run = false;
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴를 입력하셨습니다.");
			
			}
		}
	

	}
}
