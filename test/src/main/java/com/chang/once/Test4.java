package com.chang.once;

public class Test4 {
    public static void main(String[] args) throws Exception {
        StringBuffer sbf = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        //10个线程
        for (int i = 0; i < 10; i++) {
            new Thread(new TestThreadA(sbf)).start();
            new Thread(new TestThreadB(sb)).start();
        }
        
        Thread.sleep(5000);
        System.out.println("StringBuffer result:" + sbf.length());
		System.out.println("StringBuider result:" + sb.length());
    }
}

class TestThreadA implements Runnable {
    StringBuffer sbf;
 
    TestThreadA(StringBuffer sbf) {
        this.sbf = sbf;
    }
 
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sbf.append("1");
        }
    }
}

class TestThreadB implements Runnable {
    StringBuilder sb;
 
    TestThreadB(StringBuilder sb) {
        this.sb = sb;
    }
 
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sb.append("1");
        }
    }
}