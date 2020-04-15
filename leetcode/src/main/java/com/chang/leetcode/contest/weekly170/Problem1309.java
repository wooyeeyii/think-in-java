/**
 * 1309. Decrypt String from Alphabet to Integer Mapping
 * <p>
 * Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:
 * <p>
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
 * Return the string formed after mapping.
 * <p>
 * It's guaranteed that a unique mapping will always exist.
 * <p>
 * Example 1:
 * Input: s = "10#11#12"
 * Output: "jkab"
 * Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * <p>
 * Example 2:
 * Input: s = "1326#"
 * Output: "acz"
 * <p>
 * Example 3:
 * Input: s = "25#"
 * Output: "y"
 * <p>
 * Example 4:
 * Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * Output: "abcdefghijklmnopqrstuvwxyz"
 */
package com.chang.leetcode.contest.weekly170;

public class Problem1309 {

    public String freqAlphabetsSlow(String s) {
        StringBuilder result = new StringBuilder();
        String[] strs = s.split("#");
        for (int m = 0; m < strs.length; m++) {
            String t = strs[m];
            int len = t.length();
            for (int i = 0; i < len - 2; i++) {
                result.append((char) (Integer.valueOf(t.charAt(i)) + 48));
            }

            if (m != strs.length - 1 || (m == strs.length - 1 && s.endsWith("#"))) {
                int l = Integer.valueOf(t.substring(len - 2, len)) + 96;
                result.append((char) l);
            } else {
                if (len - 2 >= 0) {
                    result.append((char) (Integer.valueOf(t.charAt(len - 2)) + 48));
                }
                result.append((char) (Integer.valueOf(t.charAt(len - 1)) + 48));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Problem1309 problem = new Problem1309();
        System.out.println("a".equals(problem.freqAlphabets("1")));
        System.out.println("jkab".equals(problem.freqAlphabets("10#11#12")));
        System.out.println("acz".equals(problem.freqAlphabets("1326#")));
        System.out.println("y".equals(problem.freqAlphabets("25#")));
        System.out.println("abcdefghijklmnopqrstuvwxyz".equals(problem.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#")));
    }

    // We can simply check whehter '#' character appears at position i + 2 to determine which decription rule to apply.
    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        int len = s.length();
        int idx = 0;
        while (idx < len) {
            if (idx + 2 < len && s.charAt(idx + 2) == '#') {
                int l = Integer.valueOf(s.substring(idx, idx + 2)) + 96;
                result.append((char) l);
                idx += 3;
            } else {
                result.append((char) (Integer.valueOf(s.charAt(idx)) + 48));
                idx++;
            }
        }
        return result.toString();
    }

}
