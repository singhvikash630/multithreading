package com.jspider.thread;

public class Demo extends Thread
{
public void run() 
{
System.out.println("thread class");	
for(int i=1;i<10;i++){
	System.out.println(i);
	try {
		sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
	public static void main(String[] args)
	{
		Thread d1=new Demo();
		Thread d2=new Demo();
		//d1.run();
		//d2.run();
		
		d1.start();
		d2.start();
		
		
	}

}
