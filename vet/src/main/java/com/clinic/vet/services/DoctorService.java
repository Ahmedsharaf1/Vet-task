package com.clinic.vet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.vet.dao.ClinicDao;
import com.clinic.vet.dao.DoctorDao;
import com.clinic.vet.model.Clinic;
import com.clinic.vet.model.Doctor;

@Service
public class DoctorService {
	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private ClinicDao clinicDao;
	
	public Doctor create(Doctor doctor) {
		
	return doctorDao.save(doctor);		
	
	}
	
	public Doctor getDoctorById(Long id) {
		Doctor doctor = doctorDao.findById(id).get();
		
		 return doctor;
	}
	
	public Doctor updateDoctorById(Doctor doctor,Long id) {
		 doctor.setId(id);
		 doctorDao.save(doctor);
		 return doctor;
	}
	
	public Doctor assignDoctor(Long id,Long doctorId) {
		 Doctor doctor =doctorDao.findById(doctorId).get();
		 doctor.setClinic(clinicDao.findById(doctorId).get());
		 doctorDao.save(doctor);
		 return doctor;
	}
	
	public Doctor deassignDoctor(Long id,Long doctorId) {
		 Doctor doctor =doctorDao.findById(doctorId).get();
		 doctor.setClinic(null);
		 doctorDao.save(doctor);
		 return doctor;
	}
	
	public void delete(long id) {
		
	 doctorDao.deleteById(id);		
	
	}
	
	public List<Doctor> getAllDoctor(){
		return doctorDao.findAll();
	}
	
}
