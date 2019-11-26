package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Car;
import com.revature.services.CarService;

public class CarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private CarService carService = new CarService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		List<Car> carList = carService.getCars();
				
		// convert carList to JSON
		ObjectMapper om = new ObjectMapper();
		String carJSON = om.writeValueAsString(carList);
		
		// write our marshalled data to the response body
		try(PrintWriter pw = response.getWriter()){
			pw.write(carJSON);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// get request body from HTTP request
		String newCarJSON = request.getReader().readLine();
		
//		System.out.println(newCarJSON);
		
		// convert JSON from our request body to a java object
		ObjectMapper om = new ObjectMapper();
		Car c = om.readValue(newCarJSON, Car.class);
		
		// invoke my service method to add it to my list of cars
		boolean success = carService.addCar(c);
		if(success) {
			response.setStatus(201);
		} else {
			response.sendError(400);
		}
		
	}

}
