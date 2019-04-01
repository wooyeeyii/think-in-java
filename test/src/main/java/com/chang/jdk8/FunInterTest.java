package com.chang.jdk8;

import java.util.ArrayList;
import java.util.List;

public class FunInterTest {
    public static void main(String[] args) {
        Animal dog = () -> System.out.println("wang, wang");

        List<Animal> animal = new ArrayList<Animal>();
        animal.add(dog);
        animal.add(() -> System.out.println("miao, miao"));
        // 旧写法
        animal.add(new Animal() {
            @Override
            public void howl() {
                System.out.println("old, old");
            }
        });
        animal.forEach(Animal::howl);
    }
}
