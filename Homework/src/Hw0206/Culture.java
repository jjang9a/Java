package Hw0206;

public abstract class Culture {
	//필드
	String subject;
	int pdNum;
	int actNum;
	int cusNum = 0;
	int score = 0;
	
	//생성자
	public Culture() {
	}
	public Culture(String subject, int pdNum, int actNum) {
		this.subject = subject;
		this.pdNum = pdNum;
		this.actNum = actNum;
	}
	
	//메소드
	public void setTotalScore(int score) {
		this.cusNum ++;
		this.score += score;
	}
	public String getGrade() {
		String grade = null;
		int aScore = 0;
		aScore = score/cusNum;
		if(aScore==5) {
			grade = "☆☆☆☆☆";
		}else if(aScore>=4) {
			grade = "☆☆☆☆";
		}else if(aScore>=3) {
			grade = "☆☆☆";
		}else if(aScore>=2) {
			grade = "☆☆";
		}else if(aScore>=1) {
			grade = "☆";
		}
		return grade;
	}
	public abstract void getInformation();
}
