package com.jspider.threadsynchronize;

public class Thread1 extends Thread
{
	CommonResource cr;
	Thread1(CommonResource cr)
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
