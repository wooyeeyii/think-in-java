#### description
example in this package:
- RunTest1.java：定时任务(非守护线程)  
    - scheduld(TimerTask task, Date time): 在指定的日期执行一次某一任务。
- RunTest2.java：定时任务(守护线程)  
- RunTest3.java：定时任务时间早于当前时间
- RunTest4.java：Timer中有多个TimerTask任务以及延时的测试


*** 
RunTest.java执行结果：
```
当前时间为：1504529542114
任务执行了，时间为：1504529552163
```
**说明**
&emsp;&emsp;定时任务，10s后执行了。注意：任务虽然执行完了，但进程还未销毁，why?????????
**分析**
&emsp;&emsp;创建Timer对象时：
```
public Timer() {
		this("Timer-" + serialNumber());
	}
//调用下面的函数
public Timer(String arg0) {
		this.queue = new TaskQueue();
		this.thread = new TimerThread(this.queue);
		this.threadReaper = new Object() {
			protected void finalize() throws Throwable {
				synchronized (Timer.this.queue) {
					Timer.this.thread.newTasksMayBeScheduled = false;
					Timer.this.queue.notify();
				}
			}
		};
		this.thread.setName(arg0);
		this.thread.start();
	}
```
创建一个Timer就是启动一个新的线程，这个线程并不是守护线程，会一直运行。
***
RunTest2.java: 将新建立的Timer改为守护线程。
```
当前时间为：1505391891306
```
**说明**
&emsp;&emsp;Timer变为守护线程，主程序结束则Timer线程也结束，所以，Timer的定时任务并为执行。
***
RunTest3.java：定时任务时间早于当前时间
```
当前时间为：Thu Sep 14 20:40:35 CST 2017
计划时间为：Thu Sep 14 20:40:25 CST 2017
任务执行了，时间为：1505392835534
```
**说明**
&emsp;&emsp;任务会立马执行
***
RunTest4.java：一个Timer中多个定时任务
```
当前时间为：Thu Sep 14 20:44:32 CST 2017
计划时间1为：Thu Sep 14 20:44:42 CST 2017
计划时间2为：Thu Sep 14 20:44:47 CST 2017
任务执行了，时间为：1505393082826, Thu Sep 14 20:44:42 CST 2017
任务执行了，时间为：1505393087842, Thu Sep 14 20:44:47 CST 2017
```
**说明**
&emsp;&emsp;TimerTask是以队列的方式一个一个被顺序地执行，所以，若情面的任务耗费大量时间，则后面的任务可能不会按计划时间执行(参考RunTest5.java)。
***
RunTest5.java
```
当前时间为：Thu Sep 14 20:51:25 CST 2017
计划时间1为：Thu Sep 14 20:51:35 CST 2017
计划时间2为：Thu Sep 14 20:51:40 CST 2017
任务执行了，时间为：1505393495319, Thu Sep 14 20:51:35 CST 2017
任务执行了，时间为：1505393505319, Thu Sep 14 20:51:45 CST 2017
```






