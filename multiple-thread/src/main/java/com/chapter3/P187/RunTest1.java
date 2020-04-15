package com.chapter3.P187;

/**
 * 出现意外
 *
 * @author junjie.chang
 */
public class RunTest1 {

    public static void main(String[] args) {
        try {
            ThreadB b = new ThreadB();
            ThreadA a = new ThreadA(b);
            a.start();
            b.start();
            b.join(2000);
            System.out.println("main continue b.join(2000)," + Thread.currentThread().getName() + ", time= " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
