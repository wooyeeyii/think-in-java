package com.chang.jdk8;

import java.util.Optional;

public class OptionalTest {

    public void test() {
        Optional<B> optionalB = Optional.ofNullable(new B());
        optionalB.ifPresent(a -> a.print("aaa"));   //无返回值

        B b = new B();
        b.print("ccc").map(s -> {
            System.out.println(s);
            return new String("ddd");
        });
    }

    public static void main(String[] args) {
        OptionalTest optionalTest = new OptionalTest();
        optionalTest.test();
    }
}

class B {
    public Optional print(String str) {
        System.out.println(str);
        return Optional.ofNullable("bbb");
    }
}
