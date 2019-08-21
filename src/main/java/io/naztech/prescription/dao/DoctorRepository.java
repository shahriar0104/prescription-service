package io.naztech.prescription.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.naztech.prescription.model.Doctor;
/**
 * Doctor Repository
 * @author naym.hossain
 * @since 2019-03-27
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	List<Doctor> findByName(String name);
	
	Doctor findByUserAndPassword(String user, String pass);
}
