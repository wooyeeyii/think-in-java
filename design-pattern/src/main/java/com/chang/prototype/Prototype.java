package com.chang.prototype;
	
//抽象原型角色
public interface Prototype {
	
	/** 
	 * 克隆自身的方法
	 * @return 一个从自身克隆出来的对象
	 */
	public Object clone();
	
}
