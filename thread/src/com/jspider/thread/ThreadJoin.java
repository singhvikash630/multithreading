package com.jspider.thread;
class ThreadA extends Thread {

	public void run() {

		System.out.println(Thread.currentThread().getName() + " is Started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " is Completed");

	}
	
}
class ThreadB extends Thread {

	public void run() {

		System.out.println(Thread.currentThread().getName() + " is Started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " is Completed");

	}
	
}
 class Thread3 extends Thread {

	public void run() {

		System.out.println(Thread.currentThread().getName() + " is Started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " is Completed");

	}
	
}
public class ThreadJoin
{
	public static void main(String args[]) throws InterruptedException {

		System.out.println(Thread.currentThread().getName() + " is Started");
		ThreadA join=new ThreadA();
		join.start();
		join.join();
		ThreadB join1=new ThreadB();
		join1.start();
		join1.join();
		Thread3 join2=new Thread3();
		join2.start();
		join2.join();
		System.out.println(Thread.currentThread().getName() + " is Completed");
	}

}
