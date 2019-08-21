package io.naztech.prescription.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
 * Prescription Model
 * @author naym.hossain
 * @since 2019-03-27
 */
@Entity
@Table(name = "T_PRESCRIPTION", schema = "dbo")
@Data
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pres_key", nullable = false)
	private long key;

	@Column(name = "id_doc_key", nullable = false)
	private Long doctorKey;

	@Column(name = "id_pat_key", nullable = false)
	private Long patientKey;

	@Column(name = "tx_pat_disease")
	private String disease;
	
	@Column(name = "tx_pat_prescription_path")
	private String path;
	
	@Column(name = "tx_pat_ink_prescription")
	private byte[] inkPrescription;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "dtt_prescription")
	private LocalDateTime prescriptionDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dt_next_visit")
	private LocalDate nextVisitDate;

	/** Prescription details */
	@Column(name = "tx_prescription")
	private String prescription;

	/** Last updated Date and Time */
	@Column(name = "dtt_mod", nullable = false)
	@Setter(value = AccessLevel.PRIVATE)
	private LocalDateTime lastUpdated;

	@Setter(value = AccessLevel.PRIVATE)
	@Getter(value = AccessLevel.PRIVATE)
	@Column(name = "id_user_mod_key", nullable = false)
	private Integer userModId;

	@PreUpdate @PrePersist
	void onUpdate() {
		lastUpdated = LocalDateTime.now();
		userModId = 100001;
	}
}
