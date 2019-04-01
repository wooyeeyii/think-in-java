package com.chang.factory.abstractfactory;

public class AmdCpu implements ICpu {
	private int pinsNumber;
	
	public AmdCpu(int pinsNumber) {
		this.pinsNumber = pinsNumber;
	}
	
	@Override
	public void calculate() {
		System.out.println("This is AMD cpu, pins number: " + pinsNumber);
	}
}
