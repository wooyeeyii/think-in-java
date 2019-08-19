package com.chang.leetcode.contest.weekly150;

import java.util.Arrays;

public class Problem1160 {

    public int countCharacters(String[] words, String chars) {
        int result = 0;
        int[] flag = new int[26];
        Arrays.fill(flag, 0);
        for (int i = 0; i < chars.length(); i++) {
            flag[chars.charAt(i) - 'a'] += 1;
        }

        for (String word : words) {
            boolean valid = true;
            int[] tmp = Arrays.copyOf(flag, flag.length);
            for (int i = 0; i < word.length(); i++) {
                if (tmp[word.charAt(i) - 'a'] <= 0) {
                    valid = false;
                    break;
                } else {
                    tmp[word.charAt(i) - 'a'] -= 1;
                }
            }

            if (valid) {
                result += word.length();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem1160 problem = new Problem1160();
        String[] words1 = new String[]{"cat", "bt", "hat", "tree"};
        System.out.println(6 == problem.countCharacters(words1, "atach"));

        String[] words2 = new String[]{"hello", "world", "leetcode"};
        System.out.println(10 == problem.countCharacters(words2, "welldonehoneyr"));
    }
}
