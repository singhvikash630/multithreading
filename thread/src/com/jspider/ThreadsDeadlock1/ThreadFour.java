package com.jspider.ThreadsDeadlock1;

public class ThreadFour extends Thread
{
	CommonResource cr;
	ThreadFour(CommonResource cr)
	{
		this.cr=cr;
	}
	public void run()
	{
    		cr.resource2();
		
	
    }

}
