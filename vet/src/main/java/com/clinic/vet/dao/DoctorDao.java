package com.clinic.vet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.vet.model.Doctor;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Long> {

}
