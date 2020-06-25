//using thread we can do multitasking,we can multiple task at a time
package com.jspider.thread;
class BThread extends Thread
{
	public static void yield()
	{
	}
	//public native void join(){}
	@Override
	public void interrupt() {
		// TODO Auto-generated method stub
		super.interrupt();
	}
	public void run()
	{
		System.out.println("print 1 to 10");
		for(int i=1;i<=10;i++)
		{
			System.out.println("i:"+i);
				
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
		}
	}
}
public class Demo1 {

	
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("program starts");
		BThread a1=new BThread();
		a1.start();
		System.out.println("print 11 to 20");
		for(int j=11;j<=20;j++)
		{
			System.out.println("j:"+j);
				Thread.sleep(2000);
			
			
		}
		System.out.println("program ends");

	}

}
