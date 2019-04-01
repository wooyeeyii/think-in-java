#### description
example in this package:  用异常法停止线程

*** 
RunTest1.java执行结果：
```
thread.isAlive():true
已经是停止状态了！即将退出!
last statement in MyThread.run()
```
**分析**    
&emsp;&emsp; 在run的每次循环执行过程中，先判断其线程的中断标志，若未中断，继续执行，若中断，则从循环中跳出。但循环外的代码仍会继续执行。若不想让后续代码执行，在RunTest2中实现。
***
RunTest2.java执行结果：
```
thread.isAlive():true
已经是停止状态了！即将退出!
进入MyThread.run()方法中的catch. 
java.lang.InterruptedException
    at com.chapter1.P28.MyThread2.run(MyThread2.java:12)
```
**分析**    
&emsp;&emsp; 在MyThread.java的基础上，若中断，并非break，而是throw new InterruptedException();并在run()方法的最后直接捕捉这个异常。这样就能让抛出异常地方之后的代码都不执行。
***
RunTest3.java执行结果：
```

```
**分析**    
&emsp;&emsp; 
***




