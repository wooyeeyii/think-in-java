/*
 * 386. Lexicographical Numbers
 *
 * Given an integer n, return 1 - n in lexicographical order.
 *
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 *
 * Please optimize your algorithm to use less time and space.
 * The input size may be as large as 5,000,000.
 */
package com.chang.leetcode;

import com.chang.common.ArrayToStringUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem386 {

    /*
     * Example
     *
     * The idea is pretty simple. If we look at the order we can find out
     * we just keep adding digit from 0 to 9 to every digit and make it a tree.
     * Then we visit every node in pre-order.
     *        1        2        3    ...
     *       /\        /\       /\
     *    10 ...19  20...29  30...39   ....
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; ++i) {
            dfs(i, n, res);
        }
        return res;
    }

    public void dfs(int cur, int n, List<Integer> res) {
        if (cur > n)
            return;
        else {
            res.add(cur);
            for (int i = 0; i < 10; ++i) {
                if (10 * cur + i > n)
                    return;
                dfs(10 * cur + i, n, res);
            }
        }
    }

    /*
     *
     */
    public List<Integer> lexicalOrder_2(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr = curr * 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Problem386 problem = new Problem386();

        List<Integer> res1 = problem.lexicalOrder(13);
        System.out.println(ArrayToStringUtil.oneDimension(res1));
        System.out.println("##################");
    }
}
