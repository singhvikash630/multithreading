package com.jspider.advanceconcurrency;

import java.util.Date;
import java.util.concurrent.*;

class PrintingJob1 implements Runnable
{
   private PrinterQueue printerQueue;
 
   public PrintingJob1(PrinterQueue printerQueue)
   {
      this.printerQueue = printerQueue;
   }
 
   
   public void run()
   {
      System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
      printerQueue.printJob(new Object());
   }
}

class PrinterQueue1
{
   private final Semaphore semaphore;
 
   public PrinterQueue1()
   {
      semaphore = new Semaphore(1);
   }
 
   public void printJob(Object document)
   {
      try
      {
         semaphore.acquire();
          
         Long duration = (long) (Math.random() * 10000);
         System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration / 1000) + " seconds :: Time - " + new Date());
         Thread.sleep(duration);
      } 
      catch (InterruptedException e)
      {
         e.printStackTrace();
      } 
      finally
      {
         System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
          
         semaphore.release();
      }
   }
}
public class ConcurrencyBinarySemaphore {
	public static void main(String[] args)
	   {
	      PrinterQueue printerQueue = new PrinterQueue();
	      Thread thread[] = new Thread[10];
	      for (int i = 0; i < 10; i++)
	      {
	         thread[i] = new Thread(new PrintingJob(printerQueue), "Thread " + i);
	      }
	      for (int i = 0; i < 10; i++)
	      {
	         thread[i].start();
	      }
	   }
}
