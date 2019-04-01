#### description
example in this package:  
&emsp;&emsp; 使用ReentrantLock()对象的lock与unlock之间的代码块，执行效果与synchronized关键字一样
	 
*** 
RunTest.java执行结果：
```
mehtodA run begin.A, time= 1503281191467
methodA run end.  A, time= 1503281193467
mehtodA run begin.AA, time= 1503281193467
methodA run end.  AA, time= 1503281195467
mehtodB run begin.B, time= 1503281195467
methodB run end.  B, time= 1503281197467
mehtodB run begin.BB, time= 1503281197467
methodB run end.  BB, time= 1503281199467
```