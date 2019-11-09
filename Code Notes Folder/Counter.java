package com.revature.sync;

public class Counter {
	
	volatile int value;
	
	public synchronized void increment() {//increment will update the value everytime its called so the end result would be 10000
		value++;
	}

}
