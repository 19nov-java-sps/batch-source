package shapes;

public abstract class Shape implements Drawable, Calculatable {
	
	private int numOfSides;
	
	public Shape() {
		super();
	}
	
	public int getNumOfSides() {
		return numOfSides;
	}
	
	public void setNumOfSides(int numOfSides) {
		this.numOfSides = numOfSides;
	}

}