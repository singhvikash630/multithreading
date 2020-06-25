package com.jspider.thread;

public class Demo4 {

	public static void main(String[] args)
	{
		Thread name=Thread.currentThread();
		System.out.println(name);
		name.setName("My Thread");
		System.out.println(name);
		
	}

}
