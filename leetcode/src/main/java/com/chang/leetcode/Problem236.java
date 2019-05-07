/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has
 * both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * <p>
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * Note:
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */
package com.chang.leetcode;

import com.chang.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pl = new ArrayList<>();
        List<TreeNode> ql = new ArrayList<>();
        List pll = new ArrayList<>();
        findPath(root, p, pl, pll);
        List qll = new ArrayList<>();
        findPath(root, q, ql, qll);

        return findLastCommon(pll, qll);
    }

    private void findPath(TreeNode node, TreeNode p, List<TreeNode> pl, List<TreeNode> res) {
        if(null != res && res.size() > 0) {
            return;
        }

        pl.add(node);
        if (p == node) {
            res.addAll(pl);
            return;
        }

        if (null != node.left) {
            findPath(node.left, p, pl, res);
        }
        if (null != node.right) {
            findPath(node.right, p, pl, res);
        }

        pl.remove(pl.size() - 1);
    }

    private TreeNode findLastCommon(List<TreeNode> pl, List<TreeNode> ql) {
        int lenp = pl.size();
        int lenq = ql.size();
        TreeNode common = null;
        for (int i = 0; i < Math.min(lenp, lenq); i++) {
            if (pl.get(i) == ql.get(i)) {
                common = pl.get(i);
            } else {
                break;
            }
        }
        return common;
    }

    public static void main(String[] args) {
        Problem236 problem = new Problem236();
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;

        TreeNode res1 = problem.lowestCommonAncestor(n1, n2, n3);
        System.out.println(3 == res1.val);

        TreeNode res2 = problem.lowestCommonAncestor(n1, n2, n9);
        System.out.println(5 == res2.val);

    }

    public TreeNode lowestCommonAncestorExample(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }

}
