#### description
example in this package:  
- currentThread():返回代码段正在被哪个线程调用；
    ```
    //静态方法
    public static native Thread currentThread();
    ```
- isAlive():测试线程是否处于活动状态(已经启动且尚未终止);
&emsp;&emsp;

*** 
RunTest.java执行结果：
```
CountOperation--begin
Thread.currentThread.getName(): main
Thread.currentThread.isAlive(): true
this.getName(): Thread-0
this.isAlive(): false
CountOperation--end

run--begin
Thread.currentThread.getName(): A
Thread.currentThread.isAlive(): true
this.getName(): Thread-0
this.isAlive(): false
run--end
```
**注意**    
&emsp;&emsp;注意Thread.currentThread() 和this的区别。Thread.currentThread()指当前正在执行的线程，而this指针是指当前对象。
**分析**    
&emsp;&emsp; 首先声明一个CountOperation，执行构造函数，主线程构造的，当前执行线程为main；其中，this指当前声明的CountOperation对象，默认名称为Thread-0。 其后，t1线程开始运行，t1线程执行的内容是CountOperation对象的run方法，此时，运行的线程是t1,名称为A， 但this指针仍指向的是CountOperation对象，其默认名称为Thead-0.    
&emsp;&emsp;正在执行的就是当前线程，所以Thread.currentThread.isAlive()输出总为真，而本例中使用CountOperation对象，但其对应的线程一直未开启，所以this.isAlive(): false始终为false。
***
若将上面声明的t1线程去掉，直接执行c线程。    
RunTest2.java执行结果：
```
CountOperation--begin
Thread.currentThread.getName(): main
Thread.currentThread.isAlive(): true
this.getName(): Thread-0
this.isAlive(): false
CountOperation--end

run--begin
Thread.currentThread.getName(): Thread-0
Thread.currentThread.isAlive(): true
this.getName(): Thread-0
this.isAlive(): true
run--end
```
**分析**    
&emsp;&emsp;run中执行的线程的名称不同。    
&emsp;&emsp;this.isAlive(): true, 当前线程为CountOperation，所以为真。


