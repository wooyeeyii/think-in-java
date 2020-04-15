/**
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However,
 * flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * <p>
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
 * and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * <p>
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * <p>
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * <p>
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 */
package com.chang;

public class Problem605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int count = 0;

        int pre = -1;
        int pos = 0;
        while (pos < len) {
            if (flowerbed[pos] == 1) {
                count += (pre < 0 ? pos / 2 : (pos - pre - 2) / 2);
                pre = pos;
            }
            pos++;
        }

        count += (pre < 0 ? (len + 1) / 2 : (len - pre - 1) / 2);
        return count >= n;
    }

    public static void main(String[] args) {
        Problem605 problem = new Problem605();
        System.out.println(problem.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(!problem.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(!problem.canPlaceFlowers(new int[]{0, 1, 0, 0, 1}, 1));
        System.out.println(!problem.canPlaceFlowers(new int[]{0, 1, 0, 1, 0}, 1));
        System.out.println(problem.canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1));
        System.out.println(problem.canPlaceFlowers(new int[]{1, 0, 1, 0, 0}, 1));
        System.out.println(problem.canPlaceFlowers(new int[]{0}, 1));
        System.out.println(!problem.canPlaceFlowers(new int[]{0, 0}, 2));
        System.out.println(problem.canPlaceFlowers(new int[]{0, 0}, 1));
        System.out.println(problem.canPlaceFlowers(new int[]{0, 0, 0}, 2));
        System.out.println(!problem.canPlaceFlowers(new int[]{0, 0, 0}, 3));
    }
}
