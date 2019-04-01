#### description
example in this package:  
- NEW状态：线程实例化后还未执行start()方法时的状态
- RUNNABLE状态：线程进入运行的状态；
- TERMINATED状态：线程被销毁时的状态；
- TIMED_WAITING状态：线程执行了Thread.sleep()方法，呈等待状态；
- BLOCKED状态：线程在等待锁的时候；
- WAITING状态：线程执行了Object.wait()方法后所处的状态；

*** 
RunTest.java执行结果：
```
a1进入了业务方法.
main方法中的状态, a1: RUNNABLE
main方法中的状态, a2: BLOCKED
a2进入了业务方法.
```
**分析**
&emsp;&emsp; 线程a1抢占锁，使得a2线程一直在等待a1释放锁，呈BLOCKED状态
***