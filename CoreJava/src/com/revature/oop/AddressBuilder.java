package com.revature.oop;

public interface AddressBuilder {
	
	//Here is an abstract method
public String[] buildAddress();

	//Here is a concrete method(default)

public default void printAddress () {
	for (int i=0; i<this.buildAddress().length;i++) {
	System.out.print(this.buildAddress()[i]);
	System.out.print(" ");
	}
	System.out.println("");
	}
}
