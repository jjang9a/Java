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
		System.out.println("이름 : "+name+", 키 : "+height+"cm, 몸무게 : "+weight+"kg");
		System.out.println("비만도는 "+getObesity()+"입니다.");
	}
	
	public double getObesity() {
		return (weight - getStandardWeight())/getStandardWeight() * 100;
	}
	
	
	
}
