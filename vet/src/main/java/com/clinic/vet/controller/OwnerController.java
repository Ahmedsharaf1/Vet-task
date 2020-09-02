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

import com.clinic.vet.model.Owner;
import com.clinic.vet.services.OwnerService;

@RestController
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	@PostMapping("/owner")
	public Owner create(@RequestBody Owner owner,
			HttpServletRequest httpRequest) {
		return ownerService.create(owner);
	}
	
	@DeleteMapping("/owner/{id}")
	public void deleteClinic(@PathVariable long id) {
		ownerService.delete(id);
	}
	
	@PutMapping("/owner/{id}")
	public ResponseEntity<Object> updateOwner(@RequestBody Owner owner, @PathVariable long id) {
		
		return new ResponseEntity<Object>(ownerService.updateOwnerById(owner,id), HttpStatus.OK);
	}
	
	@GetMapping("/owner")
	public ResponseEntity<List<Owner>> getAllOwner(){
		return new ResponseEntity<List<Owner>>(ownerService.getAllOwner(),HttpStatus.OK);
	}
	
	@GetMapping("/owner/{id}")
	public ResponseEntity<Owner> getOwner(@PathVariable long id){
		return new ResponseEntity<Owner>(ownerService.getOwnerById(id),HttpStatus.OK);
	}
	
}
