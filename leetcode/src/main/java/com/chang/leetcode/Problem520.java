/**
 * 520. Detect Capital
 *
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 *
 * Example 1:
 *
 * Input: "USA"
 * Output: True
 *
 *
 * Example 2:
 *
 * Input: "FlaG"
 * Output: False
 *
 *
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
package com.chang.leetcode;

public class Problem520 {

    public boolean detectCapitalUse(String word) {
        if(null == word || word.length() == 0) {
            return true;
        }

        int len = word.length();
        int flag = 1;
        if(word.charAt(0) <= 'Z') {
            flag = (len >= 2 && word.charAt(1) > 'Z') ? 1 : 0;
        }
        for(int i = 1; i < word.length(); i++) {
            int tmp = word.charAt(i) > 'Z' ? 1 : 0;
            if(1 == (flag ^ tmp)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem520 problem = new Problem520();
        System.out.println(problem.detectCapitalUse("USA"));
        System.out.println(problem.detectCapitalUse("leetcode"));
        System.out.println(problem.detectCapitalUse("Leetcode"));
        System.out.println(!problem.detectCapitalUse("LeetCode"));
        System.out.println(!problem.detectCapitalUse("mL"));
        System.out.println(problem.detectCapitalUse("m"));
        System.out.println(problem.detectCapitalUse("M"));
    }

}
