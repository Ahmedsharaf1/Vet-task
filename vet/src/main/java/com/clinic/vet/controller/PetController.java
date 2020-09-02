package com.clinic.vet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.vet.model.Pet;
import com.clinic.vet.services.PetService;

@RestController
public class PetController {

	@Autowired
	private PetService petService;
	
	@PostMapping("/pet")
	public Pet create(@RequestBody Pet pet,
			HttpServletRequest httpRequest) {
		return petService.create(pet);
	}
	
	@DeleteMapping("/pet/{id}")
	public void deleteClinic(@PathVariable long id) {
		petService.delete(id);
	}
	
	@PutMapping("/pet/{id}")
	public ResponseEntity<Object> updatePet(@RequestBody Pet pet, @PathVariable long id) {
		
		return new ResponseEntity<Object>(petService.updatePetById(pet,id), HttpStatus.OK);
	}
	
	@GetMapping("/pet")
	public ResponseEntity<List<Pet>> getAllPet(){
		return new ResponseEntity<List<Pet>>(petService.getAllPet(),HttpStatus.OK);
	}
	
	@GetMapping("/pet/{id}")
	public ResponseEntity<Pet> getPet(@PathVariable long id){
		return new ResponseEntity<Pet>(petService.getPetById(id),HttpStatus.OK);
	}
	
}
