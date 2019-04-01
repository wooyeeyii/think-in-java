/**
 * 验证静态变量，静态代码块的初始顺序
 */
package com.chang.jvm.initialize;

public class initialize {

    public static void main(String[] args) {
        B b = new B();
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
