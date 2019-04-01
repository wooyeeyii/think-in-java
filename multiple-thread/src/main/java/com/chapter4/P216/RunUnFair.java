package com.chapter4.P216;

public class RunUnFair {
	private MyService myService = new MyService(false);

	public static void main(String[] args) {
		final MyService myService = new MyService(true);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("ThreadName=" + Thread.currentThread().getName() + "start. ");
				myService.serviceMethod();
			}
		};

		Thread[] threadArray = new Thread[10];
		for(int i=0; i<10; i++) {
			threadArray[i] = new Thread(runnable);
		}
		//按顺序启动运行
		for(int i=0; i<10; i++) {
			threadArray[i].start();
		}

	}
}
