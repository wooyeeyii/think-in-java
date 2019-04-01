package com.chang.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LamdaExpressionTest {

    public List<String> list;

    public LamdaExpressionTest() {
        list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
    }

    public void printValur(String str) {
        System.out.println("print value : " + str);
    }

    public void printListTra() {
        for (String s : list) {
            printValur(s);
        }
    }

    public void printListUseForEach() {
        list.forEach(x -> printValur(x));
    }


    public void useLocalValue() {
        final String separator = ",";
        Arrays.asList("a", "b", "d").forEach(
                (String e) -> System.out.print(e + separator));
    }

    /**
     * ar.sort((e1, e2) -> e1.compareTo(e2));
     * 等价于
     * ar.sort((e1, e2) -> {
     *      int result = e1.compareTo(e2);
     *      return result;
     *      });
     */
    public void withoutReturn() {
        List<String> ar = Arrays.asList("z", "y", "x");
        ar.sort((e1, e2) -> e1.compareTo(e2));
        // 等价于
        ar.add("b");
        ar.add("a");
        ar.sort((e1, e2) -> {
            int result = e1.compareTo(e2);
            return result;
        });
    }


    /**
     * 所有的函数输出结果一致，都是遍历数组
     *
     * @param args
     */
    public static void main(String[] args) {
        LamdaExpressionTest test = new LamdaExpressionTest();
        test.printListTra();
        System.out.println("#######################");
        test.printListUseForEach();
        System.out.println("#######################");
        test.list.forEach(test::printValur);
        System.out.println("#######################");
        Consumer<String> methodParam = test::printValur; //方法参数
        test.list.forEach(x -> methodParam.accept(x));//方法执行accept
        System.out.println("#######################");
        test.useLocalValue();
        System.out.println("#######################");
        test.withoutReturn();
        System.out.println("#######################");

    }
}
