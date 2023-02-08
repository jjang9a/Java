package test;

public class Application {
	public static void main(String[] args) {
//		System.out.println("<<문제2>>");
//		
//		Card card1 = new Card("5432-4567-9534-3657", 20251203, 253);
//		card1.showCardInfo();
//		System.out.println();
//		
//		Card card2 = new TossCard("5432-4567-9534-3657", 20251203, 253, "신빛용");
//		card2.showCardInfo();
//		System.out.println();
//		
//		Card card3 = new DGBCard("5432-4567-9534-3657", 20251203, 253, "신빛용");
//		card3.showCardInfo();
		
		
		System.out.println("\n<<문제3>>");
		
		int price = 10000;
		
		Payment card = new CardPayment(0.08);
		card.showInfo();
		System.out.println("온라인 결제 금액 : "+ card.online(price));
		System.out.println("오프라인 결제 금액 : "+ card.offline(price));
		System.out.println();
		
		Payment simple = new SimplePayment(0.05);
		simple.showInfo();
		System.out.println("온라인 결제 금액 : "+ simple.online(price));
		System.out.println("오프라인 결제 금액 : "+ simple.offline(price));
		
	}
}
