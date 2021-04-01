package com.chang.once;

public class Once {

    public static void main(String[] args) {
        foo1(4);
        foo2(4);
        foo3(4);
    }

    public static void foo1(int n) {
        if (n > 0) {
            foo1(n - 1);
        }
        System.out.println(n);
    }

    public static void foo2(int n) {
        if (n > 0) {
            foo2(--n);
        }
        System.out.println(n);
    }

    public static void foo3(int n) {
        if (n > 0) {
            foo3(n--);
        }
        System.out.println(n);
    }

}





