package io.naztech.prescription.model;

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
 * Doctor Model
 * @author naym.hossain
 * @since 2019-03-27
 */
@Entity
@Table(name = "T_DOCTOR", schema = "dbo")
@Data @Accessors(chain = true) @NoArgsConstructor @RequiredArgsConstructor
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_doc_key", nullable = false)
	private long key;

	@NonNull @Column(name = "tx_doc_name", nullable = false)
	private String name;

	@Column(name = "tx_doc_speciality")
	private String speciality;

	@Column(name = "tx_doc_mobile")
	private String mobile;

	@Column(name = "tx_doc_phone")
	private String phone;
	
	@NonNull @Column(name = "tx_doc_username", nullable = false)
	private String user;
	
	@NonNull @Column(name = "tx_doc_password", nullable = false)
	private String password;

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
