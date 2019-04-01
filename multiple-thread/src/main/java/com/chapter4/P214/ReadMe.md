#### description
example in this package:  
&emsp;&emsp; 多对多交替打印
	 
*** 
RunTest.java执行结果：
```
set before await:☆☆
★★★★★
get before await:★★
get before await:★★
get before await:★★
get before await:★★
get before await:★★
☆☆☆☆☆
set before await:☆☆
★★★★★
get before await:★★
☆☆☆☆☆
set before await:☆☆
★★★★★
get before await:★★
☆☆☆☆☆
set before await:☆☆
set before await:☆☆
★★★★★
get before await:★★
☆☆☆☆☆
set before await:☆☆
set before await:☆☆
set before await:☆☆
set before await:☆☆
★★★★★
get before await:★★
get before await:★★
☆☆☆☆☆
set before await:☆☆
set before await:☆☆
```
**现象**
&emsp;&emsp; 可能出现假死，程序运行一会儿停止打印了
**原因**
&emsp;&emsp; 极端的分析，所有线程发出的notify全部都被线程A[0-9]获得，只有最开始的A(假定为A0线程)能执行发出signal,其他线程全部再次进入while循环而await(); 若A0发出的signal再被A类线程获得，则所有线程全部await();程序就假死。可以考虑将signal换为signalAll, 在下面一个实验.先分析一下，使用signalAll不会出现假死，且红黑五角星会交替打印，但set before await:☆☆和get before await:★★还是可能连续打印的。
[实现生产者/消费者模式:多对多交替打印(使用notifyAll)](https://github.com/wooyeeyii/ThinkInJava/tree/master/MultipleThread/src/com/chapter4/P214/notifyAll)



