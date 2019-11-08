package com.revature.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.revature.shapes.Rectangle;

public class ReflectionDriver {
	
	/*
	 * Reflection allows our application to introspect; can examine classes,
	 * methods, and fields at runtime. This is not something we generally would want 
	 * to do ourselves but is very important for the functionality of debuggers 
	 * and for frameworks.
	 * 
	 */

	public static void main(String[] args) {

		try {
			
			Class<?> c1 = Class.forName("com.revature.shapes.Rectangle");
			System.out.println("Class: "+c1.getName());
			System.out.println("Superclass: "+c1.getSuperclass());
			System.out.println("Superclass of superclass: "+ c1.getSuperclass().getSuperclass());
		
			// get interfaces implemented by our Shape class
			Class<?>[] interfaces = c1.getSuperclass().getInterfaces();
			for(Class<?> inter : interfaces) {
				System.out.println(inter);
			}
			
			// access methods within a class
			System.out.println("methods:");
			Method[] methods = c1.getDeclaredMethods();
			for(Method m : methods) {
				System.out.println(m.toString());
			}
			
			// access fields within a class
			System.out.println("fields:");
			Field[] fields = c1.getDeclaredFields();
			for(Field f: fields) {
				System.out.println(f);
			}
			
			// create an instance of the Rectangle class
			Rectangle rect = (Rectangle) c1.newInstance();
			System.out.println(rect);
			
			// manipulate field value
			Field widthField = c1.getDeclaredField("width");
			widthField.setAccessible(true);
			widthField.set(rect, 20);
			widthField.setAccessible(false);
			System.out.println(rect);
			
			// invoke object methods
			Method setHeightMethod = c1.getDeclaredMethod("setHeight", int.class);
			setHeightMethod.invoke(rect, 15);
			System.out.println(rect);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace(); 
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
