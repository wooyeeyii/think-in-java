package com.chang.decorator;

public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        System.out.println("mark. I am from ConcreteDecoratorA.");

        super.sampleOperation();

        //写相关业务
    }

}
