package com.clinic.vet.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clinic.vet.exceptions.MyFileNotFoundException;
import com.clinic.vet.model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, Long> {

	@Query(value = "select * from FILES where DOCTOR_ID=?1  ",nativeQuery = true)
	Optional<DBFile> findByDoctorId(Long doctorId) throws MyFileNotFoundException;
	
	@Query(value = "select * from FILES where DOCTOR_ID=?1  ",nativeQuery = true)
	Optional<DBFile> findByPetId(Long doctorId) throws MyFileNotFoundException;
}
