#### description
example in this package:  
&emsp;&emsp; 方法join()后面的代码提前运行：出现意外
	 
*** 
原因：  
&emsp;&emsp;从RunTest2的结果来看，main end总是先执行，说明RunTest1的main线程中的b.join()会最先抢到b对象锁，执行过程可能如下：
1. b.join(2000)获得b对象锁，释放b对象锁；
2. 线程a获得b对象锁，执行直至结束，释放b对象锁；
3. **线程b与main线程争夺b对象锁**， 若b线程获得锁，则输出结果：
	```
	A run begin.Thread-1, time= 1502951581603
	A run end.  Thread-1, time= 1502951586602
	B run begin.Thread-0, time= 1502951586602
	B run end.  Thread-0, time= 1502951591602
	main continue b.join(2000),main, time= 1502951591602
	```
	若main获得锁,发现时间已过，释放锁，则：
	```
	A run begin.Thread-1, time= 1502951523200
	A run end.  Thread-1, time= 1502951528200
	main continue b.join(2000),main, time= 1502951528200
	B run begin.Thread-0, time= 1502951528200
	B run end.  Thread-0, time= 1502951533200
	```
  
**可能出现的意外情况**
&emsp;&emsp;若主线程优先于线程b获得锁(并释放锁)，则主线程b.join(2000)之后的代码与线程b并行，可能出现下面的执行顺序：
```
A run begin.
A run end.
B run begin.
main continue b.join(2000),main
B run end.
```

备注：
1. 线程的join()方法不是同步方法；
2. 线程的join(long time)是同步方法，在执行前需获得对象锁，并在判断join时间是否超时时也要获得对象锁，这也说明主线程等待的时间不是严格的join声明的参数time。