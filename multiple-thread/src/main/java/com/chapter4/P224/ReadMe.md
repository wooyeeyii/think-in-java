#### description
example in this package:  
&emsp;&emsp; 
- isFair() 判断是不是公平锁。(默认情况下， ReentrantLock类使用的是非公平锁)   (简单，跳过测试)
	 
*** 
isHeldByCurrentThreadTest.java执行结果：
```
before lock, isLocked(): false
before lock, 当前线程是否保持此锁定, isHeldByCurrentThread()：false
after lock, isLocked(): true
after lock, 当前线程是否保持此锁定, isHeldByCurrentThread()：true
```
**说明**
- isHeldByCurrentThread()查询当前线程是否保持此锁定。
- isLocked() 查询此锁定是否由任意线程保持。(即若有线程持有lock, 则为true; 若没有线程持有lock, 则为false)

***