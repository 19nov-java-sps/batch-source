package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CarServlet extends HttpServlet {
//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws 
//	IOException,ServletException {
//		List<Car> carList= carService.getCars();
//		ObjectMapper om = new ObjectMapper();
//		String carJson = om.writeValueAsString(carList);
		//try with resouces before curly braces autoclosable
//				try(PrintWriter pw=res.getWriter()) {
//					pw.write(carJson);
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//	}
	
//	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws 
//	IOException,ServletException {
//		String newCarJson = req.getReader().readLine();
//		System.out.println(newCarJson);
//		
//		ObjectMapper om= new ObjectMapper();
//		Car c = om.readValue(newCarJson, Car.class);
//		
//		
//		boolean success = carService.addCar(c);
//		if(success) {
//			res.setStatus(201);
//		} else {
//			res.setStatus(400);
//		}
//	}
}
