#### description
example in this package:  
&emsp;&emsp; ReentrantReadWriteLock **写写互斥**。

*** 
RunTest.java执行结果：
```
获得写锁：A 1504528391928
获得写锁：B 1504528401929
```
**说明**
&emsp;&emsp;从时间戳来看，A线程获得锁，输出，睡眠10s，释放锁，线程B获得锁.... 写锁互斥，同一时间仅允许一个线程进行写操作。
***