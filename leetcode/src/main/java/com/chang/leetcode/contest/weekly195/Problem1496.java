/*
 * 1496. Path Crossing
 *
 * Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west,
 * respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
 * Return True if the path crosses itself at any point, that is, if at any time you are on a location you've previously visited.
 * Return False otherwise.
 *
 * Example 1:
 * Input: path = "NES"
 * Output: false
 * Explanation: Notice that the path doesn't cross any point more than once.
 *
 * Example 2:
 * Input: path = "NESWW"
 * Output: true
 * Explanation: Notice that the path visits the origin twice.
 *
 * Constraints:
 *
 * 1 <= path.length <= 10^4
 * path will only consist of characters in {'N', 'S', 'E', 'W}
 */
package com.chang.leetcode.contest.weekly195;

import java.util.HashSet;
import java.util.Set;

public class Problem1496 {

    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        Pos pre = new Pos(0, 0);
        set.add("x0y0");
        for (int i = 0; i < path.length(); i++) {
            Pos pos = null;
            switch (path.charAt(i)) {
                case 'N':
                    pos = new Pos(pre.x, pre.y + 1);
                    break;
                case 'S':
                    pos = new Pos(pre.x, pre.y - 1);
                    break;
                case 'W':
                    pos = new Pos(pre.x - 1, pre.y);
                    break;
                case 'E':
                    pos = new Pos(pre.x + 1, pre.y);
                    break;
                default:
                    break;
            }

            if (!set.add(pos.toString())) {
                return true;
            }
            pre = pos;
        }

        return false;
    }

    class Pos {
        public int x;
        public int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode()
        {
            return x * 1001 + y;
        }

        @Override
        public String toString() {
            return "x" + x + "y" + y;
        }
    }

    public static void main(String[] args) {
        Problem1496 problem = new Problem1496();
        System.out.println(problem.isPathCrossing("NESWW"));
    }

    public boolean isPathCrossing2(String path) {
        Set<Pos> set = new HashSet<>();
        Pos pre = new Pos(0, 0);
        for (int i = 0; i < path.length(); i++) {
            Pos pos = null;
            switch (path.charAt(i)) {
                case 'N':
                    pos = new Pos(pre.x, pre.y + 1);
                    break;
                case 'S':
                    pos = new Pos(pre.x, pre.y - 1);
                    break;
                case 'W':
                    pos = new Pos(pre.x - 1, pre.y);
                    break;
                case 'E':
                    pos = new Pos(pre.x + 1, pre.y);
                    break;
                default:
                    break;
            }

            if (!set.add(pos)) {
                return true;
            }
            pre = pos;
        }

        return false;
    }

}
