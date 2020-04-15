/**
 * Count and Say
 * <p>
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * Note: Each term of the sequence of integers will be represented as a string.
 * Example 1:
 * Input: 1
 * Output: "1"
 * <p>
 * Example 2:
 * Input: 4
 * Output: "1211"
 */
package com.chang.leetcode;

public class Problem38 {

    public String countAndSay(int n) {
        String res = "1";
        if (n <= 0) {
            return "";
        }
        int i = 2;
        while (i <= n) {
            String pre = res;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < pre.length(); ) {
                char c = pre.charAt(j);
                int count = 0;
                while (j < pre.length() && c == pre.charAt(j)) {
                    j++;
                    count++;
                }
                sb.append(count);
                sb.append(c);
            }
            res = sb.toString();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem38 problem = new Problem38();
        System.out.println(problem.countAndSay(7));
    }


}
