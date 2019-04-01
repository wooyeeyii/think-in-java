#### description
example in this package: 守护线程    
&emsp;&emsp; 线程分两种：用户线程和守护(Daemon)线程    
&emsp;&emsp; 守护即线程的作用是为其他线程的运行提供便利服务，当它守护的线程结束时，则守护线程自动销毁。

*** 
RunTest1.java执行结果：
```
i = 1
i = 2
i = 3
i = 4
i = 5
i = 6
我离开了，thread对象也不再打印了，也就是停止了
```
**分析**    
&emsp;&emsp; thread设置为main的守护线程，被守护线程结束了，则守护线程自动销毁。
***




