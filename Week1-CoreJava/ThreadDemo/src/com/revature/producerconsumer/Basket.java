package com.revature.producerconsumer;

public class Basket {
	
	private int contents;
	private boolean isAvailable = false;
	
	/*
	 * CONSUMER
	 *  - if there is something in the basket we
	 *     want to return the contents
	 *  - if there's not something available, 
	 *     we want the consumer to wait for something
	 *     to become available
	 */
	public synchronized int get() {
		while(!isAvailable) {
			try {
				
				System.out.println("\t\t\t"+Thread.currentThread().getName()+ " is waiting");
				wait();
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" got:"+contents);
		isAvailable = false;
		notify();
		return contents;
	}
	
	/*
	 * PRODUCER
	 * - if there is something in the basket,
	 *    the producer would want to wait until 
	 *    the contents have been consumed
	 * - if there isn't anything in the basket,
	 *    we want to put our value into the basket
	 *    (set the value to the contents in the basket)
	 *    
	 */
	public synchronized void put(int value) {
		while(isAvailable) {
			try {
				
				System.out.println("\t\t\t"+Thread.currentThread().getName()+" is waiting");
				wait();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" put: "+value);
		contents = value;
		isAvailable = true;
		notify();
	}

}
