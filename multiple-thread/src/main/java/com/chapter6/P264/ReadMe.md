#### description
example in this package:  
&emsp;&emsp;延迟加载/"懒汉模式"是在调用get()方法时实例才被创建，常见的实现办法就是在get()方法中进行new实例化。

*** 
RunTest.java执行结果：
```
1797317857
```
**说明**
&emsp;&emsp; 此实现虽然取得了一个对象的实例，但如果是在多线程的环境中，就可能会出现取出多个实例的情况，与单例模式的初衷是相违背的。
***