package Hw0203;

public class Employee {
	//필드
	String name;
	int earn;
	
	//생성자
	Employee(String name, int earn){
		this.name = name;
		this.earn = earn;
	}
	
	//메소드
	public String getName() {
		return name;
	}
	public int getEarn() {
		return earn;
	}
	
	public void getInformation() {
		System.out.println("이름 : "+name+", 연봉 : "+earn);
	}
	
	public void print() {
		System.out.println("수퍼클래스");
	}
}
