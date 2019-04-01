#### description
example in this package:  
&emsp;&emsp; 序列化与反序列化的单例模式实现：静态内置类可以达到线程安全问题，但如果遇到序列化对象时，使用默认的方式运行得到的结果还是多例的。

*** 
RunTest.java执行结果：
```
865113938
1283928880
```
**说明**
&emsp;&emsp; 序列化和反序列化后不是同一个对象。      
解决办法：在反序列化中使用readResolve()方法， 即将MyObject中注释的protected函数恢复使用，则执行结果如下：
```
865113938
调用了 readResolve 方法! 
865113938
```
**说明**
&emsp;&emsp; 序列化和反序列化后是同一个对象，(why?) 
***
