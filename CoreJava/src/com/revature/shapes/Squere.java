package com.revature.shapes;

public class Squere extends Rectangle {

	public Squere() {
		super();
	}
	
	public Squere(int sideLength) {
		super.setHeight(sideLength);
		super.setWidth(sideLength);
	}
	
	public void setHeight(int height) {
		super.setHeight(height);
		super.setWidth(height);
		
	}
	
	public void setWidth(int width) {
		super.setWidth(width);
		super.setHeight(width);
	}
	
	public void draw() {
		System.out.println("drawing square");
	}

	@Override
	public String toString() {
		return "Squere [getHeight()=" + getHeight() + ", getWidth()=" + getWidth() + "]";
	}
	
}
