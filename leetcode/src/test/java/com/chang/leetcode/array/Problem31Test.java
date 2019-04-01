package com.chang.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem31Test {

    Problem31 problem = new Problem31();

    @Test
    public void test1() {
        int[] nums = new int[] {3, 2, 1};
        problem.nextPermutation(nums);
        Assert.assertArrayEquals(new int[] {1, 2, 3}, nums);

        nums = new int[] {1, 2, 3};
        problem.nextPermutation(nums);
        Assert.assertArrayEquals(new int[] {1, 3, 2}, nums);

        nums = new int[] {1, 1, 5};
        problem.nextPermutation(nums);
        Assert.assertArrayEquals(new int[] {1, 5, 1}, nums);

        nums = new int[] {1, 3, 2};
        problem.nextPermutation(nums);
        Assert.assertArrayEquals(new int[] {2, 1, 3}, nums);

    }

}