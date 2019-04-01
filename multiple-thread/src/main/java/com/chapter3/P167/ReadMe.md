#### description
example in this package:  
&emsp;&emsp;一生产与多消费者：操作栈 （解决wait条件改变与假死）
	 
*** 
异常说明：
	consumer的notify() 也会唤醒其他的consumer(他们使用的是同一个对象锁)。
	而此时if条件其实不满足，但依旧会执行读数据，就超界了
	
思考：
	synchronized具有原子性吗，synchronized代码块的执行过程中会被打断吗？
	有原子性，不会被中断。