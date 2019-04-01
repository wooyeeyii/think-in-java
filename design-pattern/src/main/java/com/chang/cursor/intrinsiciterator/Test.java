package com.chang.cursor.intrinsiciterator;

import java.util.ArrayList;

import com.chang.cursor.extrinsiciterator.Aggregate;
import com.chang.cursor.extrinsiciterator.MyIterator;

public class Test {
	
	public void operation() {
		
		ArrayList<String> aryl = new ArrayList<String>();
		
		Object[] objArray = {"One", "Two", "Three", "Four", "Five", "Six", "Seven"};
		
		Aggregate agg = new ConcreteAggregate(objArray);
		MyIterator it = agg.createIterator();
		
		while(!it.isDone()) {
			System.out.println(it.currentItem());
			it.next();
		}
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.operation();
	}

}
