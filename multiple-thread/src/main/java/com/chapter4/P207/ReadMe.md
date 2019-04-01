#### description
example in this package:  
&emsp;&emsp; UseConditionWaitNotifyOK
	 
*** 
RunTest.java执行结果：
```
await  时间为：1503489908210
signal 时间为：1503489909209
```
**成功**    
```
//对应关系
object(wait) <--> condition(await); 
object(wait(long timeout)) <--> condition(long time, TimeUnit unit); 
object(notify) <--> condition(signal); 
object(notifyAll) <--> condition(signalAll);
```



