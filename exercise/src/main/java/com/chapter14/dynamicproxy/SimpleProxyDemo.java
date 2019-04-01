package com.chapter14.dynamicproxy;

public class SimpleProxyDemo {
	
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("else else");
	}
	
	public static void main(String[] args) {
		consumer(new RealObject());
		consumer( new SimpleProxy(new RealObject()) );
	}

}
 