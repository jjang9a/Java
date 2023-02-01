package JAVA;

import java.util.Scanner;

public class Hw0201 {
	public static void main(String[] args) {
		// 문제1) 다음은 키보드로부터 상품 수와 상품 가격을 입력받아서
		// 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램을 작성하세요.
		// 1) 메뉴는 다음과 같이 구성하세요.
		// 1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료
		// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현하세요.
		// 3) 제품별 가격을 출력하세요.
		//	출력예시, "상품명 : 가격"
		// 4) 분석기능은 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합을 구합니다.
		// 5) 종료 시에는 프로그램을 종료한다고 메세지를 출력하도록 구현하세요.
		
		Scanner sc = new Scanner(System.in);
		
		int iCount = 0;
		Item iArr[] = null;
		boolean run = true;
		
		while(run) {
			System.out.println("1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료");
			System.out.println("입력>");
			int num = Integer.parseInt(sc.nextLine());
			
			if(num == 1) {
				System.out.println("상품의 수를 입력하세요>");
				iCount = Integer.parseInt(sc.nextLine());
				
			}else if(num == 2) {
				iArr = new Item[iCount];
				
				for(int i=0; i<iArr.length; i++) {
					iArr[i] = new Item();
					
					System.out.println("상품명>");
					iArr[i].name = sc.nextLine();
					
					System.out.println("가격>");
					iArr[i].price = Integer.parseInt(sc.nextLine());
				}
				
			}else if(num == 3) {
				for(int i=0; i<iArr.length; i++) {
					System.out.println(iArr[i].name+" : "+iArr[i].price+"원");
				}
				
			}else if(num == 4) {
				// 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램을 작성하세요.
				int max = iArr[0].price;
				int maxIn = 0;
				int sum = 0;
				for(int i=0; i<iArr.length; i++){
					if(iArr[i].price > max) {
						max = iArr[i].price;
						maxIn = i;
					}
				}
				for(int i=0; i<iArr.length; i++){
					if(i != maxIn) {
						sum += iArr[i].price;
					}
				}
				System.out.println("최고가의 제품은 "+iArr[maxIn].name+"이고, 그 외 제품가의 총 합은 "+sum+"원 입니다.");
				
			}else if(num == 5) {
				System.out.println("프로그램 종료");
				run = false;
			}
			
		}
	}
}

