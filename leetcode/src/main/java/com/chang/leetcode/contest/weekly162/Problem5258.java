package com.chang.leetcode.contest.weekly162;

import java.util.Arrays;

public class Problem5258 {

    int max = 0;
    int[] score = null;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.score = score;
        int[] charNumber = new int[26];
        for (char c : letters) {
            charNumber[c - 'a'] += 1;
        }

        dfs(words, 0, charNumber, 0);
        return max;
    }

    private void dfs(String[] words, int index, int[] charNumber, int cur) {
        max = Math.max(max, cur);

        if (words == null || words.length - 1 < index) return;

        for (int i = index; i < words.length; i++) {
            int[] charNumberNext = canFitIn(words[i], charNumber);
            if (null != charNumberNext) {
                int next = cur;
                for (char c : words[i].toCharArray()) {
                    next += score[c - 'a'];
                }
                dfs(words, i + 1, charNumberNext, next);
            }
        }
    }

    private int[] canFitIn(String word, int[] charNumber) {
        int[] charNumberNext = Arrays.copyOf(charNumber, charNumber.length);
        for (char c : word.toCharArray()) {
            if (charNumberNext[c - 'a'] > 0) {
                charNumberNext[c - 'a'] -= 1;
            } else {
                return null;
            }
        }
        return charNumberNext;
    }

    public static void main(String[] args) {
        Problem5258 problem = new Problem5258();
        System.out.println(23 == problem.maxScoreWords(new String[]{"dog", "cat", "dad", "good"},
                new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'},
                new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

        problem.max = 0;
        System.out.println(27 == problem.maxScoreWords(new String[]{"xxxz", "ax", "bx", "cx"},
                new char[]{'z', 'a', 'b', 'c', 'x', 'x', 'x'},
                new int[]{4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10}));

        problem.max = 0;
        System.out.println(0 == problem.maxScoreWords(new String[]{"leetcode"},
                new char[]{'l', 'e', 't', 'c', 'o', 'd'},
                new int[]{0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}));
    }
}
