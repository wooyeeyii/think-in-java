package com.chang.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Problem7Test {

    private Problem7 problem = new Problem7();

    @Test
    public void reverseTest() {
        int y = problem.reverse(1534236469);
        Assert.assertEquals(0, y);
        y = problem.reverse(-123);
        Assert.assertEquals(-321, y);
        y = problem.reverse(120);
        Assert.assertEquals(21, y);
    }

    @Test
    public void reverseTest2() {
        int y = problem.reverseMehtod2(1534236469);
        Assert.assertEquals(0, y);
        y = problem.reverseMehtod2(-123);
        Assert.assertEquals(-321, y);
        y = problem.reverseMehtod2(120);
        Assert.assertEquals(21, y);
    }

}