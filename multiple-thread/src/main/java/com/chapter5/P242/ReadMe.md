#### description
example in this package:
- RunTest1.java����ʱ����(���ػ��߳�)  
    - scheduld(TimerTask task, Date time): ��ָ��������ִ��һ��ĳһ����
- RunTest2.java����ʱ����(�ػ��߳�)  
- RunTest3.java����ʱ����ʱ�����ڵ�ǰʱ��
- RunTest4.java��Timer���ж��TimerTask�����Լ���ʱ�Ĳ���


*** 
RunTest.javaִ�н����
```
��ǰʱ��Ϊ��1504529542114
����ִ���ˣ�ʱ��Ϊ��1504529552163
```
**˵��**
&emsp;&emsp;��ʱ����10s��ִ���ˡ�ע�⣺������Ȼִ�����ˣ������̻�δ���٣�why?????????
**����**
&emsp;&emsp;����Timer����ʱ��
```
public Timer() {
		this("Timer-" + serialNumber());
	}
//��������ĺ���
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
����һ��Timer��������һ���µ��̣߳�����̲߳������ػ��̣߳���һֱ���С�
***
RunTest2.java: ���½�����Timer��Ϊ�ػ��̡߳�
```
��ǰʱ��Ϊ��1505391891306
```
**˵��**
&emsp;&emsp;Timer��Ϊ�ػ��̣߳������������Timer�߳�Ҳ���������ԣ�Timer�Ķ�ʱ����Ϊִ�С�
***
RunTest3.java����ʱ����ʱ�����ڵ�ǰʱ��
```
��ǰʱ��Ϊ��Thu Sep 14 20:40:35 CST 2017
�ƻ�ʱ��Ϊ��Thu Sep 14 20:40:25 CST 2017
����ִ���ˣ�ʱ��Ϊ��1505392835534
```
**˵��**
&emsp;&emsp;���������ִ��
***
RunTest4.java��һ��Timer�ж����ʱ����
```
��ǰʱ��Ϊ��Thu Sep 14 20:44:32 CST 2017
�ƻ�ʱ��1Ϊ��Thu Sep 14 20:44:42 CST 2017
�ƻ�ʱ��2Ϊ��Thu Sep 14 20:44:47 CST 2017
����ִ���ˣ�ʱ��Ϊ��1505393082826, Thu Sep 14 20:44:42 CST 2017
����ִ���ˣ�ʱ��Ϊ��1505393087842, Thu Sep 14 20:44:47 CST 2017
```
**˵��**
&emsp;&emsp;TimerTask���Զ��еķ�ʽһ��һ����˳���ִ�У����ԣ������������ķѴ���ʱ�䣬������������ܲ��ᰴ�ƻ�ʱ��ִ��(�ο�RunTest5.java)��
***
RunTest5.java
```
��ǰʱ��Ϊ��Thu Sep 14 20:51:25 CST 2017
�ƻ�ʱ��1Ϊ��Thu Sep 14 20:51:35 CST 2017
�ƻ�ʱ��2Ϊ��Thu Sep 14 20:51:40 CST 2017
����ִ���ˣ�ʱ��Ϊ��1505393495319, Thu Sep 14 20:51:35 CST 2017
����ִ���ˣ�ʱ��Ϊ��1505393505319, Thu Sep 14 20:51:45 CST 2017
```






