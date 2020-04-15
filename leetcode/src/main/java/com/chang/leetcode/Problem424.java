package com.chang.leetcode;

import java.util.Arrays;

public class Problem424 {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0 || k < 0) {
            return 0;
        }

        int maxLength = -1;
        for (int i = 0; i < s.length() - k; i++) {
            char flag = s.charAt(i);
            int count = 0;
            int j = i + 1;
            while (j < s.length() && count < k) {
                if (s.charAt(j) != flag) {
                    count++;
                }
                j++;
            }
            while (j < s.length() && s.charAt(j) == flag) {
                j++;
            }
            maxLength = maxLength > (j - i) ? maxLength : (j - i);
            if (j == s.length() && count < k) {
                int frontLength = j - i + k - count > s.length() ? s.length() : (j - i + k - count);
                maxLength = maxLength > frontLength ? maxLength : frontLength;
            }
        }
        return maxLength;
    }

    public int characterReplacement_2(String s, int k) {
        int[] count = new int[26];
        Arrays.fill(count, 0);
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            if (end - start + 1 > maxCount + k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Problem424 problem = new Problem424();
        String s = "AABABBA";
        int k = 1;
        System.out.println(problem.characterReplacement_2(s, k));
    }
}
