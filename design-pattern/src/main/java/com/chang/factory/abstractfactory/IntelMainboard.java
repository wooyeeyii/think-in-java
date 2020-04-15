package com.chang.factory.abstractfactory;

public class IntelMainboard implements IMainboard {
    private int pinsNumber;

    public IntelMainboard(int pinsNumber) {
        this.pinsNumber = pinsNumber;
    }

    @Override
    public void installCpu() {
        System.out.println("This is Intel Mainboard, pins number: " + pinsNumber);
    }
}
