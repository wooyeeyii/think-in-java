package com.chang.leetcode.math;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem29Test {

    private Problem29 problem = new Problem29();

    @Test
    public void test1() {
        Assert.assertEquals(3, problem.divide(10, 3));
        Assert.assertEquals(3, problem.divide(9, 3));
        Assert.assertEquals(-2, problem.divide(7, -3));
        Assert.assertEquals(2147483647, problem.divide(-2147483648, -1));
        Assert.assertEquals(-2147483648, problem.divide(-2147483648, 1));
    }

}