package com.chang.decorator;

public class ConcreteComponent implements Component{

	@Override
	public void sampleOperation() {
		System.out.println("mark. I am from ConcreteComponent.");
	}

}
