#### description
example in this package:  
&emsp;&emsp; ReentrantReadWriteLock **写写互斥**。

*** 
RunTest.java执行结果：
```
获得写锁：A 1504528602524
获得读锁：B 1504528612525
```
**说明**
&emsp;&emsp;写读是互斥的。 同样读写也是互斥的。只要出现“写操作”， 都是互斥的。仅有读读是异步的。
***