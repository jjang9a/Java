package test;

public class Num04 {
	public static void main(String[] args) {
		String[] arr = {"010102-4", "991012-1", "960304-1", "881012-2", "040403-3"};
		
		int m = 0;
		int f = 0;
		
		for(int i=0; i<arr.length; i++) {
			char gender = arr[i].charAt(7);
			switch(gender) {
			case '1':
			case '3':
				m++;
				break;
			case '2':
			case '4':
				f++;
				break;
			}
		}
		
		System.out.println("남자 : "+m+"명, 여자 : "+f+"명");
	}
}
