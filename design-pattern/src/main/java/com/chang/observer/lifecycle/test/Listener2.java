package com.chang.observer.lifecycle.test;

import com.chang.observer.lifecycle.Lifecycle;
import com.chang.observer.lifecycle.LifecycleEvent;
import com.chang.observer.lifecycle.LifecycleListener;

public class Listener2 implements LifecycleListener {
    @Override
    public void lifecycleEvent(LifecycleEvent event) {
        if(Lifecycle.BEFORE_START_EVENT.equals(event.getType())) {
            System.out.println("listener2 before start event active.");
        } else if(Lifecycle.START_EVENT.equals(event.getType())) {
            System.out.println("listener2 start event active.");
        } else if (Lifecycle.AFTER_START_EVENT.equals(event.getType())) {
            System.out.println("listener2 after start event active.");
        } else if(Lifecycle.STOP_EVENT.equals(event.getType())) {
            System.out.println("listener2 stop event active.");
        } else {
            System.out.println("listener2 pass this kind of event.");
        }
    }
}
