#### 概述
&emsp;&emsp;观察者模式是对象的行为模式.    
&emsp;&emsp;观察者模式定义了一种多个对象依赖一个对象的关系，让多个观察者对象同时监听某一个主题对象。这个主体对象在状态上发生变化时，会通知所有观察者对象，使它们能够对应做出反应。

#### 思路
&emsp;&emsp;被观察对象类中会有观察者的类的集合，当被观察对象的状态发生改变时，观察者(包含在前面说的集合中)会调用对应的函数作出响应。    
&emsp;&emsp;按照这个思路，我们举个例子看看：    
##### 观察者的接口和实现类：
```
public interface Observer {
    /**
     * 更新接口
     * @param state    更新的状态
     */
    public void update(String state);
}

public class ConcreteObserver implements Observer {
    //观察者的状态
    private String observerState;

    @Override
    public void update(String state) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = state;
        System.out.println("观察者状态改变为："+observerState);
    }

}
```
##### 主体的抽象类和实现类：
```
public abstract class Subject {
    /**
     * 用来保存注册的观察者对象
     */
    private List<Observer> list = new ArrayList<Observer>();
    /**
     * 注册观察者对象
     * @param observer    观察者对象
     */
    public void attach(Observer observer){
        list.add(observer);
        System.out.println("Attached an observer");
    }
    /**
     * 删除观察者对象
     * @param observer    观察者对象
     */
    public void detach(Observer observer){
        list.remove(observer);
    }
    /**
     * 通知所有注册的观察者对象
     */
    public void notifyObservers(String newState){
        for(Observer observer : list){
            observer.update(newState);
        }
    }
}


public class ConcreteSubject extends Subject{
    private String state;
    public String getState() {
        return state;
    }
    
    public void change(String newState){
        state = newState;
        System.out.println("主体状态改变, 变之后为：" + state);
        //状态发生改变，通知各个观察者
        this.notifyObservers(state);
    }
}
```
##### 测试类
```
public class Client {

    public static void main(String[] args) {
        //创建主题对象
        ConcreteSubject subject = new ConcreteSubject();
        //创建观察者对象
        Observer observer = new ConcreteObserver();
        //将观察者对象登记到主题对象上
        subject.attach(observer);
        //改变主题对象的状态
        subject.change("new state");
    }
}
```
##### 测试结果
```
Attached an observer
主体状态改变, 变之后为：new state
观察者状态改变为：new state
```

#### 推模型和拉模型
&emsp;&emsp;在观察者模式中，又分为推模型和拉模型两种方式:
1. **推模型**    
    主题对象向观察者推送主题的详细信息，不管观察者是否需要，推送的信息通常是主题对象的全部或部分数据
2. **拉模型**
    主题对象在通知观察者的时候，只传递少量信息。如果观察者需要更具体的信息，由观察者主动到主题对象中获取。(会将主体对象自身传递给观察者)    
&emsp;&emsp;推模型是明确知晓观察者需要的数据，而拉模型则不知道需要的明确数据，便将自己传给观察者，让观察者自取；推模型推送的数据是确定的，难以扩展，而拉模型和很轻易的获取主体的新对象；推模型的安全性显然要高很多。

#### 在Tomcat中的使用实例
&emsp;&emsp;观察者模式在Tomcat也有应用，来看看源码。    
&emsp;&emsp;为了减少篇幅，一些代码别剪掉了。
```
package org.apache.catalina;
public interface Lifecycle {
    public static final String START_EVENT = "start";
    public static final String BEFORE_START_EVENT = "before_start";
    public static final String AFTER_START_EVENT = "after_start";
    public static final String STOP_EVENT = "stop";
    
    public void addLifecycleListener(LifecycleListener listener);
    public void removeLifecycleListener(LifecycleListener listener);
    public void start() throws LifecycleException;
    public void stop() throws LifecycleException;
}
```
&emsp;&emsp;这里的lifecyleListener就是观察者了. 这个接口仅有一个函数，就是事件触发后的执行。
```
public interface LifecycleListener {
    public void lifecycleEvent(LifecycleEvent event);
}
```
&emsp;&emsp;lifecycleEvent事件类型的类, 传递给观察者的参数有主体本身，还有参数，主体本身使用的是lifecycle接口，可以向下强转为对象本身类型。
```
public final class LifecycleEvent
    extends EventObject {
    public LifecycleEvent(Lifecycle lifecycle, String type) {
        this(lifecycle, type, null);
    }

    public LifecycleEvent(Lifecycle lifecycle, String type, Object data) {
        super(lifecycle);
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
```
&emsp;&emsp;Tomcat还提供给了一个辅助类LifecycleSupport, 我们可以在我们的主题类中加入这个辅助类的对象，帮我们轻松实现观察者模式
```
package org.apache.catalina.util;
import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

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
```
代码中有使用的示例.


#### 参考资料
[《JAVA与模式》之观察者模式](https://www.cnblogs.com/java-my-life/archive/2012/05/16/2502279.html)    
[代码分享](https://github.com/wooyeeyii/think-in-java/tree/master/design-pattern/src/main/java/com/chang/observer)