#### description
example in this package:  
&emsp;&emsp; ͳ��������߳�
	 
*** 
hasQueuedThreadTest.javaִ�н����
```
false
true
true
```
**˵��**
- hasQueuedThread(Thread arg0)��ѯ�߳�arg0�Ƿ����ڵȴ���ô�����
- hasQueuedThreads()��ѯ�Ƿ����߳����ڵȴ���ô�����
&emsp;&emsp; �����У���һ���߳�threadA�ȿ��������������ʱ��sleep,��ռ������ˣ�hasQueuedThread(threadA)��false�� ���ڶ����������߳�threadBһֱ�ڵȴ���������hasQueuedThread(threadB)��true�� ���߳��ڵȴ������������hasQueuedThreads()���Ҳ��true.

***
hasWaiters.javaִ�н��
```
��û���߳����ڵȴ�condition�� true �߳����Ƕ��٣� 10
after condition.signal ��û���߳����ڵȴ�condition�� true �߳����Ƕ��٣� 9
```
**˵��**
- hasWaiters(Condition condition) ��ѯ�Ƿ����߳����ڵȴ���������йص�condition����
&emsp;&emsp; ����10���̲߳�start,�ҽ���condition.await()����һ�β�ѯ��10���߳��ڵȴ�������condition.signal()�ͷ�����һ��await(), ����9����





