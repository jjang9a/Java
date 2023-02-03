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
		if(getObesity()>=50) {
			System.out.println("이름 : "+name+", 키 : "+height+"cm, 몸무게 : "+weight+"kg, 고도비만 입니다.");
		}else if(getObesity()>=30) {
			System.out.println("이름 : "+name+", 키 : "+height+"cm, 몸무게 : "+weight+"kg, 중등도비만 입니다.");
		}else if(getObesity()>=20) {
			System.out.println("이름 : "+name+", 키 : "+height+"cm, 몸무게 : "+weight+"kg, 경도비만 입니다.");
		}else if(getObesity()>=10) {
			System.out.println("이름 : "+name+", 키 : "+height+"cm, 몸무게 : "+weight+"kg, 과체중 입니다.");
		}else{
			System.out.println("이름 : "+name+", 키 : "+height+"cm, 몸무게 : "+weight+"kg, 비만이 아닙니다.");
		}
	}
	
	public double getObesity() {
		return (weight - getStandardWeight())/getStandardWeight() * 100;
	}
	
	
	
}
