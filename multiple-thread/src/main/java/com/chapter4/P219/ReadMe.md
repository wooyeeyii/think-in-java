#### description
example in this package:  
&emsp;&emsp; ͳ��������߳���
	 
*** 
GetHoldCountTest.javaִ�н����
```
serviceMethod1 before get lock again, getHoldCount=1
serviceMethod2 getHoldCount=2
serviceMethod1 after release lock once, getHoldCount=1
```
**˵��**
&emsp;&emsp; ����int getHoldCount() �������ǲ�ѯ**��ǰ�߳�**  **���ִ�����**�ĸ����������ؼ��֣���ǰ�߳�+���ִ����������ͷŵĲ���ͳ�Ʒ�Χ�ڡ�

***
GetQueueLengthTest.javaִ�н��
```
ThreadName=Thread-0 ���뷽����
���߳�����9 �ڵȴ��������
```
**����**
&emsp;&emsp; ����10���̲߳�start,��һ���̻߳������sleep(sleep�����ͷ���)����sleepʱ��ܳ��������߳̾��ڵȴ���

***
GetWaitQueueLengthTest.javaִ�н��
```
��10 ���߳����ڵȴ�condition
```
**˵��**
&emsp;&emsp; getWaitQueueLength(Condition condition) �����������Ƿ��صȴ����������صĸ�������Condition���̼߳���




