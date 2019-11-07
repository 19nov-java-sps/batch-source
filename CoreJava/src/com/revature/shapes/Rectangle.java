package com.revature.shapes;

public class Rectangle extends Shape {
private int height;
private int width;

public Rectangle() {
//	super(); // technically we don't need super here, it will automatically be included as the first line of the constructor if we don't
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
public void drow() {
	System.out.println("drawing rectangle");// TODO Auto-generated method stub
	
}

@Override
public int calculateArea() {
	// TODO Auto-generated method stub
	return width*height;
}

@Override
public int calculatePerimiter() {
	// TODO Auto-generated method stub
	return 2*(width*height);
}


}
