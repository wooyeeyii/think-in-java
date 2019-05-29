/**
 * 319. Bulb Switcher
 *
 * There are n bulbs that are initially off. You first turn on all the bulbs.
 * Then, you turn off every second bulb. On the third round,
 * you toggle every third bulb (turning on if it's off or turning off if it's on).
 * For the i-th round, you toggle every i bulb. For the n-th round, you only toggle the last bulb.
 * Find how many bulbs are on after n rounds.
 *
 * Example:
 * Input: 3
 * Output: 1
 * Explanation:
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off].
 *
 * So you should return 1, because there is only one bulb is on.
 */
package com.chang.leetcode;

public class Problem319 {

    /**
     * 第一次，拨动所有编号是1倍数的灯，第二次，拨动所有编号是2倍数的灯 ...
     * 对于第i个灯，若拨动次数为偶数，则熄灭，也就是说若约数有偶数个，就熄灭
     * 约数都是成对出现的，仅有一种情况，就是 4 = 2 * 2, 9 = 3 * 3... 这样就有奇数个约数，
     * 所以，平方数的灯最后是亮的
     */
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) {
        Problem319 problem = new Problem319();
        System.out.println(1 == problem.bulbSwitch(3));
    }
}
