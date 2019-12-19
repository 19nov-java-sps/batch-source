package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Garment;
import com.revature.services.GarmentService;

@RestController  // this takes the place of @Controller and @ResponseBody over each of our methods
@RequestMapping("/garments")
public class GarmentController {

	@Autowired
	private GarmentService garmentService;
	
	@GetMapping
	public List<Garment> getAll(@RequestParam(value="brand", required=false)String brand){
		if(brand == null) {
			return garmentService.findAllGarments();
		} 
		return garmentService.findGarmentsByBrand(brand);
	}
	
	@GetMapping("/{id}")
	public Garment getGarmentById(@PathVariable("id") Integer id) {
		return garmentService.findGarmentById(id);
	}
	
	@PostMapping
	public ResponseEntity<Garment> addGarment(@Valid @RequestBody Garment garment) {
		garmentService.addGarment(garment);
		return new ResponseEntity<Garment>(garment, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public Garment updateGarment(@PathVariable("id") int id, @RequestBody Garment garment) {
		garment.setId(id);
		return garmentService.updateGarment(garment);
	}
	
	@DeleteMapping("/{id}")
	public Garment deleteGarment(@PathVariable("id") int id) {
		return garmentService.deleteGarment(new Garment(id));
	}
	
	
}
