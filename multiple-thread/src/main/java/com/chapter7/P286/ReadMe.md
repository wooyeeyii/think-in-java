#### description
example in this package:    
&emsp;&emsp;可把线程归类到线程组中，线程组中可以有线程对象，也可以包含线程组。作用：有效地对线程或线程组对象进行组织

*** 
RunTest.java执行结果：
```
活动的线程数为：2
ThreadName=Thread-2
ThreadName=Thread-3
线程组的名称为：My Group
ThreadName=Thread-2
ThreadName=Thread-3
ThreadName=Thread-3
ThreadName=Thread-2
ThreadName=Thread-3
ThreadName=Thread-2
ThreadName=Thread-2
ThreadName=Thread-3
...
```
**分析**    
&emsp;&emsp; 如RunTest.java中代码，实际上```Thread bThread = new Thread(group, bThreadTmp);```中bThread和bThreadTmp是两个线程，bThread.start()与bThreadTmp.start()互不影响，可以看到两个线程在同时运行。
***