package com.chang.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ReleaseTime {
	
	public static void main(String[] args) {
		SetTest setTest = new SetTest();
		setTest.add("1");
		setTest.add("2");
		setTest.add("3");
		
		System.out.println( setTest.get("2") );
		System.out.println( "--------------" );
		
		setTest.printAll();

	}
}

class SetTest {
	private Map<String, String> map = new HashMap<String, String>();
	
	public void add(String str) {
		map.put(str, str);
	}
	
	public String get(String str) {
		String tmp = map.get(str);
		map.remove(str);
		return tmp;
	}
	
	public void printAll() {
		for( Entry<String, String> entry : map.entrySet() ) {
			System.out.println("key: " + entry.getKey() + ", value: " +  entry.getValue() );
		}
	}
	
}
