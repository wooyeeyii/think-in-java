#### description
example in this package:  
&emsp;&emsp;ʹ��Condition������Զ��߳�ִ�е�ҵ���������滮��
	 
*** 
RunTest.javaִ�н����
```
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadC 1
ThreadC 2
ThreadC 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadC 1
ThreadC 2
ThreadC 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadC 1
ThreadC 2
ThreadC 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadC 1
ThreadC 2
ThreadC 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadC 1
ThreadC 2
ThreadC 3
//���Ͼ��ǳ��������������������
```
**����**
&emsp;&emsp;����threadA�߳�ִ�У����3�ν����������־nextPrintWho��Ϊ2�������õ���A��C��ص��߳����õ������������await()�У���B�߳����е�һ�������̣߳�ִ�����3�ν������nextPrintWho��Ϊ3�����ԣ�����C�߳����е�һ���̻߳�������ִ����ȥ.........
&emsp;&emsp;����û������ѭ����A/B/C����5���̣߳�һ���̻߳��������ӡ��ͽ����ˣ�ѭ��5�κ�ThreadC������conditionA.signalAll()�Ѿ�û���̳߳���conditionA������
***