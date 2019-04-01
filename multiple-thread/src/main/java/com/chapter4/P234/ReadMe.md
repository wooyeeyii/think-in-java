#### description
example in this package:  
&emsp;&emsp;使用Condition对象可以对线程执行的业务进行排序规划。
	 
*** 
RunTest.java执行结果：
```
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadC 1
ThreadC 2
ThreadC 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadC 1
ThreadC 2
ThreadC 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadC 1
ThreadC 2
ThreadC 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadC 1
ThreadC 2
ThreadC 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadC 1
ThreadC 2
ThreadC 3
//以上就是程序的所有输出，程序结束
```
**分析**
&emsp;&emsp;首先threadA线程执行，输出3次结果，并将标志nextPrintWho设为2，此设置导致A和C相关的线程若得到锁，均会进入await()中，而B线程组中的一个会获得线程，执行输出3次结果，将nextPrintWho设为3，所以，仅有C线程组中的一个线程会获得锁并执行下去.........
&emsp;&emsp;程序没有无线循环，A/B/C均有5个线程，一个线程获得锁，打印完就结束了，循环5次后，ThreadC发出的conditionA.signalAll()已经没有线程持有conditionA的锁了
***