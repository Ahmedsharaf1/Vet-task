package com.clinic.vet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.vet.dao.ClinicDao;
import com.clinic.vet.model.Clinic;

@Service
public class ClinicService {

	@Autowired
	private ClinicDao clinicDao;
	
	public Clinic create(Clinic clinic) {
		
	return clinicDao.save(clinic);		
	
	}
	
	public Clinic getClinicById(long id) {
		 Clinic clinic = clinicDao.findById(id).get();
		
		 return clinic;
	}
	
	public Clinic updateClinicById(Clinic clinic,long id) {
//		 Clinic clinic2 = clinicDao.findById(id).get();
		 clinic.setId(id);
		 clinicDao.save(clinic);
		 return clinic;
	}
	
	public void delete(long id) {
		
	 clinicDao.deleteById(id);		
	
	}
	
	public List<Clinic> getAllClinic(){
		return clinicDao.findAll();
	}
	
	public List<Clinic> findByAddress(String address){
		
		return clinicDao.findByAddress(address);
	}
	
	public List<Clinic> findByPhone(String phone){
		
		return clinicDao.findByPhone(phone);
	}
	
	
}
