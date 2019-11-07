package com.revature.abstraction;

public class MyConcreteClass extends MyAbstractClass implements InterfaceA, InterfaceB{

	public void myAbstractMethod() {
		System.out.println("not so abstract anymore");
	}
	
	public void doSomething() {
		System.out.println("doing something");
	}
	
	public void doSomethingElse() {
		InterfaceA.super.doSomethingElse();
	}
}
