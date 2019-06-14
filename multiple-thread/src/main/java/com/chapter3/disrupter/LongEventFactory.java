package com.chapter3.disrupter;

import com.lmax.disruptor.EventFactory;

/**
 * 事件生产工厂
 *
 * @author wanghao
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}

