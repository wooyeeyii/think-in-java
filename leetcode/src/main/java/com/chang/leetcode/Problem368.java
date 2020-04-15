/**
 * 368. Largest Divisible Subset
 * <p>
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj)
 * of elements in this subset satisfies:
 * <p>
 * Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * <p>
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * <p>
 * Example 2:
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 */
package com.chang.leetcode;

import com.chang.common.ArrayToStringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (null == nums || 0 == nums.length) {
            return list;
        }

        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] posRec = new int[nums.length];
        dp[0] = 1;
        posRec[0] = -1;
        int rec = 0;
        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            int maxPos = -1;
            for (int j = 0; j < i; j++) {
                if ((nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) && dp[j] + 1 > max) {
                    max = dp[j] + 1;
                    maxPos = j;
                }
            }
            dp[i] = max;
            posRec[i] = maxPos;
            if (dp[i] > rec) {
                pos = i;
                rec = dp[i];
            }
        }

        while (-1 != pos) {
            list.add(nums[pos]);
            pos = posRec[pos];
        }
        return list;
    }

    public static void main(String[] args) {
        Problem368 problem = new Problem368();
        int[] nums1 = new int[]{1, 2, 3};
        System.out.println(ArrayToStringUtil.oneDimension(problem.largestDivisibleSubset(nums1)));
        System.out.println("################");
        int[] nums2 = new int[]{1, 2, 4, 8};
        System.out.println(ArrayToStringUtil.oneDimension(problem.largestDivisibleSubset(nums2)));
        System.out.println("################");
        int[] nums3 = new int[]{4, 8, 10, 240};
        System.out.println(ArrayToStringUtil.oneDimension(problem.largestDivisibleSubset(nums3)));
        System.out.println("################");
        int[] nums4 = new int[]{2, 3, 8, 9, 27};
        System.out.println(ArrayToStringUtil.oneDimension(problem.largestDivisibleSubset(nums4)));
        System.out.println("################");

        int[] nums10 = new int[]{472, 105, 328, 922, 963, 625, 827, 232, 913, 832, 730, 152, 697, 614, 570, 639,
                459, 895, 70, 488, 239, 596, 930, 402, 904, 197, 911, 126, 876, 535, 597, 332, 863, 870, 646, 839, 878,
                751, 528, 959, 929, 679, 7, 543, 248, 353, 494, 67, 841, 732, 662, 122, 485, 565, 318, 747, 42, 545, 282,
                638, 228, 496, 860, 874, 334, 556, 103, 437, 83, 61, 365, 761, 259, 361, 64, 612, 206, 131, 452, 938, 144,
                573, 774, 243, 521, 102, 787, 154, 92, 15, 649, 951, 240, 506, 342, 770, 940, 135, 700, 820, 393, 412, 884,
                356, 618, 366, 807, 907, 861, 380, 32, 921, 622, 23, 760, 57, 466, 416, 391, 273, 706, 512, 212, 998, 263,
                279, 743, 27, 514, 98, 996, 231, 905, 902, 91, 636, 285, 364, 609, 189, 738, 368, 203, 846, 6, 970, 210,
                748, 594, 268, 157, 726, 257, 419, 999, 797, 869, 96, 792, 451, 352, 693, 894, 987, 978, 595, 518, 346,
                315, 114, 900, 160, 119, 721, 218, 814, 988, 477, 66, 733, 740, 421, 537, 642, 178, 882, 21, 337, 868, 350,
                945, 815, 219, 290, 129, 684, 640, 155, 409, 712, 372, 222, 848, 765, 932, 283, 14, 819, 544, 146, 425, 958,
                644, 903, 458, 473, 85, 627, 845, 641, 340, 198, 961, 456, 992, 495, 413, 170, 390, 559, 143, 166, 428, 100,
                809, 647, 354, 619, 435, 250, 837, 533, 530, 883, 948, 816, 432, 261, 623, 560, 503, 406, 916, 147, 826, 277,
                312, 253, 729, 251, 434, 443, 686, 683, 944, 186, 829, 898, 63, 457, 405, 417, 811, 579, 957, 404, 532, 621, 8,
                260, 445, 45, 887, 296, 728, 236, 591, 447, 422, 696, 481, 893, 264, 974, 701, 714, 379, 12, 482, 541, 942, 385,
                849, 345, 469, 705, 527, 571, 799, 962, 650, 387, 552, 97, 808, 971, 242, 803, 36, 505, 777, 89, 507, 52, 47, 436,
                703, 716, 794, 229, 628, 108, 800, 779, 69, 449, 165, 973, 897, 324, 943, 689, 917, 745, 76, 873, 164, 616, 9, 24,
                237, 739, 892, 818, 718, 351, 617, 420, 744, 314, 687, 956, 782, 781, 297, 424, 737, 912, 522, 272, 408, 369, 645,
                275, 611, 840, 382, 125, 890, 162, 568, 295, 349, 301, 997, 38, 908, 179, 333, 439, 899, 329, 65, 159, 142, 121,
                923, 247, 854, 802, 330, 335, 43, 843, 254, 137, 954, 515, 790, 950, 566, 857, 490, 822, 519, 286, 150, 583, 796,
                291, 941, 37, 742, 723, 784, 976, 374, 780, 888, 569, 879, 805, 88, 468, 463, 969, 258, 877, 176, 564, 654, 798,
                789, 793, 401, 493, 557, 592, 202, 418, 115, 852, 462, 953, 717, 338, 480, 981, 396, 634, 836, 681, 629, 935, 553,
                540, 397, 665, 758, 817, 224, 821, 158, 968, 323, 17, 3, 776, 177, 81, 906, 749, 344, 169, 140, 926, 118, 501, 927,
                504, 598, 875, 34, 643, 548, 813, 470, 508, 736, 602, 378, 59, 652, 994, 915, 249, 213, 661, 450, 39, 267, 586, 55,
                727, 25, 113, 141, 734, 972, 872, 300, 516, 526, 270, 112, 555, 171, 766, 256, 127, 10, 316, 554, 194, 448, 657,
                847, 174, 241, 620, 68, 562, 426, 133, 265, 491, 909, 989, 168, 173, 167, 928, 41, 567, 986, 724, 658, 208, 699,
                709, 306, 933, 2, 653, 881, 298, 750, 577, 702, 319, 694, 394, 601, 651, 309, 16, 310, 668, 486, 192, 136, 33, 856,
                134, 563, 370, 358, 498, 593, 230, 484, 308, 851, 235, 51, 551, 536, 980, 415, 810, 246, 307, 79, 221, 580, 576, 101,
                438, 791, 455, 673, 75, 610, 376, 44, 624, 399, 294, 271, 195, 725, 637, 78, 773, 806, 967, 163, 871, 389, 453, 558,
                925, 193, 467, 274, 371, 788, 599};
        // [3,6,12,24,96,192,576]
        System.out.println(ArrayToStringUtil.oneDimension(problem.largestDivisibleSubset(nums10)));
        System.out.println("################");
    }
}
