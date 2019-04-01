package com.chang.TemplateMethod;

public abstract class AbstractTemplate {
	
	/** 模板方法 **/
	public  void templateMethod() {
		//调用基本方法
		abstractMethod();
		hookMethod();
		concreteMethod();
	}

	//基本方法的声明，由子类实现
	protected abstract void abstractMethod();

	// 基本方法， 空方法
	protected void hookMethod() {}

	// 基本方法， 已实现
	private void concreteMethod() {
		//业务相关的代码
	};

}
