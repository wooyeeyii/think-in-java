/*
 * 744. Find Smallest Letter Greater Than Target
 *
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
 * find the smallest element in the list that is larger than the given target.
 *
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 *
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 *
 * Note:
 * letters has a length in range [2, 10000].
 * letters consists of lowercase letters, and contains at least 2 unique letters.
 * target is a lowercase letter.
 */
package com.chang.leetcode;

public class Problem744 {

    public char nextGreatestLetterSlow(char[] letters, char target) {
        int min = 25;
        for (char c : letters) {
            if (c > target && c - target < min) {
                min = c - target;
            } else if (c < target && c + 26 - target < min) {
                min = c + 26 - target;
            }
        }

        return target + min <= 'z' ? (char) (target + min) : (char) (target + min - 26);
    }

    public static void main(String[] args) {
        Problem744 problem = new Problem744();
        System.out.println(problem.nextGreatestLetter(new char[]{'a', 'b'}, 'z'));
        System.out.println(problem.nextGreatestLetter(new char[]{'d', 'e'}, 'c'));
        System.out.println(problem.nextGreatestLetter(new char[]{'m', 'n'}, 'c'));
        System.out.println(problem.nextGreatestLetter(new char[]{'b', 'e'}, 'c'));
    }

    public char nextGreatestLetter(char[] a, char x) {
        int n = a.length;

        //hi starts at 'n' rather than the usual 'n - 1'.
        //It is because the terminal condition is 'lo < hi' and if hi starts from 'n - 1',
        //we can never consider value at index 'n - 1'
        int lo = 0, hi = n;

        //Terminal condition is 'lo < hi', to avoid infinite loop when target is smaller than the first element
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > x) hi = mid;
            else lo = mid + 1;                 //a[mid] <= x
        }

        //Because lo can end up pointing to index 'n', in which case we return the first element
        return a[lo % n];
    }

}
