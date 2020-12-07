/**
 * 1670. Design Front Middle Back Queue
 */
package com.chang.leetcode.contest.biweekly40;

import java.util.Deque;
import java.util.LinkedList;

public class Problem1670 {

    Deque<Integer> left, right;

    public Problem1670() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    public void pushFront(int val) {
        left.offerFirst(val);
        if (left.size() > right.size()) {
            right.offerFirst(left.pollLast());
        }
    }

    public void pushMiddle(int val) {
        if (left.size() == right.size()) {
            right.offerFirst(val);
        } else {
            left.offerLast(val);
        }
    }

    public void pushBack(int val) {
        if (right.size() > left.size()) {
            left.offerLast(right.pollFirst());
        }
        right.offerLast(val);
    }

    public int popFront() {
        if (left.size() < right.size()) {
            left.offerLast(right.pollFirst());
        }
        return left.isEmpty() ? -1 : left.pollFirst();
    }

    public int popMiddle() {
        if (left.size() == right.size()) {
            return left.isEmpty() ? -1 : left.pollLast();
        } else {
            return right.isEmpty() ? -1 : right.pollFirst();
        }
    }

    public int popBack() {
        if (left.size() == right.size() && !left.isEmpty()) {
            right.offerFirst(left.pollLast());
        }
        return right.isEmpty() ? -1 : right.pollLast();
    }

    public static void main(String[] args) {
        Problem1670 problem = new Problem1670();
        problem.pushFront(1);
        problem.pushBack(2);
        problem.pushMiddle(3);
        problem.pushMiddle(4);
        System.out.println(problem.popFront());
        System.out.println(problem.popMiddle());
        System.out.println(problem.popMiddle());
        System.out.println(problem.popBack());
        System.out.println(problem.popFront());
    }

}
