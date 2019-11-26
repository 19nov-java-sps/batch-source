package com.revature.multithreading;

public class MyObject {

	public static void main(String[] args) {

		TestThread t = new TestThread();
		t.start();
		
		System.out.println("Thread state: " + t.getState() + ", is alive? " + t.isAlive());
	}

}
