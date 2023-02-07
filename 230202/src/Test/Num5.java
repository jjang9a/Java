package Test;

import java.util.Scanner;

public class Num5 {
	public static void main(String[] args) {
		
		/* 1) 주사위 크기(5~10) 입력받기 / 범위를 벗어날 경우 범위 안내 메시지 출력
		 * 2) 5가 나올 때까지 주사위를 몇 번 굴리는지 구하고 출력
		 * 3) (2)에서 각 주사위 수별로 몇 번씩 나왔는지 출력
		 * 4) (2)에서 가장 많이 나온 수가 몇인지 구하고 출력
		 * 		가장 많이 나온 수가 여러 개 일 경우 가장 작은 수가 출력됩니다
		 * 5) 프로그램을 종료
		 */
		
		Scanner sc = new Scanner(System.in);
		int range = 0;
		int[] jusawi = null;
		boolean run = true;
		
		while(run) {
			System.out.println("=== 1.주사위 크기 2.주사위 굴리기 3.결과 보기 4.가장 많이 나온 수 5.종료 ===");
			System.out.println("메뉴>");
			int num = Integer.parseInt(sc.nextLine());
			
			if(num == 1) {
				System.out.println("주사위 크기>");
				range = Integer.parseInt(sc.nextLine());
				
				if(range>=5 && range<=10) {
					jusawi = new int[range];
				}else {
					System.out.println("주사위의 범위는 5~10사이입니다");
				}
			}else if(num ==2) {
				int count = 0;
				while(true) {
					int random = (int)(Math.random()*(range))+1;
					count ++;
					jusawi[random-1]++;
					if(random == 5) {
						break;
					}
				}
				System.out.println("5가 나올때까지 주사위를 "+count+"번 굴렸습니다.");
				
				
			}else if(num ==3) {
				for(int i=0; i<jusawi.length; i++) {
					System.out.println((i+1)+"은 "+jusawi[i]+"번 나왔습니다.");
				}
				
			}else if(num ==4) {
				int max = jusawi[0];
				int index = 0;
				for(int i=1; i<jusawi.length; i++) {
//				for(int i=jusawi.length-1; i>0; i--) {
					if(jusawi[i] > max) {
						//60번째줄 max값 대입 잘못 됨.
//						jusawi[i] = max;
						max = jusawi[i];
						index = i;
					}
				}
				System.out.println("가장 많이 나온 수는 " +(index+1)+"입니다.");
				
			}else if(num ==5) {
				System.out.println("프로그램 종료");
				run = false;
			}

			
		}
		
	}
}
