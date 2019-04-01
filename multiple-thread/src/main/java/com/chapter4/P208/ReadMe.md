#### description
example in this package:  
&emsp;&emsp; MustUseMoreCondition_Error
	 
*** 
RunTest.java执行结果：
```
begin awaitA 时间为: 1503490678067, ThreadName=Thread-0
begin awaitB 时间为: 1503490678067, ThreadName=Thread-1
 signalAll   时间为：1503490680067, ThreadName=main
 end  awaitA 时间为: 1503490680067, ThreadName=Thread-0
 end  awaitB 时间为: 1503490680067, ThreadName=Thread-1
```
&emsp;&emsp;这个程序没什么不对，想要通知所有只有lock锁并且处于await状态的就使用signalAll, 如何实现通知个别特定的线程，查看下面一个项目。



