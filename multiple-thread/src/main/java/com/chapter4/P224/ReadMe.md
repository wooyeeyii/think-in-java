#### description
example in this package:  
&emsp;&emsp; 
- isFair() �ж��ǲ��ǹ�ƽ����(Ĭ������£� ReentrantLock��ʹ�õ��Ƿǹ�ƽ��)   (�򵥣���������)
	 
*** 
isHeldByCurrentThreadTest.javaִ�н����
```
before lock, isLocked(): false
before lock, ��ǰ�߳��Ƿ񱣳ִ�����, isHeldByCurrentThread()��false
after lock, isLocked(): true
after lock, ��ǰ�߳��Ƿ񱣳ִ�����, isHeldByCurrentThread()��true
```
**˵��**
- isHeldByCurrentThread()��ѯ��ǰ�߳��Ƿ񱣳ִ�������
- isLocked() ��ѯ�������Ƿ��������̱߳��֡�(�������̳߳���lock, ��Ϊtrue; ��û���̳߳���lock, ��Ϊfalse)

***