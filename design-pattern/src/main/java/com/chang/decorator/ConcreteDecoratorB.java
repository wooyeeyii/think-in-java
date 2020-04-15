package com.chang.decorator;

public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        System.out.println("mark. I am from ConcreteDecoratorB.");

        super.sampleOperation();

        //写相关业务
    }

}
