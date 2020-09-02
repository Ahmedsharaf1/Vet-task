package com.clinic.vet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.vet.dao.OwnerDao;
import com.clinic.vet.model.Owner;

@Service
public class OwnerService {

	@Autowired
	private OwnerDao ownerDao;

	public Owner create(Owner owner) {
		return ownerDao.save(owner);
	}

	public Owner getOwnerById(long id) {

		Owner doctor = ownerDao.findById(id).get();
		return doctor;
	}

	public Owner updateOwnerById(Owner owner, long id) {
		owner.setId(id);
		ownerDao.save(owner);
		return owner;
	}

	public void delete(long id) {

		ownerDao.deleteById(id);

	}

	public List<Owner> getAllOwner() {
		return ownerDao.findAll();
	}

}
