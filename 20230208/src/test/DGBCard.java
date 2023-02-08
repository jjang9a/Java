package test;

public class DGBCard extends Card{
	//필드
	String company;
	String cardStaff;
	
	//생성자
	public DGBCard(String cardNo, int validDate, int cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
		this.company = "대구은행";
	}
	
	//메소드

	@Override
	public void showCardInfo() {
		System.out.println("카드정보 - Card No, "+getCardNo()+", 유효기간 : "+getValidDate()+", CVC : "+getCvc());
		System.out.println("담당직원 - "+cardStaff+", "+company);
	}

}
