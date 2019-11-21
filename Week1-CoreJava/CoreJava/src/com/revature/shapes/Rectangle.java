package com.revature.shapes;

public class Rectangle extends Shape {
	
	private int height;
	private int width;
	
	public Rectangle() {
//		super(); // technically we don't need super here, it will automatically be included as the first line of the constructor if we don't
		setNumOfSides(4);
	}
	
	// constructor overloading
	public Rectangle(int height, int width) {
		this(); // allows us to reuse the "setNumOfSides" code on line 10
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width + "]";
	}

	@Override
	public void draw() {
		System.out.println("drawing rectangle");
		
	}

	@Override
	public int calculateArea() {
		return width*height;
	}

	@Override
	public int calculatePerimeter() {
		return 2*(width+height);
	}
	
	
	

}
