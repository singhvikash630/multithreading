package com.jspider.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSetCAS {
	//What will happen if multiple threads try to update count?
	    /*private volatile int count = 0;
	    public void upateVisitors() 
	    {
	       ++count; //increment the visitors count
	    }*/
	
	//It makes use of locking and that introduces lot of delay and overhead.
	/*private int count = 0;
    public synchronized void upateVisitors() 
    {
       ++count; //increment the visitors count
    }*/
	
	//The classes that support atomic operations
	private AtomicInteger count = new AtomicInteger(0);
    public void upateVisitors() 
    {
       count.incrementAndGet(); //increment the visitors count
    }
    
    //Check the following code in AtomicLong class
    public final long incrementAndGet() {
        for (;;) {
            long current = get();
            long next = current + 1;
            if (compareAndSet(current, next))
              return next;
        }
    }
	public static void main(String[] args) {
		
	}

}
