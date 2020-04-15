package com.chang.factory.abstractfactory;

public class AmdMainboard implements IMainboard {
    private int pinsNumber;

    public AmdMainboard(int pinsNumber) {
        this.pinsNumber = pinsNumber;
    }

    @Override
    public void installCpu() {
        System.out.println("This is AMD Mainboard, pins number: " + pinsNumber);
    }
}
