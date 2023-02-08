package com.yedam.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("java");
		set.add("JDBC");
		set.add("Serverlt/JSP");
		set.add("java");
		set.add("iBatis");
		
		int size = set.size();
		System.out.println("총 객체 수 : "+size);
		
		//반복자를 활용한 HashSet 객체 출력
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t"+element);
		}
		
		System.out.println("=======================");
		
		set.remove("java");
		set.remove("JDBC");
		
		//향상된 for문
		for(String temp : set) {
			System.out.println("\t" +temp);
		}
		
		set.clear();
		System.out.println("총 객체 수 : "+set.size());
		
		if(set.isEmpty()) {
			System.out.println("객체가 존재 하지 않습니다.");
		}
		
		
		
		
		
	}
}
