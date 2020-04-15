package com.chapter1.P28;

public class RunTest3 {

    public static void main(String[] args) {
        MyThread2 thread = new MyThread2();
        thread.start();
		/*try {
			Thread.sleep(1);*/
        System.out.println("thread.isAlive():" + thread.isAlive());
        thread.interrupt();
		/*} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

    }

}
