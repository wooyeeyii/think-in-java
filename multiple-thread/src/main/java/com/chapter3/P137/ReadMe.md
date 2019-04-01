#### description    
example in this package:  
&emsp;&emsp; wait和notify的一些细节。
- wait()会立即释放锁，但notify不会释放锁，仅仅是唤醒因调用wait处于阻塞状态的线程，使其进入就绪状态，被唤醒的线程会试图重新获得锁再执行.
- 处于wait状态的线程遇到interrupt会抛出InterruptedException()异常

WaitNotifyTest1的测试结果
```
begin wait time = 1548923848866
begin notify time = 1548923848867
end notify time = 1548923848867
end wait time = 1548923848867
```
	 