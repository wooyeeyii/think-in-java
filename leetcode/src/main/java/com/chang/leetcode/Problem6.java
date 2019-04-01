/**
 * 6. ZigZag Conversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows
 * like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 *
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"

 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
package com.chang.leetcode;

public class Problem6 {

    public String convert(String s, int numRows) {
        if(1 == numRows) {
            return s;
        }
        char[] str = new char[s.length()];
        int n = 0;
        for(int i = 0; i < numRows; i++) {
            int gap = 2 * numRows - 2;
            if(i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j = j + gap) {
                    str[n++] = s.charAt(j);
                }
            } else {
                for (int j = i; j < s.length(); j = j + gap) {
                    str[n++] = s.charAt(j);
                    if((j + 2 * (numRows - 1 - i)) < s.length())
                    str[n++] = s.charAt((j + 2 * (numRows - 1 - i)));
                }
            }
        }
        return new String(str);
    }

    public static void main(String[] args) {
        Problem6 problem = new Problem6();
        System.out.println("PAHNAPLSIIGYIR"
                .equals(problem.convert("PAYPALISHIRING", 3)));
        System.out.println("PINALSIGYAHRPI"
                .equals(problem.convert("PAYPALISHIRING", 4)));
        System.out.println("A"
                .equals(problem.convert("A", 1)));
    }
}
