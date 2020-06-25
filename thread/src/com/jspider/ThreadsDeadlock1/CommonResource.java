package com.jspider.ThreadsDeadlock1;

public class CommonResource
{
	synchronized void resource1() throws InterruptedException
	{
		String name=Thread.currentThread().getName();
		System.out.println(name+"entering resource1()...");
		wait();
		System.out.println(name+"return from wait");
		for(int i=1;i<=10;i++)
		{
			System.out.println("i:"+i);
			Thread.sleep(500);
		}
		System.out.println(name+"existing resource1()...");
	}
	synchronized void resource2()
	{
		String name=Thread.currentThread().getName();
		System.out.println(name+"entering resource2()...");
		notifyAll();
		System.out.println(name+"existing resource2()...");
	}

}
