package com.chang.leetcode.math;

import java.util.*;
import java.util.stream.Collectors;

public class Problem592 {

    public String fractionAddition(String expression) {
        List<Integer> numerators = new ArrayList<>();
        List<Integer> denominators = new ArrayList<>();  // 分母

        // 算分母的最小公倍数   做分母

        // 分子转换为对应分母最小公倍数的对应值求和   做分子

        return null;
    }

    private void getFraction(String expression, List<Integer> numerators, List<Integer> denominators) {
        List<String> fractions = Arrays.asList(expression.split("[+-]+"));
        List<Integer> signs =
                Arrays.asList(expression.split("[0-9]+[/][0-9]+"))
                        .stream()
                        .map(s -> {
                            if(s.equals("-"))
                                return -1;
                            else
                                return 1;
                        })
                        .collect(Collectors.toList());

        if (fractions.get(0).equals("")) {
            fractions = fractions.subList(1, fractions.size());
        }
        if (signs.size() < fractions.size()) {
            signs.add(0, 1);
        }

        Set<Integer> multiples = new HashSet<>();

        fractions.forEach( fraction -> {
            String[] f = fraction.split("[/]");
            int numerator = Integer.parseInt(f[0]);
            int denominator = Integer.parseInt(f[1]);

            numerators.add(numerator);
            denominators.add(denominator);
            multiples.add(denominator);
        });
    }

    private Integer lcm(List<Integer> denominators) {
        Integer mul = 1;
        for(int i=0;i<denominators.size(); i++)
        {
            mul= mul / (gcd(mul, denominators.get(i))) * denominators.get(i) ;
        }
        return mul;
    }

    private Integer gcd(Integer a, Integer b) {
        int gcd = 0;
        Integer n1 = Math.max(a, b);
        Integer n2 = Math.min(a, b);

        if (n1 % n2 == 0) {
            gcd = n2;
        }

        while (n1 % n2 > 0) {
            Integer n3 = n1 % n2;
            n1 = n2;
            n2 = n3;

            if (n1 % n2 == 0) {
                gcd = n2;
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        Problem592 problem = new Problem592();

        System.out.println("0/1".equals(problem.fractionAddition("-1/2+1/2")));
        System.out.println("1/3".equals(problem.fractionAddition("-1/2+1/2+1/3")));
        System.out.println("-1/6".equals(problem.fractionAddition("1/3-1/2")));
        System.out.println("2/1".equals(problem.fractionAddition("5/3+1/3")));
        System.out.println("-1/3".equals(problem.fractionAddition("-1/3")));
    }

}
