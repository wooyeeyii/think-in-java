/*
 * 1239. Maximum Length of a Concatenated String with Unique Characters
 *
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 *
 * Return the maximum possible length of s.
 *
 * Example 1:
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 *
 * Example 2:
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 *
 * Example 3:
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 *
 * Constraints:
 *
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 */
package com.chang.leetcode.contest.weekly160;

import java.util.*;

public class Problem1239 {

    public static void main(String[] args) {

        Interface1239 problem = new Problem1239OfMy();
//        Interface1239 problem = new Problem1239OfExample1();
//        Interface1239 problem = new Problem1239OfExample2();

        String[] arr5 = new String[]{"yy", "bkhwmpbiisbldzknpm"};
        List<String> list5 = Arrays.asList(arr5);
        System.out.println(0 == problem.maxLength(list5));

        String[] arr1 = new String[]{"un", "iq", "ue"};
        List<String> list1 = Arrays.asList(arr1);
        System.out.println(4 == problem.maxLength(list1));

        String[] arr2 = new String[]{"cha", "r", "act", "ers"};
        List<String> list2 = Arrays.asList(arr2);
        System.out.println(6 == problem.maxLength(list2));

        String[] arr4 = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
        List<String> list4 = Arrays.asList(arr4);
        System.out.println(11 == problem.maxLength(list4));

        String[] arr6 = new String[]{"ogud", "ejipchfydrgl", "b", "kjxmzhnuoisgqvawel", "mizlcgdqebwuotfnk", "bjvkrgeozidytquchlw", "tzjqwumkirxeal", "x", "rkpuabmo", "mxndpcqzua"};
        List<String> list6 = Arrays.asList(arr6);
        System.out.println(20 == problem.maxLength(list6));

        String[] arr3 = new String[]{"abcdefghijklmnopqrstuvwxyz"};
        List<String> list3 = Arrays.asList(arr3);
        System.out.println(26 == problem.maxLength(list3));

    }

}


