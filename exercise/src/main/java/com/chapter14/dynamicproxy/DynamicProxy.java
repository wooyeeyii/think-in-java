package com.chapter14.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
	private Object proxied;
	
	public DynamicProxy(Object proxied) {
		this.proxied = proxied;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("******* proxy: " + proxy.getClass() + ", method: " + method  +", args: " + args);
		if(null != args) {
			for(Object arg : args) {
				System.out.println("  " + arg);
			}
		}
		return method.invoke(proxied, args);
	}
}
