#### description
example in this package:  
&emsp;&emsp; ��ƽ�����̻߳������˳���ǰ����̼߳�����˳���������; �ǹ�ƽ����������ռ���ƣ�����������


#### ˼��
**���Ի���**
��ʵ��[ʵ��������/������ģʽ:��Զཻ���ӡ](https://github.com/wooyeeyii/ThinkInJava/tree/master/MultipleThread/src/com/chapter4/P214)ʹ�ù�ƽ��
**����**
&emsp;&emsp; ǰ����ּ����ĳ�����ʹ�ù�ƽ���󲻻���ּ�������Ϊ�̵߳�����˳����get��set����ִ�У����Կ��������������
**����**
&emsp;&emsp;�����Դ��벻��get��set����start(),����������A�������̣߳�������B�������̣߳�����ܳ��ּ���(����Լ���)��
	 
*** 
RunFair.javaִ�н����
```
ThreadName=Thread-1 start. 
ThreadName=Thread-8 start. 
ThreadName=Thread-7 start. 
ThreadName=Thread-1 �������.
ThreadName=Thread-4 start. 
ThreadName=Thread-3 start. 
ThreadName=Thread-0 start. 
ThreadName=Thread-5 start. 
ThreadName=Thread-2 start. 
ThreadName=Thread-9 start. 
ThreadName=Thread-8 �������.
ThreadName=Thread-6 start. 
ThreadName=Thread-7 �������.
ThreadName=Thread-4 �������.
ThreadName=Thread-3 �������.
ThreadName=Thread-0 �������.
ThreadName=Thread-5 �������.
ThreadName=Thread-2 �������.
ThreadName=Thread-9 �������.
ThreadName=Thread-6 �������.
```
**����**
&emsp;&emsp; ��ƽ�����߳̿�ʼִ�е�˳����ǻ������˳��

*** 
RunUnFair.javaִ�н����
```
ThreadName=Thread-3start. 
ThreadName=Thread-2start. 
ThreadName=Thread-8start. 
ThreadName=Thread-7start. 
ThreadName=Thread-4start. 
ThreadName=Thread-0start. 
ThreadName=Thread-5start. 
ThreadName=Thread-1start. 
ThreadName=Thread-3 �������.
ThreadName=Thread-7 �������.
ThreadName=Thread-6start. 
ThreadName=Thread-2 �������.
ThreadName=Thread-8 �������.
ThreadName=Thread-4 �������.
ThreadName=Thread-0 �������.
ThreadName=Thread-9start. 
ThreadName=Thread-5 �������.
ThreadName=Thread-1 �������.
ThreadName=Thread-6 �������.
ThreadName=Thread-9 �������.
```
**����**
&emsp;&emsp; �ǹ�ƽ�����߳�start()��˳�򲢲�����������˳��




