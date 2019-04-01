package com.chang.once;

public class FinalTest {



    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        final Object c = null;
        //c = a;   报错
        //c = b;
        FinalTest test = new FinalTest();
        A aa = new A();
    }
}
class A {
    final int a = 1;    //声明时指定初始值
    final int b;
    final int c;
    static final String NAME_1 = "MengLei"; //声明时指定初始值
    static final String NAME_2;

    {
        b = 2;  //使用非静态初始化块为实例属性b指定初始值
    }

    public A() {
        c = 3;  //使用构造器为实例属性c指定初始值
    }
    static {
        NAME_2 = "MengChen";    //使用静态初始化块为类属性指定初始值
    }

    public void method(int c) {
        //this.a = c; //错误的
    }

}
