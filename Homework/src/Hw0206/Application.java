package Hw0206;

public class Application {
	public static void main(String[] args) {
		System.out.println("<<<1번>>>");
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
		ji.setTotalScore(4);
		ji.setTotalScore(5);
		
		ji.getInformation();
		
		
		System.out.println("\n<<<2번>>>");
		Keypad rpg = new RPGgame();

		rpg.leftUpButton();
		rpg.rightUpButton();
		rpg.changeMode();
		rpg.rightUpButton();
		rpg.rightDownButton();
		rpg.leftDownButton();
		rpg.changeMode();
		rpg.rightDownButton();
		
		System.out.println("===================");
		Keypad ac = new ArcadeGame();
		
		ac.leftUpButton();
		ac.rightUpButton();
		ac.leftDownButton();
		ac.changeMode();
		ac.rightUpButton();
		ac.leftUpButton();
		ac.rightDownButton();

		System.out.println("\n<<<3번>>>");
		
		PortableNotebook pn = new PortableNotebook("한글2020", "크롬", "영화", "안드로이드앱");
		
		pn.writeDocumentaion();
		pn.watchVideo();
		pn.changeMode();
		pn.useApp();
		pn.searchInternet();

	}
}
