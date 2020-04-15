package com.chapter3.extend.future;

import java.util.concurrent.*;

public class FutureCookThreadPool {

    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws Exception {
        FutureCookThreadPool f = new FutureCookThreadPool();
        f.makeMeal();
    }

    public void makeMeal() throws Exception {
        long start = System.currentTimeMillis();

//        String s = purchaseCookTools();

        Future<String> task = purchaseCookToolsAsync();

        purchaseVegetable();

        String s = task.get();

        System.out.println(s);
        cook();

        System.out.println("spend time: " + (System.currentTimeMillis() - start));
    }

    private String purchaseCookTools() {
        System.out.println("purchase cook tools.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "guowanpiaopen";
    }

    private Future<String> purchaseCookToolsAsync() {
        Future<String> task = executorService.submit(() -> {
            System.out.println("purchase cook tools.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "guowanpiaopen";
        });

        return task;
    }


    private void purchaseVegetable() {
        System.out.println("purchase vegetable");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void cook() {
        System.out.println("cook");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
