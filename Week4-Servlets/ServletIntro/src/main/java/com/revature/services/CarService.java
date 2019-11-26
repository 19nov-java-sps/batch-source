package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Car;

public class CarService {
	
	private List<Car> cars = new ArrayList<>();
	
	
	public CarService() {
		cars.add(new Car(304, "Ford", "Mustang", 2017));
		cars.add(new Car(308, "Toyota", "Supra", 2019));
		cars.add(new Car(314, "Tesla", "Cyber Truck", 2018));
	}

	
	public List<Car> getCars(){
		return new ArrayList<Car>(cars);
	}
	
	public boolean addCar(Car c) {
		return cars.add(c);
	}
	
	
}
