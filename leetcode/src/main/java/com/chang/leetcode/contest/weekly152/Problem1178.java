/*
 * 1178. Number of Valid Words for Each Puzzle
 *
 * With respect to a given puzzle string, a word is valid if both the following conditions are satisfied:
 * word contains the first letter of puzzle.
 * For each letter in word, that letter is in puzzle.
 * For example, if the puzzle is "abcdefg", then valid words are "faced", "cabbage", and "baggage";
 * while invalid words are "beefed" (doesn't include "a") and "based" (includes "s" which isn't in the puzzle).
 * Return an array answer, where answer[i] is the number of words in the given word list words that are valid with respect to the puzzle puzzles[i].
 *
 * Example :
 * Input:
 * words = ["aaaa","asas","able","ability","actt","actor","access"],
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * Output: [1,1,3,2,4,0]
 * Explanation:
 * 1 valid word for "aboveyz" : "aaaa"
 * 1 valid word for "abrodyz" : "aaaa"
 * 3 valid words for "abslute" : "aaaa", "asas", "able"
 * 2 valid words for "absoryz" : "aaaa", "asas"
 * 4 valid words for "actresz" : "aaaa", "asas", "actt", "access"
 * There're no valid words for "gaswxyz" cause none of the words in the list contains letter 'g'.
 *
 *
 * Constraints:
 * 1 <= words.length <= 10^5
 * 4 <= words[i].length <= 50
 * 1 <= puzzles.length <= 10^4
 * puzzles[i].length == 7
 * words[i][j], puzzles[i][j] are English lowercase letters.
 * Each puzzles[i] doesn't contain repeated characters.
 */
package com.chang.leetcode.contest.weekly152;

import com.chang.common.ArrayToStringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1178 {

    // Time Limit Exceeded
    public List<Integer> findNumOfValidWordsTooSlow(String[] words, String[] puzzles) {
        List<Integer> result = new ArrayList<>();

        int lenW = words.length;
        int lenP = puzzles.length;
        int[][] wordAlphas = new int[lenW][26];
        int[][] puzzleAlphas = new int[lenP][26];

        for (int i = 0; i < lenW; i++) {
            Arrays.fill(wordAlphas[i], 0);
            for (int j = 0; j < words[i].length(); j++) {
                wordAlphas[i][words[i].charAt(j) - 'a'] += 1;
            }
        }
        for (int i = 0; i < lenP; i++) {
            Arrays.fill(puzzleAlphas[i], 0);
            for (int j = 0; j < puzzles[i].length(); j++) {
                puzzleAlphas[i][puzzles[i].charAt(j) - 'a'] += 1;
            }
        }

        for (int i = 0; i < lenP; i++) {
            int count = 0;
            for (int j = 0; j < lenW; j++) {
                boolean flag = true;
                if (0 == wordAlphas[j][puzzles[i].charAt(0) - 'a']) {
                    flag = false;
                } else {
                    for (int m = 0; m < words[j].length(); m++) {
                        if (wordAlphas[j][words[j].charAt(m) - 'a'] > 0 &&
                                puzzleAlphas[i][words[j].charAt(m) - 'a'] == 0) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    count++;
                }
            }
            result.add(count);
        }

        return result;
    }

    // modify, but still too slow
    // Time Limit Exceeded
    public List<Integer> findNumOfValidWordsTooSlow2(String[] words, String[] puzzles) {
        List<Integer> result = new ArrayList<>();
        int lenW = words.length;
        int lenP = puzzles.length;
        int[] wordC = new int[lenW];
        int[][] puzzleC = new int[lenP][2];
        for (int i = 0; i < lenW; i++) {
            int flag = 0;
            for (int j = 0; j < words[i].length(); j++) {
                flag = flag | (1 << (words[i].charAt(j) - 'a'));
            }
            wordC[i] = flag;
        }
        for (int i = 0; i < lenP; i++) {
            int flag = 0;
            for (int j = 0; j < puzzles[i].length(); j++) {
                flag = flag | (1 << (puzzles[i].charAt(j) - 'a'));
            }
            puzzleC[i][1] = flag;
            puzzleC[i][0] = 1 << (puzzles[i].charAt(0) - 'a');
        }

        for (int i = 0; i < lenP; i++) {
            int count = 0;
            for (int j = 0; j < lenW; j++) {
                if ((puzzleC[i][0] & wordC[j]) != 0 && wordC[j] == (puzzleC[i][1] & wordC[j])) {
                    count++;
                }
            }
            result.add(count);
        }

        return result;
    }

    public static void main(String[] args) {
        Problem1178 problem = new Problem1178();
        String[] words1 = new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
        String[] puzzles1 = new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
        List<Integer> res1 = problem.findNumOfValidWords(words1, puzzles1);
        System.out.println(ArrayToStringUtil.oneDimension(res1));
    }

    // Trie 线段树?
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> result = new ArrayList<>();

        return null;
    }

}
