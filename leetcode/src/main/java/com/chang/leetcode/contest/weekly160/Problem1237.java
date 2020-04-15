/**
 * 1237. Find Positive Integer Solution for a Given Equation
 * <p>
 * Given a function  f(x, y) and a value z, return all positive integer pairs x and y where f(x,y) == z.
 * <p>
 * The function is constantly increasing, i.e.:
 * <p>
 * f(x, y) < f(x + 1, y)
 * f(x, y) < f(x, y + 1)
 * The function interface is defined like this:
 * <p>
 * interface CustomFunction {
 * public:
 * // Returns positive integer f(x, y) for any given positive integer x and y.
 * int f(int x, int y);
 * };
 * For custom testing purposes you're given an integer function_id and a target z as input, where function_id represent one function
 * from an secret internal list, on the examples you'll know only two functions from the list.
 * <p>
 * You may return the solutions in any order.
 * <p>
 * Example 1:
 * Input: function_id = 1, z = 5
 * Output: [[1,4],[2,3],[3,2],[4,1]]
 * Explanation: function_id = 1 means that f(x, y) = x + y
 * <p>
 * Example 2:
 * Input: function_id = 2, z = 5
 * Output: [[1,5],[5,1]]
 * Explanation: function_id = 2 means that f(x, y) = x * y
 */
package com.chang.leetcode.contest.weekly160;

import java.util.ArrayList;
import java.util.List;

public class Problem1237 {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int max = 1000;
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= max; j++) {
                if (customfunction.f(i, j) == z) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                } else if (customfunction.f(i, j) > z) {
                    break;
                }
            }

            if (customfunction.f(i, 1) > z) {
                break;
            }
        }
        return res;
    }

    class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return 0;
        }
    }
}


