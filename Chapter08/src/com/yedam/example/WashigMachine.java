package com.yedam.example;

public interface WashigMachine extends Dry {
	public void start();
	public void stop();
	public void end();
	public void speedChange(int speed);
}
