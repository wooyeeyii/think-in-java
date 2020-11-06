package com.examples.reorder;

public class HashCodeTest {

    private int hash;

    public int hashCode() {
        if (hash == 0) {
            hash = 1;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return hash;
    }

    public int hashCode2() {
        int h = hash;
        if (h == 0) {
            hash = h = 1;
        }
        return h;
    }

    public static void main(String[] args) {
        HashCodeTest test = new HashCodeTest();
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                int h = test.hashCode();
                if(0 == h) {
                    System.out.println("0000!");
                }
            }).start();
        }
    }

}
