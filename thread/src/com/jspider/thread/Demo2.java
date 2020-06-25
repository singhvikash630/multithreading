package com.jspider.thread;

class CThread extends Thread
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
     }
class DThread extends Thread
   {
   public void run()
       {
         System.out.println("print 11 to 20");
         for(int j=11;j<=20;j++)
            {
            System.out.println("j:"+j);	
            try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
         }
  }
public class Demo2
{
public static void main(String[] args) throws InterruptedException
   {
	System.out.println("program starts");
	CThread c1=new CThread();
	DThread d1=new DThread();
	c1.start();
	d1.start();
	System.out.println("print 21 to 30");
	for(int k=21;k<=30;k++)
	{
		System.out.println("k:"+k);
		Thread.sleep(2000);
	}
	System.out.println("program ends");

	}
}
