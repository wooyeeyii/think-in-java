package com.chang.once;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test2 {
	
	public static void main(String[] args) {
		int count = 100;
		Test2 a= new Test2();
		a.testThreadPool(count);
		a.testThread(count);
	}
	
	public void testThreadPool(int count) {
		long startTime = System.currentTimeMillis();
		final List<Integer> l = new LinkedList<Integer>();
		ThreadPoolExecutor  tp = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS,
														new LinkedBlockingQueue<Runnable>(count));	//一个线程的线程池
		final Random random = new Random();
		for(int i=0; i<count; i++) {
			tp.execute(new Runnable() {
				@Override
				public void run() {
					l.add(random.nextInt());
				}
			});
		}
		tp.shutdown();
		try{
			tp.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() - startTime);
		System.out.println(l.size());
	}
	
	public void testThread(int count) {
		long startTime = System.currentTimeMillis();
		final List<Integer> l = new LinkedList<Integer>();
		final Random random = new Random();
		for(int i=0; i<count; i++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					l.add(random.nextInt());
				}
			});
			t.start();
			try{
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(System.currentTimeMillis() - startTime);
		System.out.println(l.size());
	}
	
	
}