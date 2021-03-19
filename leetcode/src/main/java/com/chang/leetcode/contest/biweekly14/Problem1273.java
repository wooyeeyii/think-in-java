/*
 * 1273. Delete Tree Nodes
 *
 * A tree rooted at node 0 is given as follows:
 *
 * The number of nodes is nodes;
 * The value of the i-th node is value[i];
 * The parent of the i-th node is parent[i].
 * Remove every subtree whose sum of values of nodes is zero.
 *
 * After doing so, return the number of nodes remaining in the tree.
 *
 * 0(1)
 * 1(-1)                    2(4)
 * 3(0)               4(-2)  5(-1)  6(-1)
 *
 * Example 1:
 * Input: nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-1]
 * Output: 2
 * Constraints:
 *
 * 1 <= nodes <= 10^4
 * -10^5 <= value[i] <= 10^5
 * parent.length == nodes
 * parent[0] == -1 which indicates that 0 is the root.
 */
package com.chang.leetcode.contest.biweekly14;

public class Problem1273 {

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        int[] sum = new int[nodes];
        int[] count = new int[nodes];
        for (int i = 0; i < value.length; i++) {
            sum[i] = value[i];
            count[i] = 1;
            int idx = parent[i];
            while (idx != -1) {
                sum[idx] += value[i];
                count[idx] += 1;
                idx = parent[idx];
            }
        }

        int left = nodes;
        for (int i = nodes - 1; i >= 0; i--) {
            if (sum[i] == 0) {
                left -= count[i];
                resetCount(count, parent, i, count[i]);
            }
        }

        return left;
    }

    private void resetCount(int[] count, int[] parent, int i, int number) {
        int idx = parent[i];
        while (idx != -1) {
            count[idx] -= number;
            idx = parent[idx];
        }
    }

    public static void main(String[] args) {
        Problem1273 problem = new Problem1273();
        System.out.println(problem.deleteTreeNodesExample(7, new int[]{-1, 0, 0, 1, 2, 2, 2}, new int[]{1, -2, 4, 0, -2, -1, -1}));
    }

    /*
     * Build up the mapping of parent and its children.
     * Recursively find the sum and the count of subtree.@param n
     * Time O(N), Space O(N)
     */
    public int deleteTreeNodesExample(int n, int[] parent, int[] value) {
        int[] res = new int[n];
        for (int i = n - 1; i > 0; --i) {
            value[parent[i]] += value[i];
            res[parent[i]] += (value[i] != 0 ? res[i] + 1 : 0); // awesome
        }
        return value[0] != 0 ? res[0] + 1 : 0;
    }

}
