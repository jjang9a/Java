package JAVA;

public class Item {
	//필드 -상품수, 가격
		String name;
		int price;
		
	//생성자
		public Item() {
			
		}
		
		public Item(String name, int price) {
			this.name = name;
			this.price = price;
		}
		
	//메소드 - 최고가격제품, 해당제품을 제외한 제품들의 총 합
}
