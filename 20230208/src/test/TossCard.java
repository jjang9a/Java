package test;

public class TossCard extends Card{
	//필드
	String company;
	String cardStaff;
	
	//생성자
	public TossCard(String cardNo, int validDate, int cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
		this.company = "Toss";
	}
	
	//메소드

	@Override
	public void showCardInfo() {
		System.out.println("카드정보 - Card No, "+getCardNo());
		System.out.println("담당직원 - "+cardStaff+", "+company);
	}
	

}
