package com.jspider.threadsdeadlock;

public class CommonResource
{
	synchronized public void resource1() throws InterruptedException
	{
	System.out.println("entering into resource1()");
	for(int i=1;i<=10;i++)
	{
		System.out.println("i:"+i);
		Thread.sleep(500);
		
	}
	System.out.println("existing into resource1()");	
	
	}
	synchronized static public void resource2() throws InterruptedException
	{
		System.out.println("entering into resource2()");
		for(int j=1;j<=10;j++)
		{
			System.out.println("j:"+j);
			Thread.sleep(500);
			
		}
		System.out.println("existing into resource2()");	
		
		
	}

}
