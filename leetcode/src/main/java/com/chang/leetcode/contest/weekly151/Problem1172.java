/**
 * 1172. Dinner Plate Stacks
 * <p>
 * You have an infinite number of stacks arranged in a row and numbered (left to right) from 0, each of the stacks has the same maximum capacity.
 * <p>
 * Implement the DinnerPlates class:
 * <p>
 * DinnerPlates(int capacity) Initializes the object with the maximum capacity of the stacks.
 * void push(int val) pushes the given positive integer val into the leftmost stack with size less than capacity.
 * int pop() returns the value at the top of the rightmost non-empty stack and removes it from that stack, and returns -1 if all stacks are empty.
 * int popAtStack(int index) returns the value at the top of the stack with the given index and removes it from that stack,
 * and returns -1 if the stack with that given index is empty.
 * <p>
 * Example:
 * Input:
 * ["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
 * [[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
 * Output:
 * [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
 * <p>
 * Explanation:
 * DinnerPlates D = DinnerPlates(2);  // Initialize with capacity = 2
 * D.push(1);
 * D.push(2);
 * D.push(3);
 * D.push(4);
 * D.push(5);         // The stacks are now:  2  4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(0);   // Returns 2.  The stacks are now:     4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.push(20);        // The stacks are now: 20  4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.push(21);        // The stacks are now: 20  4 21
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(0);   // Returns 20.  The stacks are now:     4 21
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(2);   // Returns 21.  The stacks are now:     4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.pop()            // Returns 5.  The stacks are now:      4
 * 1  3
 * ﹈ ﹈
 * D.pop()            // Returns 4.  The stacks are now:   1  3
 * ﹈ ﹈
 * D.pop()            // Returns 3.  The stacks are now:   1
 * ﹈
 * D.pop()            // Returns 1.  There are no stacks.
 * D.pop()            // Returns -1.  There are still no stacks.
 * <p>
 * Constraints:
 * <p>
 * 1 <= capacity <= 20000
 * 1 <= val <= 20000
 * 0 <= index <= 100000
 * At most 200000 calls will be made to push, pop, and popAtStack.
 */
package com.chang.leetcode.contest.weekly151;

import java.util.*;

public class Problem1172 {

    private class mySolution {
        ArrayList<Stack> data = new ArrayList<>();
        int capacity = 0;
        int endIdx = -1;
        PriorityQueue<Integer> availableIdx = new PriorityQueue<>();

        public mySolution(int capacity) {
            this.capacity = capacity;
        }

        public void push(int val) {
            if (availableIdx.isEmpty()) {
                Stack stackAtEnd = (endIdx < 0 || endIdx >= data.size()) ? null : data.get(endIdx);
                if (null != stackAtEnd && stackAtEnd.size() < capacity) {
                    stackAtEnd.push(val);
                    if (stackAtEnd.size() == capacity) {
                        addNewEmptyStack();
                    }
                } else {
                    Stack<Integer> newStack = addNewEmptyStack();
                    newStack.push(val);
                }
            } else {
                int aviIdx = availableIdx.poll();
                if (aviIdx >= endIdx) {
                    availableIdx.clear();
                    push(val);
                } else {
                    Stack stackAtIdx = data.get(aviIdx);
                    stackAtIdx.push(val);
                }
            }
        }

        private Stack<Integer> addNewEmptyStack() {
            Stack<Integer> newStack = new Stack<>();
            data.add(newStack);
            endIdx++;
            return newStack;
        }

        public int pop() {
            int end = endIdx;
            while (end >= 0) {
                int res = popAtStack(end);
                if (-1 != res) {
                    return res;
                }
                end = endIdx;
            }
            return -1;
        }

        public int popAtStack(int index) {
            int result = -1;
            if (index > endIdx) {
                return result;
            }
            Stack<Integer> stackAtIdx = data.get(index);
            if (!stackAtIdx.isEmpty()) {
                result = stackAtIdx.pop();
            }

            if (index == endIdx) {
                while (endIdx >= 0 && data.get(endIdx).isEmpty()) {
                    endIdx--;
                }
            } else {
                availableIdx.add(index);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Problem1172 problem1172 = new Problem1172();
        Problem1172.solutionExample problem = problem1172.new solutionExample(2);
        problem.push(1);
        problem.push(2);
        problem.push(3);
        problem.push(4);
        problem.push(5);
        System.out.println(2 == problem.popAtStack(0));
        problem.push(20);
        problem.push(21);
        System.out.println(20 == problem.popAtStack(0));
        System.out.println(21 == problem.popAtStack(2));
        System.out.println(5 == problem.pop());
        System.out.println(4 == problem.pop());
        System.out.println(3 == problem.pop());
        System.out.println(1 == problem.pop());
        System.out.println(-1 == problem.pop());
    }

    private class solutionExample {

        private int capacity;
        private ArrayList<Integer> data;
        private PriorityQueue<Integer> availableIdx;

        public solutionExample(int capacity) {
            this.capacity = capacity;
            data = new ArrayList<>();
            availableIdx = new PriorityQueue<>();
        }

        public void push(int val) {
            if (!availableIdx.isEmpty()) {
                data.set(availableIdx.poll(), val);
            } else {
                data.add(val);
            }
        }

        public int pop() {
            int result = -1;
            for (int i = data.size() - 1; i >= 0; i--) {
                if (null == data.get(i)) {
                    data.remove(i);
                    availableIdx.remove(i);
                } else {
                    result = data.get(i);
                    data.set(i, null);
                    break;
                }
            }
            return result;
        }

        public int popAtStack(int index) {
            int endIdx = (index + 1) * capacity - 1;
            int start = index * capacity;
            int result = -1;
            for (int i = endIdx; i >= start; i--) {
                if (null != data.get(i)) {
                    availableIdx.add(i);
                    result = data.get(i);
                    data.set(i, null);
                    break;
                }
            }
            return result;
        }

    }
}
