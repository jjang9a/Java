package Hw0206;

public class Performance extends Culture{

	//필드
	String gnere;
	
	//생성자
	public Performance(String subject, int pdNum, int actNum, String gnere) {
		super(subject,pdNum,actNum);
		this.gnere = gnere;
	}
	
	//메소드
	@Override
	public void getInformation() {
		System.out.println(gnere+"제목 : "+subject);
		System.out.println("참여 감독 수 : "+pdNum);
		System.out.println("참여 배우 수 : "+actNum);
		System.out.println("관객 수 : "+cusNum);
		System.out.println("총점 : "+score);
		System.out.println("평점 : "+getGrade());
	}
	

}
