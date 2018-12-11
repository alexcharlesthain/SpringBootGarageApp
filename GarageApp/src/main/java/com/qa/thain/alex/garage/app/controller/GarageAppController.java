package com.qa.thain.alex.garage.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.qa.thain.alex.garage.app.exception.ResourceNotFoundException;
import com.qa.thain.alex.garage.app.model.*;
import com.qa.thain.alex.garage.app.repository.GarageAppRepository;

@RestController
@RequestMapping("/api")
public class GarageAppController {

	@Autowired
	GarageAppRepository myRepository;

	//method to create a vehicle
	@PostMapping("/vehicle")
	public GarageAppModel createPerson(@Valid @RequestBody GarageAppModel mSDM) {
		return myRepository.save(mSDM);		
	}
	
	//Method to get a vehicle
	@GetMapping("/vehicle/{id}")
	public GarageAppModel getVehiclebyID(@PathVariable(value="id")Long vehicleID) {
		return myRepository.findById(vehicleID).orElseThrow(()-> new ResourceNotFoundException("GarageAppModel", "id",vehicleID));
	}
	
	//Method to get all vehicles
	@GetMapping("/vehicles")
	public List<GarageAppModel> getAllVehicles() {
		return myRepository.findAll();
	}
	
	//Method to update a vehicle
	@PutMapping("/person/{id}")
	public GarageAppModel updateVehicle(@PathVariable(value = "id") Long vehicleID,
			@Valid @RequestBody GarageAppModel vehicleDetails){
		
		GarageAppModel mSDM = myRepository.findById(vehicleID).orElseThrow(() -> new ResourceNotFoundException("Vehicle","id", vehicleID));
		
		mSDM.setvMake(vehicleDetails.getvMake());
		mSDM.setvModel(vehicleDetails.getvModel());
		mSDM.setvRegistrationNumber(vehicleDetails.getvRegistrationNumber());
		mSDM.setvType(vehicleDetails.getvType());
		
		GarageAppModel updateData = myRepository.save(mSDM);
		return updateData;
	}
	
	//Method to remove a vehicle
	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<?> deleteVehicle(@PathVariable(value="id")Long vehicleID) {
		GarageAppModel mSDM = myRepository.findById(vehicleID).orElseThrow(()-> new ResourceNotFoundException("Vehicle","id",vehicleID));
		
		myRepository.delete(mSDM);
		return ResponseEntity.ok().build();
	
	}	
}
