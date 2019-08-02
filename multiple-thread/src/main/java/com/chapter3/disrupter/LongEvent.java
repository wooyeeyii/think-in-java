package com.chapter3.disrupter;

public class LongEvent {

    private long value;

    public void set(long value) {
        this.value = value;
    }

    public long get() {
        return this.value;
    }
}
