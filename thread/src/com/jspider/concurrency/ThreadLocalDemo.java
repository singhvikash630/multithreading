package com.jspider.concurrency;

class MyRunnable implements Runnable {
	private ThreadLocal threadLocal = new ThreadLocal();


	public void run() {
		threadLocal.set(Math.random() * 100);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}

		System.out.println(threadLocal.get());
	}
}

public class ThreadLocalDemo {
	public static void main(String[] args) {
		MyRunnable sharedRunnableInstance = new MyRunnable();

		Thread thread1 = new Thread(sharedRunnableInstance);
		Thread thread2 = new Thread(sharedRunnableInstance);

		thread1.start();
		thread2.start();
	}
}
