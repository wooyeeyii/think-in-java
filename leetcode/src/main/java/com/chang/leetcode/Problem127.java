/*
 * 127. Word Ladder
 *
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
package com.chang.leetcode;

import java.util.*;

public class Problem127 {

    private int minCount = Integer.MAX_VALUE;

    /*
     * Time Limit Exceeded
     */
    public int ladderLengthWrong(String beginWord, String endWord, List<String> wordList) {
        if (0 == wordList.size()) {
            if (1 == diffCount(beginWord, endWord)) {
                return 1;
            } else {
                return 0;
            }
        }

        int pos = wordList.indexOf(endWord);
        if (pos == -1) {
            return 0;
        }
        wordList.remove(pos);

        List<String> list = new ArrayList<String>();
        list.add(beginWord);
        list.addAll(wordList);
        list.add(endWord);
        int len = list.size();
        boolean[] used = new boolean[len];
        int[][] diffBoard = constructDiffArr(list);

        distance(0, len - 1, diffBoard, used, 0);
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }

    private void distance(int start, int end, int[][] diffBoard, boolean[] used, int count) {
        if (end == 0) {
            if (count < minCount) {
                minCount = count + 1;
            }
            return;
        }
        for (int i = 0; i < diffBoard.length; i++) {
            if (1 == diffBoard[i][end] && !used[i]) {
                used[i] = true;
                distance(start, i, diffBoard, used, count + 1);
                used[i] = false;
            }
        }
    }

    private int[][] constructDiffArr(List<String> wordList) {
        int len = wordList.size();
        int[][] diffBoard = new int[len][len];
        for (int i = 0; i < len; i++) {
            diffBoard[i][i] = 0;
            for (int j = i + 1; j < len; j++) {
                diffBoard[i][j] = diffCount(wordList.get(i), wordList.get(j));
                diffBoard[j][i] = diffBoard[i][j];
            }
        }
        return diffBoard;
    }

    private int diffCount(String ord, String dst) {
        if (null == ord || null == dst) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < ord.length(); i++) {
            if (ord.charAt(i) != dst.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem127 problem = new Problem127();

        String[] wordList1 = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> list1 = new ArrayList<String>(Arrays.asList(wordList1));
        System.out.println(5 == problem.ladderLength("hit", "cog", list1));

        problem.minCount = Integer.MAX_VALUE;
        String[] wordList2 = new String[]{"hot", "dot", "dog", "lot", "log"};
        List<String> list2 = new ArrayList<String>(Arrays.asList(wordList2));
        System.out.println(0 == problem.ladderLength("hit", "cog", list2));

        problem.minCount = Integer.MAX_VALUE;
        String[] wordList3 = new String[]{"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln",
                "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya",
                "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr",
                "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di",
                "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi",
                "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};
        List<String> list3 = new ArrayList<String>(Arrays.asList(wordList3));
        System.out.println(problem.ladderLength("qa", "sq", list3));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String temp = q.poll();
                if (temp.equals(endWord)) {
                    return steps + 1;
                }
                for (Iterator<String> iterator = wordList.iterator(); iterator.hasNext(); ) {
                    String current = iterator.next();
                    if (canTransform(current, temp)) {
                        iterator.remove();
                        q.offer(current);
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    //和字典中单词比较是否可以转换
    private boolean canTransform(String word1, String word2) {
        for (int i = 0, count = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i) && ++count > 1) return false;
        }
        return true;
    }

}
