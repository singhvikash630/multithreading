package com.jspider.advanceconcurrency;

import java.util.concurrent.CountDownLatch;

public class ConcurrencyCountDownLatch {
	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(args.length);

		try {
			Thread th = new Thread(new FoodProcessor(latch, args));
			th.start();
			System.out.println("Order is received and is being processed");
			latch.await();
			System.out.println("Order is processed successfully and ready to get dispatch");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
