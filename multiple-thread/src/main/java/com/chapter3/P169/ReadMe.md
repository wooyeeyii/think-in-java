#### description
example in this package:  
&emsp;&emsp;多生产者与一消费者：操作栈
	 
*** 
运行结果
```
pop = 0
pop = anyString = 0.965355883101087
pop 操作中的：Thread-4 线程呈wait装状态. 
push = 1
push 操作中的：Thread-0 线程呈wait装状态. 
push 操作中的：Thread-3 线程呈wait装状态. 
push 操作中的：Thread-1 线程呈wait装状态. 
push 操作中的：Thread-2 线程呈wait装状态. 
pop = 0
pop = anyString = 0.18790305147364095
pop 操作中的：Thread-4 线程呈wait装状态. 
push = 1
push 操作中的：Thread-2 线程呈wait装状态. 
push 操作中的：Thread-1 线程呈wait装状态. 
push 操作中的：Thread-3 线程呈wait装状态. 
push 操作中的：Thread-0 线程呈wait装状态. 
pop = 0
pop = anyString = 0.09689265291521798
pop 操作中的：Thread-4 线程呈wait装状态. 
push = 1
push 操作中的：Thread-0 线程呈wait装状态. 
push 操作中的：Thread-3 线程呈wait装状态. 
push 操作中的：Thread-1 线程呈wait装状态. 
push 操作中的：Thread-2 线程呈wait装状态. 
```
&emsp;&emsp;无异常
