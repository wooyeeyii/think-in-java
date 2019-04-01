#### description
example in this package:  
&emsp;&emsp; 统计锁相关线程
	 
*** 
hasQueuedThreadTest.java执行结果：
```
false
true
true
```
**说明**
- hasQueuedThread(Thread arg0)查询线程arg0是否正在等待获得此锁定
- hasQueuedThreads()查询是否有线程正在等待获得此锁定
&emsp;&emsp; 本例中，第一个线程threadA先开启，获得锁并长时间sleep,霸占锁，因此，hasQueuedThread(threadA)是false， 而第二个开启的线程threadB一直在等待锁，所以hasQueuedThread(threadB)是true。 有线程在等待锁，因此锁的hasQueuedThreads()结果也是true.

***
hasWaiters.java执行结果
```
有没有线程正在等待condition？ true 线程数是多少？ 10
after condition.signal 有没有线程正在等待condition？ true 线程数是多少？ 9
```
**说明**
- hasWaiters(Condition condition) 查询是否有线程正在等待与此锁定有关的condition条件
&emsp;&emsp; 开了10个线程并start,且进入condition.await()，第一次查询有10个线程在等待，调用condition.signal()释放其中一个await(), 还有9个。





