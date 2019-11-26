package com.revature.multithreading;

public class Driver {

	public static void main(String[] args) {

		StringBuilder sbuilder = new StringBuilder();
		StringBuffer sbuffer = new StringBuffer();
		
		Runnable job = new StringTestRunnable(sbuilder, sbuffer);
		
		Thread t1 = new Thread(job);
		Thread t2 = new Thread(job);
		
	
		t1.start();
		t2.start();
		
	try {
		t1.join();
		t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		
		System.out.println("builder result: " + sbuilder);
		System.out.println("buffer result: " + sbuffer);
		
	}

}

