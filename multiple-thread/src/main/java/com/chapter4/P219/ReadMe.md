#### description
example in this package:  
&emsp;&emsp; 统计锁相关线程数
	 
*** 
GetHoldCountTest.java执行结果：
```
serviceMethod1 before get lock again, getHoldCount=1
serviceMethod2 getHoldCount=2
serviceMethod1 after release lock once, getHoldCount=1
```
**说明**
&emsp;&emsp; 方法int getHoldCount() 的作用是查询**当前线程**  **保持此锁定**的个数，两个关键字，当前线程+保持此锁定，已释放的不在统计范围内。

***
GetQueueLengthTest.java执行结果
```
ThreadName=Thread-0 进入方法！
有线程数：9 在等待获得锁！
```
**分析**
&emsp;&emsp; 开了10个线程并start,第一个线程获得锁后sleep(sleep并不释放锁)，且sleep时间很长，其他线程均在等待。

***
GetWaitQueueLengthTest.java执行结果
```
有10 个线程正在等待condition
```
**说明**
&emsp;&emsp; getWaitQueueLength(Condition condition) 方法的作用是返回等待与此锁定相关的给定条件Condition的线程计数




