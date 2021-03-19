/*
 * 287. Find the Duplicate Number
 * Medium
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
 * find the duplicate one.
 *
 * Example 1:
 * Input: [1,3,4,2,2]
 * Output: 2
 *
 * Example 2:
 * Input: [3,1,3,4,2]
 * Output: 3
 *
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
package com.chang.leetcode;

public class Problem287 {

    //Basically transfer the problem to finding the beginning of cycle in linked list.
    // example [3,1,3,4,2]
    // 3 1 3 4 2 are five nodes node0 node1 node2 node3 node4 node5
    // node0->node4->node5->node2
    public int findDuplicate(int[] nums) {
        if (nums.length == 0)
            return 0;
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            if (slow == nums[slow])
                return slow;
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            if (slow == nums[slow])
                return slow;
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Problem287 problem = new Problem287();
        int[] data1 = new int[]{1, 3, 4, 2, 2};
        System.out.println(2 == problem.findDuplicate(data1));

        int[] data2 = new int[]{3, 1, 3, 4, 2};
        System.out.println(3 == problem.findDuplicate(data2));

    }


}
