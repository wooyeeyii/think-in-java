package com.chang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(n <=0 ) {
            return list;
        }
        TreeNode node1 = new TreeNode(1);
        list.add(node1);
        for(int i = 2; i <= n; i++) {
            List<TreeNode> tmp = new ArrayList<TreeNode>();
            //nth node as root
            for(TreeNode node : list) {
                TreeNode nodeNth = new TreeNode(i);
                TreeNode newLeft = clone(node);
                nodeNth.left = newLeft;
                tmp.add(nodeNth);
            }
            // add nth node to old tree
            for(TreeNode node : list) {
                TreeNode posOld = node;
                int count = 0;
                while(posOld.right != null) {
                    TreeNode nodeNth = new TreeNode(i);
                    TreeNode root = clone(node);
                    TreeNode posNew = root;
                    for(int k = 0; k < count; k++) {
                        posNew = posNew.right;
                    }
                    add(posNew, nodeNth);
                    tmp.add(root);
                    posOld = posOld.right;
                    count++;
                }
                
                TreeNode nodeNth = new TreeNode(i);
                TreeNode root = clone(node);
                TreeNode posEnd = root;
                while(posEnd.right != null) {
                    posEnd = posEnd.right;
                }
                posEnd.right = nodeNth;
                tmp.add(root);
            }
            
            list = tmp;
            System.out.println("-----------------------");
            for(TreeNode printRoot : list) {
                printTree(printRoot);
                System.out.println();
            }
        }
        return list;
    }
    
    private void add(TreeNode pos, TreeNode nodeNth) {
        nodeNth.left = pos.right;
        pos.right = nodeNth;
    }
    
    private TreeNode clone(TreeNode root) {
        if(null == root) {
            return null;
        }
        TreeNode newNode = new TreeNode(root.val);
        newNode.left = clone(root.left);
        newNode.right = clone(root.right);
        return newNode;
    }
    
    public void printTree(TreeNode root) {
        while(root == null) {
            return;
        }
        
        System.out.print(root.val);
        printTree(root.left);
        printTree(root.right);
    }
    
    public static void main(String[] args) {
        Problem95 problem = new Problem95();
        List<TreeNode> res = problem.generateTrees(5);
        System.out.println("##################");
        System.out.println(res.size());
    }
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
