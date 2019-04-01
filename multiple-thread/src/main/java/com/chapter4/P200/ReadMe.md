#### description
example in this package:  
&emsp;&emsp; reentrantLock类能实现和synchronized关键字相同的效果，并且在扩展功能上也更加强大，使用上比synchronized更加灵活
	 
*** 
调用ReentrantLock对象的lock()方法获得锁，调用unlock()方法释放锁, 所以RunTest中多个线程是同步的。    
&emsp;&emsp;RunTest.java的运行结果
```
ThreadName = Thread-0 1
ThreadName = Thread-0 2
ThreadName = Thread-0 3
ThreadName = Thread-0 4
ThreadName = Thread-0 5
ThreadName = Thread-3 1
ThreadName = Thread-3 2
ThreadName = Thread-3 3
ThreadName = Thread-3 4
ThreadName = Thread-3 5
ThreadName = Thread-4 1
ThreadName = Thread-4 2
ThreadName = Thread-4 3
ThreadName = Thread-4 4
ThreadName = Thread-4 5
ThreadName = Thread-1 1
ThreadName = Thread-1 2
ThreadName = Thread-1 3
ThreadName = Thread-1 4
ThreadName = Thread-1 5
ThreadName = Thread-2 1
ThreadName = Thread-2 2
ThreadName = Thread-2 3
ThreadName = Thread-2 4
ThreadName = Thread-2 5
```
备注：一个线程持有锁，则其他线程只能等待；哪一个线程持有锁是随机的，