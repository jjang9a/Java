package Hw0206;

import java.util.Scanner;

public class ApplicationGame {
	public static void main(String[] args) {
		
		//4번 문제
		
		Scanner sc = new Scanner(System.in);
		int random = (int)(Math.random()*2)+1;
		boolean run = true;
		Keypad game = null;
		
		if(random == 1) {
			game = new RPGgame(0);
		}else {
			game = new ArcadeGame();
		}
		
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
					if(random == 2) {
						game = new RPGgame(0);
					}else {
						game = new ArcadeGame();
					}
					break;
				case 9 :
					System.out.println("EXIT");
					run = false;
					break;
			}
		}
	}
}
