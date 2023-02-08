package test;

public interface Payment {
	
	//필드
	public double ONLINE_PAYMENT_RATIO = 0.05;
	public double OFFLINE_PAYMENT_RATIO = 0.03;
	
	//메소드
	public int online(int price);
	public int offline(int price);
	public void showInfo();
	
}
