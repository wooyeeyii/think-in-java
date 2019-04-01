package com.chapter3.P184;

/**
 * 使用join等待线程结束
 * @author junjie.chang
 *
 */
public class ThreadD extends Thread {

	private ThreadB b;
	public ThreadD(ThreadB b) {
		super();
		this.b = b;
	}

	@Override
	public void run() {
		try{
			synchronized(b) {
				b.start();
				b.join();
				System.out.print("ThreadD continue after b.join() ");
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
