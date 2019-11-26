package com.revature.sync;

public class Counter {
	
	volatile int value;
	
	public synchronized void increment() {
		value++;
	}

}
