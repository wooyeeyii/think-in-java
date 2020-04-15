package com.chang.leetcode;

import java.util.Arrays;

public class Problem215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < 0) {
            return 0;
        }
        int[] heap = new int[k];
        Arrays.fill(heap, Integer.MAX_VALUE);
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i);
            if (size < k) {
                sortMinHeap(heap, nums[i], size);
                size++;
            } else {
                if (nums[i] >= heap[0]) {
                    sortMinHeap(heap, nums[i], size);
                }
            }
            print(heap);
        }
        return heap[0];
    }

    public void sortMinHeap(int[] heap, int value, int size) {
        int k = heap.length;
        if (size >= k) {
            int i = 0;
            while (i * 2 + 1 < k) {
                if (k >= i * 2 + 3) {
                    if (heap[i * 2 + 1] < heap[i * 2 + 2]) {
                        if (value <= heap[i * 2 + 1]) {
                            break;
                        } else {
                            heap[i] = heap[i * 2 + 1];
                            i = i * 2 + 1;
                        }
                    } else {
                        if (value <= heap[i * 2 + 2]) {
                            break;
                        } else {
                            heap[i] = heap[i * 2 + 2];
                            i = i * 2 + 2;
                        }
                    }
                }
                if (k == i * 2 + 2) {
                    if (heap[i * 2 + 1] > value) {
                        break;
                    } else {
                        heap[i] = heap[i * 2 + 1];
                        i = i * 2 + 1;
                    }
                }

            }
            heap[i] = value;
        } else {
            int i = size;
            //遍历找到合适的位置
            while (i > 0) {
                if (heap[(i - 1) / 2] > value) {
                    heap[i] = heap[(i - 1) / 2];
                    i = (i - 1) / 2;
                } else {
                    break;
                }
            }
            heap[i] = value;
        }
    }

    public void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d, ", nums[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem215 problem = new Problem215();
//        int[] nums = new int[] {3,2,3,1,2,4,5,5,6};
//        int k = 4;
        int[] nums = new int[]{-1, 2, 0};
        int k = 2;
        int res = problem.findKthLargest(nums, k);
        System.out.println("#########3");
        System.out.println(res);
    }
}
