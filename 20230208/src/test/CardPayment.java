package test;

public class CardPayment implements Payment{
	//필드
	double cardRatio;
	
	//생성자
	public CardPayment(double cardRatio) {
		this.cardRatio = cardRatio;
	}

	//메소드
	@Override
	public int online(int price) {
		return (int)(price * (1-ONLINE_PAYMENT_RATIO-cardRatio));
	}
	
	@Override
	public int offline(int price) {
		return (int)(price * (1-OFFLINE_PAYMENT_RATIO-cardRatio));
	}
	
	@Override
	public void showInfo() {
		System.out.println("*** 카드로 결제 시 할인정보");
		System.out.println("온라인 결제시 총 할인율 : "+(ONLINE_PAYMENT_RATIO+cardRatio));
		System.out.println("오프라인 결제시 총 할인율 : "+(OFFLINE_PAYMENT_RATIO+cardRatio));
	}
	
	
}
