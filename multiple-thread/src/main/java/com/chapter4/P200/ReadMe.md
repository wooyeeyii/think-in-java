#### description
example in this package:  
&emsp;&emsp; reentrantLock����ʵ�ֺ�synchronized�ؼ�����ͬ��Ч������������չ������Ҳ����ǿ��ʹ���ϱ�synchronized�������
	 
*** 
����ReentrantLock�����lock()���������������unlock()�����ͷ���, ����RunTest�ж���߳���ͬ���ġ�    
&emsp;&emsp;RunTest.java�����н��
```
ThreadName = Thread-0 1
ThreadName = Thread-0 2
ThreadName = Thread-0 3
ThreadName = Thread-0 4
ThreadName = Thread-0 5
ThreadName = Thread-3 1
ThreadName = Thread-3 2
ThreadName = Thread-3 3
ThreadName = Thread-3 4
ThreadName = Thread-3 5
ThreadName = Thread-4 1
ThreadName = Thread-4 2
ThreadName = Thread-4 3
ThreadName = Thread-4 4
ThreadName = Thread-4 5
ThreadName = Thread-1 1
ThreadName = Thread-1 2
ThreadName = Thread-1 3
ThreadName = Thread-1 4
ThreadName = Thread-1 5
ThreadName = Thread-2 1
ThreadName = Thread-2 2
ThreadName = Thread-2 3
ThreadName = Thread-2 4
ThreadName = Thread-2 5
```
��ע��һ���̳߳��������������߳�ֻ�ܵȴ�����һ���̳߳�����������ģ�