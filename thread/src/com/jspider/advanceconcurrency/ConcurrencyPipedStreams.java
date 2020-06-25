package com.jspider.advanceconcurrency;

import java.io.*;

class PipeWriterThread implements Runnable {
	PipedWriter pw;
	String name = null;

	public PipeWriterThread(String name, PipedWriter pw) {
		this.name = name;
		this.pw = pw;
	}

	public void run() {
		try {
			while (true) {
				// Write some data after every two seconds
				pw.write("Testing data written...n");
				pw.flush();
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			System.out.println(" PipeThread Exception: " + e);
		}
	}
}

class PipeReaderThread implements Runnable {
	PipedReader pr;
	String name = null;

	public PipeReaderThread(String name, PipedReader pr) {
		this.name = name;
		this.pr = pr;
	}

	public void run() {
		try {
			// continuously read data from stream and print it in console
			while (true) {
				char c = (char) pr.read(); // read a char
				if (c != -1) { // check for -1 indicating end of file
					System.out.print(c);
				}
			}
		} catch (Exception e) {
			System.out.println(" PipeThread Exception: " + e);
		}
	}


}
public class ConcurrencyPipedStreams {
	public ConcurrencyPipedStreams() {
	    try {
	        // Create writer and reader instances
	        PipedReader pr = new PipedReader();
	        PipedWriter pw = new PipedWriter();
	        // Connect the writer with reader
	        pw.connect(pr);
	        // Create one writer thread and one reader thread
	        Thread thread1 = new Thread(
	                new PipeReaderThread("ReaderThread", pr));
	        Thread thread2 = new Thread(
	                new PipeWriterThread("WriterThread", pw));
	        // start both threads
	        thread1.start();
	        thread2.start();
	    } catch (Exception e) {
	        System.out.println("PipeThread Exception: " + e);
	    }
	}
	public static void main(String[] args) {
	    new ConcurrencyPipedStreams();
	}
	 
	}
