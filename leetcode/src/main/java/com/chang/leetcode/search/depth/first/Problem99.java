/**
 * 99. Recover Binary Search Tree
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Example 1:
 * Input: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 * Output: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 *
 * Example 2:
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 * Output: [2,1,4,null,null,3]
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 *
 * Follow up:
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */
package com.chang.leetcode.search.depth.first;

import com.chang.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem99 {

    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        middleSearchTree(root, list);

        // 找出顺序不正确的两个node
        Integer a = null, b = null;
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) > list.get(i + 1)) {
                if(a == null) {
                    a = list.get(i);
                    b = list.get(i + 1);
                } else {
                    b = list.get(i);
                    break;
                }
            }
        }
        System.out.println("a = " + a + ", b = " + b);
    }

    private void middleSearchTree(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        middleSearchTree(root.left, list);
        list.add(root.val);
        middleSearchTree(root.right, list);
    }

    public static void main(String[] args) {
        Problem99 problem = new Problem99();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n3;
        n3.right = n2;
        problem.recoverTree(n1);
    }

}
