package com.chang.leetcode.contest.weekly152;

public class Problem5173 {

    public int numPrimeArrangements(int n) {
        int c = (int)Math.pow(10, 9) + 7;
        int primeNumber = countPrimeNumber(n);

        long mulS = 1;
        int min = Math.min(primeNumber, n - primeNumber);
        int max = Math.max(primeNumber, n - primeNumber);
        for(int i = 1; i <= min; i++) {
            mulS = (mulS * i) % c;
        }
        long mulB = mulS * mulS % c;
        for(int j = min + 1; j <= max; j++ ) {
            mulB = (mulB * j) % c;
        }
        return (int)mulB;
    }

    private int countPrimeNumber(int n) {
        if(n <= 1) return 0;

        int count = 0;
        for(int i = 2; i <= n; i++) {
            boolean flag = true;
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                   flag = false;
                    break;
                }
            }
            if(flag) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Problem5173 problem = new Problem5173();
        System.out.println(12 == problem.numPrimeArrangements(5));
        System.out.println(682289015 == (problem.numPrimeArrangements(100)));
    }

}
