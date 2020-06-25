package com.jspider.thread;

class ThreadOne extends Thread {
	String name;

	ThreadOne(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		if(name=="Thread2"){
		System.out.println(name+"doing pause"); 
    	Thread.yield();
    	System.out.println(name+"exit pause");
		}
		System.out.println(name+"doing task");
		for(int i=1;i<=5;i++){
		System.out.println("i:"+i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		}
	}
public class ThreadYield {

	public static void main(String[] args) {
		System.out.println("program starts");
		ThreadOne th1 = new ThreadOne("Thread1");
		ThreadOne th2 = new ThreadOne("Thread2");
		ThreadOne th3 = new ThreadOne("Thread3");
		th1.start();
		th2.start();
		th3.start();
		System.out.println("program ends");

	}

}
