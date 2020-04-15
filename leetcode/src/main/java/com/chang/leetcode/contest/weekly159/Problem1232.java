/**
 * 1232. Check If It Is a Straight Line
 * <p>
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 * <p>
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * <p>
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 * <p>
 * Constraints:
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 */
package com.chang.leetcode.contest.weekly159;

public class Problem1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        double a = 0;
        double b = 0;
        double x1 = coordinates[0][0];
        double y1 = coordinates[0][1];
        double x2 = coordinates[1][0];
        double y2 = coordinates[1][1];
        if (x1 != x2) {
            a = (y2 - y1) / (x2 - x1);
            b = y1 - a * x1;
            for (int[] co : coordinates) {
                if (Math.abs(co[1] - (a * co[0] + b)) > Double.MIN_VALUE) {
                    return false;
                }
            }
        } else {
            for (int[] co : coordinates) {
                if (co[0] != coordinates[0][0]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Problem1232 problem = new Problem1232();

        int[][] coordinates1 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(problem.checkStraightLine(coordinates1));

        int[][] coordinates2 = new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        System.out.println(!problem.checkStraightLine(coordinates2));

        int[][] coordinates3 = new int[][]{{0, 1}, {0, 2}, {0, 4}, {0, 5}};
        System.out.println(problem.checkStraightLine(coordinates3));

        int[][] coordinates4 = new int[][]{{0, 1}, {0, 2}, {1, 4}, {0, 5}};
        System.out.println(!problem.checkStraightLine(coordinates4));

        int[][] coordinates5 = new int[][]{{1, 5}, {2, 5}, {3, 5}, {4, 5}};
        System.out.println(problem.checkStraightLine(coordinates5));

        int[][] coordinates6 = new int[][]{{1, 5}, {2, 5}, {3, 8}, {4, 5}};
        System.out.println(!problem.checkStraightLine(coordinates6));

        int[][] coordinates7 = new int[][]{{-7, 4}, {-11, -5}, {3, -10}, {8, -10}, {-3, 0}, {11, 0}, {-1, 10}, {4, 3}, {-4, -6}, {-2, -7}, {4, 11}};
        System.out.println(!problem.checkStraightLine(coordinates7));
    }


}
