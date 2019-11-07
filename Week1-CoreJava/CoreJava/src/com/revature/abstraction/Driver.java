package com.revature.abstraction;

public class Driver {
	
	public static void main(String[] args) {
		MyConcreteClass c = new MyConcreteClass();
		c.myAbstractMethod();
		c.myConcreteMethod();
		// the above code is fine bc both of those methods are in MyConcreteClass
		// if we declared c as a MyAbstractClass, it would have been fine for the same reason
		// However, if we declared it as a a InterfaceA it would not have compiled.
		// We can declare an object of the type of an implemented interface but we would
		// only have access to the methods defined in that interface (like do something below)
		c.doSomething();
		System.out.println(c);
		
		System.out.println(InterfaceA.MY_INT);
	}

}
