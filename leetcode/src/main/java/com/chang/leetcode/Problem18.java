package com.chang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
		if (nums == null || len < 4)
			return res;

		Arrays.sort(nums);
		for(int i=0; i<len-3; i++) {
			if( (nums[i] + nums[i+1] + nums[i+2] + nums[i+3]) > target ){
				break;
			}
			if( (nums[i] + nums[len-1] + nums[len-2] + nums[len-3]) < target ){
				continue;
			}
			if( (i>0) && (nums[i]==nums[i-1]) ) {
				continue;
			}
			int threeSum = target - nums[i];
			for(int j=i+1; j<len-2; j++){
				if( (nums[j] + nums[j+1] + nums[j+2]) > threeSum ){
					break;
				}
				if( (nums[j] + nums[len-1] + nums[len-2]) < threeSum ){
					continue;
				}
				if( (j>i+1) && (nums[j]==nums[j-1]) ) {
					continue;
				}
				int twoSum = threeSum - nums[j];
				int low = j+1, high = len-1;
				while(low < high) {
					int sum = nums[low] + nums[high];
					if(sum == twoSum) {
						res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
						while( (low < high ) && (nums[low+1] == nums[low])) {
							low++;
						}
						while( (high > low ) && (nums[high-1] == nums[high])) {
							high--;
						}
						low++; 
		                high--;
					} else if( sum < twoSum ) {
						low++;
					} else {
						high--;
					}
				}
			}
		}
		
        return res;
    }
	
	public static void main(String[] args) {
		//int[] nums = new int[] {1,0,-1,0,-2,2};
		int[] nums = new int[] {0,0,0,0};
		Problem18 problem = new Problem18();
		System.out.println(problem.fourSum(nums, 0));
	}
	
}
