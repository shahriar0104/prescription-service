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

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
/**
 * Patient Model
 * @author naym.hossain
 * @since 2019-03-27
 */
@Entity
@Table(name = "T_PATIENT", schema = "dbo")
@Data @Accessors(chain = true) @NoArgsConstructor @RequiredArgsConstructor
public class Patient{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pat_key", nullable = false)
	private long key;

	@NonNull @Column(name = "tx_pat_name", nullable = false)
	private String name;

	@NonNull @Column(name = "id_pat_age")
	private Integer age;
	
	@Column(name = "tx_pat_mobile")
	private String mobile;
	
	@Column(name = "tx_pat_bdnr")
	private String BDNR;

	@Column(name = "tx_pat_bloodgroup")
	private String bloodGroup;

	@Column(name = "tx_pat_blood_donate_date")
	private LocalDate bloodDonateDate;
	
	@Column(name = "id_pat_weight")
	private String weight;
	
	@Column(name = "tx_pat_bloodpressure")
	private String bloodPressure;
	
	@Column(name = "tx_pat_phone")
	private String phone;

	@Column(name = "id_doc_key", nullable = false)
	private long doctorKey;

	/** Last updated Date and Time */
	@Column(name = "dtt_mod", nullable = false)
	@Setter(value = AccessLevel.PRIVATE)
	LocalDateTime lastUpdated;

	@Setter(value = AccessLevel.PRIVATE)
	@Getter(value = AccessLevel.PRIVATE)
	@Column(name = "id_user_mod_key", nullable = false)
	Integer userModId;

	@PreUpdate @PrePersist
	void onUpdate() {
		lastUpdated = LocalDateTime.now();
		userModId = 100001;
	}
}
