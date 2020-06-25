
//using thread we can do multitasking,we can multiple task at a time

package com.jspider.thread;
public class AThread extends Thread
{
	public void run()
	{
		System.out.println("print 1 to 10");
		for(int i=1;i<=10;i++)
		{
			System.out.println("i:"+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
public static void main(String[] args) throws InterruptedException
	{
		System.out.println("program starts");
		AThread a1=new AThread();
		a1.start();
		System.out.println("print 11 to 20");
		for(int j=11;j<=20;j++)
		{
			System.out.println("j:"+j);
			Thread.sleep(2000);
		}
		System.out.println("program ends");
   }
}
/*
  //will print values in sequential order
  
  package com.jspider.thread;
 public class AThread
{
public static void main(String[] args)
	{
		System.out.println("program starts");
		for(int i=1;i<=10;i++)
		{
			System.out.println("print 1 to 10");
			System.out.println("i:"+i);
		}
		for(int j=11;j<=20;j++)
		{
			System.out.println("print 1 to 10");
			System.out.println("j:"+j);
		}
		
		System.out.println("program ends");
   }
}*/