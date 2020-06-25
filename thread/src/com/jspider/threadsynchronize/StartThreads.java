package com.jspider.threadsynchronize;

class StartThreads {

public static void main(String[] args)
{
	System.out.println("program starts");
	CommonResource cr1=new CommonResource();
	CommonResource cr2=new CommonResource();
	Thread1 t1=new Thread1(cr1);
	Thread2 t2=new Thread2(cr1);
	t2.start();
	t1.start();
	System.out.println("program ends");
		
	}

}
