package com.clinic.vet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.vet.model.Owner;

@Repository
public interface OwnerDao extends JpaRepository<Owner, Long>{

}
