#### description
example in this package:  “非安全线程的示例”
&emsp;&emsp;
	 
*** 
RunTest.java执行结果：
```
username = b, password = bb.
username = b, password = aa.
```
**分析**
&emsp;&emsp; a线程开始运行，将a赋值给username，进入休眠，b线程开始运行，执行全过程，输出```username = b, password = bb.```````, a线程休眠结束，此时username为b，a线程赋值"aa"给password， 所以输出```username = b, password = aa.`````.    
**解决方法**
&emsp;&emsp;对LoginServlet的doPost方法使用synchronized关键字。
***


