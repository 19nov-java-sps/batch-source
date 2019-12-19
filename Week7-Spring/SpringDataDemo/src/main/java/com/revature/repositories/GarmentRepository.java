package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Garment;

@Repository
public interface GarmentRepository extends JpaRepository<Garment, Integer> {
	
	public List<Garment> findGarmentByBrand(String brand);

}
