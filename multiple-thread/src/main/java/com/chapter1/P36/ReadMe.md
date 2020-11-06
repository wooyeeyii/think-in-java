#### description
example in this package: 使用interrupt与return结合，与interrupt和抛异常效果相同。    
&emsp;&emsp;建议使用"抛异常"法来实现线程的停止，因为catch块中可以对异常的信息进行相关的处理，而且使用异常流能更好、更方便的控制程序的运行流程，
不至于代码中出现很多个return，造成污染。
