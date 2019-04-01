package com.chang.leetcode;

public class Problem215_2 {
    
    public int findKthLargest(int[] nums, int k) {
        return select(nums, 0, nums.length - 1, k - 1);
    }
    
    private int select(int[] nums, int left, int right, int k) {
        while(left < right) {
            int pivotIndex = left + (right - left)/2;
            pivotIndex = partition(nums, left, right, pivotIndex);
            
            if (pivotIndex == k) {
                return nums[k];
            }
            else if (k < pivotIndex) {
                right = pivotIndex - 1;
            }
            else
            {
                left = pivotIndex + 1;
            }
        }
        
        return nums[left];
    }
    
    private int partition(int[] nums, int left, int right, int pivotIndex)
    {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;
        
        for (int i = left; i < right; i++)
        {
            if (nums[i] > pivotValue)
            {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }

        swap(nums, right, storeIndex);
        
        return storeIndex;
    }
    
    private void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
