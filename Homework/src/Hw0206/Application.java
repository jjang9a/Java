package Hw0206;

public class Application {
	public static void main(String[] args) {
		Culture chu = new Movie("추격자", 7, 5, "영화");
		
		chu.setTotalScore(5);
		chu.setTotalScore(3);
		chu.setTotalScore(4);
		chu.setTotalScore(2);
		chu.setTotalScore(5);
		
		chu.getInformation();
		
		System.out.println("===================");
		
		Culture ji = new Performance("지킬앤하이드", 9, 10, "공연");
		
		ji.setTotalScore(4);
		ji.setTotalScore(3);
		ji.setTotalScore(5);
		ji.setTotalScore(2);
		ji.setTotalScore(5);
		
		ji.getInformation();
	}
}
