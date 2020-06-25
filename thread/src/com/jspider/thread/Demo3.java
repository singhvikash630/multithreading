
//using implements of runnable interface

package com.jspider.thread;

class Thread1 extends Thread
{
   public void run()
     {
	   System.out.println("start print 1 to 10");
     for(int i=1;i<=10;i++)
        {
        System.out.println("i:"+i);	
        try {
	        Thread.sleep(1000);
            } 
        catch (InterruptedException e) 
            {
	        e.printStackTrace();
            }
        }
     System.out.println("stop print 1 to 10");
     
    }
}
class Thread2 implements Runnable
    {
    public void run()
       {
        System.out.println("start print 10 to 20");
        for(int j=11;j<=20;j++)
           {
           System.out.println("j:"+j);	
           try {
			   Thread.sleep(1000);
		       } 
           catch (InterruptedException e)
              {
			  e.printStackTrace();
		      }
           }
        System.out.println("stop print 10 to 20");
        
       }
    }
public class Demo3
{
   public static void main(String[] args) 
	 {
	   System.out.println("program starts");
	   Thread1 a1=new Thread1();
	   Thread2 a2=new Thread2();
	   Thread t=new Thread(a2);
	   a1.start();
	   t.start();
	   System.out.println("program ends");
		
	}

}
