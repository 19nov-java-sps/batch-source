package com.revature.abstraction;

public interface InterfaceA {
	
	int myInt= 6; //implicitly public static final
	
	void doSomething(); //implicitly abstract
	
	default void doSomethingElse(){
		System.out.println("InterfaceA is doing something else");
	}
	
	
}
