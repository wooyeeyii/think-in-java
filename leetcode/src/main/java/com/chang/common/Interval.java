package com.chang.common;

public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(start);
        sb.append(",").append(end);
        sb.append("] ");
        return sb.toString();
    }
}

