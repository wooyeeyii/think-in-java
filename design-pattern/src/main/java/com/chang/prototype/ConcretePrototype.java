package com.chang.prototype;

//具体原型角色
public class ConcretePrototype implements Prototype {
	
	public Object clone() {
		//
		Prototype prototype = new ConcretePrototype();
		return prototype;
	}

}
