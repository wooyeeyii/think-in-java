#### description
example in this package: 线程的暂停与继续    
&emsp;&emsp;java多线程中，使用suspend()方法暂停线程，使用resume()方法恢复线程

*** 
RunTest1.java执行结果：
```
begin: 
thread a has been suspend forever. 
thread2 start. but can not enter function printString().
because function printString has been locked by thread. And suspend forever. 
```
**分析**    
&emsp;&emsp;当一个线程在调用同步方法时进入暂停状态，并不会释放锁，因此其他线程则只能等待该线程继续并执行完毕后才能继续执行。
***
使用suspend还有一个更容易掉进的“坑”    
RunTest2.java执行结果：
```
main start.
main end.
```
当在MyThread.java类的run方法中加入打印println(), 结果如下：
```
main start.
i = 1

...

i = 119771
i = 119772
i = 119773
i = 119774
//并不会打印main end. 
```
**分析**    
&emsp;&emsp;因为程序运行到println内部时，同步锁未被释放。所以主函数的main end 迟迟不能打印。
```
    public void println(String arg0) {
        synchronized (this) {
            this.print(arg0);
            this.newLine();
        }
    }
```
为什么suspend一定是卡在pringln内部呢？？？？？？？？？？？
***
suspend与resume方法不同步
RunTest3.java执行结果：
```
thread a has been suspend forever. 
username: a, password: 11
```
**分析**    
&emsp;&emsp;赋值操作进行到一半线程暂停，而其他地方使用这些变量就会出错
***




