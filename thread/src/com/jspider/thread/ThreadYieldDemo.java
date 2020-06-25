package com.jspider.thread;

class Producer extends Thread
{
   public void run()
   {
      for (int i = 0; i < 5; i++)
      {
         System.out.println("I am Producer : Produced Item " + i);
         //Thread.yield();
         try {
 			Thread.sleep(500);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
      }
   }
}

class Consumer extends Thread
{
   public void run()
   {
      for (int i = 0; i < 5; i++)
      {
         System.out.println("I am Consumer : Consumed Item " + i);
         //Thread.yield();
         try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
   }
}

public class ThreadYieldDemo
{
   public static void main(String[] args)
   {
	   Producer producer = new Producer();
	   Consumer consumer = new Consumer();
      
      producer.setPriority(10); //Min Priority
      consumer.setPriority(2); //Max Priority
       
      producer.start();
      consumer.start();
   }
}
