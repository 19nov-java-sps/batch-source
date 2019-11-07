package types;

import java.util.ArrayList;
import java.util.List;

public class Autoboxing {
	
	public static void main(String[] args) {
		
		// boxing - we explicitly "box" the primitive in an object
		int num1 = 5;
		Integer num2 = new Integer(num1);
		
		// unboxing - explicitly converting Integer to primitive int
		Integer num3 = new Integer(8);
		int num4 = num3.intValue();
		
		// autoboxing - primitive implicitly converted to an object
		int num5 = 6;
		Integer num6 = num5;
		
		// autounboxing - object value implicitly converted to a primitive
		Integer num7 = new Integer(25);
		int num8 = num7;
		
		// autoboxing/unboxing will occur for us when we need objects and have a primitive and vice versa (e.g. collections)
		List<Integer> myList = new ArrayList<>();
		Integer myInteger = new Integer(5);
		myList.add(myInteger);
		myList.add(28);
	}
	
	

}