package com.jspider.thread;

public class Passenger extends Thread
{
	Train tr;
	Passenger(Train trn)
	{
		tr=trn;
	}
	public void run()
	{
		synchronized(tr)
		{
			System.out.println("waiting for train");
			try {
				tr.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("total="+tr.total);
		}
	}

public static void main(String[] args)
{
	Train mytrain=new Train();
	new Passenger(mytrain).start();
	new Passenger(mytrain).start();
	new Passenger(mytrain).start();
	mytrain.start();
}
	
}
