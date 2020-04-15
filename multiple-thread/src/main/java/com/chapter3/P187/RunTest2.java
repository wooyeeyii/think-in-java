package com.chapter3.P187;

public class RunTest2 {

    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        ThreadA a = new ThreadA(b);
        a.start();
        b.start();
        System.out.println("main continue b.join(2000)," + Thread.currentThread().getName() + ", time= " + System.currentTimeMillis());
    }

}
