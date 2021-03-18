/*
 * 519. Random Flip Matrix
 *
 * You are given the number of rows n_rows and number of columns n_cols of a 2D binary matrix where all values are initially 0.
 * Write a function flip which chooses a 0 value uniformly at random, changes it to 1, and then returns the position [row.id, col.id] of that value.
 * Also, write a function reset which sets all values back to 0. Try to minimize the number of calls to
 * system's Math.random() and optimize the time and space complexity.
 *
 * Note:
 * 1 <= n_rows, n_cols <= 10000
 * 0 <= row.id < n_rows and 0 <= col.id < n_cols
 * flip will not be called when the matrix has no 0 values left.
 * the total number of calls to flip and reset will not exceed 1000.
 * Example 1:
 *
 * Input:
 * ["Solution","flip","flip","flip","flip"]
 * [[2,3],[],[],[],[]]
 * Output: [null,[0,1],[1,2],[1,0],[1,1]]
 *
 * Example 2:
 * Input:
 * ["Solution","flip","flip","reset","flip"]
 * [[1,2],[],[],[],[]]
 * Output: [null,[0,0],[0,1],null,[0,0]]
 *
 * Explanation of Input Syntax:
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has two arguments,
 * n_rows and n_cols. flip and reset have no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
package com.chang.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Problem519 {

    // use int array will cause MemoryLimitExceed.

    private Map<Integer, Integer> map;
    private int rows, cols, total;
    private Random rand;

    public Problem519(int n_rows, int n_cols) {
        map = new HashMap<>();
        rand = new Random();
        rows = n_rows;
        cols = n_cols;
        total = rows * cols;
    }

    public int[] flip() {
        // generate index, decrease total number of values
        int r = rand.nextInt(total--);

        // check if we have already put something at this index
        int x = map.getOrDefault(r, r);

        // swap - put total at index that we generated

        /*
         * it seems everybody understood what lee is saying except me, so I'll explain it just for myself :)
         * lee is suggesting that when we move the end (total) element instead of the r element, we should execute the full swap,
         * i.e. move the r element instead of the end (total), exactly as in the fisher-yates shuffle,
         * and by that generating a random permutation with a uniform distribution.
         * So when we reset, there's no point in resetting back to 1..n, as the new random permutation is just as good.
         * The original code didn't bother to do that and did only "half a swap" as we never access the "end" element of previous iterations,
         * as total is continually decremented.
         */
        map.put(r, map.getOrDefault(total, total));
        map.put(total, x);

        return new int[]{x / cols, x % cols};
    }

    public void reset() {
        // doesn't need any more
//        map.clear();
        total = rows * cols;
    }

    public static void main(String[] args) {
        Problem519 problem = new Problem519(2, 2);
        problem.flip();
        problem.flip();
        problem.flip();
    }

}
