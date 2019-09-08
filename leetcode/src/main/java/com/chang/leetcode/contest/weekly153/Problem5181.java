package com.chang.leetcode.contest.weekly153;

public class Problem5181 {

    public int distanceBetweenBusStops(int[] distance, int startOri, int destinationOri) {
        int disClockwise = 0;
        int disCounterClockwise = 0;
        if(startOri == destinationOri) {
            return 0;
        }

        int start = Math.min(startOri, destinationOri);
        int destination = Math.max(startOri, destinationOri);
        for(int i = start; i < destination; i++) {
            disClockwise += distance[i];
        }
        for(int i = destination; i < start + distance.length; i++) {
            disCounterClockwise += distance[i % distance.length];
        }
        return Math.min(disClockwise, disCounterClockwise);
    }

    public static void main(String[] args) {
        Problem5181 problem = new Problem5181();
//        System.out.println(1 == problem.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
//        System.out.println(3 == problem.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 2));
//        System.out.println(4 == problem.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3));
        System.out.println(problem.distanceBetweenBusStops(new int[]{7,10,1,12,11,14,5,0}, 7, 2));
    }
}
