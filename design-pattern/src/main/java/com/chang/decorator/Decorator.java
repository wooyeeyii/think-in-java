package com.chang.decorator;

public class Decorator implements Component {

	private Component component;
	
	public Decorator(Component component) {
		this.component = component;
	}
	
	@Override
	public void sampleOperation() {
		System.out.println("mark. I am from Decorator.");

		//委派为构件
		component.sampleOperation();
	}

}
