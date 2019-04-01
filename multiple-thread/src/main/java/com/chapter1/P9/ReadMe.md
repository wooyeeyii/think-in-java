#### description
example in this package:  
&emsp;&emsp;
	 
*** 
RunTest1.java执行结果：
```
thread: A, count = 5
thread: C, count = 5
thread: B, count = 5
thread: C, count = 4
thread: C, count = 3
thread: C, count = 2
thread: C, count = 1
thread: A, count = 4
thread: A, count = 3
thread: A, count = 2
thread: B, count = 4
thread: A, count = 1
thread: B, count = 3
thread: B, count = 2
thread: B, count = 1
```
**分析**
&emsp;&emsp;
***
RunTest2.java执行结果：
```
thread: C, count = 9
thread: D, count = 8
thread: B, count = 9
thread: A, count = 10
thread: B, count = 5
thread: D, count = 6
thread: E, count = 7
thread: C, count = 7
thread: E, count = 1
thread: D, count = 2
thread: B, count = 3
thread: A, count = 4
```
&emsp;&emsp;数据冲突，“非线程安全”问题。

