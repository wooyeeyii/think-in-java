package com.chang.proxy.dynamic;

//��̬����

public class SimpleProxy implements Interface {
	private Interface proxied;
	
	public SimpleProxy(Interface in) {
		this.proxied = in;
	}

	@Override
	public void doSomething() {
		System.out.println("SimpleProxy do something.");
		proxied.doSomething();
	}

	@Override
	public void somethingElse(String arg) {
		System.out.println("SimpleProxy something else:" + arg);
		proxied.somethingElse(arg);
	}

}
