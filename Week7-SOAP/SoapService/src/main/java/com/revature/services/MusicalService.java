package com.revature.services;

import java.util.List;

import javax.jws.WebService;

import com.revature.models.Musical;

@WebService
public interface MusicalService {
	//Service Endpoint Interface
	
	public List<Musical> getAllMusicals();
	public String addMusical(Musical musical);

}
