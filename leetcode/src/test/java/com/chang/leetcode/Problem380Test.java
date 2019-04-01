package com.chang.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class Problem380Test {

    private Problem380 problem = new Problem380();

    @Test
    public void test1() {
        System.out.println(problem.insert(1));
        System.out.println(problem.remove(2));
        System.out.println(problem.insert(2));
        System.out.println(problem.getRandom());
        System.out.println(problem.remove(1));
        System.out.println(problem.insert(2));
        System.out.println(problem.getRandom());
    }


}