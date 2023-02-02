package com.yedam.access;

public class Application01 {
	public static void main(String[] args) {
		Access ac = new Access();
		
		//public
		ac.free = "public";
		//protected
		ac.parent = "parent";
		//default
		ac.basic = "basic";
		//private
//		ac.privacy = "privacy";
		
		ac.instead();
		ac.parent();
		ac.basic();
	}
}
