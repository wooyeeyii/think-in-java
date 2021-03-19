/*
 * 1274. Number of Ships in a Rectangle
 * 
 * (This problem is an interactive problem.)
 * On the sea represented by a cartesian plane, each ship is located at an integer point,
 * and each integer point may contain at most 1 ship.
 * You have a function Sea.hasShips(topRight, bottomLeft) which takes two points as arguments and returns true if
 * and only if there is at least one ship in the rectangle represented by the two points, including on the boundary.
 * Given two points, which are the top right and bottom left corners of a rectangle,
 * return the number of ships present in that rectangle.  It is guaranteed that there are at most 10 ships in that rectangle.
 * Submissions making more than 400 calls to hasShips will be judged Wrong Answer.
 * Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * 
 * 
 * Input:
 * ships = [[1,1],[2,2],[3,3],[5,5]], topRight = [4,4], bottomLeft = [0,0]
 * Output: 3
 * Explanation: From [0,0] to [4,4] we can count 3 ships within the range.
 * 
 * Constraints:
 * On the input ships is only given to initialize the map internally. You must solve this problem "blindfolded". In other words, you must find the answer using the given hasShips API, without knowing the ships position.
 * 0 <= bottomLeft[0] <= topRight[0] <= 1000
 * 0 <= bottomLeft[1] <= topRight[1] <= 1000
 */
package com.chang.leetcode.contest.biweekly14;

public class Problem1274 {

    // TOO MANY QUERIES
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }

        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) {
            return sea.hasShips(topRight, bottomLeft) ? 1 : 0;
        }

        int count = 0;
        int middle0 = (topRight[0] + bottomLeft[0]) / 2;
        int middle1 = (topRight[1] + bottomLeft[1]) / 2;
        if (topRight[0] == bottomLeft[0]) {
            int[] middle = new int[]{bottomLeft[0], middle1};
            if (sea.hasShips(middle, bottomLeft)) {
                count += countShips(sea, middle, bottomLeft);
            }

            int[] middleN = new int[]{bottomLeft[0], middle1 + 1};
            if (sea.hasShips(topRight, middleN)) {
                count += countShips(sea, topRight, middleN);
            }
        } else if (topRight[1] == bottomLeft[1]) {
            int[] middle = new int[]{middle0, bottomLeft[1]};
            if (sea.hasShips(middle, bottomLeft)) {
                count += countShips(sea, middle, bottomLeft);
            }

            int[] middleN = new int[]{middle0 + 1, bottomLeft[1]};
            if (sea.hasShips(topRight, middleN)) {
                count += countShips(sea, topRight, middleN);
            }
        } else {
            int[] middle = new int[]{middle0, middle1};
            if (sea.hasShips(middle, bottomLeft)) {
                count += countShips(sea, middle, bottomLeft);
            }

            if (sea.hasShips(new int[]{middle0, topRight[1]}, new int[]{bottomLeft[0], middle1 + 1})) {
                count += countShips(sea, new int[]{middle0, topRight[1]}, new int[]{bottomLeft[0], middle1 + 1});
            }

            if (sea.hasShips(new int[]{topRight[0], middle1}, new int[]{middle0 + 1, bottomLeft[1]})) {
                count += countShips(sea, new int[]{topRight[0], middle1}, new int[]{middle0 + 1, bottomLeft[1]});
            }

            int[] middleN3 = new int[]{middle0 + 1, middle1 + 1};
            if (sea.hasShips(topRight, middleN3)) {
                count += countShips(sea, topRight, middleN3);
            }


        }

        return count;
    }

    class Sea {
        public boolean hasShips(int[] topRight, int[] bottomLeft) {
            return true;
        }
    }

    public static void main(String[] args) {
        Problem1274 problem = new Problem1274();
        Sea sea = problem.new Sea();
        System.out.println(problem.countShips(sea, new int[]{4, 4}, new int[]{0, 0}));
    }

    /*
     * divide the current rectangle into 4 pieces in the middle.
     * Base case: when topRight == bottomLeft, meaning our rectangle reduces into a point in the map.
     * We return 1 if hasShips(topRight, bottomLeft)
     */
    public int countShipsExample(Sea sea, int[] topRight, int[] bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }

        if (bottomLeft[0] > topRight[0] || bottomLeft[1] > topRight[1]) {
            return 0;
        }

        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) {
            return 1;
        }

        int midX = (topRight[0] + bottomLeft[0]) / 2;
        int midY = (topRight[1] + bottomLeft[1]) / 2;
        return countShipsExample(sea, new int[]{midX, midY}, bottomLeft) +
                countShipsExample(sea, topRight, new int[]{midX + 1, midY + 1}) +
                countShipsExample(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY + 1}) +
                countShipsExample(sea, new int[]{topRight[0], midY}, new int[]{midX + 1, bottomLeft[1]});
    }

}
