#### description
example in this package:  
&emsp;&emsp; ReentrantReadWriteLock **读读共享**。

*** 
RunTest.java执行结果：
```
获得读锁：B 1504527847708
获得读锁：A 1504527847708
```
**说明**
&emsp;&emsp;从时间戳来看，两个线程几乎同时进入lock后面的代码。说明在此使用了lock.readLock()读锁可以提高程序运行效率：允许多个线程同时执行lock()方法后面的代码。
***