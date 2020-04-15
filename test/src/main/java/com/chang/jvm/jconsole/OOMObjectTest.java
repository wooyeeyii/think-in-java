package com.chang.jvm.jconsole;

import java.util.ArrayList;
import java.util.List;

/**
 * 设置虚拟机参数：-Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class OOMObjectTest {
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            //稍作延时，让见识曲线的变化更明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }

}


