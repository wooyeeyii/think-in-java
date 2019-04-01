#### description
example in this package: yield
&emsp;&emsp;java多线程中，使用yield()方法使当前线程放弃cpu资源，但放弃的时间长短不确定，有可能刚放弃，马上又获得cpu时间片。

*** 
RunTest1.java执行结果：
```
//未使用yield()
run spend time: 2

//使用yield()
run spend time: 10
```
**分析**    
&emsp;&emsp; 使用yield让出时间片，使得程序运行总时长明显增加。
***





