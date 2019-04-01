package com.chang.jvm.gc;

public class ReferenceCountingGC {
	
	public Object instance = null;
	
	private static final int _1MB = 1024 * 1024;
	
	/**
	 * 这个成员变量的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
	 */
	public static void testGC() {
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		
		objA.instance = objB;
		objB.instance = objA;
		
		//假设在这里发生GC, objA和objB是否能被收回?
		System.gc();
	}
	
	public static void main(String[] args) {
		testGC();
	}
	
}
