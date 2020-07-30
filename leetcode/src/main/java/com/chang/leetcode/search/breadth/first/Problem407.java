/**
 * 407. Trapping Rain Water II
 *
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map,
 * compute the volume of water it is able to trap after raining.
 *
 * Example:
 * Given the following 3x6 height map:
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 * Return 4.
 *
 * The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.
 *
 * After the rain, water is trapped between the blocks. The total volume of water trapped is 4.
 *
 * Constraints:
 *
 * 1 <= m, n <= 110
 * 0 <= heightMap[i][j] <= 20000
 */
package com.chang.leetcode.search.breadth.first;

import java.util.PriorityQueue;

public class Problem407 {

    class Cell {
        int x;
        int y;
        int height;

        Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (null == heightMap || 0 == heightMap.length || 0 == heightMap[0].length) {
            return 0;
        }

        int rows = heightMap.length;
        int cols = heightMap[0].length;
        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> a.height - b.height);

        for (int i = 0; i < rows; i++) {
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            queue.offer(new Cell(i, cols - 1, heightMap[i][cols - 1]));
            visited[i][cols - 1] = true;
        }

        for (int i = 0; i < cols; i++) {
            queue.offer(new Cell(0, i, heightMap[0][i]));
            visited[0][i] = true;
            queue.offer(new Cell(rows - 1, i, heightMap[rows - 1][i]));
            visited[rows - 1][i] = true;
        }

        int hold = 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            for (int[] dir : dirs) {
                int r = cur.x + dir[0];
                int c = cur.y + dir[1];
                if (r >= 0 && r < rows && c >= 0 && c < cols && !visited[r][c]) {
                    visited[r][c] = true;
                    hold += Math.max(0, cur.height - heightMap[r][c]);
                    queue.offer(new Cell(r, c, Math.max(heightMap[r][c], cur.height)));
                }
            }
        }

        return hold;
    }

}
