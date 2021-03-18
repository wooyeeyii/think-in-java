package com.chang.once;

import java.util.Scanner;

public class Problem2 {

    private static void bubbleSort(int[] times) {
        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < times.length - i - 1; j++) {
                if (times[j] > times[j + 1]) {
                    int tmp = times[j + 1];
                    times[j + 1] = times[j];
                    times[j] = tmp;
                }
            }
        }
    }

    // m cup counts, n: assignments counts
    public static int cal(int[] times, int m, int n) {
        if (null == times || 0 == times.length || 0 == m || 0 == n) {
            return 0;
        }

        int maxTime = 0;
        bubbleSort(times);
        // dp
        if (n <= m) {
            return times[times.length - 1];
        }
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = times[i];
        }
        for (int i = m; i < n; i++) {
            dp[i % m] = dp[i % m] + times[i];
            maxTime = dp[i % m];
        }
        return maxTime;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int m = in.nextInt();
//        int n = in.nextInt();
//        int[] times = new int[n];
//        for (int i = 0; i < n; i++) {
//            times[i] = in.nextInt();
//
//        }
        int[] times = new int[] {8, 4, 3, 1, 10};
        int m = 3, n = 5;
        System.out.println(cal(times, m, n));
    }
}
