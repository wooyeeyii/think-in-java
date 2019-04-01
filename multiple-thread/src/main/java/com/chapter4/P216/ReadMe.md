#### description
example in this package:  
&emsp;&emsp; 公平锁：线程获得锁的顺序是按照线程加锁的顺序来分配的; 非公平锁：锁的抢占机制，随机获得锁，


#### 思考
**测试环境**
对实验[实现生产者/消费者模式:多对多交替打印](https://github.com/wooyeeyii/ThinkInJava/tree/master/MultipleThread/src/com/chapter4/P214)使用公平锁
**分析**
&emsp;&emsp; 前面出现假死的程序在使用公平锁后不会出现假死，因为线程的启动顺序是get和set轮流执行，所以可以轮流获得锁，
**或者**
&emsp;&emsp;若测试代码不是get和set轮流start(),而是先启动A的所有线程，再启动B的所有线程，则可能出现假死(多测试几次)。
	 
*** 
RunFair.java执行结果：
```
ThreadName=Thread-1 start. 
ThreadName=Thread-8 start. 
ThreadName=Thread-7 start. 
ThreadName=Thread-1 获得锁定.
ThreadName=Thread-4 start. 
ThreadName=Thread-3 start. 
ThreadName=Thread-0 start. 
ThreadName=Thread-5 start. 
ThreadName=Thread-2 start. 
ThreadName=Thread-9 start. 
ThreadName=Thread-8 获得锁定.
ThreadName=Thread-6 start. 
ThreadName=Thread-7 获得锁定.
ThreadName=Thread-4 获得锁定.
ThreadName=Thread-3 获得锁定.
ThreadName=Thread-0 获得锁定.
ThreadName=Thread-5 获得锁定.
ThreadName=Thread-2 获得锁定.
ThreadName=Thread-9 获得锁定.
ThreadName=Thread-6 获得锁定.
```
**分析**
&emsp;&emsp; 公平锁：线程开始执行的顺序就是获得锁的顺序

*** 
RunUnFair.java执行结果：
```
ThreadName=Thread-3start. 
ThreadName=Thread-2start. 
ThreadName=Thread-8start. 
ThreadName=Thread-7start. 
ThreadName=Thread-4start. 
ThreadName=Thread-0start. 
ThreadName=Thread-5start. 
ThreadName=Thread-1start. 
ThreadName=Thread-3 获得锁定.
ThreadName=Thread-7 获得锁定.
ThreadName=Thread-6start. 
ThreadName=Thread-2 获得锁定.
ThreadName=Thread-8 获得锁定.
ThreadName=Thread-4 获得锁定.
ThreadName=Thread-0 获得锁定.
ThreadName=Thread-9start. 
ThreadName=Thread-5 获得锁定.
ThreadName=Thread-1 获得锁定.
ThreadName=Thread-6 获得锁定.
ThreadName=Thread-9 获得锁定.
```
**分析**
&emsp;&emsp; 非公平锁：线程start()的顺序并不代表获得锁的顺序




