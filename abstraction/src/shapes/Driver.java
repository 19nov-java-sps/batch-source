package shapes;

public class Driver {
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(4,7);
		System.out.println(r);
		r.draw();
		
		Square s = new Square(5);
		System.out.println(s.toString());
		s.draw();
		
		
		// the results of the toString and draw methods are the same because of virtual method invocation
			// the most specific implementation will be invoked
		Rectangle s2 = new Square(5);
		System.out.println(s2.toString());
		s2.draw();
		System.out.println(s2.calculateArea());
		
		
	}

}
