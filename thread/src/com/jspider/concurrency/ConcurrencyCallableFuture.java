package com.jspider.concurrency;

import java.util.*;
import java.util.concurrent.*;

class FactorialCalculator implements Callable<Integer>
{
 
    private Integer number;
 
    public FactorialCalculator(Integer number) {
        this.number = number;
    }
 
    
    public Integer call() throws Exception {
        int result = 1;
        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }
        System.out.println("Result for number - " + number + " -> " + result);
        return result;
    }
}
public class ConcurrencyCallableFuture {
	public static void main(String[] args) 
    {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
         
        List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
         
        Random random = new Random();
         
        for (int i=0; i<4; i++)
        {
            Integer number = random.nextInt(10);
            FactorialCalculator calculator  = new FactorialCalculator(number);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }
         
        for(Future<Integer> future : resultList)
        {
              try
              {
                  System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
              } 
              catch (Exception e) 
              {
                  e.printStackTrace();
              }
          }
          //shut down the executor service now
          executor.shutdown();
    }
}
