package com.examples.visibility;

public class RunTest {

    public static void main(String[] args)
            throws InterruptedException {
        WhileRun whileRun = new WhileRun();

        new Thread(whileRun::run).start();

        Thread.sleep(1000);

        new Thread(whileRun::stopRun).start();
    }

}
