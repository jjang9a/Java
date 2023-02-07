package com.yedam.API;

public class Key {
	private int key;

	public Key(int key) {
		this.key = key;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key) {
			Key compare = (Key)obj;
			if(this.key == compare.key) {
				return true;
			}
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		//데이터가 같으면, 같은 hashcode를 가질 수 있도록 재정의
		return key;
	}
	
}
