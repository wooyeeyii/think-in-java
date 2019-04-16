/**
 * 120. Triangle
 * <p>
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * [[-1],[3,2],[-3,1,-1]]   result: -1
 * <p>
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem120 {

    // 从上往下，超级麻烦
    // 看示例，从下往上操作
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len <= 0) {
            return 0;
        }
        int[] sumArr = new int[len];
        Arrays.fill(sumArr, 0);
        sumArr[0] = triangle.get(0).get(0);
        //之前j递增，需2个int[]交替使用
        // 改进后递减，需一个就好了
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                int left = j <= 0 ? Integer.MAX_VALUE : sumArr[j - 1];
                int middle = j >= (list.size() - 1) ? Integer.MAX_VALUE : sumArr[j];
                sumArr[j] = Math.min(left, middle) + list.get(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (sumArr[i] < min) {
                min = sumArr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Problem120 problem = new Problem120();
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<Integer>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        int res1 = problem.minimumTotal(triangle);
        System.out.println(res1);
        System.out.println(11 == res1);
        System.out.println("###########################");

        List<List<Integer>> triangle2 = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(-1);
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(3);
        l2.add(2);
        List<Integer> l3 = new ArrayList<Integer>();
        l3.add(-3);
        l3.add(1);
        l3.add(-1);
        triangle2.add(l1);
        triangle2.add(l2);
        triangle2.add(l3);
        int res2 = problem.minimumTotal(triangle2);
        System.out.println(res2);
        System.out.println(-1 == res2);
    }

    public int minimumTotalExample(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            List<Integer> nextL = triangle.get(i + 1);
            for (int j = 0; j < list.size(); j++) {
                list.set(j, Math.min(nextL.get(j), nextL.get(j + 1)) + list.get(j));
            }
        }
        return triangle.get(0).get(0);
    }


}
