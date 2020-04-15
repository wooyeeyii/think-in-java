package com.chang.leetcode;


public class Problem202 {

    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Problem202 problem = new Problem202();
        System.out.println(problem.isHappy(7));
    }

}
