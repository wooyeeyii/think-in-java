package com.chang.leetcode.contest.weekly153;

public class Problem5183 {

    public String dayOfTheWeek(int day, int month, int year) {
        int start = 1971;
        int yearDiff = year - 1971;
        int longyear = 0;
        for(int i = start; i < year; i++) {
            if((i % 4 == 0 && i % 100 != 0) || (i % 400) == 0) {
                longyear++;
            }
        }
        int dayOfThisYear = 0;
        int[] dp = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if((year % 4 == 0 && year % 100 != 0) || (year % 400) == 0) {
            dp[1] = 29;
        }
        for(int i = 0; i < month - 1; i++) {
            dayOfThisYear += dp[i];
        }
        int totalDays = yearDiff * 365 + longyear + dayOfThisYear + day - 1;
        int diff = totalDays % 7;
        switch (diff) {
            case 0:
                return "Friday";
            case 1:
                return "Saturday";
            case 2:
                return "Sunday";
            case 3:
                return "Monday";
            case 4:
                return "Tuesday";
            case 5:
                return "Wednesday";
            case 6:
                return "Thursday";
        }
        return "";
    }

    public static void main(String[] args) {
        Problem5183 problem = new Problem5183();
        System.out.println("Friday".equals(problem.dayOfTheWeek(1, 1, 1971)));
        System.out.println("Saturday".equals(problem.dayOfTheWeek(31, 8, 2019)));
        System.out.println("Sunday".equals(problem.dayOfTheWeek(18, 7, 1999)));
        System.out.println("Sunday".equals(problem.dayOfTheWeek(15, 8, 1993)));
    }
}
