#### description
example in this package: 线程的优先级
&emsp;&emsp; 线程可以划分优先级，优先级较高的线程得到的CPU资源较多。     
&emsp;&emsp; 设置线程的优先级使用setPriority()方法，源码如下：
```
    /**
     * Changes the priority of this thread.
     * <p>
     * First the <code>checkAccess</code> method of this thread is called
     * with no arguments. This may result in throwing a
     * <code>SecurityException</code>.
     * <p>
     * Otherwise, the priority of this thread is set to the smaller of
     * the specified <code>newPriority</code> and the maximum permitted
     * priority of the thread's thread group.
     *
     * @param newPriority priority to set this thread to
     * @exception  IllegalArgumentException  If the priority is not in the
     *               range <code>MIN_PRIORITY</code> to
     *               <code>MAX_PRIORITY</code>.
     * @exception  SecurityException  if the current thread cannot modify
     *               this thread.
     * @see        #getPriority
     * @see        #checkAccess()
     * @see        #getThreadGroup()
     * @see        #MAX_PRIORITY
     * @see        #MIN_PRIORITY
     * @see        ThreadGroup#getMaxPriority()
     */
public final void setPriority(int newPriority) {
        ThreadGroup g;
        checkAccess();
        if (newPriority > MAX_PRIORITY || newPriority < MIN_PRIORITY) {
            throw new IllegalArgumentException();
        }
        if((g = getThreadGroup()) != null) {
            if (newPriority > g.getMaxPriority()) {
                newPriority = g.getMaxPriority();
            }
            setPriority0(priority = newPriority);
        }
    }
```
&emsp;&emsp;线程的优先级分为1-10这10个等级。JDK使用3个常量来预置定义优先级的值。
```
    /**
     * The minimum priority that a thread can have.
     */
    public final static int MIN_PRIORITY = 1;

   /**
     * The default priority that is assigned to a thread.
     */
    public final static int NORM_PRIORITY = 5;

    /**
     * The maximum priority that a thread can have.
     */
    public final static int MAX_PRIORITY = 10;
```

*** 
#### 线程优先级的继承特性
&emsp;&emsp;在java中，线程的优先级具有继承性，例如：A线程启动B线程，则B线程的优先级与A是一样的。
***
#### 线程优先级具有规则性
&emsp;&emsp;cpu会尽量将执行资源让给优先级比较高的线程。
***
#### 优先级具有随机性
&emsp;&emsp;优先级高的线程**一般(非肯定)**先执行




