package com.chapter4.P224;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void isHeldByCurrentThreadMethod() {
        try {
            System.out.println("before lock, isLocked(): " + lock.isLocked());
            System.out.println("before lock, ��ǰ�߳��Ƿ񱣳ִ�����, isHeldByCurrentThread()��" + lock.isHeldByCurrentThread());
            lock.lock();
            System.out.println("after lock, isLocked(): " + lock.isLocked());
            System.out.println("after lock, ��ǰ�߳��Ƿ񱣳ִ�����, isHeldByCurrentThread()��" + lock.isHeldByCurrentThread());
        } finally {
            lock.unlock();
        }
    }

}
