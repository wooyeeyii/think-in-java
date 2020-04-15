/**
 * 尽管 return i 是原子性操作，但是缺少同步使得其数值可以在处于不稳定的中间状态时被读取。
 * 除此之外，由于i也不是volatile的，存在可视性问题。
 */

package com.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class P682AtomicityTest implements Runnable {
    private int i = 0;

    public int getValue() {    //必须是synchronized的
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        P682AtomicityTest at = new P682AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (0 != val % 2) {
                System.out.println(val);
                System.exit(0);
            }
        }

    }


}
