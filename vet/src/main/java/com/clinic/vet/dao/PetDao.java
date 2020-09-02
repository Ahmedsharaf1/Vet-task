package com.clinic.vet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.vet.model.Pet;

@Repository
public interface PetDao extends JpaRepository<Pet, Long>{

}
