/**
 * 1240. Tiling a Rectangle with the Fewest Squares
 *
 * Given a rectangle of size n x m, find the minimum number of integer-sided squares that tile the rectangle.
 *
 * https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/
 */
package com.chang.leetcode.contest.weekly160;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1240 {

    // not a clue

    public static void main(String[] args) {
        // res是Problem1240的全局变量

        Problem1240 problem = new Problem1240();
        System.out.println(3 == problem.tilingRectangle(2, 3));

        Problem1240 problem1 = new Problem1240();
        System.out.println(5 == problem1.tilingRectangle(5, 8));

        Problem1240 problem2 = new Problem1240();
        System.out.println(6 == problem2.tilingRectangle(11, 13));
    }

    /**
     * The basic idea is to fill the entire block from the bottom up, fill in the bottom unfilled squares first, and select a different possible size square to fill it.
     * We maintain a height array (skyline) while dfs.
     *  This skyline is the identity of the state.
     *  The final result we ask for is the minimum number of squares in the state where the skyline is n m.
     * Of course, pure violence will have a high time complexity, but it can be pruned or optimized by the following three points.
     * 1. The current cnt (that is, the number of squares) of this skyline has exceeded the value of the current global optimal solution, then return directly.
     * 2, the current skyline has been traversed, and the previous cnt is smaller than the current cnt, then direct return
     * 3. When we find the empty square in the lower left corner, the next fill square is selected first from the larger square, which can make the program converge quickly. (This is not a pruning, but it is a very important optimization)
     */
    Map<Long, Integer> set = new HashMap<>();
    int res = Integer.MAX_VALUE;
    public int tilingRectangle(int n, int m) {
        if (n == m) return 1;
        if (n > m) {
            int temp = n;
            n = m;
            m = temp;
        }
        dfs(n, m, new int[n + 1], 0);
        return res;
    }

    // n <= m
    private void dfs(int n, int m, int[] h, int cnt) {
        if (cnt >= res) return;
        boolean isFull = true;

        // 找到一层中最低的地方
        int pos = -1, minH = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (h[i] < m) isFull = false;
            if (h[i] < minH) {
                pos = i;
                minH = h[i];
            }
        }
        if (isFull) {
            res = Math.min(cnt, res);
            return;
        }

        long key = 0, base = m + 1;
        for (int i = 1; i <= n; i++) {
            key += h[i] * base;
            base *= m + 1;
        }
        if (set.containsKey(key) && set.get(key) <= cnt) return;
        set.put(key, cnt);

        int end = pos;
        while (end + 1 <= n && h[end + 1] == h[pos] && (end + 1 - pos + 1 + minH) <= m) end++;
        for (int j = end; j >= pos; j--) {
            int curH = j - pos + 1;

            int[] next  = Arrays.copyOf(h, n + 1);
            for (int k = pos; k <= j; k++) {
                next[k] += curH;
            }
            dfs(n, m, next, cnt + 1);
        }

    }
}
