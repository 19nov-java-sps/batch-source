package com.revature.guitars;

public class VoxPhantom extends VoxGuitar {

	private String model;
	private int price;
	
	public String getModel() {
		return model;
	}

	public void setModel (String model) {
		this.model = model;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice (int price) {
		this.price = price;
	}
	//Implementing the custom exception
	public void voxPhantom (String model, int price) throws voxException {
		if(price < 0) {
			throw new voxException("A guitar Vox Phantom cannot have a negative price.");
	}
		else {
			System.out.println("The price of the Vox is $5683.00");		
			
		}
	}
	
//method overriding (example of 'run-time' polymorphism)	
	public void playGuitar() {
		System.out.println("Playing some amazing VOX sounds now!!!");
	}
		
}

