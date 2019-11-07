
public class Neurosurgeon extends Surgeon { 
	
	public Neurosurgeon(String name) {
		super(name); 
	}
	
	public Neurosurgeon(String name, String medicalSchool) {
		super(name, medicalSchool); 
	}
	
	public Neurosurgeon(String name, String medicalSchool, String residency) {
		super(name, medicalSchool, residency); 
	}
	
	private String specialty = "Neurosurgery";
	
	/*
	 * The overrided methods show polymorphism
	 */
	
	@Override
	public void comfortPatient() {
		// TODO Auto-generated method stub
		System.out.println("It's going to be alright."); 
	}

	@Override 
	public void treatPatient() {
		System.out.println("Perform surgery."); 
	}
	
	@Override 
	public void collectPayment() {
		System.out.println("Copy insurance information.");
	}
	
	@Override 
	public String toString() {
		return "this is the surgeon Dr. " + getName() + " and his specialty is "
				                          + this.specialty; 
	}
}
