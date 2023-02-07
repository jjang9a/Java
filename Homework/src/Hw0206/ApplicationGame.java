package Hw0206;

import java.util.Scanner;

public class ApplicationGame {
	
	public static Keypad getRandomGame() {
		Keypad game = null;
		int random = (int)(Math.random()*2)+1;
		return (random == 1) ? new RPGgame() : new ArcadeGame();
	}
	
	public static void main(String[] args) {
		
		//4번 문제
//		Keypad game = null;
//		int random = (int)(Math.random()*2)+1;
		Scanner sc = new Scanner(System.in);
		boolean run = true;

		Keypad game = getRandomGame();
//		if(random == 1) {
//			game = new RPGgame();
//		}else {
//			game = new ArcadeGame();
//		}
		
		//인터페이스 다형성, 자동타입변환
		//-> 하나의 객체로 두 개 또는 여러개의 객체 만들어 사용
		
		while(run) {
			System.out.println("============================================================================================");
			System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
			System.out.println("============================================================================================");
			System.out.println("choice>>");
			int sel = Integer.parseInt(sc.nextLine());
			switch(sel) {
				case 1 :
					game.leftUpButton();
					break;
				case 2 :
					game.leftDownButton();
					break;
				case 3 :
					game.rightUpButton();
					break;
				case 4 :
					game.rightDownButton();
					break;
				case 5 :
					game.changeMode();
					break;
				case 0 :
//					if(random == 2) {
//						random = 1;
//						game = new RPGgame();
//					}else {
//						random = 2;
//						game = new ArcadeGame();
//					}
					game = getRandomGame();
					break;
				case 9 :
					System.out.println("EXIT");
					run = false;
					break;
			}
		}
	}
}
