package com.chang.leetcode.contest.biweekly13;

public class Problem5108 {

    // grey code
    public String encode(int num) {
        if(num == 0) {
            return "";
        }

        int count = getBits(num);

        String s = "";
        int left = num;
        while(left > 0) {
            int half = (1 << count) - 1 + (1 << (count - 1)) - 1;
            int a = left <= half ? 0 : 1;
            if(a == 0) {
                left = left - (1 << count) + (1 << (count - 1));
            } else {
                left = left - half + (1 << (count - 1)) - 2;
            }
            count--;

            s += String.valueOf(a);
        }

        return s;
    }

    // 等比数列求和 2^0 + 2^1 + 2^2 + ...      2^(n + 1) - 1;
    private int getBits(int num) {
        int count = 0;
        while(((1 << count) - 1) <= num) {
            count++;
        }
        return count - 1;
    }

    public static void main(String[] args) {
        Problem5108 problem = new Problem5108();
        System.out.println("11".equals(problem.encode(6)));
        System.out.println("001".equals(problem.encode(8)));
        System.out.println("1000".equals(problem.encode(23)));
        System.out.println("101100".equals(problem.encode(107)));

    }

}
