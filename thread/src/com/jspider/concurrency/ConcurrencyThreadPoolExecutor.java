package com.jspider.concurrency;

import java.util.concurrent.*;

class Task2 implements Runnable 
{
    private String name;
 
    public Task2(String name) 
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
public class ConcurrencyThreadPoolExecutor {
	public static void main(String[] args) 
    {
        //Use the executor created by the newCachedThreadPool() method 
        //only when you have a reasonable number of threads 
        //or when they have a short duration.
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 0; i <= 5; i++) 
        {
            Task task = new Task("Task " + i);
            System.out.println("A new task has been added : " + task.getName());
            executor.execute(task);
        }
        executor.shutdown();
    }

}
