/**
 * 1592. Rearrange Spaces Between Words
 * <p>
 * You are given a string text of words that are placed among some number of spaces.
 * Each word consists of one or more lowercase English letters and are separated by at least one space. It's guaranteed that text contains at least one word.
 * Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized.
 * If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as text.
 * <p>
 * Return the string after rearranging the spaces.
 * <p>
 * Example 1:
 * Input: text = "  this   is  a sentence "
 * Output: "this   is   a   sentence"
 * Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
 * <p>
 * Example 2:
 * Input: text = " practice   makes   perfect"
 * Output: "practice   makes   perfect "
 * Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces plus 1 extra space. We place this extra space at the end of the string.
 * <p>
 * Example 3:
 * <p>
 * Input: text = "hello   world"
 * Output: "hello   world"´
 * <p>
 * Example 4:
 * Input: text = "  walks  udp package   into  bar a"
 * Output: "walks  udp  package  into  bar  a "
 * <p>
 * Example 5:
 * Input: text = "a"
 * Output: "a"
 * <p>
 * Constraints:
 * <p>
 * 1 <= text.length <= 100
 * text consists of lowercase English letters and ' '.
 * text contains at least one word.
 */
package com.chang.leetcode.string;

public class Problem1592 {

    public String reorderSpacesOriginal(String text) {
        StringBuilder sb = new StringBuilder();
        char[] chars = text.toCharArray();
        int cntWords = 0;
        int cntBlanks = 0;
        char last = ' ';
        for (char c : chars) {
            if (' ' == c) {
                cntBlanks++;

                if (' ' != last) {
                    cntWords++;
                }
            }
            last = c;
        }

        if (' ' != last) {
            cntWords++;
        }

        int gap = 1 == cntWords ? 0 : cntBlanks / (cntWords - 1);
        int left = 1 == cntWords ? cntBlanks : cntBlanks % (cntWords - 1);
        boolean addBlank = false;
        int used = 1;
        for (char c : chars) {
            if (' ' == c && addBlank && used < cntWords) {
                for (int i = 0; i < gap; i++) {
                    sb.append(' ');
                }
                used++;
                addBlank = false;
            }

            if (' ' != c) {
                sb.append(c);
                addBlank = true;
            }
        }
        for (int i = 0; i < left; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem1592 problem = new Problem1592();
        System.out.println(problem.reorderSpaces("  this   is  a sentence "));
        System.out.println(problem.reorderSpaces(" practice   makes   perfect"));
        System.out.println(problem.reorderSpaces("hello   world"));
        System.out.println(problem.reorderSpaces("  walks  udp package   into  bar a"));
        System.out.println(problem.reorderSpaces("a"));
    }

    public String reorderSpaces(String text) {
        // var words = text.trim().split("\\s+");
        String[] words = text.trim().split("\\s+");
        int cnt = words.length;
        int spaces = text.chars().map(c -> c == ' ' ? 1 : 0).sum();
        int gap = cnt <= 1 ? 0 : spaces / (cnt - 1);
        int trailingSpaces = gap == 0 ? spaces : spaces % (cnt - 1);
        // java 10+
//        return String.join(" ".repeat(gap), words) + " ".repeat(trailingSpaces);
        return "";
    }
}
