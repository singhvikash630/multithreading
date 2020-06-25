package com.jspider.concurrency;

import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.ScheduledExecutorService;

class Task implements Runnable
{
    private String name; 
    public Task(String name) {
        this.name = name;
    }     
    public String getName() {
        return name;
    }   
    public void run() 
    {
        try {
            System.out.println("Doing a task during : " + name + " - Time - " + new Date());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public class ConcurrencyScheduledExecutorService {
	  //Execute a task after a period of time with schedule() meyhod
/*public static void main(String[] args) {
	ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
    Task task1 = new Task ("Demo Task 1");
    Task task2 = new Task ("Demo Task 2");
     
    System.out.println("The time is : " + new Date());
   
    executor.schedule(task1, 5 , TimeUnit.SECONDS);
    executor.schedule(task2, 10 , TimeUnit.SECONDS);
     
    try {
          executor.awaitTermination(1, TimeUnit.DAYS);
    } catch (InterruptedException e) {
          e.printStackTrace();
    }
     
    executor.shutdown();
}*/
	//Execute a task periodically with scheduleAtFixedRate() method
	public static void main(String[] args) 
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Task task1 = new Task ("Demo Task 1");
         
        System.out.println("The time is : " + new Date());
         
        ScheduledFuture result = executor.scheduleAtFixedRate(task1, 2, 5, TimeUnit.SECONDS);
         
        try {
            TimeUnit.MILLISECONDS.sleep(20000);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        executor.shutdown();
    }
}
