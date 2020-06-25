package com.jspider.advanceconcurrency;

import java.util.Date;
import java.util.concurrent.locks.*;

class PrintingJob2 implements Runnable
{
   private PrinterQueue2 printerQueue;
 
   public PrintingJob2(PrinterQueue2 printerQueue)
   {
      this.printerQueue = printerQueue;
   } 
   
   public void run()
   {
      System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
      printerQueue.printJob(new Object());
   }
}

class PrinterQueue2
{
   private final Lock queueLock = new ReentrantLock();
 
   public void printJob(Object document)
   {
      queueLock.lock();
      try
      {
         Long duration = (long) (Math.random() * 10000);
         System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration / 1000) + " seconds :: Time - " + new Date());
         Thread.sleep(duration);
      } catch (InterruptedException e)
      {
         e.printStackTrace();
      } finally
      {
         System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
         queueLock.unlock();
      }
   }
}
public class ConcurrencyLock {
	public static void main(String[] args)
	   {
	      PrinterQueue2 printerQueue = new PrinterQueue2();
	      Thread thread[] = new Thread[2];
	      for (int i = 0; i < 2; i++)
	      {
	         thread[i] = new Thread(new PrintingJob2(printerQueue), "Thread " + i);
	      }
	      for (int i = 0; i < 2; i++)
	      {
	         thread[i].start();
	      }
	   }
}
