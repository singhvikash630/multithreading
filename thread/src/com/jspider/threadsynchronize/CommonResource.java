package com.jspider.threadsynchronize;

public class CommonResource
{
	synchronized void resource1() throws InterruptedException
	{
		System.out.println("print 1 to 10");
		for(int i=1;i<=10;i++)
		{
			System.out.println("i:"+i);
			Thread.sleep(1000);
		}
		System.out.println("stop ptint 1 to 10");
	}
   synchronized static void resource2() throws InterruptedException
	{
		System.out.println("print 11 to 20");
		for(int j=11;j<=20;j++)
		{
			System.out.println("j:"+j);
			Thread.sleep(1000);
		}
		System.out.println("stop print 11 to 20");
	}
	}
	


