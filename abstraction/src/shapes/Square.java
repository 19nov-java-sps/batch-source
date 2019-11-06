package shapes;

public class Square extends Rectangle {
	
	public Square() {
		super();
	}
	
	public Square(int sideLength) {
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
		return "Square [getHeight()=" + getHeight() + ", getWidth()=" + getWidth() + "]";
	}
	
	
	
}