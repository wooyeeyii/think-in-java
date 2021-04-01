package com.chang.leetcode;

public class Problem1716 {

    public int totalMoney(int n) {
        int m = n / 7;
        int sum = 28 * m + (m - 1) * m / 2 * 7;
        int left = n % 7;
        sum += (2 * m + left + 1) * left / 2;
        return sum;
    }

    public static void main(String[] args) {
        Problem1716 problem = new Problem1716();
        // 10
        System.out.println(problem.totalMoney(4));
        // 37
        System.out.println(problem.totalMoney(10));
        // 96
        System.out.println(problem.totalMoney(20));
    }

}
