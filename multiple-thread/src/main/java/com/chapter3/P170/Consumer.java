package com.chapter3.P170;

public class Consumer {

    private MyStack myStack;

    public Consumer(MyStack stack) {
        super();
        this.myStack = stack;
    }

    public void popService() {
        System.out.println("pop = " + myStack.pop());
    }
}
