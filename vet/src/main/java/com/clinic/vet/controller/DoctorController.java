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

import com.clinic.vet.model.Doctor;
import com.clinic.vet.services.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/doctor")
	public Doctor create(@RequestBody Doctor clinic,
			HttpServletRequest httpRequest) {
		return doctorService.create(clinic);
	}
	
	@DeleteMapping("/doctor/{id}")
	public void deleteClinic(@PathVariable Long id) {
		doctorService.delete(id);
	}
	
	@PutMapping("/doctor/{id}")
	public ResponseEntity<Object> updateClinic(@RequestBody Doctor doctor, @PathVariable Long id) {
		
		return new ResponseEntity<Object>(doctorService.updateDoctorById(doctor,id), HttpStatus.OK);
	}
	
	@GetMapping("/doctor")
	public ResponseEntity<List<Doctor>> getAllDoctor(){
		return new ResponseEntity<List<Doctor>>(doctorService.getAllDoctor(),HttpStatus.OK);
	}
	
	@GetMapping("/doctor/{id}")
	public ResponseEntity<Doctor> getclinic(@PathVariable Long id){
		return new ResponseEntity<Doctor>(doctorService.getDoctorById(id),HttpStatus.OK);
	}
	
	@GetMapping("/assign/{id}/{clinicId}")
	public ResponseEntity<Object> addDoctorToClinic( @PathVariable Long id, @PathVariable Long clinicId) {
		
		return new ResponseEntity<Object>(doctorService.assignDoctor(id,clinicId), HttpStatus.OK);
	}
	
	@GetMapping("/deassign/{id}/{clinicId}")
	public ResponseEntity<Object> removeDoctorFromClinic(@PathVariable Long id, @PathVariable Long clinicId) {
		
		return new ResponseEntity<Object>(doctorService.deassignDoctor(id,clinicId), HttpStatus.OK);
	}
	
}
