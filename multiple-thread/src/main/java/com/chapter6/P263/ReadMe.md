#### description
example in this package:  
&emsp;&emsp;立即加载/"饿汉模式"是在调用方法前，实例已经被创建了。

*** 
RunTest.java执行结果：
```
305404630
305404630
305404630
```
**说明**
&emsp;&emsp; 控制台打印的hashCode是同一个值，说明对象是同一个，也就实现了立即加载型单例设计模式。
***