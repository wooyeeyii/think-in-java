package com.chang.jvm.initialize;

public class Test {

    static class Parent {

        public static int A = 1;

        static {
            A = 2;
        }

    }

    static class Sub extends Parent {

        public static int B = A;

        public static void main(String[] args) {
            System.out.println("B = " + B);
        }
    }

    public static void main(String[] args) {

        System.out.println(Parent.A);
    }

}
