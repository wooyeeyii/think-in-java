package com.examples.visibility;

public class WhileRun {

    private boolean flag = true;

    public void run() {
        System.out.println("begin running...");
        while (flag) {
        }
        System.out.println("stop running...");
    }

    public void stopRun() {
        System.out.println("set stop begin...");
        flag = false;
        System.out.println("set stop finished...");
    }

}
