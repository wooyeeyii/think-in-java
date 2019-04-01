#### description
example in this package:  
&emsp;&emsp; 前面的"延迟加载"示例中的代码完全就是错误的，不能保持单例，在本实验中证明。

*** 
RunTest.java执行结果：
```
305404630
1311878651
2003228057
```
**说明**
&emsp;&emsp; 控制台打印的hashCode并非同一个值，说明对象并不是同一个。这就是“错误的单例模式”。
***
**备注**
&emsp;&emsp; 若将MyObject中的myObject = new MyObject()放在sleep前面，则仍只会产生一个对象。分析：线程在休眠之前已经生成对象，所以其他线程执行到这里并不会创建新的对象。