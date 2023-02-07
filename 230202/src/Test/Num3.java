package Test;

public class Num3 {
	public static void main(String[] args) {
		//큰 금액부터 동전을 우선적으로 거슬러 줘야 한다
		int[] coinUnit = new int[4];
		int money = 2680;
		System.out.println("money=" + money);
		for(int i=0; i<coinUnit.length; i++) {
			int[] coin = {500,100,50,10};
			while(money >= coin[i]) {
				money = money - coin[i];
				coinUnit[i]++;
			}
			System.out.print(coin[i]+"원 : "+coinUnit[i]+"개  ");
		}
		
	}
}
