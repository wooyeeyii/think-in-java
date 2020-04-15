package com.chang.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThrowableTest {

    private static final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    private AtomicInteger idx = new AtomicInteger(0);

    public void start() {
        executorService.scheduleAtFixedRate(this::process, 0, 2, TimeUnit.SECONDS);
    }

    private void process() {
        System.out.println("process... Number: " + idx.incrementAndGet());
        throw new RuntimeException("error");
    }

    public static void main(String[] args) {
        ThrowableTest throwableTest = new ThrowableTest();
        throwableTest.start();
    }


}
