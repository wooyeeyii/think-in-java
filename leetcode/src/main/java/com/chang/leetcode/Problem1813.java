/*
 * 1813. Sentence Similarity III
 *
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 * For example, "Hello World", "HELLO", "hello world hello world" are all sentences.
 * Words consist of only uppercase and lowercase English letters.
 *
 * Two sentences sentence1 and sentence2 are similar if it is possible to insert an arbitrary sentence (possibly empty)
 * inside one of these sentences such that the two sentences become equal.
 * For example, sentence1 = "Hello my name is Jane" and sentence2 = "Hello Jane" can be made equal by
 * inserting "my name is" between "Hello" and "Jane" in sentence2.
 *
 * Given two sentences sentence1 and sentence2, return true if sentence1 and sentence2 are similar. Otherwise, return false.
 *
 * Example 1:
 * Input: sentence1 = "My name is Haley", sentence2 = "My Haley"
 * Output: true
 * Explanation: sentence2 can be turned to sentence1 by inserting "name is" between "My" and "Haley".
 *
 * Example 2:
 * Input: sentence1 = "of", sentence2 = "A lot of words"
 * Output: false
 * Explanation: No single sentence can be inserted inside one of the sentences to make it equal to the other.
 *
 * Example 3:
 * Input: sentence1 = "Eating right now", sentence2 = "Eating"
 * Output: true
 * Explanation: sentence2 can be turned to sentence1 by inserting "right now" at the end of the sentence.
 *
 * Example 4:
 * Input: sentence1 = "Luky", sentence2 = "Lucccky"
 * Output: false
 *
 * Constraints:
 * 1 <= sentence1.length, sentence2.length <= 100
 * sentence1 and sentence2 consist of lowercase and uppercase English letters and spaces.
 * The words in sentence1 and sentence2 are separated by a single space.
 */
package com.chang.leetcode;

public class Problem1813 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // make str1 always the longer one
        String[] str1 = sentence1.split(" ");
        String[] str2 = sentence2.split(" ");
        if (str1.length < str2.length) {
            String[] tmp = str1;
            str1 = str2;
            str2 = tmp;
        }
        int len1 = str1.length, len2 = str2.length;

        int i = 0;
        for (; i < len2; i++) {
            if (!str1[i].equals(str2[i])) {
                break;
            }
        }

        for (; i < len2; i++) {
            if (!str2[i].equals(str1[len1 - len2 + i])) {
                break;
            }
        }
        return i == len2;
    }

    public static void main(String[] args) {
        Problem1813 problem = new Problem1813();
        System.out.println(problem.areSentencesSimilar("My name is Haley", "My Haley"));
        System.out.println(problem.areSentencesSimilar("of", "A lot of Words"));
        System.out.println(problem.areSentencesSimilar("Eating right now", "Eating"));
        System.out.println(problem.areSentencesSimilar("Eating right now", "now"));
        System.out.println(problem.areSentencesSimilar("Luky", "Luuuuuuky"));
    }

}
