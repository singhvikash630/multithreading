package com.jspider.ThreadsDeadlock1;
public class ThreadsStart {

	public static void main(String[] args)
	{
		System.out.println("program starts...");
		CommonResource cr1=new CommonResource();
		ThreadOne th1=new ThreadOne(cr1);
		ThreadTwo th2=new ThreadTwo(cr1);
		ThreadThree th3=new ThreadThree(cr1);
		ThreadFour th4=new ThreadFour(cr1);
		
		th1.start();
		
		th2.start();
		th3.start();
		
		th4.start();
		
		//ThreadFour th4=new ThreadFour(cr1);
		
		System.out.println("program ends...");
		
	}

}
