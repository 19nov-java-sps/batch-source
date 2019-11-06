package com.revature.vehicles;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Planes Boeing = new Planes();
			Boeing.modeOfTransportation();
			Boeing.myConcreteMethod();
			Boeing.Type();
			Boeing.setPrice("$$");
			System.out.println(Boeing.getPrice());
			
			Boats Yacht = new Boats();
			Yacht.modeOfTransportation();
			Yacht.myConcreteMethod();
			Yacht.Type();
			Yacht.setPrice("$$$");
			System.out.println(Yacht.getPrice());
			
			Cars Honda = new Cars();
			Honda.modeOfTransportation();
			Honda.myConcreteMethod();
			Honda.Type();
			Honda.setPrice("$");
			System.out.println(Honda.getPrice());
	}

}
