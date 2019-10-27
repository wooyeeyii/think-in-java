package com.chang.leetcode.string;

public class Problem551 {

    public boolean checkRecord(String s) {
        if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
            return false;
        return true;
    }

    public static void main(String[] args) {
        Problem551 problem = new Problem551();
        System.out.println(!problem.checkRecord("PPALLL"));
        System.out.println(problem.checkRecord("PPALLP"));
    }

}
