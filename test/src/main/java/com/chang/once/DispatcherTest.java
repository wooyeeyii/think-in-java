package com.chang.once;

public class DispatcherTest {

    static class Animal {
    }

    static class Cat extends Animal {
    }

    static class Dog extends Animal {
    }

    static class Man {
        public void say(Animal animal) {
            System.out.println("Class Man say animal. ");
        }

        public void say(Cat cat) {
            System.out.println("Class Man say cat. ");
        }
    }

    static class Woman extends Man {
        @Override
        public void say(Animal animal) {
            System.out.println("Class Woman say hi. ");
        }

        @Override
        public void say(Cat cat) {
            System.out.println("Class Woman say cat. ");
        }
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();
        Man man = new Man();
        Woman woman = new Woman();

        man.say(animal);
        man.say(cat);
        woman.say(animal);
        woman.say(cat);
    }

}
