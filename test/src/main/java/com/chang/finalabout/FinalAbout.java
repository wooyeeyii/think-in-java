/**
 * HashMap使用new HashMap<>(map)复制另一个map时，为浅复制，生成了另一块空间，
 * 但新map中引用的对象仍与原map相同，修改引用对象中的值，两个map均会发生变化。
 */
package com.chang.finalabout;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FinalAbout {

	public static void main(String[] args) {
		final Map<String, A> map = new HashMap<String, A>();

		map.put("1", new A("1"));
		map.put("2", new A("2"));
		map.put("3", new A("3"));
		Map<String, A> mapcopy = new HashMap<String, A>(map);

		System.out.println("Original map:");
		for(Entry<String, A> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue().a);
		}

		System.out.println("Copy map:");
		for(Entry<String, A> entry : mapcopy.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue().a);
		}

		mapcopy.put("7", new A("7"));
		mapcopy.put("8", new A("8"));

		mapcopy.get("1").Aa("1111111");
		mapcopy.get("2").Aa("2222222");
		mapcopy.put("2", new A("000"));
		mapcopy.remove("3");

		System.out.println("after copy and modified, the Original map:");
		for(Entry<String, A> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue().a);
		}

		System.out.println("after modified, the Copy map:");
		for(Entry<String, A> entry : mapcopy.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue().a);
		}

	}

}

class A {
	public String a = new String();

	public A(String a) {
		this.a = a;
	}

	public void Aa(String a) {
		this.a = a;
	}

}
