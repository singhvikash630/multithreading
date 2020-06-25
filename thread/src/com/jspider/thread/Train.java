package com.jspider.thread;

public class Train extends Thread
{
	int total;
	public void run()
	{
		synchronized(this)
		{
			for(int i=0;i<100;i++)
			{
				total+=i;
				
			}
			notifyAll();
			
		}
	}

}
