package com.revature;

import org.springframework.web.client.RestTemplate;

import com.revature.models.Garment;
import com.revature.models.GarmentType;
import com.revature.models.Size;

public class Driver {
	
	public static void main(String[] args) {
		
		String url = "http://localhost:8082/garments/2";
		
		RestTemplate restTemplate = new RestTemplate();
		
		Garment g = restTemplate.getForObject(url, Garment.class);
		System.out.println(g);
	
		
//		String postUrl = "http://localhost:8082/garments";
//		Garment newGarment = new Garment(9,Size.XL,"Banana Republic",GarmentType.JACKET,"Gray");
//		restTemplate.postForObject(postUrl, newGarment, Garment.class);
		
	}

}
