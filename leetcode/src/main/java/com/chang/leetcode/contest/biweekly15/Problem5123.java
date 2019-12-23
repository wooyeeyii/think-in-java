package com.chang.leetcode.contest.biweekly15;

public class Problem5123 {

    private char[] chars = null;
    private int len = 0;
    private int combinationLength = 0;
    private int[] pos = null;
    private char[] nextStr = null;
    private boolean hasNext = true;

    public Problem5123(String characters, int combinationLength) {
        this.chars = characters.toCharArray();
        len = chars.length;
        this.combinationLength = combinationLength;
        pos = new int[combinationLength];
        nextStr = new char[combinationLength];
        for (int i = 0; i < combinationLength; i++) {
            pos[i] = i;
            nextStr[i] = chars[pos[i]];
        }
    }

    public String next() {
        String res = new String(nextStr);

        calNext();

        return res;
    }

    private void calNext() {
        int last = -1;
        for (int i = combinationLength - 1; i >= 0; i--) {
            if (pos[i] < len - (combinationLength - i)) {
                last = i;
                break;
            }
        }

        if (last < 0) {
            this.hasNext = false;
            return;
        }

        int end = pos[last] + 1;
        for (int j = last; j < combinationLength; j++) {
            pos[j] = end;
            nextStr[j] = chars[pos[j]];
            end++;
        }
    }

    public boolean hasNext() {
        return hasNext;
    }

    public static void main(String[] args) {
        Problem5123 problem = new Problem5123("chp", 1);
        System.out.println(problem.hasNext());
        System.out.println(problem.hasNext());
        System.out.println(problem.next());
        System.out.println(problem.hasNext());
        System.out.println(problem.next());
        System.out.println(problem.hasNext());
        System.out.println(problem.next());
        System.out.println(problem.hasNext());
    }

}
