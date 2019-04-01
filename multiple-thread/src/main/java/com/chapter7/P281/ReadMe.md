#### description
example in this package:  
- NEW状态：线程实例化后还未执行start()方法时的状态
- RUNNABLE状态：线程进入运行的状态；
- TERMINATED状态：线程被销毁时的状态；
- TIMED_WAITING状态：线程执行了Thread.sleep()方法，呈等待状态；
- BLOCKED状态：线程在等待锁的时候；
- WAITING状态：线程执行了Object.wait()方法后所处的状态；

*** 
RunTest.java执行结果：
```
构造方法中的状态: RUNNABLE
main方法中的状态1：NEW
run 方法中的状态: RUNNABLE
main方法中的状态2：TERMINATED
```
**分析**
&emsp;&emsp; 第一行的runnable是main线程的运行状态；第二行是创建的新线程t的状态；第三行是新线程t正在执行；第四行是线程t执行结束后被销毁的状态
***