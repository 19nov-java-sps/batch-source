package com.revature.oopExercise;

public class Driver {
	public static void main(String[] args) throws Exception {
 		// TODO Auto-generated method stub
 			Planes Boeing = new Planes();
 			Boeing.modeOfTransportation();
 			Boeing.myConcreteMethod();
 			Boeing.Type();
 			Boeing.setPrice("$$");
 			System.out.println(Boeing.getPrice());
 			Boeing.setHowManyDoIOwn(1);
 			System.out.println(Boeing.getHowManyDoIOwn());
 			
 			
 			System.out.println("---------------");

 			Boats Yacht = new Boats();
 			Yacht.modeOfTransportation();
 			Yacht.myConcreteMethod();
 			Yacht.Type();
 			Yacht.setPrice("$$$");
 			System.out.println(Yacht.getPrice());
 			Yacht.setHowManyDoIOwn(0);
 			System.out.println(Yacht.getHowManyDoIOwn());
 			
 			System.out.println("---------------");

 			Cars Honda = new Cars();
 			Honda.modeOfTransportation();
 			Honda.myConcreteMethod();
 			Honda.Type();
 			Honda.setPrice("$");
 			System.out.println(Honda.getPrice());
 			Honda.setHowManyDoIOwn(1);
 			System.out.println(Honda.getHowManyDoIOwn());
 			
 			System.out.println("---------------");
 			
 			Planes privateJet= new Planes();
 			privateJet.modeOfTransportation();
 			privateJet.myConcreteMethod();
 			privateJet.setPrice("$$$$$$");
 			System.out.println(privateJet.getPrice());
 			privateJet.setHowManyDoIOwn(-1);
 			System.out.println(privateJet.getHowManyDoIOwn());
 			
 			
 	}
}
