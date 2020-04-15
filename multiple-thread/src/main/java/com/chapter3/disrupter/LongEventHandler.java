package com.chapter3.disrupter;

import com.lmax.disruptor.EventHandler;

/**
 * 消息者事件处理器，打印输出到控制台
 *
 * @author harry
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("consumer:" + Thread.currentThread().getName() +
                " Event: value=" + event.get() + ", sequence=" + sequence + ", endOfBatch=" + endOfBatch);
    }

}
