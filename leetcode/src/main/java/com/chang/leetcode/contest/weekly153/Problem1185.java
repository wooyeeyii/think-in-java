package com.chang.leetcode.contest.weekly153;

public class Problem1185 {

    public String dayOfTheWeek(int day, int month, int year) {
        int[] dayOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400) == 0) {
            dayOfMonth[1] = 29;
        }

        String[] res = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

        int start = 1971;
        int yearDiff = year - 1971;
        int longyear = 0;
        for (int i = start; i < year; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400) == 0) {
                longyear++;
            }
        }

        int dayOfThisYear = 0;
        for (int i = 0; i < month - 1; i++) {
            dayOfThisYear += dayOfMonth[i];
        }

        int totalDays = (yearDiff * 365 + longyear) + dayOfThisYear + day - 1;

        int diff = totalDays % 7;
        return res[diff];
    }

    public static void main(String[] args) {
        Problem1185 problem = new Problem1185();
        System.out.println("Friday".equals(problem.dayOfTheWeek(1, 1, 1971)));
        System.out.println("Saturday".equals(problem.dayOfTheWeek(31, 8, 2019)));
        System.out.println("Sunday".equals(problem.dayOfTheWeek(18, 7, 1999)));
        System.out.println("Sunday".equals(problem.dayOfTheWeek(15, 8, 1993)));
    }
}
