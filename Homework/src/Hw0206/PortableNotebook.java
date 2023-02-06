package Hw0206;

public class PortableNotebook implements Notebook, Tablet {
	//필드
	String mode = "NOTEBOOK_MODE";
	String word;
	String browser;
	String vedio;
	String app;
	
	//생성자
	public PortableNotebook(String word, String browser, String vedio, String app) {
		this.word = word;
		this.browser = browser;
		this.vedio = vedio;
		this.app = app;
		System.out.println(mode);
	}
	
	//매소드
	@Override
	public void watchVideo() {
		System.out.println(vedio+"를 시청.");
	}

	@Override
	public void useApp() {
		if(mode.equals("NOTEBOOK_MODE")) {mode = "TABLET_MODE";}
		System.out.println(app+"를 실행.");
	}

	@Override
	public void writeDocumentaion() {
		System.out.println(word+"를 통해 문서를 작성.");
	}

	@Override
	public void searchInternet() {
		System.out.println(browser+"를 통해 인터넷을 검색.");
	}
	
	public void changeMode() {
		if(mode.equals("NOTEBOOK_MODE")) {
			mode = "TABLET_MODE";
			}else if(mode.equals("TABLET_MODE")) {
				mode = "NOTEBOOK_MODE";
			}
		System.out.println(mode);
	}
	
}
