#### description
example in this package:  
&emsp;&emsp; 
- void lockInterruptibly(): 如果当前线程未被中断，则获取锁定，如果已经被中断则出现异常
- boolean tryLock(): 仅在调用时锁定未被另一线程保持的情况下，才能获取该锁定。
- boolean tryLock(long timeout, TimeUnit unit): 如果锁定在给定等待时间内没有被另一个线程保持，且当前线程未被中断，则获得该锁定。
	 
*** 
.java执行结果：
```
```
**说明**

***