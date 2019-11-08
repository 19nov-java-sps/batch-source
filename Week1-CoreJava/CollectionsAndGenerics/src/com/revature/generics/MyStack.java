package com.revature.generics;

import java.util.Vector;

// the E we use here will be used elsewhere in the class
// when you instantiate an instance of MyStack the type you include
// in the angle brackets will take the place of E everywhere in this class
public class MyStack<E> extends Vector<E> {

	private static final long serialVersionUID = 1L;
	
	/*
	 *  determines if the stack is empty
	 */
	public boolean empty() {
		return elementCount==0;
	}
	
	/*
	 * Looks at the object at the top of the stack 
	 * without removing it from the stack.
	 */
	public E peek() {
		return lastElement();
	}

	/*
	 * Removes the object from the top of the stack
	 * and returns that object.
	 */
	public E pop() {
		return remove(elementCount-1);
	}

	/*
	 * Adds an item to the top of the stack.
	 */
	public E push(E item) {
		add(item);
		return item;
	}
	
	/*
	 * Returns 1-based position indicating where the 
	 * object is on the stack. The topmost object is 
	 * considered to be at distance 1. If the item is 
	 * not found in the stack the method should return -1.
	 */
	public int search(Object o) {
		int index = indexOf(o);
		if(index==-1) {
			return -1;
		}
		return elementCount - index;
	}
	
	public static void main(String[] args) {
		
//		MyStack stack1 = new MyStack();
//		stack1.add(5);
//		String str = (String) stack1.pop();
		
		
		MyStack<String> stack = new MyStack<>();
		System.out.println(stack.isEmpty());
		stack.push("red");
		stack.push("orange");
		stack.push("yellow");
		System.out.println(stack);
		System.out.println(stack.isEmpty());
		String element = stack.pop();
		System.out.println(element);
		System.out.println(stack);

	}
}
