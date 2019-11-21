package com.revature.intro;

public class Driver {

	public static void main(String[] args) {

		
		
		Thread t = new TestThread();
		System.out.println("Thread state: "+ t.getState()+", is alive? "+t.isAlive());
		
//		t.run();
		t.start();
		
		System.out.println("Thread state: "+ t.getState()+", is alive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+", is alive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+", is alive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+", is alive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+", is alive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+", is alive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+", is alive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+", is alive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+", is alive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+", is alive? "+t.isAlive());
		System.out.println("Thread state: "+ t.getState()+", is alive? "+t.isAlive());

		
	}

}
