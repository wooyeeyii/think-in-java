/*
 * Koko Eating Bananas
 * 
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.
 * The guards have gone and will come back in H hours.
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas,
 * and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead,
 * and won't eat any more bananas during this hour.
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 * 
 * Example 1:
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * 
 * Example 2:
 * 
 * Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * 
 * Example 3:
 * Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 * 
 * Note:
 * 
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 */
package com.chang.leetcode;

import java.util.Arrays;

public class Problem875 {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1, high = getMaxPile(piles);
        while (low <= high) {
            int middle = (low + high) >> 1;
            if (canEatAll(piles, H, middle)) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }

    private boolean canEatAll(int[] piles, int H, int rate) {
        int h = 0;
        for (int a : piles) {
            h += a % rate == 0 ? a / rate : a / rate + 1;
            if (h > H) {
                return false;
            }
        }
        return true;
    }

    private int getMaxPile(int[] piles) {
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(pile, maxPile);
        }
        return maxPile;
    }

    public static void main(String[] args) {
        Problem875 problem = new Problem875();
        int[] nums1 = new int[]{3, 6, 7, 11};
        System.out.println(4 == problem.minEatingSpeed(nums1, 8));
        int[] nums2 = new int[]{30, 11, 23, 4, 20};
        System.out.println(30 == problem.minEatingSpeed(nums2, 5));
        int[] nums3 = new int[]{30, 11, 23, 4, 20};
        System.out.println(23 == problem.minEatingSpeed(nums3, 6));
    }
}
