package com.jspider.thread;

import java.util.Scanner;

class Counter extends Thread {
	
	//If below variable is not volatile then it will go to infinite loop
	private volatile boolean counting = true;
	private int count = 1;

	@Override
	public void run() {
		while (counting) {
			System.out.println(count);
			count++;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stopCounting() {
		counting = false;

	}
}

public class VolatileDemo {

	public static void main(String[] args) {
		System.out.println("Program Starts");
		Counter counter = new Counter();
		counter.start();

		Scanner scan = new Scanner(System.in);
		scan.nextLine();

		counter.stopCounting();
		System.out.println("Program Ends ");

	}

}


