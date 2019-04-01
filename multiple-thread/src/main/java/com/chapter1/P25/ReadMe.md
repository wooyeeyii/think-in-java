#### description
example in this package: 查看线程是否处于停止状态的方法
- this.interrupted():测试当前线程是否已经中断
    ```
        //静态方法，判断当前线程
        //并且会清除线程的中断状态，即若当前线程中断，调用一次Thread.interrupted()，显示true，之后该线程就并非中断状态了。
        public static boolean interrupted() {
            return currentThread().isInterrupted(true);
        }
        //true：清除标志；false:不清除标志
        private native boolean isInterrupted(boolean ClearInterrupted);
    ```
- this.isInterrupted()：测试线程Thread对象是否已经中断

*** 
RunTest.java执行结果：
```
Thread.interrupted(): false
Thread.interrupted(): false
end!
```
**分析**    
&emsp;&emsp; Thread.interrupted();当前线程的中断状态，而main线程未中断，中断的是thread线程，所以为false。
***
RunTest2.java执行结果：
```
Thread.interrupted(): true
Thread.interrupted(): false
end!
```
**分析**    
&emsp;&emsp; 此例中中断的是当前main线程，所以第一个interrupted()显示为true；而Thread.interrupted()会清除线程的中断标志，所以第二次调用显示false.
***
RunTest3.java执行结果：
```
thread.isAlive():true
thread.interrupted(): true
thread.interrupted(): true
thread.isAlive():true
end!
```
**分析**    
&emsp;&emsp; Thread.interrupted();中断thread线程，且查看thread.isInterrupted()，所以第一个为true，且thread.isInterrupted()不清除中断标志，第二次依旧为true    
**注意**
&emsp;&emsp;RunTest3.java中Thread.sleep(10);这句代码可能会引起问题，本意是让main线程停一会再让thread线程中断，但如果时间把控不好，可能thread线程已执行完毕，结果会输出4个false。
***




