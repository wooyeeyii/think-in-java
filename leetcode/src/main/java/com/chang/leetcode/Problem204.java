package com.chang.leetcode;

public class Problem204 {
    
    public int countPrimes(int n) {
//        if (0 == n || 1 == n) {
//            return 0;
//        }
//        int sum = 0;
//        for (int i = 2; i < n; i++) {
//            if(isPrime(i)) {
//                sum++;
//            }
//        }
//        return sum;
        
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(!notPrime[i]) {
                count++;
                for (int j = i; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            } 
        }
        return count;
    }
    
//    private boolean isPrime(int n) {
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if(n % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        Problem204 problem = new Problem204();
        System.out.println(problem.countPrimes(3));
    }

}
