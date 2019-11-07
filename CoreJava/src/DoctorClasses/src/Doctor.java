
public abstract class Doctor implements Healthcare {
	private String name; 
	private String medicalSchool; 
	private String residency; 
	
	//Doctor(){}
	
	Doctor(String name) {
		this.name = name; 
	}
	
	Doctor(String name, String medicalSchool) {
		this.name = name; 
		this.medicalSchool = medicalSchool;
	}
	
	Doctor(String name, String medicalSchool, String residency) {
		this.name = name; 
		this.medicalSchool = medicalSchool; 
		this.residency = residency; 
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	public String getName() {
		return this.name; 
	}
	
	public void setMedicalSchool(String medicalSchool) {
		this.medicalSchool = medicalSchool; 
	}
	public String getMedicalSchool() {
		return this.medicalSchool; 
	}
	
	public void setResidency(String residency) {
		this.residency = residency; 
	}
	public String getResidency() {
		return this.residency;
	}
	
	@Override
	public void answerQuestion(String question) {
		System.out.println("Answering question.")
	}

	
	@Override
	public String toString() {
		return "This is Dr. " + this.name; 
	}
	
	public abstract void comfortPatient(); 
}
