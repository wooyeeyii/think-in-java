package com.chang.proxy.dynamic;

import java.lang.reflect.Proxy;

public class DynamicProxyDemo {
	
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("me me");
	}
	
	public static void main(String[] args) {
		RealObject real =new RealObject();
		consumer(real);
		
		Interface proxy = (Interface)Proxy.newProxyInstance(Interface.class.getClassLoader(), 
				new Class[]{Interface.class}, new DynamicProxy(real));
		consumer(proxy);
	}

}
