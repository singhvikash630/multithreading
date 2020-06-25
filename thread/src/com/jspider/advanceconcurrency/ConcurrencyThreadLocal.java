package com.jspider.advanceconcurrency;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class DemoTask implements Runnable {
	// Atomic integer containing the next thread ID to be assigned
	private static final AtomicInteger nextId = new AtomicInteger(0);

	// Thread local variable containing each thread's ID
	private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return nextId.getAndIncrement();
		}
	};

	// Returns the current thread's unique ID, assigning it if necessary
	public int getThreadId() {
		return threadId.get();
	}

	// Returns the current thread's starting timestamp
	private static final ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
		protected Date initialValue() {
			return new Date();
		}
	};

	public void run() {
		System.out.printf("Starting Thread: %s : %s\n", getThreadId(), startDate.get());
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s : %s\n", getThreadId(), startDate.get());
	}
}

public class ConcurrencyThreadLocal {
	public static void main(String[] args) {
		DemoTask task = new DemoTask();
		Thread thread;
		System.out.printf("Starting the Threads\n\n");
		for (int i = 1; i <= 2; i++) {
			thread = new Thread(task);
			thread.start();
		}
		System.out.printf("All Threads are created now\n\n");

	}
}
