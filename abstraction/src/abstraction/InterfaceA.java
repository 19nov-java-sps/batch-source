package abstraction;

public interface InterfaceA 
{
	
	int MY_INT = 6; // implicitly public static final

	void doSomething(); // implicitly abstract
	
	default void doSomethingElse() 
	{
		System.out.println("InterfaceA is doing something else");
	}
	
	
}
