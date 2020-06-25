package com.jspider.threadsdeadlock;

public class ThreadOne extends Thread 
{
	CommonResource cr;
	ThreadOne(CommonResource cr)
	{
		this.cr=cr;
	}
	public void run()
	{
    try {
		cr.resource1();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}
