#### description
example in this package:  
&emsp;&emsp; UseConditionWaitNotifyError
	 
*** 
RunTest.java执行结果:
```
Exception in thread "Thread-0" java.lang.IllegalMonitorStateException
	at java.util.concurrent.locks.ReentrantLock$Sync.tryRelease(Unknown Source)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.release(Unknown Source)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.fullyRelease(Unknown Source)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
	at com.chapter4.P205.MyService.await(MyService.java:13)
	at com.chapter4.P205.ThreadA.run(ThreadA.java:13)
```
**原因**    
&emsp;&emsp;监视器出错，类似于wait()方法，必须在锁内部使用，这里调用condition.await()方法之前必须调用lock.lock()获得同步监视器
