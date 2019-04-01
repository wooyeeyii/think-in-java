package com.chang.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodInvokeTest {

    public static void main(String[] args) {
        // 构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下
        Car car = Car.create(Car::new);

        List<Car> cars = Arrays.asList(car);
        // 静态方法引用：它的语法是Class::static_method
        cars.forEach(Car::collide);
        // 特定类的任意对象的方法引用：它的语法是Class::method
        cars.forEach(Car::repair);
        // 特定对象的方法引用：它的语法是instance::method
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);

        // 例子2
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.forEach(System.out::println);
    }

}
