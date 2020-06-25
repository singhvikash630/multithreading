package com.jspider.concurrency;
import java.util.concurrent.*;
class Task1 implements Runnable 
{
    private String name;
 
    public Task1(String name) 
    {
        this.name = name;
    }
     
    public String getName() {
        return name;
    }
 
   
    public void run() 
    {
        try
        {
            long duration = (long) (Math.random() * 10);
            System.out.println("Doing a task during : " + name);
            TimeUnit.SECONDS.sleep(duration);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
}

public class ConcurrencyFixedSizeThreadPool {
	public static void main(String[] args) 
    {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) 
        {
            Task task = new Task("Task " + i);
            System.out.println("A new task has been added : " + task.getName());
            executor.execute(task);
        }
        System.out.println("Maximum threads inside pool " + executor.getMaximumPoolSize());
        executor.shutdown();
    }
}
