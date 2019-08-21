package io.naztech.prescription.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.naztech.prescription.model.Patient;
/**
 * Patient Repository
 * @author naym.hossain
 * @since 2019-03-27
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	List<Patient> findByPhone(String phone);
	
	List<Patient> findByName(String name);
}
