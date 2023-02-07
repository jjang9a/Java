package Test;

public class Num4 {
	public static void main(String[] args) {
		for(int i=2; i<10; i++) {
			System.out.println(i+"단");
			for(int j=1; j<=i; j++) {
				System.out.println(i+" X "+j+" = "+i*j);
			}
		}
	}
}
