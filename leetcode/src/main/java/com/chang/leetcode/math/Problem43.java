package com.chang.leetcode.math;

public class Problem43 {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        if (m == 0 || (m == 1 && Integer.valueOf(num1) == 0) ||
                n == 0 || (n == 1 && Integer.valueOf(num2) == 0)) {
            return "0";
        }
        int[][] sum = new int[n][m + n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m + n; j++) {
                sum[i][j] = 0;
            }
        }

        int low = 0;
        int high = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.valueOf(num2.charAt(n - 1 - i)) - 48;
            int j = 0;
            high = 0;
            for (; j < m; j++) {
                int b = Integer.valueOf(num1.charAt(m - 1 - j)) - 48;
                String mul = String.valueOf(a * b + high);
                low = mul.charAt(mul.length() - 1) - 48;
                high = mul.length() > 1 ? Integer.valueOf(mul.substring(0, mul.length() - 1)) : 0;
                sum[i][i + j] = low;
            }
            sum[i][i + j] = high;
        }

        int[] colSum = new int[m + n];
        high = 0;
        for (int i = 0; i < m + n; i++) {
            int tmp = high;
            for (int j = 0; j < n; j++) {
                tmp += sum[j][i];
            }
            String mul = String.valueOf(tmp);
            low = mul.charAt(mul.length() - 1) - 48;
            high = mul.length() > 1 ? Integer.valueOf(mul.substring(0, mul.length() - 1)) : 0;
            colSum[i] = low;
        }
        StringBuilder sb = new StringBuilder();
        if (colSum[m + n - 1] != 0) {
            sb.append(String.valueOf(colSum[m + n - 1]));
        }
        for (int i = m + n - 2; i >= 0; i--) {
            sb.append(String.valueOf(colSum[i]));
        }
        return sb.toString();
    }

    public String multiplyModify1(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        if (m == 0 || (m == 1 && Integer.valueOf(num1) == 0) ||
                n == 0 || (n == 1 && Integer.valueOf(num2) == 0)) {
            return "0";
        }

        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (pos[0] != 0) {
            sb.append(String.valueOf(pos[0]));
        }
        for (int i = 1; i < m + n; i++) {
            sb.append(String.valueOf(pos[i]));
        }
        return sb.toString();
    }

    /**
     * Is there any possibility that pos[p1] will be greater than 10?
     * e.g., mul = 81 and pos[p2] = 9, pos[p1] = 8, then pos[p1] will become 17
     * <p>
     * I guess you don't need to worry about that if you have pos[p1] = 17
     * since this 17 will only be there temporarily. The way we iterate j is from right to left,
     * so every time we move to the j on the left, p1 will become p2,
     * and this 17 will be added into sum together with mul, followed by %.
     */
    public String multiplySample1(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
