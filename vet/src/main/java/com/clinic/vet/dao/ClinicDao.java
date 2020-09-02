package com.clinic.vet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clinic.vet.model.Clinic;

@Repository
public interface ClinicDao extends JpaRepository<Clinic, Long> {

	@Query(value = "select * from CLINIC where LOWER(ADDRESS) like CONCAT('%',LOWER(?1), '%')",nativeQuery = true)
	List<Clinic> findByAddress(String address);
	
	@Query(value = "select * from CLINIC where PHONE like CONCAT('%',?2, '%')",nativeQuery = true)
	List<Clinic> findByPhone(String phone);
}
