package io.naztech.prescription.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.naztech.prescription.dao.DoctorRepository;
import io.naztech.prescription.model.Doctor;
/**
 * Doctor Service
 * @author naym.hossain
 * @since: 2019-03-27
 */
@Service
public class DoctorService {
	@Autowired private DoctorRepository docRepo;

	public List<Doctor> getAll() {
		return docRepo.findAll();
	}
	
	public Doctor login(String userName, String pass) {
		return docRepo.findByUserAndPassword(userName, pass);
	}
	
	public Optional<Doctor> getById(Long id) {
		return docRepo.findById(id);
	}

	public Doctor save(Doctor ob) {
		return docRepo.save(ob);
	}

	public boolean deleteById(Long id) {
		Optional<Doctor> doc = docRepo.findById(id);
		if (!doc.isPresent()) return false;

		docRepo.deleteById(id);
		return true;
	}
}
