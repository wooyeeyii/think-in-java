/*
 * 1505. Minimum Possible Integer After at Most K Adjacent Swaps On Digits
 *
 * Given a string num representing the digits of a very large integer and an integer k.
 * You are allowed to swap any two adjacent digits of the integer at most k times.
 * Return the minimum integer you can obtain also as a string.
 *
 * Example 1:
 * Input: num = "4321", k = 4
 * Output: "1342"
 * Explanation: The steps to obtain the minimum integer from 4321 with 4 adjacent swaps are shown.
 *
 * Example 2:
 * Input: num = "100", k = 1
 * Output: "010"
 * Explanation: It's ok for the output to have leading zeros, but the input is guaranteed not to have any leading zeros.
 *
 * Example 3:
 * Input: num = "36789", k = 1000
 * Output: "36789"
 * Explanation: We can keep the number without any swaps.
 *
 * Example 4:
 * Input: num = "22", k = 22
 * Output: "22"
 *
 * Example 5:
 * Input: num = "9438957234785635408", k = 23
 * Output: "0345989723478563548"
 *
 * Constraints:
 * 1 <= num.length <= 30000
 * num contains digits only and doesn't have leading zeros.
 * 1 <= k <= 10^9
 */
package com.chang.leetcode.contest.weekly196;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem1505 {

    // TOO SLOW
    public String minInteger(String num, int k) {
        char[] chars = num.toCharArray();
        int start = 0, len = num.length();
        while (k > 0 && start < len) {
            int minPos = start, cnt = 0;
            for (int idx = start; idx < len && cnt <= k; idx++, cnt++) {
                if (chars[idx] < chars[minPos]) {
                    minPos = idx;
                }
            }
            if (minPos != start) {
                for (int i = minPos; i > start; i--) {
                    swap(chars, i, i - 1);
                }
            }

            k = k - (minPos - start);
            start += 1;
        }

        return String.valueOf(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public static void main(String[] args) {
        Problem1505 problem = new Problem1505();
        System.out.println("1342".equals(problem.minInteger("4321", 4)));
        System.out.println("010".equals(problem.minInteger("100", 1)));
        System.out.println("36789".equals(problem.minInteger("36789", 1000)));
        System.out.println("22".equals(problem.minInteger("22", 22)));
        System.out.println("0345989723478563548".equals(problem.minInteger("9438957234785635408", 23)));
    }

    public String minIntegerExample(String num, int k) {
        //pqs stores the location of each digit.
        List<Queue<Integer>> pqs = new ArrayList<>();
        for (int i = 0; i <= 9; ++i) {
            pqs.add(new LinkedList<>());
        }

        for (int i = 0; i < num.length(); ++i) {
            pqs.get(num.charAt(i) - '0').add(i);
        }
        String ans = "";
        SegmentTree seg = new SegmentTree(num.length());

        for (int i = 0; i < num.length(); ++i) {
            // At each location, try to place 0....9
            for (int digit = 0; digit <= 9; ++digit) {
                // is there any occurrence of digit left?
                if (pqs.get(digit).size() != 0) {
                    // yes, there is a occurrence of digit at pos
                    Integer pos = pqs.get(digit).peek();
                    // Since few numbers already shifted to left, this `pos` might be outdated.
                    // we try to find how many number already got shifted that were to the left of pos.
                    int shift = seg.getCountLessThan(pos);
                    // (pos - shift) is number of steps to make digit move from pos to i.
                    if (pos - shift <= k) {
                        k -= pos - shift;
                        seg.add(pos); // Add pos to our segment tree.
                        pqs.get(digit).remove();
                        ans += digit;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    class SegmentTree {
        int[] nodes;
        int n;

        public SegmentTree(int max) {
            nodes = new int[4 * (max)];
            n = max;
        }

        public void add(int num) {
            addUtil(num, 0, n, 0);
        }

        private void addUtil(int num, int l, int r, int node) {
            if (num < l || num > r) {
                return;
            }
            if (l == r) {
                nodes[node]++;
                return;
            }
            int mid = (l + r) / 2;
            addUtil(num, l, mid, 2 * node + 1);
            addUtil(num, mid + 1, r, 2 * node + 2);
            nodes[node] = nodes[2 * node + 1] + nodes[2 * node + 2];
        }

        // Essentialy it tells number of numbers < num.
        public int getCountLessThan(int num) {
            return getUtil(0, num, 0, n, 0);
        }

        private int getUtil(int ql, int qr, int l, int r, int node) {
            if (qr < l || ql > r) return 0;
            if (ql <= l && qr >= r) {
                return nodes[node];
            }

            int mid = (l + r) / 2;
            return getUtil(ql, qr, l, mid, 2 * node + 1) + getUtil(ql, qr, mid + 1, r, 2 * node + 2);
        }
    }

}

