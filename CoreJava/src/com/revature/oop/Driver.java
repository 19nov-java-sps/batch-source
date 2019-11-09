package com.revature.oop;

public class Driver {

	public static void main(String[] args) {

		OfficeBuilding office1 = new OfficeBuilding(5, 200.52,300.44, 
				"10007", "NY", "New York", "Broadway", "1077", 50450500, 0.2, 25.22);
		OfficeBuilding office2 = new OfficeBuilding();
		office2.setLength (400.12);
		office2.setWidth(450.15);
		office2.setStockNumber(15);
		office2.setInvestment(235245678);
		office2.setRentRatePerSquareFeet(9.45);
		office2.setVacancyRate(0.1);
		
		
		System.out.println(office1.buildAddress());
		System.out.println("Total incestments " + office1.investment + " , " + office2.investment);
		System.out.println("Total area " + office1.totalArea());
		System.out.println("Total rent " + office1.totalRent());	
		System.out.println("Calculated ROI " + office1.ROI());	
		System.out.println("Calculated ofice ROI " + office2.officeROI());	
		

	}

}
