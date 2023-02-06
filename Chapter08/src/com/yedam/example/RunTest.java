package com.yedam.example;

public class RunTest {
	public static void main(String[] args) {
		LgWashing lg = new LgWashing();
		
		lg.start();
		lg.speedChange(3);
		lg.dry();
		lg.end();
	}
}
