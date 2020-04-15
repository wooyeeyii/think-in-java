/**
 * 430. Flatten a Multilevel Doubly Linked List
 * <p>
 * You are given a doubly linked list which in addition to the next and previous pointers,
 * it could have a child pointer, which may or may not point to a separate doubly linked list.
 * These child lists may have one or more children of their own, and so on,
 * to produce a multilevel data structure, as shown in the example below.
 * <p>
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list.
 * You are given the head of the first level of the list.
 * <p>
 * Example:
 * Input:
 * 1---2---3---4---5---6--NULL
 * |
 * 7---8---9---10--NULL
 * |
 * 11--12--NULL
 * <p>
 * Output:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 */
package com.chang.leetcode;

public class Problem430 {

    public Node flatten(Node head) {
        Node node = head;
        while (null != node) {
            if (null != node.child) {
                Node next = node.next;
                Node newHead = flatten(node.child);
                node.next = newHead;
                newHead.prev = node;
                node.child = null;
                while (null != node.next) {
                    node = node.next;
                }
                node.next = next;
                if (null != next) {
                    next.prev = node;
                }
                node = next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Problem430 problem = new Problem430();
        Node n1 = problem.new Node();
        n1.val = 1;
        Node n2 = problem.new Node();
        n2.val = 2;
        Node n3 = problem.new Node();
        n3.val = 3;
        Node n4 = problem.new Node();
        n4.val = 4;
        Node n5 = problem.new Node();
        n5.val = 5;
        Node n6 = problem.new Node();
        n6.val = 6;
        Node n7 = problem.new Node();
        n7.val = 7;
        Node n8 = problem.new Node();
        n8.val = 8;
        Node n9 = problem.new Node();
        n9.val = 9;
        Node n10 = problem.new Node();
        n10.val = 10;
        Node n11 = problem.new Node();
        n11.val = 11;
        Node n12 = problem.new Node();
        n12.val = 12;
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;
        n4.next = n5;
        n5.prev = n4;
        n5.next = n6;
        n6.prev = n5;

        n7.next = n8;
        n8.prev = n7;
        n8.next = n9;
        n9.prev = n8;
        n9.next = n10;
        n10.prev = n9;


        n11.next = n12;
        n12.prev = n11;

        n3.child = n7;
        n8.child = n11;



/*        Node n13 = problem.new Node();
        n13.val = 13;
        Node n14 = problem.new Node();
        n14.val = 14;
        n13.next = n14;
        n9.child = n13;*/


        Node head = problem.flattenExample(n1);
        while (null != head.next) {
            System.out.print(head.next.val + ", ");
            head = head.next;
        }
        System.out.println();
        System.out.println("###########");
        while (null != head) {
            System.out.print(head.val + ", ");
            head = head.prev;
        }
        System.out.println();
        System.out.println("###########");

    }

    public Node flattenExample(Node head) {
        Node node = head;
        while (null != node) {
            if (null != node.child) {
                Node child = node.child;
                node.child = null;
                Node childTail = child;
                while (null != childTail.next) {
                    childTail = childTail.next;
                }
                childTail.next = node.next;
                if (null != node.next) {
                    node.next.prev = childTail;
                }
                node.next = child;
                child.prev = node;
            }
            node = node.next;
        }

        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    ;
}
