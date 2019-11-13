package com.revature.gc;

public class myObject {
	
	static int count;
	
	public void finalized() {
		count++;
		System.out.println(count+" : gc collected");
		
	}
	
	public static void main(String[] args) {
		for(int i = 0; i<100; i++) {
			myObject o = new myObject();
		}
		System.gc();
	}
} 
