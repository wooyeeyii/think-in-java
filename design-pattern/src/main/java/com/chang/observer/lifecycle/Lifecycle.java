package com.chang.observer.lifecycle;

public interface Lifecycle {
    public static final String START_EVENT = "start";
    public static final String BEFORE_START_EVENT = "before_start";
    public static final String AFTER_START_EVENT = "after_start";
    public static final String STOP_EVENT = "stop";

    public void addLifecycleListener(LifecycleListener listener);
    public void removeLifecycleListener(LifecycleListener listener);
    public void start() throws Exception;
    public void stop() throws Exception;
}
