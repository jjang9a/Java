package test;

public class Person {
	//필드
	int ssn;
	String name;
	String adress;
	
	//생성자
	public Person() {
	}
	
	public Person(int ssn, String name, String adress) {
		this.ssn = ssn;
		this.name = name;
		this.adress = adress;
	}

	
	//메소드
	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
}
