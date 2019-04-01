package com.chang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem347 {
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        List<Integer> result = new ArrayList<Integer>();
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        if (nums.length <= 0 ) {
//            return result;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//        map.forEach((key, value) -> {
//            if (result.size() < k) {
//               result.add(0, key);
//               minHeapSort(result, map);
//            } else {
//                if (value > map.get(result.get(0))) {
//                    result.set(0, key);
//                    minHeapSort(result, map);
//                }
//            }
//        });
//        return result;
//    }
//    
//    private void minHeapSort(List<Integer> result, Map<Integer, Integer> map) {
//        int i = 0;
//        int value = result.get(0);
//        while ((i * 2 + 2) < result.size()) {
//            int root = map.get(result.get(i));
//            int left = map.get(result.get(i * 2 + 1));
//            int right = map.get(result.get(i * 2 + 2));
//            if(left > right && root > right) {
//                result.set(i, result.get(i * 2 + 2));
//                i = i * 2 + 2;
//            } else if (right > left && root > left) {
//                result.set(i, result.get(i * 2 + 1));
//                i = i * 2 + 1;
//            } else if (value < left && root < right) {
//                break;
//            }
//        }
//        if ((i * 2 + 1) == result.size() - 1) {
//            if (map.get(result.get(i)) > map.get(result.get(i * 2 + 1))) {
//                result.set(i, result.get(i * 2 + 1));
//                i = i * 2 + 1;
//            }
//        }
//        
//        result.set(i, value);
//    }

//    public List<Integer> topKFrequent(int[] nums, int k) {
//
//        List<Integer>[] bucket = new List[nums.length + 1];
//        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
//
//        for (int n : nums) {
//            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
//        }
//
//        for (int key : frequencyMap.keySet()) {
//            int frequency = frequencyMap.get(key);
//            if (bucket[frequency] == null) {
//                bucket[frequency] = new ArrayList<>();
//            }
//            bucket[frequency].add(key);
//        }
//
//        List<Integer> res = new ArrayList<>();
//
//        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
//            if (bucket[pos] != null) {
//                res.addAll(bucket[pos]);
//            }
//        }
//        return res;
//    }
//    

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (nums.length <= 0 ) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            Integer tmp = map.get(nums[i]);
            if(null == tmp) {
                tmp = 0;
            }
            map.put(nums[i], tmp + 1);
        }

        /*map.forEach((key, value) -> {
            if(bucket[value] == null) {
                bucket[value] = new ArrayList<Integer>();
            }
            bucket[value].add(key);
        });*/
        for(Integer key:map.keySet()) {
            Integer value = map.get(key);
            if(bucket[value] == null) {
                bucket[value] = new ArrayList<Integer>();
            }
            bucket[value].add(key);
        }

        for(int j = bucket.length - 1; j > 0 && result.size() < k; j--) {
            if(bucket[j] != null) {
                result.addAll(bucket[j]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem347 problem = new Problem347();
//        int[] nums = new int[] {1,1,1,2,2,3};
        int[] nums = new int[] {3, 0, 1, 0};
        System.out.println(problem.topKFrequent(nums, 1));
    }


}
