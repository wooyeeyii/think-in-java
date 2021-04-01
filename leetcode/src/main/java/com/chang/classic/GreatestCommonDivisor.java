package com.chang.classic;

public class GreatestCommonDivisor {

    // 辗转相除法
    // gcd(a,b) = gcd(b,a mod b)
    public int divideEach(int a, int b) {
        int m = Math.max(a, b);
        int n = Math.min(a, b);
        while (0 != n) {
            int c = m % n;
            m = n;
            n = c;
        }
        return m;
    }

    // 更相减损法
}
