package com.chang.leetcode.math;

import org.junit.Assert;
import org.junit.Test;

public class Problem43Test {

    Problem43 problem = new Problem43();

    @Test
    public void test1() {
        Assert.assertEquals("2", problem.multiply("1", "2"));
        Assert.assertEquals("0", problem.multiply("9999", "0"));
        Assert.assertEquals("2442", problem.multiply("111", "22"));
        Assert.assertEquals("98901", problem.multiply("999", "99"));
        Assert.assertEquals("67143675422804947379429215144664313370120390398055713625298709447",
                problem.multiply("401716832807512840963", "167141802233061013023557397451289113296441069"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("2", problem.multiplyModify1("1", "2"));
        Assert.assertEquals("0", problem.multiplyModify1("9999", "0"));
        Assert.assertEquals("2442", problem.multiplyModify1("111", "22"));
        Assert.assertEquals("98901", problem.multiplyModify1("999", "99"));
        Assert.assertEquals("67143675422804947379429215144664313370120390398055713625298709447",
                problem.multiplyModify1("401716832807512840963", "167141802233061013023557397451289113296441069"));
    }

}