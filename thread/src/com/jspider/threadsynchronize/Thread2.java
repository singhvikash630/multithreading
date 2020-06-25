package com.jspider.threadsynchronize;

public class Thread2 extends Thread
{
	CommonResource cr;
	Thread2(CommonResource cr)
	{
		this.cr=cr;
	}
	public void run()
        {
    		try {
				cr.resource2();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}

