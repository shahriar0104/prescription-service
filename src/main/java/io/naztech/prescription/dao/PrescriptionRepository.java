package io.naztech.prescription.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.naztech.prescription.model.Prescription;

/**
 * Prescription Repository
 * 
 * @author naym.hossain
 * @since 2019-03-27
 */
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

	@Query("SELECT u FROM Prescription u WHERE u.patientKey = :patient ORDER BY u.prescriptionDate DESC")
	List<Prescription> findByPatientKey(@Param("patient") long patientKey);
	
	@Query("SELECT u.path FROM Prescription u where u.id = :id") 
	String findPresPathById(@Param("id") Long id);

	List<Prescription> findAllByPrescriptionDateBetween(LocalDateTime start, LocalDateTime end);
}
