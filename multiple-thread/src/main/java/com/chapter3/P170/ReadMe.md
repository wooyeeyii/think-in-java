#### description
example in this package:  
&emsp;&emsp;多生产者与多消费者：操作栈
	 
*** 
运行结果
```
push = 1
push 操作中的：Thread-3 线程呈wait装状态. 
pop = 0
pop = anyString = 0.7198866363472117
push = 1
push 操作中的：Thread-1 线程呈wait装状态. 
push 操作中的：Thread-2 线程呈wait装状态. 
pop = 0
pop = anyString = 0.2395502147506443
push = 1
push 操作中的：Thread-3 线程呈wait装状态. 
pop = 0
pop = anyString = 0.7662809809077402
pop 操作中的：Thread-4 线程呈wait装状态. 
pop 操作中的：Thread-6 线程呈wait装状态. 
pop 操作中的：Thread-8 线程呈wait装状态. 
push = 1
push 操作中的：Thread-0 线程呈wait装状态. 
pop = 0
pop = anyString = 0.9828068035912142
pop 操作中的：Thread-6 线程呈wait装状态. 
```
&emsp;&emsp;无异常
