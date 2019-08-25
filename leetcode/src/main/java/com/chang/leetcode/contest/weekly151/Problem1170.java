package com.chang.leetcode.contest.weekly151;

import java.util.Arrays;

public class Problem1170 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] queryCount = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            queryCount[i] = minCount(queries[i]);
        }
        int[] wordCount = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            wordCount[i] = minCount(words[i]);
        }
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int count = 0;
            for(int j = 0; j < words.length; j++) {
                if(wordCount[j] > queryCount[i]) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

    private int minCount(String s) {
        int[] flag = new int[26];
        Arrays.fill(flag, 0);
        for (int i = 0; i < s.length(); i++) {
            flag[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] > 0) {
                return flag[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem1170 problem = new Problem1170();
        // 1
        int[] res1 = problem.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"});
        // 1, 2
        int[] res2 = problem.numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"});
    }
}
