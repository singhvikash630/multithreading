package com.jspider.advanceconcurrency;

import java.util.concurrent.CountDownLatch;

public class FoodProcessor implements Runnable {
	private final CountDownLatch latch;
	private final String[] items;

	public FoodProcessor(CountDownLatch latch, String[] items) {
		this.latch = latch;
		this.items = items;
	}

	public void run() {
		for (int i = 0; i < items.length; i++) {
			try {
				System.out.println("Before processing item,vaue of countdownlatch is:" + latch);
				Thread.sleep(10000);
				System.out.println("Item " + items[i] + " is prepared");
				latch.countDown();
				System.out.println("After processing item,vaue of countdownlatch is:" + latch);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
