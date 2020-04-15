/**
 * 331. Verify Preorder Serialization of a Binary Tree
 * <p>
 * One way to serialize a binary tree is to use pre-order traversal.
 * When we encounter a non-null node, we record the node's value.
 * If it is a null node, we record using a sentinel value such as #.
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * <p>
 * For example, the above binary tree can be serialized
 * to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * <p>
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of
 * a binary tree. Find an algorithm without reconstructing the tree.
 * <p>
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * <p>
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * <p>
 * Example 1:
 * Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * <p>
 * Example 2:
 * Input: "1,#"
 * Output: false
 * <p>
 * Example 3:
 * Input: "9,#,#,1"
 * Output: false
 */
package com.chang.leetcode;

import java.util.Stack;

public class Problem331 {

    public boolean isValidSerialization(String preorder) {
        if (null == preorder || preorder.length() == 0) {
            return true;
        }
        String[] nodes = preorder.split(",");
        if (nodes.length == 1 && "#".equals(nodes[0])) {
            return true;
        }
        int len = nodes.length;
        Stack stack = new Stack();
        stack.push(nodes[0]);
        int idx = 1;
        while (idx < len && stack.size() > 0) {
            String s = nodes[idx];
            if (!"#".equals(s)) {
                stack.push(s);
            } else {
                if (stack.size() > 0 && "#".equals(stack.peek())) {
                    while (stack.size() > 0 && "#".equals(stack.peek())) {
                        if (stack.size() < 2) {
                            return false;
                        }
                        stack.pop();
                        stack.pop();
                    }
                    if (0 != stack.size()) {
                        stack.push("#");
                    }
                } else {
                    stack.push(s);
                }
            }
            idx++;
        }
        if (idx == len && 0 == stack.size()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem331 problem = new Problem331();
        System.out.println(problem.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(problem.isValidSerialization("9,#,93,#,9,9,#,#,#"));
        System.out.println(problem.isValidSerialization(""));
        System.out.println(problem.isValidSerialization("#"));
        System.out.println(!problem.isValidSerialization("#,#,#"));
        System.out.println(!problem.isValidSerialization("1,#"));
        System.out.println(!problem.isValidSerialization("1,#,#,#,#"));
        System.out.println(!problem.isValidSerialization("9,#,#,1"));
        System.out.println(!problem.isValidSerialization("#,#,#,1"));
        System.out.println(!problem.isValidSerialization("1,#,#,2,#,#"));
        System.out.println(!problem.isValidSerialization("#,#,#,#,#,1,2,3,4"));
    }

    public boolean isValidSerializationExample(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            diff--;
            if (diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }

    public boolean isValidSerializationExample2(String preorder) {
        int nonleaves = 0, leaves = 0, i = 0;
        String[] nodes = preorder.split(",");
        for (i = 0; i < nodes.length && nonleaves + 1 != leaves; i++)
            if (nodes[i].equals("#")) leaves++;
            else nonleaves++;
        return nonleaves + 1 == leaves && i == nodes.length;
    }

}
