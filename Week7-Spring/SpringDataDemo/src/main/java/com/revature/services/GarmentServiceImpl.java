package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Garment;
import com.revature.repositories.GarmentRepository;

@Service
public class GarmentServiceImpl implements GarmentService {
	
	//autowire repository
	@Autowired
	private GarmentRepository garmentRepo;

	@Override
	public List<Garment> findAllGarments() {
		return garmentRepo.findAll();
	}

	@Override
	public Garment findGarmentById(int id) {
		return garmentRepo.getOne(id);
	}

	@Override
	public Garment addGarment(Garment garment) {
		return garmentRepo.save(garment);
	}

	@Override
	public Garment updateGarment(Garment garment) {
		return garmentRepo.save(garment);
	}

	@Override
	public Garment deleteGarment(Garment garment) {
		garmentRepo.delete(garment);
		return garment;
	}

	@Override
	public List<Garment> findGarmentsByBrand(String brand) {
		return garmentRepo.findGarmentByBrand(brand);
	}

}
