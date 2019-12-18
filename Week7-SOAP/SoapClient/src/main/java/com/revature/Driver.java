package com.revature;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.models.Musical;
import com.revature.services.MusicalService;

public class Driver {
	
	public static void main(String[] args) {
		
		
		String serviceEndpoint = "http://localhost:8080/SoapService/musicals";
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(MusicalService.class);
		factory.setAddress(serviceEndpoint);
		
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();
		
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		
		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));
		
		MusicalService service = (MusicalService) factory.create();
		List<Musical> musicals = service.getAllMusicals();
		for(Musical m: musicals) {
			System.out.println(m);
		}
		
		Musical musical = new Musical("The Lion King", "Irene Mecchi and Roger Allers", 150);
		service.addMusical(musical);
		System.out.println("-------------------------------");
		
		
		musicals = service.getAllMusicals();
		for(Musical m: musicals) {
			System.out.println(m);
		}
	}
	
	
}
