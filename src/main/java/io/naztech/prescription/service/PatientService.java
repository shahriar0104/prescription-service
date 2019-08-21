package io.naztech.prescription.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.naztech.prescription.dao.PatientRepository;
import io.naztech.prescription.model.Patient;
/**
 * Patient Service
 * @author naym.hossain
 * @since: 2019-03-27
 */
@Service
public class PatientService {

	@Autowired PatientRepository patRepo;
	
	public List<Patient> getAll(){
		return patRepo.findAll();
	}
	
	public Optional<Patient> getById(Long id) {
		return patRepo.findById(id);
	}

	public Patient save(Patient ob) {
		return patRepo.save(ob);
	}

	public boolean deleteById(Long id) {
		Optional<Patient> pat = patRepo.findById(id);
		if (!pat.isPresent()) return false;

		patRepo.deleteById(id);
		return true;
	}
	
	public List<Patient> getByName(String name){
		return patRepo.findByName(name);
	}
	
	public List<Patient> getByPhone(String phone){
		return patRepo.findByPhone(phone);
	}
	
}
