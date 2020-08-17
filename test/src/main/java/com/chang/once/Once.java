package com.chang.once;

public class Once {

    private int find(int[][] nums) {
        int rows = nums.length;
        int cols = nums[0].length;
        int[] idxs = new int[rows];
        int min = -1;
        int k = 0;
        for (; k < cols; k++) {
            min = nums[0][idxs[0]];
            int row = 1;
            for (; row < rows; row++) {
                int col = idxs[row];
                for (; col < cols; col++) {
                    idxs[row] = col;
                    if (nums[row][col] >= min) {
                        idxs[row] = col; // col + 1
                        break;
                    }
                }

                if (col >= cols) {
                    return -1;
                }

                if (nums[row][col] != min) {
                    break;
                }
            }

            if (row == rows) {
                return min;
            }
            idxs[0]++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Once once = new Once();
        int[][] nums = new int[][]{
                {1, 2, 3, 4, 6, 7, 8, 9},
                {0, 1, 2, 3, 4, 5, 6, 7, 8},
                {3, 5, 6, 7, 8, 9, 10},
                {4, 6, 7, 8, 9, 10, 11},
                {0, 7, 8, 9, 10, 11, 12}
        };
        System.out.println(once.find(nums));
    }


}





