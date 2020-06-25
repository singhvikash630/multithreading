package com.jspider.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TestOne implements Runnable {
	public void run() {
		while (true)
		{
			System.out.println("Executing task one");
			try
			{
				Thread.sleep(1000);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

	}
}

class TestTwo implements Runnable {
	public void run() {
		while (true)
		{
			System.out.println("Executing task two");
			try
			{
				Thread.sleep(1000);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}
public class ConcurrencyExecutors {
	private static ExecutorService executor = null;
	private static volatile Future taskOneResults = null;
	private static volatile Future taskTwoResults = null;
	private static void checkTasks() throws Exception {
		if (taskOneResults == null || taskOneResults.isDone() || taskOneResults.isCancelled())
		{
			taskOneResults = executor.submit(new TestOne());
		}

		if (taskTwoResults == null || taskTwoResults.isDone() || taskTwoResults.isCancelled())
		{
			taskTwoResults = executor.submit(new TestTwo());
		}
	}

	public static void main(String[] args) {
				executor = Executors.newFixedThreadPool(3);
		while (true)
		{
			try
			{
				checkTasks();
				Thread.sleep(1000);
			} catch (Exception e) {
				System.err.println("Caught exception: " + e.getMessage());
			}
		}
	}
}
