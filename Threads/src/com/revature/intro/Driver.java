package com.revature.intro;

public class Driver {
	public static void main(String[] args) {
		
		Thread thread = new Thread();
		
		System.out.println("Thread state: " + thread.getState()+ ", is alive? " +thread.isAlive());
//		thread.run();
		thread.start();
		System.out.println("Thread state: " + thread.getState()+ ", is alive? " +thread.isAlive());
	}
}
