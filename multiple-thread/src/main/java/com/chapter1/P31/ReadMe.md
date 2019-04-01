#### description
example in this package:  线程在sleep()时进行中断，或者调用中断后让线程sleep()，线程会有什么样的表现。

*** 
RunTest1.java执行结果：
```
//线程sleep时进行中断操作
thread.isAlive():true
thread.interrupted(): false
java.lang.InterruptedException: sleep interrupted
    at java.lang.Thread.sleep(Native Method)
    at com.chapter1.P31.MyThread.run(MyThread.java:9)
thread.isAlive():false
```
**分析**    
&emsp;&emsp; 线程在sleep()时， 对线程进行interrupt()操作，则线程会直接抛出InterruptedException异常, 且此时中断标志为false。
***
RunTest2.java执行结果：
```
//线程中断后进行sleep()
thread.isAlive():true
thread.isAlive():true
thread is going to sleep. thread.interrupted(): true
thread.interrupted(): false
java.lang.InterruptedException: sleep interrupted
    at java.lang.Thread.sleep(Native Method)
    at com.chapter1.P31.MyThread2.run(MyThread2.java:13)

```
**分析**    
&emsp;&emsp; 有中断标志的线程进行sleep()，会直接抛出interruptedException。但sleep()之前的代码会正常运行。
***
**追根溯源**    
&emsp;&emsp;源码如下：if any thread has interrupted the current thread. The <i>interrupted status</i> of the current thread is cleared when this exception is thrown.
```
/**
     * Causes the currently executing thread to sleep (temporarily cease
     * execution) for the specified number of milliseconds, subject to
     * the precision and accuracy of system timers and schedulers. The thread
     * does not lose ownership of any monitors.
     *
     * @param  millis
     *         the length of time to sleep in milliseconds
     *
     * @throws  IllegalArgumentException
     *          if the value of {@code millis} is negative
     *
     * @throws  InterruptedException
     *          if any thread has interrupted the current thread. The
     *          <i>interrupted status</i> of the current thread is
     *          cleared when this exception is thrown.
     */
    public static native void sleep(long millis) throws InterruptedException;
```




