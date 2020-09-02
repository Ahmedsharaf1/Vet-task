package com.clinic.vet.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.clinic.vet.dao.DBFileRepository;
import com.clinic.vet.exceptions.FileStorageException;
import com.clinic.vet.exceptions.MyFileNotFoundException;
import com.clinic.vet.model.DBFile;
import com.clinic.vet.model.Doctor;
import com.clinic.vet.model.Pet;

import java.io.IOException;

@Service
public class DBFileStorageService {

    @Autowired
    private DBFileRepository dbFileRepository;
    
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PetService petService;

    
    public DBFile storeFile(MultipartFile file,String doctorId,String petId) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

            if(doctorId==null||doctorId=="") {
            	Pet pet = petService.getPetById(Long.parseLong(petId));
            	pet.setDbFile(dbFile);
            	dbFile.setPet(pet);
//               petService.updatePetById(pet, Long.parseLong(petId));
            	}
            else {
            	Doctor doctor = doctorService.getDoctorById(Long.parseLong(doctorId)) ;
            	doctor.setDbFile(dbFile);
            	dbFile.setDoctor(doctor);
            	
//            	doctorService.updateDoctorById(doctor, Long.parseLong(doctorId));
            }
            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DBFile getFileDoctor(String fileId) throws NumberFormatException, MyFileNotFoundException {
        return dbFileRepository.findByDoctorId(Long.parseLong(fileId))
        		.orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
    
    public DBFile getFilePet(String fileId) throws NumberFormatException, MyFileNotFoundException {
        return dbFileRepository.findByPetId(Long.parseLong(fileId))
        		.orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
