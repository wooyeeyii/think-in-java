#### description
example in this package:  println()方法与i++联合使用“有可能”出现的另一种异常情况。    
println()方法在内部是同步的，但i--操作却是在进去println()之前发生的，所以有可能发生非线程安全的问题。
```
    //println()方法
    public void println(String arg0) {
        synchronized (this) {
            this.print(arg0);
            this.newLine();
        }
    }
```
&emsp;&emsp;
	 
*** 
RunTest.java执行结果：
```
i = 5, threadName = Thread-4
i = 3, threadName = Thread-1
i = 5, threadName = Thread-3
i = 4, threadName = Thread-2
i = 2, threadName = Thread-5
```
**分析**     
&emsp;&emsp; 上面分析过了，i--的操作在进入println()之前发生，可能出现非线程安全问题.    
**解决方法**    
&emsp;&emsp;对MyThread的run方法使用synchronized关键字。
***


