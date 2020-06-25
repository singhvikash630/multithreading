package com.jspider.threadsdeadlock;

public class ThreadTwo extends Thread
{
	CommonResource cr;
	ThreadTwo(CommonResource cr)
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
