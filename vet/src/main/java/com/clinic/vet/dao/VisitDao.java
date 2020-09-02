package com.clinic.vet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.vet.model.Visit;

@Repository
public interface VisitDao extends JpaRepository<Visit, Long> {

}
