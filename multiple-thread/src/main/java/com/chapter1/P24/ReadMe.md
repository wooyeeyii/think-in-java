#### description
example in this package:  停止线程    
&emsp;&emsp;3中方法：    
- 使用退出标志，使线程正常退出，也就是当run方法完成后线程终止
- 使用stop方法强行终止线程，不可取
- 使用interrupt方法终端线程    
&emsp;&emsp;本例中调用interrupt方法来停止线程，但它并不会立马停止线程。调用interrupt方法仅仅是在当前线程中打了一个停止的标志，并不是真的停止线程。
&emsp;&emsp;
*** 
RunTest.java执行结果：
```
// ···
i = 499990
i = 499991
i = 499992
i = 499993
i = 499994
i = 499995
i = 499996
i = 499997
i = 499998
i = 499999
```
**分析**    
&emsp;&emsp; thread完全执行完毕。
***



