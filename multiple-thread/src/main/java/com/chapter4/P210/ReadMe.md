#### description
example in this package:  
&emsp;&emsp; MustUseMoreCondition_OK
	 
*** 
RunTest.java执行结果：
```
begin awaitA 时间为: 1503491657317, ThreadName=Thread-0
begin awaitB 时间为: 1503491657318, ThreadName=Thread-1
begin awaitB 时间为: 1503491657318, ThreadName=Thread-2
 signalA     时间为：1503491659317, ThreadName=main
 end  awaitA 时间为: 1503491659317, ThreadName=Thread-0
 signalBAll  时间为：1503491661317, ThreadName=main
 end  awaitB 时间为: 1503491661317, ThreadName=Thread-1
 end  awaitB 时间为: 1503491661317, ThreadName=Thread-2
```
**分析**
&emsp;&emsp;同一个Lock下可有多个Condition,线程可以使用不同的Condition进行await,需对应的Condition调用signal进行唤醒(使用signalAll方法可以唤醒调用该Condition进行await的所有线程)
&emsp;&emsp;使用ReentrantLock对象唤醒指定类的线程



