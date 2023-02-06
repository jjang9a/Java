package Hw0203;

public class Human {
//	- 이름과 키, 몸무게를 필드로 가지며 생성자를 이용하여 값을 초기화한다.
//	- 메소드는 다음과 같이 정의한다.
//	(1) public void getInformation() : 이름, 키와 몸무게를 출력하는 기능
	
	//필드
	protected String name;
	protected int height;
	protected int weight;
	

	//생성자
	Human(String name, int height, int weight){
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	//메소드
	public void getInformation() {
		System.out.print("이름 : "+name+"\t키 : "+height+"cm\t몸무게 : "+weight+"kg");
	}
	
}
