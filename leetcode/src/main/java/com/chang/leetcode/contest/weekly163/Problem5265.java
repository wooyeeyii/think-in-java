package com.chang.leetcode.contest.weekly163;

public class Problem5265 {

    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int a1 = 0; // n % 3 == 1的最小值
        int a2 = 0; // n % 3 == 1的第二小值
        int b1 = 0;
        int b2 = 0;

        for (int n : nums) {
            sum += n;
            if (n % 3 == 1) {
                if (a1 == 0) {
                    a1 = n;
                } else if (a2 == 0) {
                    a2 = Math.max(n, a1);
                    a1 = Math.min(n, a1);
                } else {
                    if (n < a2) {
                        a2 = Math.max(a1, n);
                        a1 = Math.min(a1, n);
                    }
                }
            } else if (n % 3 == 2) {
                if (b1 == 0) {
                    b1 = n;
                } else if (b2 == 0) {
                    b2 = Math.max(n, b1);
                    b1 = Math.min(n, b1);
                } else {
                    if (n < b2) {
                        b2 = Math.max(b1, n);
                        b1 = Math.min(b1, n);
                    }
                }
            }
        }

        if (sum % 3 == 0) {
            return sum;
        } else if (sum % 3 == 1) {
            if (b1 != 0 && b2 != 0) {
                return sum - Math.min(a1, b1 + b2);
            } else {
                return sum - a1;
            }
        } else if (sum % 3 == 2) {
            if (a1 != 0 && a2 != 0) {
                return sum - Math.min(b1, a1 + a2);
            } else {
                return sum - b1;
            }
        }


        return 0;
    }

    public static void main(String[] args) {
        Problem5265 problem = new Problem5265();
        System.out.println(18 == problem.maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
        System.out.println(0 == problem.maxSumDivThree(new int[]{4}));
        System.out.println(50487 == problem.maxSumDivThree(new int[]{366, 809, 6, 792, 822, 181, 210, 588, 344, 618, 341, 410, 121, 864, 191, 749, 637, 169, 123, 472, 358, 908, 235, 914, 322, 946, 738, 754, 908, 272, 267, 326, 587, 267, 803, 281, 586, 707, 94, 627, 724, 469, 568, 57, 103, 984, 787, 552, 14, 545, 866, 494, 263, 157, 479, 823, 835, 100, 495, 773, 729, 921, 348, 871, 91, 386, 183, 979, 716, 806, 639, 290, 612, 322, 289, 910, 484, 300, 195, 546, 499, 213, 8, 623, 490, 473, 603, 721, 793, 418, 551, 331, 598, 670, 960, 483, 154, 317, 834, 352}));
    }


}
