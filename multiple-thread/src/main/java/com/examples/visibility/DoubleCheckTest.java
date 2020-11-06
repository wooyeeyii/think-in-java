package com.examples.visibility;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DoubleCheckTest {

    private DoubleCheckTest doubleCheckTest;

    public void getInstance() {
        if (null != doubleCheckTest) {
            synchronized (this.getClass()) {
                if (null != doubleCheckTest) {
                    System.out.println("generate...");
                    doubleCheckTest = new DoubleCheckTest();
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        DoubleCheckTest doubleCheckTest = new DoubleCheckTest();
        executorService.execute(doubleCheckTest::getInstance);
    }

}
