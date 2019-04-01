#### description
example in this package:  不推荐，最好不要用stop()停止线程

*** 
RunTest1.java执行结果：
```
stop() 之后进入catch() 方法。
java.lang.ThreadDeath
    at java.lang.Thread.stop(Unknown Source)
    at com.chapter1.P33.MyThread.run(MyThread.java:9)
```
**备注**    
&emsp;&emsp;stop()方法已经废弃，如果强制让线程停止则可能使一些清理性的工作得不到完成。另外一种情况就是对锁定的对象进行了“解锁”，导致数据得不到同步的处理，出现数据的不一致问题。 示例如runTest2.java
***
RunTest2.java执行结果：
```
username:b, password:aa
```
**分析**
&emsp;&emsp;线程对变量的设置进行了一半，就遇到stop()操作被强制退出，所以password仍是“aa”。    
&emsp;&emsp;其实，使用抛异常的方法，若你抛出异常的位置不对的话，也会有数据不一致的情况(将RunTest2.java中printString方法的sleep地方变成抛异常，并在run()最后抓住，则一样会有数据不一致). 但使用过程中，stop()更不可控，而抛异常的方式能更明显的受程序员的控制。





