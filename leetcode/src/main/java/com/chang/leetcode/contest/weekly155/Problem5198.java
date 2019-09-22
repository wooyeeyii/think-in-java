package com.chang.leetcode.contest.weekly155;

public class Problem5198 {

    public int nthUglyNumberTooSlow(int n, int a, int b, int c) {
        long result = 0;
        long aCur = 1;
        long bCur = 1;
        long cCur = 1;
        for(int i = 0; i < n; i++) {
            long min = Math.min(aCur * a, Math.min(bCur * b, cCur * c));
            result = min;
            if(aCur * a == min) {
                aCur++;
            }
            if(bCur * b == min) {
                bCur++;
            }
            if(cCur * c == min) {
                cCur++;
            }
        }
        return (int)result;
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        int count = 0;
        int cur = 1;
        while(count < n) {
            if(cur % a == 0 || cur % b == 0 || cur % c == 0) {
                count++;
            }
            cur++;
        }
        return cur - 1;
    }

    public static void main(String[] args) {
        Problem5198 problem = new Problem5198();
        System.out.println(4 == problem.nthUglyNumber(3, 2, 3, 5));
        System.out.println(6 == problem.nthUglyNumber(4, 2, 3, 4));
        System.out.println(10 == problem.nthUglyNumber(5, 2, 11, 13));
        System.out.println(1999999984 == problem.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }
}
