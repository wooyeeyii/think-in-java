package com.chang.reflection;

public class TestClassType {
    private int intpri = 0;
    public int intpub = 0;
    private String strpri = "NIL";
    public String strpub = "NIL";

    //构造函数
    public TestClassType() {
        System.out.println("----构造函数---");
    }

    public TestClassType(String str) {
        super();
        System.out.println(str);
    }

    //静态的参数初始化
    static {
        System.out.println("---静态的参数初始化---");
    }

    //非静态的参数初始化
    {
        System.out.println("----非静态的参数初始化---");
    }

    public void printValue() {
        System.out.println("intpri: " + intpri + ", intpub: " + intpub + ", strpri: " + strpri + ", strpub: " + strpub);
    }

    public void Method(int a, String b) {
        System.out.println("a: " + a + ", b:" + b);
    }
} 
