package Hw0203;

public class StandardWeightInfo extends Human{

	//필드
	
	//생성자
	StandardWeightInfo(String name, int height, int weight) {
		super(name, height, weight);
	}
	
	//메소드
	public double getStandardWeight() {
		return (height - 100) * 0.9;
	}

	@Override
	public void getInformation() {
		System.out.println("이름 : "+name+", 키 : "+height+"cm, 몸무게 : "+weight+"kg, 표준체중은 "+getStandardWeight()+"입니다.");
	}
}
