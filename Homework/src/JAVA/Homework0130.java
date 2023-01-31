package JAVA;

import java.util.Scanner;

public class Homework0130 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 문제1) 차례대로 x와 y의 값이 주어졌을 때 어느 사분면에 해당되는지 출력하도록 구현하세요.

		int x = 10;
		int y = -5;
		if(x>0 && y>0) {
			System.out.println("("+x+","+y+")"+" 은 1사분면 위의 점입니다.");
		}else if(x<0 && y>0) {
			System.out.println("("+x+","+y+")"+" 은 2사분면 위의 점입니다.");
		}else if(x<0 && y<0) {
			System.out.println("("+x+","+y+")"+" 은 3사분면 위의 점입니다.");
		}else if(x>0 && y<0) {
			System.out.println("("+x+","+y+")"+" 은 4사분면 위의 점입니다.");
		}else {
			System.out.println("정확한 값을 입력하세요.");
		}

		
		
		// 문제2) 연도가 주어졌을 때 해당 년도가 윤년인지를 확인해서 출력하도록 하세요.
		// 윤년은 연도가 4의 배수이면서 100의 배수가 아닐 때 또는 400의 배수일때입니다.
		// 예를 들어, 2012년은 4의 배수이면서 100의 배수가 아니라서 윤년이며,
		// 1900년은 100의 배수이고 400의 배수는 아니기 때문에 윤년이 아닙니다.
		// HiNT : 이중 IF문 사용
		// 문제출처, 백준(https://www.acmicpc.net/) 2753번 문제
		
		int year = 2023;
		if(year%4==0 && year%100!=0) {
			System.out.println(year+"년은 윤년입니다.");
		}else if(year%400==0) {
			System.out.println(year+"년은 윤년입니다.");
		}else {
			System.out.println(year+"년은 윤년이 아닙니다.");
		}
		
		
		
		// 문제3) switch문을 이용하여 가위, 바위, 보 중 하나가 주어졌을 때 사용자 어떤 값을 가져야 이길 수 있는 지를 출력하도록
		// 구현하세요.
		// 예를 들어, 가위가 주어졌을 때 "이기기 위해선 바위를 내야합니다." 라고 출력하도록 하세요.
		// 한 단어를 입력받을 경우 Scanner객체의 next() 함수를 사용하면 됩니다.
		System.out.println("가위~ 바위~ 보!>");
		String muk = scanner.nextLine();
		switch(muk) {
		case "가위":
			System.out.println("이기기 위해선 바위를 내야 합니다.");
			break;
		case "바위":
			System.out.println("이기기 위해선 보를 내야 합니다.");
			break;	
		case "보":
			System.out.println("이기기 위해선 가위를 내야 합니다.");
			break;
		default:
			System.out.println("가위, 바위, 보 중 하나를 입력하세요");
			break;
		}
		
		
		
		// 문제4) 차례대로 m과 n을 입력받아 m단을 n번째까지 출력하도록 하세요.
		// 예를 들어 2와 3을 입력받았을 경우 아래처럼 출력합니다.
		// 2 X 1 = 2
		// 2 X 2 = 4
		// 2 X 3 = 6
		System.out.println("m값 입력>");
		int m = Integer.parseInt(scanner.nextLine());
		System.out.println("n값 입력>");
		int n = Integer.parseInt(scanner.nextLine());
		for(int i=1; i<=n; i++) {
			System.out.println(m +" X "+i +" = "+ (i*m));
		}
		
		
		
		//문제5) 호수에서 살고 있는 얼음요정이 곱셈을 공부하기로 했다. 근데 이 요정은 너무 멍청해서 9라는 숫자 이외에는 헷갈려서 잘 쓰지 못한다고 한다. 그래서 사람과는 곱셈방식이 좀 다르다.
		//(규칙 1)
		//곱하는 수나 곱한 결과에 9가 없으면 뭘 곱하든 9가 된다.
		//3*4=9
		//13*17=9
		//(규칙 2)
		//곱하는 수나 곱한 결과에 9가 있으면 값을 그대로 출력한다.
		//19*2=38
		//13*7=91
		//얼음요정의 n*n단을 출력해보자.

		//예시 ) 입력 9
		//출력 
		//1*1=9  2*1=9	 3*1=9	4*1=9	5*1=9	6*1=9	7*1=9	8*1=9	9*1=9 
		//1*2=9  2*2=9	 3*2=9 	4*2=9 	5*2=9 	6*2=9 	7*2=9 	8*2=9	9*2=18 
		//1*3=9	 2*3=9	 3*3=9 	4*3=9 	5*3=9 	6*3=9 	7*3=9 	8*3=9	9*3=27 
		//1*4=9	 2*4=9	 3*4=9 	4*4=9 	5*4=9 	6*4=9 	7*4=9 	8*4=9	9*4=36 
		//1*5=9	 2*5=9	 3*5=9 	4*5=9 	5*5=9 	6*5=9 	7*5=9 	8*5=9 	9*5=45 
		//1*6=9	 2*6=9	 3*6=9 	4*6=9 	5*6=9 	6*6=9 	7*6=9 	8*6=9 	9*6=54 
		//1*7=9	 2*7=9	 3*7=9 	4*7=9 	5*7=9 	6*7=9 	7*7=49 	8*7=9 	9*7=63 
		//1*8=9	 2*8=9	 3*8=9 	4*8=9 	5*8=9 	6*8=9 	7*8=9 	8*8=9 	9*8=72 
		//1*9=9	 2*9=18	 3*9=27 4*9=36 	5*9=45 	6*9=54 	7*9=63 	8*9=72 	9*9=81
		
		System.out.println("얼음요정의 구구단 값 입력>");
		int gugu = Integer.parseInt(scanner.nextLine());
		for(int i=1; i<=gugu; i++) {
			for(int j=1; j<=gugu; j++) {
				if(i==9 || j==9 || (i*j)/10==9 || (i*j)%10==9) {
					System.out.print(j+"*"+i+"="+i*j+"\t");
				}else {
					System.out.print(j+"*"+i+"=9\t");
				}
			}
			System.out.println();
		}
		
		
		
	}
	
}
