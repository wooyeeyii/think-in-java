/**
 * 56. Merge Intervals
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * <p>
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
package com.chang.leetcode;

import com.chang.common.Interval;

import java.util.*;

public class Problem56 {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<Interval>();
        if (intervals.size() <= 0) {
            return list;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > end) {
                Interval in = new Interval(start, end);
                list.add(in);
                start = intervals.get(i).start;
            }
            end = Math.max(end, intervals.get(i).end);
        }
        Interval in = new Interval(start, end);
        list.add(in);
        return list;
    }

    public static void main(String[] args) {
        Problem56 problem = new Problem56();
        List<Interval> list1 = new ArrayList<Interval>();
        Interval in1 = new Interval(1, 3);
        list1.add(in1);
        Interval in2 = new Interval(2, 6);
        list1.add(in2);
        Interval in3 = new Interval(8, 10);
        list1.add(in3);
        Interval in4 = new Interval(15, 18);
        list1.add(in4);
        // output: [[1,6],[8,10],[15,18]]
        List<Interval> res1 = problem.merge(list1);
        for (Interval r : res1) {
            System.out.print(r.toString());
        }
        System.out.println("#################");

        List<Interval> list2 = new ArrayList<Interval>();
        Interval n1 = new Interval(1, 4);
        list2.add(n1);
        Interval n2 = new Interval(2, 3);
        list2.add(n2);
        List<Interval> res2 = problem.merge(list2);
        for (Interval r : res2) {
            System.out.print(r.toString());
        }
        System.out.println("#################");

        List<Interval> list3 = new ArrayList<Interval>();
        Interval m1 = new Interval(1, 4);
        list3.add(m1);
        Interval m2 = new Interval(5, 6);
        list3.add(m2);
        // output: [[1, 5]]
        List<Interval> res3 = problem.merge(list3);
        for (Interval r : res3) {
            System.out.print(r.toString());
        }
        System.out.println("#################");

    }


    // 错误，不能解决[1, 4] [5, 6]
    public List<Interval> mergeWrong(List<Interval> intervals) {
        List<Interval> list = new ArrayList<Interval>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Interval in : intervals) {
            min = Math.min(min, in.start);
            max = Math.max(max, in.end);
        }
        int[] flag = new int[max - min + 1];
        Arrays.fill(flag, 0);
        for (Interval in : intervals) {
            for (int i = in.start; i <= in.end; i++) {
                flag[i - min] = 1;
            }
        }
        int pos = 0;
        while (pos < flag.length) {
            int begin = pos;
            while (begin < flag.length && 0 == flag[begin]) {
                begin++;
            }
            int end = begin;
            while (end < flag.length && 0 != flag[end]) {
                end++;
            }
            if (end > begin) {
                Interval in = new Interval(begin + min, end + min - 1);
                list.add(in);
            }
            pos = end;
        }
        return list;
    }

}
