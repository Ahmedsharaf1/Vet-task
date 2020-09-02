package com.clinic.vet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clinic.vet.dao.PetDao;
import com.clinic.vet.model.Pet;

@Service
public class PetService {

	@Autowired
	private PetDao petDao;

	public Pet create(Pet pet) {
		return petDao.save(pet);
	}

	public Pet getPetById(Long id) {

		Pet pet = petDao.findById(id).get();
		return pet;
	}

	public Pet updatePetById(Pet pet, Long id) {
		pet.setId(id);
		petDao.save(pet);
		return pet;
	}

	public void delete(long id) {

		petDao.deleteById(id);

	}

	public List<Pet> getAllPet() {
		return petDao.findAll();
	}
}
