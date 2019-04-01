package com.chang.factory.abstractfactory;

public class IntelCpu implements ICpu {
	private int pinsNumber;
	
	public IntelCpu(int pinsNumber) {
		this.pinsNumber = pinsNumber;
	}
	
	@Override
	public void calculate() {
		System.out.println("This is Intel cpu, pins number: " + pinsNumber);
	}
}
