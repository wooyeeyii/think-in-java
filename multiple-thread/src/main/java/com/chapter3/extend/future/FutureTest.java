package com.chapter3.extend.future;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FutureTest {

    public static void main(String[] args) {
        FutureTest futureTest = new FutureTest();
        futureTest.methodTest();
    }

    public void methodTest() {
        Future<HashMap> future = getDataFromRemote2();

        // do other things
        System.out.println("has invoke remote mehod, but i am still running...");

        // time to use remote data
        try {
            System.out.println("time to wait for remote data...");
            HashMap data = (HashMap) future.get();
            System.out.println("get remote data...");
            System.out.println(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private Future<HashMap> getDataFromRemote2() {
        final ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(10));    //
        return pool.submit(new Callable<HashMap>() {
            public HashMap call() throws Exception {
                return getDataFromRemote();
            }
        });
    }

    private HashMap<String, String> getDataFromRemote() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map;
    }

}
