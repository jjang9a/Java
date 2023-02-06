package Hw0203;

public class ObesityInfo extends StandardWeightInfo{

	//필드
	
	//생성자
	ObesityInfo(String name, int height, int weight) {
		super(name, height, weight);
	}

	//메소드
	@Override
	public void getInformation() {
		System.out.print("이름 : "+name+"\t키 : "+height+"cm\t몸무게 : "+weight+"kg");
		if(getObesity()>=50) {
			System.out.println("\t고도비만 입니다.");
		}else if(getObesity()>=30) {
			System.out.println("\t중등도비만 입니다.");
		}else if(getObesity()>=20) {
			System.out.println("\t경도비만 입니다.");
		}else if(getObesity()>=10) {
			System.out.println("\t과체중 입니다.");
		}else{
			System.out.println("\t비만이 아닙니다.");
		}
	}
	
	public double getObesity() {
		return (weight - getStandardWeight())/getStandardWeight() * 100;
	}
	
	
	
}
