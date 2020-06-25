package com.jspider.advanceconcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ConcurrentSemaphore {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3);
		ExecutorService service = Executors.newFixedThreadPool(50);
		service.execute(new Task(semaphore));
		service.shutdown();
	}
}

class Task implements Runnable {
	Semaphore semaphore;

	public Task(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void run() {
		try {
			semaphore.acquire();
			//semaphore.acquireUninterruptibly();
			// IO call to the slow service
			semaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
