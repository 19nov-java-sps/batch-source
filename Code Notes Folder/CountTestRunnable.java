package com.revature.sync;

public class CountTestRunnable implements Runnable {
	
	Counter c = new Counter();
	
	public CountTestRunnable() {
		super();
	}
	
	public CountTestRunnable(Counter c) {//takes in a Counter object and saves it to c.
		super();
		this.c = c;
	}

	@Override
	public void run() {
		for(int i=0; i<5000; i++) {//will call increment method 5000 times.
			c.increment();
		}
	}

}
