package com.jspider.ThreadsDeadlock1;


public class ThreadThree extends Thread
{
	CommonResource cr;
	ThreadThree(CommonResource cr)
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
