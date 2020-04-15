/**
 * 621. Task Scheduler
 * <p>
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.
 * Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * However, there is a non-negative cooling interval n that means between two same tasks,
 * there must be at least n intervals that CPU are doing different tasks or just be idle.
 * <p>
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * <p>
 * Example:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * <p>
 * Note:
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */
package com.chang.leetcode.greedy;

public class Problem621 {

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = Integer.MIN_VALUE;
        int maxCount = 0;
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
            if (max == count[tasks[i] - 'A']) {
                maxCount++;
            }

            if (count[tasks[i] - 'A'] > max) {
                max = count[tasks[i] - 'A'];
                maxCount = 1;
            }
        }

        int intervals = max - 1;
        int slotBetween = n - maxCount + 1;
        int availableSlots = intervals * slotBetween;
        int tasksTodo = tasks.length - max * maxCount;
        int idles = Math.max(0, availableSlots - tasksTodo);

        return tasks.length + idles;
    }

    public static void main(String[] args) {
        Problem621 problem = new Problem621();
        System.out.println(8 == problem.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

    public int leastIntervalExample(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) {
                maxCount++;
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        // maxCount 可看成拥有max个数量的字符绑定在一起
        // 例如 20个A， 20个B，10个C，n = 25， 则空缺是(AB)...(AB)...(AB) ...为25 - (2 - 1)
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}
