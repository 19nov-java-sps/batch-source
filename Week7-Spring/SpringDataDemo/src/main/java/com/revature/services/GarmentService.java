package com.revature.services;

import java.util.List;

import com.revature.models.Garment;

public interface GarmentService {
	
	public List<Garment> findAllGarments();
	public Garment findGarmentById(int id);
	public Garment addGarment(Garment garment);
	public Garment updateGarment(Garment garment);
	public Garment deleteGarment(Garment garment);
	public List<Garment> findGarmentsByBrand(String brand);
	

}
