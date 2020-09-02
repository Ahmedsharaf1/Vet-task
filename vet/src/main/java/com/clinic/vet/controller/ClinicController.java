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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.clinic.vet.model.Clinic;
import com.clinic.vet.services.ClinicService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="ClinicController", description="clinicOperation")

public class ClinicController {

	@Autowired
	private ClinicService clinicService;
	
	

    @ApiOperation(value = "",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@PostMapping("/clinic")
	public Clinic create(@RequestBody Clinic clinic,
			HttpServletRequest httpRequest) {
		return clinicService.create(clinic);
	}
	
	@DeleteMapping("/clinic/{id}")
	public void deleteClinic(@PathVariable long id) {
		clinicService.delete(id);
	}
	
	@PutMapping("/clinic/{id}")
	public ResponseEntity<Object> updateClinic(@RequestBody Clinic clinic, @PathVariable long id) {
		
		return new ResponseEntity<Object>(clinicService.updateClinicById(clinic,id), HttpStatus.OK);
	}
	
	@GetMapping("/clinic")
	public ResponseEntity<List<Clinic>> getAllCliniv(){
		return new ResponseEntity<List<Clinic>>(clinicService.getAllClinic(),HttpStatus.OK);
	}
	
	@GetMapping("/search/address/{address}")
	public ResponseEntity<List<Clinic>> searchByAddress(@PathVariable String address){
		return new ResponseEntity<List<Clinic>>(clinicService.findByAddress(address),HttpStatus.OK);
	}
	
	@GetMapping("/search/phone/{phone}")
	public ResponseEntity<List<Clinic>> searchByPhone(@PathVariable String phone){
		return new ResponseEntity<List<Clinic>>(clinicService.findByPhone(phone),HttpStatus.OK);
	}
	
}
