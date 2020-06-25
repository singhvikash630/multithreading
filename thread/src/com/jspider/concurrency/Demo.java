package com.jspider.concurrency;

import java.util.concurrent.*;

public class Demo implements Callable {

	@Override
	public Integer call() throws Exception {
		int result = 0;
		for (int i = 1; i <= 20; i++) {
			result += i;
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newSingleThreadExecutor();
		Demo demo = new Demo();
		Future future = service.submit(demo);
		Integer result = (Integer) future.get();
		System.out.println(result);

	}

}
