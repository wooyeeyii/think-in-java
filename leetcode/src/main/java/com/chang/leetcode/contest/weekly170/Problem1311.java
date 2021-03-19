/*
 * 1311. Get Watched Videos by Your Friends
 *
 * There are n people, each person has a unique id between 0 and n-1. Given the arrays watchedVideos and friends,
 * where watchedVideos[i] and friends[i] contain the list of watched videos and the list of friends respectively for the person with id = i.
 *
 * Level 1 of videos are all watched videos by your friends, level 2 of videos are all watched videos by the friends of your friends and so on.
 * In general, the level k of videos are all watched videos by people with the shortest path equal to k with you.
 * Given your id and the level of videos, return the list of videos ordered by their frequencies (increasing).
 * For videos with the same frequency order them alphabetically from least to greatest.
 *
 * Example 1:
 * Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
 * Output: ["B","C"]
 * Explanation:
 * You have id = 0 (green color in the figure) and your friends are (yellow color in the figure):
 * Person with id = 1 -> watchedVideos = ["C"]
 * Person with id = 2 -> watchedVideos = ["B","C"]
 * The frequencies of watchedVideos by your friends are:
 * B -> 1
 * C -> 2
 *
 * Example 2:
 * Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2
 * Output: ["D"]
 * Explanation:
 * You have id = 0 (green color in the figure) and the only friend of your friends is the person with id = 3 (yellow color in the figure).
 *
 * Constraints:
 *
 * n == watchedVideos.length == friends.length
 * 2 <= n <= 100
 * 1 <= watchedVideos[i].length <= 100
 * 1 <= watchedVideos[i][j].length <= 8
 * 0 <= friends[i].length < n
 * 0 <= friends[i][j] < n
 * 0 <= id < n
 * 1 <= level < n
 * if friends[i] contains j, then friends[j] contains i
 */
package com.chang.leetcode.contest.weekly170;

import java.util.*;

public class Problem1311 {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Set<Integer> counted = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        counted.add(id);
        int curLevel = 0;
        while (curLevel < level && !queue.isEmpty()) {
            Queue<Integer> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                Integer n = queue.poll();
                for (int m : friends[n]) {
                    if (!counted.contains(m)) {
                        next.offer(m);
                        counted.add(m);
                    }
                }
            }

            queue = next;
            curLevel++;
        }

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            watchedVideos.get(queue.poll()).forEach(v -> {
                if (!map.containsKey(v)) {
                    list.add(v);
                }
                map.put(v, map.getOrDefault(v, 0) + 1);
            });
        }

        Collections.sort(list, (a, b) -> {
            int fa = map.get(a);
            int fb = map.get(b);
            return fa == fb ? a.compareTo(b) : fa - fb;
        });
        return list;
    }

    public static void main(String[] args) {
        Problem1311 problem = new Problem1311();
        List<List<String>> watches = new ArrayList<>();
        List<String> w1 = Arrays.asList(new String[]{"bjwtssmu"});
        List<String> w2 = Arrays.asList(new String[]{"aygr", "mqls"});
        List<String> w3 = Arrays.asList(new String[]{"vrtxa", "zxqzeqy", "nbpl", "qnpl"});
        List<String> w4 = Arrays.asList(new String[]{"r", "otazhu", "rsf"});
        List<String> w5 = Arrays.asList(new String[]{"bvcca", "ayyihidz", "ljc", "fiq", "viu"});
        watches.add(w1);
        watches.add(w2);
        watches.add(w3);
        watches.add(w4);
        watches.add(w5);

        int[][] friends = new int[][]{{3, 2, 1, 4}, {0, 4}, {4, 0}, {0, 4}, {2, 3, 1, 0}};
        // ["ayyihidz","bjwtssmu","bvcca","fiq","ljc","viu"]
        List<String> res = problem.watchedVideosByFriends(watches, friends, 3, 1);
    }

}
