#### 钩子函数
tomcat异常退出时, 保证一些关闭处理工作的正常执行
##### 论钩子的作用和工作原理
&emsp;&emsp;```Runtime.getRuntime().addShutdownHook(shutdownHook);```在jvm中增加一个关闭的钩子，当**jvm关闭**的时候，会执行系统中已经设置的所有通过方法addShutdownHook添加的钩子，当系统执行完这些钩子后，jvm才会关闭。所以这些钩子可以在jvm关闭的时候进行内存清理、对象销毁等操作.    
##### 什么是Runtime
&emsp;&emsp;通过Runtime实例，使得应用程序和其运行环境相连接。Runtime是在应用启动期间自动建立，应用程序不能够创建Runtime，但可以通过Runtime.getRuntime()来获得当前应用的Runtime对象引用，通过该引用我们可以获得当前运行环境的相关信息，比如空闲内存、最大内存以及为当前虚拟机添加关闭钩子(addShutdownHook())，执行指定命令(exec())等等. 
##### jvm关闭
jvm的关闭方式有三种：
1. 正常关闭：当最后一个非守护线程结束或者调用了System.exit或者通过其他特定平台的方法关闭(发送SIGINT，SIGTERM信号等);
2. 强制关闭：通过调用Runtime.halt方法或者是在操作系统中直接kill(发送SIGKILL信号)掉JVM进程;
3. 异常关闭：运行中遇到RuntimeException异常等。

##### 关闭钩子(shutdown hooks)
&emsp;&emsp;一些情况下，我们需要在jvm关闭时做一些扫尾清理工作。为此JVM提供了关闭钩子(shutdown hooks)来做这些事情。另外特别注意的是：**如果JVM因异常关闭，那么子线程(Hook本质上也是子线程)将不会停止。但在JVM被强行关闭时，这些线程都会被强行结束**.     
&emsp;&emsp;当应用程序遇到非正常关闭时，我们在应用程序中加的钩子就能起作用了，帮我们进行清理工作，Tomcat就是利用钩子在程序异常退出时正常的让server stop。
