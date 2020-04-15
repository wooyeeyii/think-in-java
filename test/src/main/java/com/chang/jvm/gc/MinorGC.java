/**
 * allocation4 4M无法放入eden空间，执行一次minor gc
 * 完成后，tenured被占6M， eden占4M
 */
package com.chang.jvm.gc;

public class MinorGC {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数 -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:+UseSerialGC
     */
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}
