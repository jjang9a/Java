package Hw0203;

public class EmpDept extends Employee{
	//필드
	String part;
	
	//생성자
	EmpDept(String name, int earn, String part) {
		super(name, earn);
		this.part = part;
	}
	
	//메소드
	public String getPart() {
		return part;
	}

	@Override
	public void getInformation() {
		super.getInformation();
		System.out.println("\t부서 : "+part);
	}

	@Override
	public void print() {
		System.out.println("수퍼클래스\n서브클래스");
	}
	
}
