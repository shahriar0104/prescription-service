package io.naztech.prescription.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import io.naztech.prescription.dao.PrescriptionRepository;
import io.naztech.prescription.model.Patient;
import io.naztech.prescription.model.Prescription;

/**
 * Prescription Service
 * 
 * @author naym.hossain
 * @since: 2019-03-27
 */
@Service
public class PrescriptionService {
	@Autowired PrescriptionRepository presRepo;
	@Autowired PatientService patServ;

	public List<Prescription> getAll() {
		return presRepo.findAll();
	}

	public Optional<Prescription> getById(Long id) {
		return presRepo.findById(id);
	}
	
	public String getDataById(Long id) {
		return presRepo.findPresPathById(id);
	}
	
	public Prescription save(Prescription ob, Patient pat) {
		Optional<Patient> patient = patServ.getById(pat.getKey());
		if (!patient.isPresent()) patServ.save(pat);

		return presRepo.save(ob);
	}
	
	public Prescription saveP(Prescription ob) {
		return presRepo.save(ob);
	}
	
	public Prescription saveQ(Prescription ob) {
		return presRepo.save(ob);
	}

	public boolean deleteById(Long id) {
		Optional<Prescription> pres = presRepo.findById(id);
		if (!pres.isPresent()) return false;

		presRepo.deleteById(id);
		return true;
	}

	public List<Prescription> getByPatientId(Long id) {
		return presRepo.findByPatientKey(id);
	}

	public List<Prescription> findByDate(LocalDate date) {
		LocalDateTime start = date.atTime(00, 00, 00);
		LocalDateTime end = date.atTime(23, 59, 59);
		return presRepo.findAllByPrescriptionDateBetween(start, end);
	}
}
