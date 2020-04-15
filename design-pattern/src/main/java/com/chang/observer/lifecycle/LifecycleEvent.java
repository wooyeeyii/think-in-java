package com.chang.observer.lifecycle;

public final class LifecycleEvent {
    public LifecycleEvent(Lifecycle lifecycle, String type) {
        this(lifecycle, type, null);
    }

    public LifecycleEvent(Lifecycle lifecycle, String type, Object data) {
        super();
        this.lifecycle = lifecycle;
        this.type = type;
        this.data = data;
    }

    // The event data associated with this event.
    private Object data = null;
    // The Lifecycle on which this event occurred.(即主体)
    private Lifecycle lifecycle = null;
    // The event type this instance represents.(事件类型)
    private String type = null;

    public Object getData() {
        return (this.data);
    }

    public Lifecycle getLifecycle() {
        return (this.lifecycle);
    }

    public String getType() {
        return (this.type);
    }
}
