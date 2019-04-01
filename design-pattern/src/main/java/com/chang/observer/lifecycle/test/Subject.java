package com.chang.observer.lifecycle.test;

import com.chang.observer.lifecycle.Lifecycle;
import com.chang.observer.lifecycle.LifecycleListener;
import com.chang.observer.lifecycle.LifecycleSupport;

public class Subject implements Lifecycle {

    private LifecycleSupport support = new LifecycleSupport(this);

    @Override
    public void addLifecycleListener(LifecycleListener listener) {
        support.addLifecycleListener(listener);
    }

    @Override
    public void removeLifecycleListener(LifecycleListener listener) {
        support.removeLifecycleListener(listener);
    }

    @Override
    public void start() throws Exception {
        support.fireLifecycleEvent(BEFORE_START_EVENT, null);
        support.fireLifecycleEvent(START_EVENT, null);
        support.fireLifecycleEvent(AFTER_START_EVENT, null);
    }

    @Override
    public void stop() throws Exception {
        support.fireLifecycleEvent(STOP_EVENT, null);
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        Listener1 listener1 = new Listener1();
        Listener2 listener2 = new Listener2();
        subject.addLifecycleListener(listener1);
        subject.addLifecycleListener(listener2);
        try {
            subject.start();
            subject.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
