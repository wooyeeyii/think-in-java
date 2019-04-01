package com.chang.decorator;

public class Test {
	
	
	public static void main(String[] args) {
		Component component = new ConcreteComponent();
		ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB(new ConcreteDecoratorA(component));
		concreteDecoratorB.sampleOperation();
		System.out.println();
		ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(new ConcreteDecoratorA(component));
		concreteDecoratorA.sampleOperation();
	}

}
