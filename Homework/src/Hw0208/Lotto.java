package Hw0208;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {
	//로또 생성 후 리스트 출력하는 프로그램
	//1. 중복되지 않은 번호가 6개 출력된다.
	//2. 한장당 총 1~5줄 생성된다.
	//3. 한 줄당 금액은 천원이며, 입력한 금액만큼 생성한다.
	//4. 구매 금액, 생성된 로또 번호를 출력한다.
	//5. 5장씩 끊어서 출력할 것 
	
		Scanner sc = new Scanner(System.in);
		ArrayList<int[]> list = new ArrayList<>();
		boolean run = true;
		int money = 0;
		
		
		while(run) {
			System.out.println("메뉴를 선택 해 주세요.");
			System.out.println("1. 로또 생성 | 2. 로또 조회 | 99. 프로그램 종료");
			int select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
			case 1 :
				System.out.println("금액을 투입해주세요.");
				money = Integer.parseInt(sc.nextLine());
				int[] lotto;
				for(int k=0; k<money/1000; k++) {
					lotto = new int[6];
					for(int i=0; i<lotto.length; i++) {
						int num = (int)(Math.random()*45)+1;
						lotto[i] = num;
						for(int j=0; j<i; j++) {
							if(lotto[i] == lotto[j]) {
								i--;
								break;
							}
						}
					}
					list.add(lotto);
				}
				System.out.println("번호 출력 완료");
				break;
				
			case 2 :
				System.out.println("구매 한 금액> "+money+"월");
				for(int i=0; i<list.size(); i++) {
					System.out.print((i%5)+1+"번> ");
					for(int j=0; j<6; j++) {
						System.out.print(list.get(i)[j]+" ");
					}
					System.out.println();
					if((i%5)==4) {
						System.out.println("----------------------");
					}
				}
				break;
				
			case 99 :
				System.out.println("프로그램 종료");
				run = false;
				break;
				
			default :
				System.out.println("1, 2, 99 중 하나를 입력해주세요");
				break;
			}
		}
		
	}
}
