package com.chang.observer.lifecycle;

public final class LifecycleSupport {
    public LifecycleSupport(Lifecycle lifecycle) {
        super();
        this.lifecycle = lifecycle;
    }

    //主体自身
    private Lifecycle lifecycle = null;
    //观察者集合
    private LifecycleListener listeners[] = new LifecycleListener[0];

    //触发事件，观察者执行相应操作
    public void fireLifecycleEvent(String type, Object data) {
        //封装事件类型
        LifecycleEvent event = new LifecycleEvent(lifecycle, type, data);
        LifecycleListener interested[] = null;
        synchronized (listeners) {
            interested = (LifecycleListener[]) listeners.clone();
        }
        for (int i = 0; i < interested.length; i++)
            interested[i].lifecycleEvent(event);
    }

    public void addLifecycleListener(LifecycleListener listener) {
        synchronized (listeners) {
            LifecycleListener results[] =
                    new LifecycleListener[listeners.length + 1];
            for (int i = 0; i < listeners.length; i++)
                results[i] = listeners[i];
            results[listeners.length] = listener;
            listeners = results;
        }
    }
    public void removeLifecycleListener(LifecycleListener listener) {
        synchronized (listeners) {
            int n = -1;
            for (int i = 0; i < listeners.length; i++) {
                if (listeners[i] == listener) {
                    n = i;
                    break;
                }
            }
            if (n < 0)
                return;
            LifecycleListener results[] =
                    new LifecycleListener[listeners.length - 1];
            int j = 0;
            for (int i = 0; i < listeners.length; i++) {
                if (i != n)
                    results[j++] = listeners[i];
            }
            listeners = results;
        }
    }
    public LifecycleListener[] findLifecycleListeners() {
        return listeners;
    }
}
